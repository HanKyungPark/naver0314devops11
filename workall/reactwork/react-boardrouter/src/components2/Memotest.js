 /*
    use Memo : memoization : 랜더링을 최적화하기 위한 기능
    */

import { Button } from "@mui/material";
import { useState } from "react";
import ShowState from "./ShowState";

const MemoTest=()=>{
    const [number,setNumber]=useState(0);
    const [text,setText]=useState('');

    const increNumber=()=>{
        setNumber(number+1);
    }

    const decreNumber=()=>{
        setNumber(number-1);
    }
    
    const onChangeTextHandler=(e)=>{
        setText(e.target.value)
    }
   
    return(
        <div style={{fontSize:'2em',margin:'100px 100px'}}>
            <div>
            <Button variant="contained" color="success"
            onClick={increNumber}>+</Button>
            &nbsp;
            
            <Button variant="contained" color="success"
            onClick={decreNumber}>-</Button>
            <br/>
            <input type="text" placeholder="Last Name?"
            //value={text}
            onChange={onChangeTextHandler}/>
            </div>
            <ShowState number={number} text={text}/>
        </div>
    )
}
export default MemoTest;