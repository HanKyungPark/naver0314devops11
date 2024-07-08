import { useState } from 'react';
import s1 from '../mycar1.png';
import s2 from '../mycar2.png';
import s3 from '../mycar3.png';


const SixApp=()=>{

     const [show,setShow]=useState(true);
     const [name,setName]=useState('리액트 문제 다풀면 복습 100%보장');
     const [border,setBorder]=useState('solid');
     const [photo,setPhoto]=useState(s1);
     const [width,setWidth]=useState(200);
    
    return(
        <div>
            SixApp숙제
            <br/>
            <input type='checkbox'
             onClick={()=>setShow(!show)}/>사진숨김
              {
                show &&
                <img alt='car' src={photo} style={{width:`${width}px`,border:`10px ${border},pink`,marginLeft:'20px'}}/>
            }
            

            <button type='button' className='btn btn-outline-danger'
                style={{marginLeft:'60px'}} onClick={(e)=>setWidth(width-10)}>점점작게</button>
                <button type='button' className='btn btn-outline-danger'
                style={{marginLeft:'10px'}} onClick={(e)=>setWidth(width+10)}>점점크게</button>  
            <br/>
            <table>
                <tr>
                    <th>
                <input type='text' value={name}
                onChange={(e)=>setName(e.target.value)}/>
                    </th>
                </tr>
            </table>
            <br/>
            <br/>
            <select className='form-select' style={{width:'120px'}}
            onChange={(e)=>setPhoto(e.target.value)}>
                <option value={s1}selected>1</option>
                <option value={s2}>2</option>
                <option value={s3}>3</option>
                
            </select>
            <select className='form-select' style={{width:'120px'}}
            value={border}
            onChange={(e)=>setBorder(e.target.value)}>
                <option selected>solid</option>
                <option>dashed</option>
            </select>
            {/* <img src={s1} alt='1' style={{width:'200px'}}/> */}
            <br/>
            <br/>
           <div >
                {name}
           </div>

        </div>
    )
}



export default SixApp