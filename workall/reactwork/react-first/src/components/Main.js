//Main 에 각종 컴포넌트를 배치해보자
//이번에는 함수형으로 만들어보자


import { useState } from "react";
import FiveApp from "./FiveApp.js";
import FourApp from "./FourApp.js";
import { OneApp } from "./OneApp"
import SixApp from "./SixApp.js";
import ThreeApp from "./ThreeApp.js";
import TwoApp from "./TwoApp.js";


const Main=()=>{
    const [idx,setIdx]=useState(6)
        return(
            <div>
                {/* <SixApp/>
                <hr/>
                <FiveApp/>
                <hr/>
                <FourApp/>
                <hr/>
                <ThreeApp/>
                <hr/>
                <TwoApp/>
                <hr/>
                <OneApp/> */}
                <h1>2024-07-08 리액트 첫수업</h1>
                <select className="form-select" style={{width:'200px'}}
                onChange={(e)=>setIdx(Number(e.target.value))}>
                    <option value={1}>1번 컴포넌트</option>
                    <option value={2}>2번 컴포넌트</option>
                    <option value={3}>3번 컴포넌트</option>
                    <option value={4}>4번 컴포넌트</option>
                    <option value={5}>5번 컴포넌트</option>
                    <option value={6} selected>오늘의 문제</option>
                </select>
                <br/><br/>
                {
                    idx===1?<OneApp/>:idx===2?<TwoApp/>:
                    idx===3?<ThreeApp/>:idx===4?<FourApp/>:
                    idx===5?<FiveApp/>:<SixApp/>
                }
            </div>
            )
}
export default Main;