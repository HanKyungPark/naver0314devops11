import { Button, ButtonGroup } from "@mui/material";

const Student=({stu,dispathch})=>{
    return(
        <div className="input-group" style={{width:'300px'}}>
            <div style={{textDecoration:stu.inHere?'line-through':'none',
        width:'130px',cursor:'pointer',
        color:stu.isHere?'gray':'black'}}
        onClick={()=>dispathch({'type':'mark-student',
        payload:{id:stu.id}})}>
                {stu.name}
            </div>
            &nbsp;
            <Button variant="contained" size="small"
            color="success"
            onClick={()=>dispathch({'type':'delete-student',
            payload:{id:stu.id}})}>삭제</Button>
        </div>
    )
}

export default Student;