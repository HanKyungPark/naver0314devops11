import './MyStyle.css';

const SevenApp=()=>{
    let array1=new Array(12);
    let foodArray=[
        {fname:"샌드위치",price:12000,photo:"1.jpg"},
        {fname:"망고빙수",price:16000,photo:"11.jpg"},
        {fname:"육개장",price:9000,photo:"3.jpg"}
    ]
    return(
        <div>
            <h1 className="alert alert-info">SevenApp-map 반복문</h1>
            <h5>food 의 1.jpg 부터 20.jpg 출력</h5>
            {
                [...array1].map((item,idx)=><img key={idx} alt='image' src={require(`../food/${idx+1}.jpg`)} className='smallphoto'></img>)
            }
            <hr/>
            <h5>image의 1.jpg ~ 12.jpg출력</h5>
            {
                [...new Array(20)].map((item,idx)=><img src={require(`../image/${idx+1}.jpg`)} className='smallphoto'/>)
            }
            <h5>food Array 배열안의 객체값 출력</h5>
            {
                foodArray.map((item,idx)=>
                <figure key={idx} style={{float:'left',marginRight:'10px'}}>
                    <img alt='' src={require(`../food/${item.photo}`)} className='smallphoto'/>
                    <figcaption>
                        <h6>음식명 : {item.fname}</h6>
                        <h6>가격 : {item.price}원</h6>
                    </figcaption>
                </figure>
                )
            }
        </div>
    )
}
export default SevenApp;