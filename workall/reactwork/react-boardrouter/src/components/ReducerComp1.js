import { Alert, Button } from "@mui/material"
import { Action } from "@remix-run/router"
import { useReducer, useState } from "react"
// state 관리가 용이하며 유지,보수가 편리하다
    // 호출 : dispath(type,action) 로 호출시 ->reducer(state,action) 함수가 호출됨
    // reducer : state 를 업데이트하는 역할
    // dispath-state 업데이트를 요구
    // action : 요구의 내용

    //상수 등록
    const ACTION_TYPES={
        add:'addmoney',
        sub:'submoney',
    }

    //첫번째 예제는 간단하게 입출금하는 예제
const reducer =(state,action)=>{
    console.log("reducer(은행) 가 일을 합니다",state,action)

    //action type 에 따라 state(money) 값을 변경 처리
    switch(action.type){
        case ACTION_TYPES.add:
            return state+Number(action.payload);
            case ACTION_TYPES.sub:
                return state-Number(action.payload);
                default:
                    return state;
    }

}
const ReducerComp1=()=>{
    const [number,setNumber]=useState(0);
    const [money,dispath]=useReducer(reducer,0);
    return(
        <div>
            <Alert>Reducer Component #1</Alert>
            <h3>useReducer 은행에 오신것을 환영합니다</h3>
            <h3>잔고 : <b>{money}</b></h3>
            <hr/>
            <input type="number" value={number}
            step={1000} onChange={(e)=>setNumber(e.target.value)}
            className="font-control" style={{width:'200px'}}/>
            <Button variant="contained" size="small" color="success"
            onClick={()=>dispath({'type':ACTION_TYPES.add,payload:number})}>입금</Button>

            &nbsp;&nbsp;
            <Button variant="contained" size="small" color="success"
            onClick={()=>dispath({'type':ACTION_TYPES.sub,payload:number})}>출금</Button>
        </div>
    )
}
export default ReducerComp1