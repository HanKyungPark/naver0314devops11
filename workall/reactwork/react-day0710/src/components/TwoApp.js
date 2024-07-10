import { useState } from "react"

const { Alert } = require("@mui/material")

const TwoApp =()=>{
    const [names,setNames]=useState(["hi","안녕"])
    const [irum,setIrum]=useState('')

    //추가이벤트
    const addNameEvent=()=>{
        if(irum.length===0){
            alert("추가할 이름을 입력해주세요");
            return
        }
        //입력한 이름을 배열변수 names에 추가
        setNames(names.concat(irum));
        setIrum('')
    }

    //삭제하는 함수
    const deleteName=(idx)=>{
        let a=window.confirm(`${idx+1}번째 이름을 삭제하시겠습니까?`)
        if(a){
            setNames(names.filter((n,i)=>i!==idx));
        }
    }

    return(
        <div>
            <Alert>TwoApp</Alert>
            <div className="input-group" style={{width:"300px"}}>
                <h5>이름 : </h5>
                <input type="text" className="form-control"
                style={{width:'130px'}} value={irum}
                onChange={(e)=>setIrum(e.target.value)}/>
                <button variant='contained' color="success"
                onClick={addNameEvent}>추가</button>
            </div>
            <hr/>
            {
            names.map((myname,idx)=>
            <div className="input-group">
                <h4 style={{width:'200px'}}>{myname}</h4>

                <button variant='outlined' color="info"
                onClick={()=>deleteName(idx)}>삭제</button>
                </div>)
            }
        </div>
    )
}
export default TwoApp