import { Button } from "@mui/material";
import "./MyStyle.css";
const SixChild1App=(props)=>{
    let {carname,carphoto,carprice,onIncre}=props;

    return(
        <div className="box2" style={{backgroundColor:props.bgcolor}}>
            자동차명 : {carname}<br/>
            가격 : {carprice}만원<br/>
            사진 : <br/>
            <img src={require(`../mycar/${carphoto}`)}
            className="small2"/>
            <br/>
            <Button variant='outlined' color="error"
            size="small" onClick={onIncre}>방문</Button>
        </div>
    )
}
export default SixChild1App