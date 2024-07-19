import { Alert } from "@mui/material";
import  axios  from "axios";
import { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";
import noimage from '../image/no1.png';

const BoardList=()=>{

    const [boardList,setBoardList]=useState([]);
    const getDataList=()=>{
        axios.get("/boot/board/list")
        .then(res=>{
            setBoardList(res.data);
        });
    }

    const storage=process.env.REACT_APP_STORAGE;

    //처음 딱 한번 목록 가져오기
    useEffect(()=>{
        getDataList();
    },[])

    
        return(
        <div style={{width:'500px'}}>
            <Alert>
            <b>총 {boardList.length}개의 게시글이 있습니다</b>
            </Alert>
            <table className="table table-striped">
            <thead>
                <tr className="table-danger">
                    <th style={{width:'50'}}>번호</th>
                    <th style={{width:'350'}}>제목</th>
                    <th style={{width:'70'}}>작성자</th>
                    <th style={{width:'100'}}>작성일</th>
                    <th style={{width:'50'}}>조회</th>
                </tr>
            </thead>
            <tbody>
                {   
                    boardList &&
                    boardList.map((row,idx)=>
                        <tr key={idx}>
                            <td align="center">{boardList.length-idx}</td>
                            <td>
                                <NavLink to={`/board/detail/${row.boardnum}`}
                                style={{textDecoration:'none',color:'black'}}>
                                    <img alt="" src={`${storage}/${row.photo}`}
                                    style={{width:'40px',height:'40px'}} />
                                    {row.subject}
                                    &nbsp;
                                    {row.readcount>0?
                                    <span style={{color:'red'}}>
                                        [{row.answercount}]
                                        </span>:""}
                                </NavLink>
                            </td>
                            <td>{row.writer}</td>
                            <td>{row.writeday.substring(0,10)}</td>
                            <td align="center">{row.readcount}</td>
                        </tr>
                    )
                }
            </tbody>
            </table>
        </div>
    )
}
export default BoardList;