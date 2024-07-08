import react, { useState } from 'react'
import car1 from '../mycar1.png';

const FiveApp=()=>{
    const [show,setShow]=useState(true);
    const [fname,setFname]=useState('Gamja Flower');
    const [fcolor,setFcolor]=useState('red');
    const [bcolor,setBcolor]=useState('#afeeee')

    let message="오늘은 리액트를 공부중입니다.";
    return(
        <div>
            <h1 className='alert alert-danger'>FiveApp-글꼴변경</h1>
            <button type='button' className='btn btn-sm btn-info'
            onClick={()=>setShow(!show)}>show/hide</button>
            {
                show &&
                <img alt='car' src={car1} style={{width:'200px'}}/>
            }
            <hr/>
            <div style={{fontSize:'30px',color:fcolor,
            fontFamily:fname,backgroundColor:bcolor}}>
                {message}
                </div>
                <h5>select이벤트를 이용해서 글꼴변경하기</h5>
                <div className='input-group' style={{width:'300px'}}>
                    <select className='form-select' style={{width:'120px'}}
                    value={fname}
                    onChange={(e)=>setFname(e.target.value)}>
                    <option>East Sea Dokdo</option>
                    <option>Jua</option>
                    <option>Gaegu</option>
                    <option selected>Gamja Flower</option>
                    <option>Single Day</option>
                    </select>
                    &nbsp;&nbsp;
                    <select className='form-select' style={{width:'120px'}}
                    value={fcolor}
                    onChange={(e)=>setFcolor(e.target.value)}>
                    <option>hotpink</option>
                    <option selected>red</option>
                    <option>green</option>
                    <option>orange</option>
                    <option>black</option>
                    </select>
                    <br/>
                    &nbsp;&nbsp;
                    <label>
                        <input type='radio' defaultValue='#afeeee'
                        name='bcolor' defaultChecked
                        onClick={(e)=>setBcolor(e.target.value)}/>하늘색
                    </label>
                    &nbsp;&nbsp;
                    <label>
                        <input type='radio' defaultValue='#fffacd'
                        onClick={(e)=>setBcolor(e.target.value)}
                        name='bcolor'/>노랑색
                    </label>
                    &nbsp;&nbsp;
                    <label>
                        <input type='radio' defaultValue='#90ee90'
                        onClick={(e)=>setBcolor(e.target.value)}
                        name='bcolor'/>그린색
                    </label>
                </div>
        </div>
    )
}
export default FiveApp
