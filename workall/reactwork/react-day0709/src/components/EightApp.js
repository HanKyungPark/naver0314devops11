import React from 'react';
import './MyStyle.css';
import { Alert } from "react-bootstrap";


const EightApp = () => {
    const personArray = [
        { pname: "전지현", photo: "8.jpg", addr: "제주도애월읍", age: 45 },
        { pname: "설현", photo: "15.jpg", addr: "부산 해운대구", age: 26 },
        { pname: "신민아", photo: "17.jpg", addr: "서울시 강남구", age: 31 },
        { pname: "수지", photo: "19.jpg", addr: "서울시 여의도", age: 29 },
        { pname: "강동원", photo: "9.jpg", addr: "경기도 용인시", age: 41 }
    ];

    return (
        <div>
            <Alert>EightApp-table 을 이용해서 출력</Alert>
            {/* <table className="table table-bordered" style={{ width: "500px" }}>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                        <th>사진</th>
                        <th>주소</th>
                        <th>나이</th>
                    </tr>
                </thead>
                <tbody>
                    {personArray.map((item, idx) => (
                        <tr key={idx}>
                            <td>{idx + 1}</td>
                            <td>{item.pname}</td>
                            <td><img alt='' src={require(`../image/${item.photo}`)} className='smallphoto' /></td>
                            <td>{item.addr}</td>
                            <td>{item.age}</td>
                        </tr>
                    ))}
                </tbody>
            </table> */}
            <table className='table table-bordered' style={{width:"500px"}}>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                        <th>사진</th>
                        <th>주소</th>
                        <th>나이</th>
                    </tr>
                </thead>
                <tbody>
                   {personArray.map((item,idx)=>(
                    <tr key={idx}>
                        <td>{idx+1}</td>
                        <td>{item.pname}</td>
                        <td><img alt='' src={require(`../image/${item.photo}`)} className='smallphoto'/></td>
                        <td>{item.addr}</td>
                        <td>{item.age}</td>
                    </tr>
                   ))}
                </tbody>

            </table>
        </div>
    );
};

export default EightApp;
