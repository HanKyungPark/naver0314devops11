import { useState } from "react"
import SixChild1App from "./SixChild1App"
import SixChild2App from "./SixChild2App";

const { Alert } = require("@mui/material")

const SixApp =()=>{
    const [count,setCount]=useState(0);
    const [array,setArray]=useState([
        {cname:"아우디",cphoto:"mycar15.png",cprice:'2300',color:"#afeeee"},
        {cname:"벤츠",cphoto:"mycar7.png",cprice:'3400',color:"#ffc0cb"},
        {cname:"제네시스",cphoto:"mycar12.png",cprice:'1700',color:"#e0ffff"},
        {cname:"미니",cphoto:"mycar11.png",cprice:'4200',color:"#40e0d0"}
    ])

    //삭제하는 함수
    const deleteCar=(idx)=>{
        // alert(idx)
        setArray(array.filter((a,i)=>i!==idx));

    }
    //count 변경 이벤트
    const countIncre=()=>setCount(count+1);
    return(
        <div>
            <Alert>SixApp-부모자식간의 통신 #2</Alert>
            <Alert severity="error" style={{fontSize:'20px'}}>
                회원 방문 횟수 : {count} 회</Alert>
            <SixChild1App carname="아반떼" carphoto="mycar8.png" 
           bgcolor="#ffc0cb" carprice="3500" onIncre={countIncre}/>
            <SixChild1App carname="그랜저" carphoto="mycar5.png" 
          bgcolor="#7fffd4"  carprice="4700" onIncre={countIncre}/>
           {/* <SixChild1App carname="벤츠" carphoto="mycar13.png" 
          bgcolor="orange"  carprice="2100" onIncre={countIncre}/> */}
          <hr style={{clear: 'both'}}/>
          <table className="tbstyle">
            <thead>
                <tr style={{backgroundColor:'#f5f5dc'}}>
                    <th style={{width:'140px'}}>자동차명</th>
                    <th style={{width:'90px'}}>사진</th>
                    <th style={{width:'100px'}}>가격</th>
                    <th style={{width:'100px'}}>삭제</th>
                </tr>
            </thead>
            <tbody>
                {
                array.map((item,idx)=><SixChild2App row={item} key={idx}
               idx={idx} onDelete={deleteCar}/>)
            }
            </tbody>
          </table>
        </div>
    )
}
export default SixApp