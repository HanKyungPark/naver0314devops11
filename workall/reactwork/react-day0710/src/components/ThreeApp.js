import { useState,useRef } from "react"

const { Alert } = require("@mui/material")
/*
useRef : 변수를 관리하는 기능, 값이 변경되어도 다시 랜더링이되지 않는다.
형식(state 변수는 매번 화면이 랜더링된다.)
const ref=useRef(value);
값을 가져오려면
ref.current
*/
const ThreeApp =()=>{
    const [count,setCount]=useState(1);
    const countRef=useRef(1);
    console.log("랜더링중...")

    //count 변수 1 증가하는 이벤트
    const countIncre=()=>setCount(count+1);
    //ref 변수 1 증가하는 이벤트
    const countRefIncre=()=>{
        countRef.current=countRef.current+1;
        //화면이 랜더링되지 않아 확인이 안되므로 콘솔로 바뀐값을 확인해보자
        console.log("countRef.current="+countRef.current);
    }
    return(
        <div>
            <Alert>ThreeApp-UseRef 공부하기</Alert>
            <h1>state 변수 : {count}</h1>
            <h1>ref 변수 : {countRef.current}</h1>
            <hr/>
            <button variant='contained' color="success"
            onClick={countIncre}>
                state 변수 1 증가하기
            </button>
            <br/><br/>
            <button variant='contained' color="success"
            onClick={countRefIncre}>
                ref 변수 1 증가하기
            </button>
        </div>
    )
}
export default ThreeApp