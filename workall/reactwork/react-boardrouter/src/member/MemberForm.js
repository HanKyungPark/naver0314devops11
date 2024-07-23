import { Button } from '@mui/material';
import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const MemberForm = () => {
    const [idcheck,setIdCheck]=useState(false);
    const [userid,setUserid]=useState('');
    const [passwd,setPasswd]=useState('');
    const [hp,setHp]=useState('');

    const navi=useNavigate();

    //중복확인 이벤트
    const userIdCheckEvent=()=>{
        let url=`/boot/member/check?userid=${userid}`;
        axios.get(url)
        .then(res=>{
            if(res.data==='success'){
                alert("이미 가입된 아이디입니다");
                setUserid('');
                setIdCheck(false);
            }else{
                alert("가입 가능한 아이디입니다");
                setIdCheck(true);
            }
        })
    }

    //회원가입 이벤트
    const addSubmitMember=(e)=>{
        e.preventDefault();
        //alert("submit");
        if(idcheck===false){
            alert("먼저 아이디 중복체크를 해주세요");
            return;
        }

        let url=`/boot/member/insert?userid=${userid}&passwd=${passwd}&hp=${hp}`;
        axios.get(url)
        .then(res=>{
            //추가 성공후 멤버 목록으로 이동
            navi("/member/list");
        })
    }

    return (
        <form onSubmit={addSubmitMember}>
            <table className='table table-bordered' style={{width:'300px',marginLeft:'100px'}}>
                <caption align="top"><h5><b>회원 가입</b></h5></caption>
                <tbody>            
                    <tr>
                        <th style={{width:'100px'}}>아이디</th>
                        <td className='input-group'>
                            <input type='text' value={userid} onChange={(e)=>{
                                setUserid(e.target.value);
                                setIdCheck(false);
                            }}
                            className='form-control' required/>
                            &nbsp;
                            <Button variant='contained' color="error"
                            onClick={userIdCheckEvent}>중복확인</Button>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width:'100px'}}>비밀번호</th>
                        <td>
                            <input type='password' value={passwd}
                            className='form-control' required
                            onChange={(e)=>setPasswd(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width:'100px'}}>핸드폰</th>
                        <td>
                            <input type='text' value={hp}
                            className='form-control' required
                            onChange={(e)=>setHp(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <Button variant='contained' color='success'
                             type='submit'>회원가입</Button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    );
};

export default MemberForm;