import { DeleteForeverOutlined } from "@mui/icons-material";
import "./MyStyle.css";
import { Button } from "@mui/material";
const SixChild2App=({row,onDelete,idx})=>{
    
    return(
        <tr style={{backgroundColor:row.color}}>
            <td>{row.cname}</td>
            <td>
               <img alt='' src={require(`../mycar/${row.cphoto}`)} className='small'/>
            </td>
            <td>{row.cprice}만원</td>
            <Button size="small" color="error" variant='contained'
            startIcon={<DeleteForeverOutlined/>}
            onClick={()=>onDelete(idx)}>Del</Button>
        </tr>
    )
}
export default SixChild2App