import {Alert, Switch} from '@mui/material';
import React, { useState } from 'react';
import img1 from '../image/17.jpg';
import img2 from '../image/12.jpg';

const ThreeApp=()=>{
    const[show,setShow]=useState(true);
    const[visible,setVisible]=useState('visible');

    const photoStyle={
        width:'200px',
        height:'250px',
        border:'1px solid gray',
        borderRadius:'100px'
    }

    //체크박스 이벤트
    const photocheckEvent=(e)=>setShow(e.target.checked);
    //Switch 이벤트
    const photoSwitchEvent=(e)=>{
        setVisible(e.target.checked?"visible":"hidden");
    }
    return(
        <div>
            <Alert>ThreeApp</Alert>
            <Alert severity='info'>이미지 show/hide 하는 여러 방법</Alert>
            <label>
                <input type='checkbox'defaultChecked
                onClick={photocheckEvent}/>사진1보이기
            </label>
            <br/>
            {
                show &&
            <img src={img1} style={photoStyle}/>
            }
            <hr/>
            <Switch color ="primary" defaultChecked
            onChange={photoSwitchEvent}/>
            <br/>
            <img alt='' src={img2} style={{width:'200px',visibility:visible}}/>
        </div>
    )
}

export default ThreeApp;