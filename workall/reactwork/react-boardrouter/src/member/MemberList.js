import axios from "axios";
import { useEffect, useState } from "react";

const MemberList=()=>{

    const [memberList,setMemberList]=useState([]);
    const getDataList=()=>{
        axios.get("/boot/member/list")
        .then(res=>{
            setMemberList(res.data);
        })
    }

    useEffect(()=>{
        getDataList();
    },[])
    return(
        <div>

            
            <table className="table table-bordered" style={{width:'500px'}}>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>핸드폰</th>
                        <th>가입일</th>
                    </tr>
                </thead>
                <tbody>
                   {
                    memberList &&
                    memberList.map((row,idx)=>
                    <tr key={idx}>
                        <td>{idx+1}</td>
                        <td>{row.userid}</td>
                        <td>{row.hp}</td>
                        <td>{row.gaipday}</td>
                    </tr>)
                   }
                </tbody>
            </table>
        </div>
    )
}
export default MemberList;