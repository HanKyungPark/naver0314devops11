import img1 from '../food/11.jpg';
import img2 from '../image/12.jpg';
import img3 from '../image/5.jpg';
import img4 from '../food/9.jpg';
import './MyStyle.css';
const SixApp=()=>{
    const names=["장미꽃","안개꽃","다알리아","목수국","채송화"]
    //이미지 배열
    const photos=[img1,img2,img3,img4];

    //방법1
    // const nameList=names.map(function(item,idx){
    //     return <li>{idx}:{item}</li>
    // })

    //위의 코드를 화살표함수로 변경해보세요
    const nameList=names.map((item,idx)=><li key={idx}>{idx}:{item}</li>)
    return(
        <div>
            <h3 className="alert alert-danger">SixApp-map 반복문</h3>
            <h5>미리 변수에 저장후 출력 #1</h5>
            <ul>
                {nameList}
            </ul>
            <hr/>
            <h5>직접 map 으로 반복하기 #2</h5>
            {
                names.map((item,idx)=><h5 key={idx}>{idx}:{item}</h5>)
            }
            <hr/>
            <h5>이미지 배열 출력하기</h5>
            {
                photos.map((photo,idx)=>
                <img key={idx} alt='' src={photo} className='photo'/>)
            }
        </div>
    )
}

export default SixApp;