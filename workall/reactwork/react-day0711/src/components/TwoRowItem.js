import { Button } from "@mui/material";

const TwoRowItem=(props)=>{
    let {idx,row,onDelete}=props;
    return(
        <tr>
            <td>{idx+1}</td>
            <td>{row.irum}</td>
            <td>{row.age}</td>
            <td>{row.blood}</td>
            <td>{row.today.toLocaleDateString('ko-KR')}</td>
            {/* <td>{row.today.toLocaleString('ko_KR')}</td> : 시간까지 */}
            <td><Button onClick={()=>{
                let a=window.confirm("멤버를 삭제할까요?")
                if(a){
                onDelete(idx);}}}>삭제</Button></td>
        </tr>
    )
}
export default TwoRowItem;