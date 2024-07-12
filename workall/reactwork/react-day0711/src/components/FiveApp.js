import { Alert } from "@mui/material";
import Axios from "axios";
import { useEffect, useState } from "react";
import FiveRowItem from "./FiveRowItem";

const FiveApp = () => {
    const [mycarlist, setMyCarList] = useState([]);

    // 백엔드에서 mycar 목록을 가져온다
    const list = () => {
        Axios.get("/mycar/list")
            .then(res => {
                setMyCarList(res.data);
            })
            .catch(error => {
                console.error("There was an error fetching the car list!", error);
            });
    };

    // 처음 로딩시 목록 가져오기
    useEffect(() => {
        list();
    }, []); // 처음 한번만 호출

    return (
        <div>
            <Alert>FiveApp-Axios db데이타 가져오기</Alert>
            <Alert severity="info">총 {mycarlist.length}개의 자동차정보가 있습니다</Alert>
            <table className="table table-bordered" style={{width:'400px'}}>
                <tbody>
                    {
                        mycarlist.map((mycar,idx)=>
                        <FiveRowItem mycar={mycar} key={idx}/>)
                    }
                </tbody>
                
            </table>
        </div>
    );
};

export default FiveApp;
