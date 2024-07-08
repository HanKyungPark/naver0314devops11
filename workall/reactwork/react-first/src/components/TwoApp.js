import './MyStyle.css';
const TwoApp=()=>{
    let message="Have a Good Day!!!";
    return(
        <div>
            <h1 className="alert alert-danger">TwoApp-function형태</h1>
            {/* 3개의 div 에 class msg 를 적용하시오
            첫번째 div 는 배경색을 'orange',border를 '10ㅔㅌ solid gray'
            두번째 div 는 배경색을 pink, 글자색을 blue, box-shadow 넣기
            세번째 div 는 border 를 '10px groove gold' border-radius 값을 30px*/}

            <div className='msg div1'>{message}</div>
            <div className='msg div2'>{message}</div>
            <div className='msg div3'>{message}</div>
        </div>
    )
}

export default TwoApp;