import { Alert } from "@mui/material"
import './MyStyle.css';

// const FiveChild2App=({photo,msg})=>{
    const FiveChild2App=(props)=>{
        let {photo,msg}=props
    return(
        <div className="box1">
            <img alt="" src={require(`../mycar/${photo}`)} className="small"/>
            <b>{msg}</b>
        </div>
    )
}

export default FiveChild2App;