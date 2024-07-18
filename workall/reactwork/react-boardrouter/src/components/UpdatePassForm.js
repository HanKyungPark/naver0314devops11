import { Button } from "@mui/material";
import axios from "axios";
import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const UpdatePassForm = () => {
    const navi = useNavigate();
    const { boardnum } = useParams();

    const [pass, setPass] = useState('')

    const handleCheckPassword = () => {
        let url = `/boot/board/updatecheckpass?boardnum=${boardnum}&pass=${pass}`;
        axios.get(url)
            .then(res => {
                if (res.data.result === 'success') {
                    navi(`/board/update/${boardnum}`);
                } else {
                    window.alert("비밀번호가 맞지 않습니다");
                }
            });
    };

    return (
        <div>
            <h4><b>비밀번호 입력</b></h4>
            <input
                type="password"
                placeholder="비밀번호 입력"
                onChange={(e) => setPass(e.target.value)}
            />
            <Button
                variant='outlined'
                color="success"
                size="small"
                style={{ width: '80px' }}
                onClick={handleCheckPassword}>확인</Button>
            <Button
                variant='outlined'
                color="success"
                size="small"
                style={{ width: '80px' }}
                onClick={() => navi("/board/list")}> 취소</Button>
        </div>
    )
}

export default UpdatePassForm;
