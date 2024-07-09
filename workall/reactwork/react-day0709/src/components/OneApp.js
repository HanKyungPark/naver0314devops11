import { AccessAlarm, BookmarkAdd } from "@mui/icons-material";
import { Button } from "@mui/material";
import styled from "styled-components";

const OneApp = () => {
    // styled-components 태그가 지정된 템플릿 리터럴(백틱)을 활용하여
    // 구성 요소의 스타일을 지정합니다.
    // h1 태그에 스타일을 추가해보자
    const Title = styled.h1`
        font-size: 1.5em;
        text-align: center;
        color: orange;
        background-color: pink;
    `;

    // button에 스타일을 추가해서 적용
    const Mybutton = styled.button`
        color: orange;
        width: 200px;
        height: 60px;
        border: 1px solid hotpink;
        border-radius: 30px;
        margin-top: 10px;
    `;

    // 기존 스타일 확장
    const MyButton2 = styled(Mybutton)`
        color: blue;
        background-color: yellow;
        border: 2px solid gray;
    `;

    //Title 을 확장한 Title2 를 직접 만들어보세요
    const Title2 = styled(Title)`
    width:200px;
    height:200px;
    line-height:200px;
    background-color:tomato;
    border:3px solid green;
    `

    return (
        <div>
            <h3 className="alert alert-danger">
                <AccessAlarm />
                <BookmarkAdd />
                OneApp
            </h3>
            <h1>Hello H1</h1>
            <Title>Hello Title</Title>
            <hr />
            <Button variant="outlined" color="success">Hello Button</Button>
            <Button variant="contained" color="success">Hello Button</Button>
            <br />
            <Mybutton>Mybutton Style</Mybutton>
            <MyButton2>MyButton2 Style</MyButton2>
            <Title2>Hello Title2</Title2>
        </div>
    );
}

export default OneApp;
