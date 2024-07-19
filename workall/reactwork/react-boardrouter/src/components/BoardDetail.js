import { Alert, Button } from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import { EditNote, HighlightOff } from "@mui/icons-material";

const BoardDetail = () => {
    const { boardnum } = useParams();
    const [selectData, setSelectData] = useState('');
    const [nickname, setNickname] = useState('');
    const [comment, setComment] = useState('');
    const storage = process.env.REACT_APP_STORAGE;
    const navi = useNavigate();
    const [open, setOpen] = useState(false);
    const [pass, setPass] = useState('');
    const [list, setList] = useState([]);
    
    

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const getData = () => {
        axios.get("/boot/board/detail?boardnum=" + boardnum)
            .then(res => {
                setSelectData(res.data);
            });
    };

    useEffect(() => {
        getData();
        commentListEvent();
    }, [boardnum]);

    const addCommentEvent = () => {
        if (nickname === '') {
            alert("닉네임을 입력해주세요");
            return;
        }
        if (comment === '') {
            alert("코멘트를 입력해주세요");
            return;
        }

        axios.post("/boot/comment/insert", { nickname, comment, boardnum })
            .then(res => {
                commentListEvent(); // 댓글 다시 출력
                // 입력값 초기화
                setNickname('');
                setComment('');
            });
    };

    const commentListEvent = () => {
        // 댓글 출력 함수
        axios.get(`/boot/comment/list?boardnum=${boardnum}`)
            .then(res => {
                setList(res.data);
            
            });
    };

    const deleteComment = (idx) => {
        axios.get(`/boot/comment/delete?idx=${idx}`)
            .then(res => {
               
                    commentListEvent();
               
            });
    };

    return (
        <div style={{ width: '500px', marginLeft: '30px' }}>
            <table className="table">
                <caption align='top'><h3><b>게시물 상세보기</b></h3></caption>
                <tbody>
                    <tr>
                        <td>
                            <h3><b>{selectData.subject}</b></h3>
                            <b>{selectData.writer}</b>
                            <span style={{ float: 'right', color: 'gray', fontSize: '14px' }}>
                                조회&nbsp;{selectData.readcount}
                                &nbsp;&nbsp;
                                {selectData.writeday}
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            {selectData.photo !== 'no' ? (
                                <div>
                                    <h3><b>대표 사진</b></h3>
                                    <img alt="" src={`${storage}/${selectData.photo}`} style={{ width: '200px' }} />
                                    <hr />
                                </div>
                            ) : ""}
                            <pre dangerouslySetInnerHTML={{ __html: selectData.content }}></pre>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <Button variant='outlined' color="success" size="small" style={{ width: '80px' }}
                                onClick={() => navi("/board/list")}>목록</Button>
                            &nbsp;
                            <Button variant='outlined' color="success" size="small" style={{ width: '80px' }}
                                onClick={() => navi("/board/form")}>글쓰기</Button>
                            &nbsp;
                            <Button variant='outlined' color="success" size="small" style={{ width: '80px' }}
                                onClick={() => navi(`/board/updatepassform/${boardnum}`)}>수정</Button>
                            &nbsp;
                            <Button variant='outlined' color="success" size="small" style={{ width: '80px' }}
                                onClick={handleClickOpen}>삭제</Button>
                            <Dialog
                                open={open}
                                onClose={handleClose}
                                PaperProps={{
                                    component: 'form',
                                    onSubmit: (event) => {
                                        event.preventDefault();
                                        let url = `/boot/board/deletecheckpass?boardnum=${boardnum}&pass=${pass}`;
                                        axios.get(url)
                                            .then(res => {
                                                if (res.data.result === 'success')
                                                    navi("/board/list");
                                                else
                                                    window.alert("비밀번호가 맞지않습니다");
                                            });
                                        handleClose();
                                    },
                                }}
                            >
                                <DialogTitle>삭제확인</DialogTitle>
                                <DialogContent>
                                    <DialogContentText>
                                        비밀번호를 입력해주세요
                                    </DialogContentText>
                                    <TextField
                                        autoFocus
                                        required
                                        margin="dense"
                                        id="standard-password-input"
                                        label="Password"
                                        type="password"
                                        autoComplete="current-password"
                                        variant="standard"
                                        onChange={(e) => setPass(e.target.value)}
                                    />
                                </DialogContent>
                                <DialogActions>
                                    <Button onClick={handleClose}>취소</Button>
                                    <Button type="submit">글삭제</Button>
                                </DialogActions>
                            </Dialog>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div>댓글 목록</div>
                            <hr />
                            <div className="input-group" style={{ width: '500px' }}>
                                <input type="text" className="form-control" style={{ width: '120px' }} placeholder="닉네임입력"
                                    value={nickname} onChange={(e) => setNickname(e.target.value)} />
                                &nbsp;&nbsp;
                                <input type="text" className="form-control" placeholder="댓글을 입력하세요"
                                    value={comment} onChange={(e) => setComment(e.target.value)} style={{ width: '250px' }} />
                                <Button variant="contained" size="small" color="error"
                                    onClick={addCommentEvent}>저장</Button>
                            </div>
                            <hr />
                            <table className="table table-bordered" style={{ width: '300px' }}>
                                <thead>
                                    <tr>
                                        <th>닉네임</th>
                                        <th>댓글</th>
                                        <th>날짜</th>
                                        <th>수정/삭제</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        list &&
                                        list.map((row, idx) =>
                                            <tr key={idx}>
                                                <td>{row.nickname}</td>
                                                <td>{row.comment}</td>
                                                <td>{row.writeday}</td>
                                                <td>
                                                    <EditNote style={{ cursor: 'pointer', color: 'gray' }}
                                                        onClick={() => {let comment=window.prompt("댓글수정",row.comment);
                                                        let url=`/boot/comment/update?idx=${row.idx}&comment=${comment}`;
                                                       axios.get(url)
                                                       .then(res=>{
                                                        //수정후 목록다시호출
                                                        commentListEvent();
                                                       })
                                                        }}/>
                                                    &nbsp;&nbsp;
                                                    <HighlightOff style={{ cursor: 'pointer', color: 'gray' }}
                                                        onClick={()=>deleteComment(row.idx)} />
                                                </td>
                                            </tr>
                                        )
                                    }
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default BoardDetail;
