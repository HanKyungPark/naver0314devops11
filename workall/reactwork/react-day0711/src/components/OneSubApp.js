import { CloseSharp } from "@mui/icons-material"

const OneSubApp=({idx,item,deleteSangpum})=>{
    return(
       <>
        <tr>
            <td style={{width:'200px',backgroundColor:'#ccf'}} rowSpan={4} align="center"> 
                <img alt="" src={require(`../image/${item.sphoto}`)}
                style={{width:'120px',height:'130px',border:'1px solid gray'}}/>
                <br/>
                <div onClick={()=>deleteSangpum(idx)}>
                <CloseSharp style={{cursor:'pointer'}}/>
                </div>
            </td>
            <td>상품번호 : {idx+1}번</td>
        </tr>
        <tr>
            <td>상품명 : {item.sname}</td>
        </tr>
        <tr>
            <td>상품가격 : {item.sprice}원</td>
        </tr>
        <tr>
            <td>상품색상 :
                <b style={{backgroundColor:item.scolor}}>{item.scolor}</b>
            </td>
        </tr>
       </>
    )
}
export default OneSubApp