import FiveChild2App from "./FiveChild2App"
import FiveChildApp from "./FiveChildApp"

const { Alert } = require("@mui/material")

const FiveApp =()=>{
    return(
        <div>
            <Alert>FiveApp-부모,자식 컴포넌트의 통신 #1</Alert>
            <h5>FiveChildApp 컴포넌트 호출</h5>
            <FiveChildApp irum={'정진욱'} age={28} addr={'서울시'}/>
            <FiveChildApp irum={'손가원'} age={25} addr={'까치산'}/>
            <FiveChildApp irum={'이장우'} age={27} addr={'안산시'}/>

            <h5>FiveChild2App 컴포넌트 호출</h5>
            <FiveChild2App irum={'이장우'} photo={"mycar11.png"} msg={"노랑이차"}/>
            <FiveChild2App irum={'김도훈'} photo={"mycar13.png"} msg={"분홍이차"}/>
        </div>
    )
}
export default FiveApp