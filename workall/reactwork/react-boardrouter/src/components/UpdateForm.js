import { CameraAltOutlined, ColorLensOutlined } from "@mui/icons-material";
import { Alert, Button } from "@mui/material";
import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Editor } from "@toast-ui/react-editor";
import '@toast-ui/editor/dist/toastui-editor.css';

const UpdateForm = () => {
    const [writer, setWriter] = useState('');
    const [subject, setSubject] = useState('');
    const [photo, setPhoto] = useState('no');
    const [content,setContent] = useState('');
    const { boardnum } = useParams();

    const navi = useNavigate();

    const fileRef = useRef(null);
    const contentRef = useRef(null);

    const [boardList, setBoardList] = useState([]);
    const getDataList = () => {
        axios.get("/boot/board/list")
            .then(res => {
                setBoardList(res.data);
            });
    };

    const storage = process.env.REACT_APP_STORAGE;
    console.log(storage);

    const getData=()=>{
        axios.get("/boot/board/update")
        .then()
    }

    const uploadPhoto = (e) => {
        const uploadFile = e.target.files[0];
        const uploadForm = new FormData();
        uploadForm.append("upload", uploadFile);

        axios({
            method: 'post',
            url: '/boot/board/upload',
            data: uploadForm,
            headers: { 'Content-Type': 'multipart/form-data' },
        }).then(res => {
            setPhoto(res.data);
        });
    };

    useEffect(() => {
        contentRef.current?.getInstance().setHTML('');
    }, []);

    const dataSaveEvent = () => {
        const content = contentRef.current?.getInstance().getHTML();

        if (writer === '') {
            alert("작성자를 입력해주세요");
            return;
        }

        if (subject === '') {
            alert("제목 입력해주세요");
            return;
        }

        if (content === '') {
            alert("내용을 입력해주세요");
            return;
        }

        axios.post("/boot/board/insert", { writer, photo, subject, content })
            .then(res => {
                setPhoto('no');
                setWriter('');
                setSubject('');
                contentRef.current?.getInstance().setHTML('');

                navi("/board/list");
            });
    };

    return (
        <div>
            <Alert>게시판 글쓰기</Alert>
            <table className="table table-bordered" style={{ width: '400px' }}>
                <tbody>
                    <tr>
                        <th className="table-info" style={{ width: '100px' }}>작성자</th>
                        <td>
                            <input type="text" className="form-control" value={writer} onChange={(e) => setWriter(e.target.value)} />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2}>
                            <input type="text" className="form-control" value={subject} onChange={(e) => setSubject(e.target.value)} />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2}>
                            <input type="file" style={{ display: 'none' }} ref={fileRef} onChange={uploadPhoto} />
                            <CameraAltOutlined onClick={() => fileRef.current.click()} style={{ cursor: 'pointer', fontSize: '30px' }} />
                            <img alt="" src={`${storage}/${photo}`} style={{ width: '60px', marginLeft: '30px' }} />
                            <Editor
                                placeholder="내용을 입력해주세요."
                                previewStyle="vertical"
                                height="500px"
                                initialEditType="wysiwyg"
                                toolbarItems={[
                                    ['heading', 'bold', 'italic', 'strike'],
                                    ['hr', 'quote'],
                                    ['ul', 'ol', 'task', 'indent', 'outdent'],
                                    ['image'],
                                    ['code', 'codeblock']
                                ]}
                                hooks={{
                                    addImageBlobHook: async (blob, callback) => {
                                        const formData = new FormData();
                                        formData.append('upload', blob);

                                        let url = "/boot/board/upload";

                                        axios.post(url, formData, {
                                            headers: { "content-type": "multipart/form-data" }
                                        }).then(res => {
                                            callback(`${storage}/${res.data}`);
                                        });
                                    }
                                }}
                                ref={contentRef}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align="center">
                            <Button variant="contained" color="success" style={{ width: '100px' }} onClick={dataSaveEvent}>DB저장</Button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default UpdateForm;
