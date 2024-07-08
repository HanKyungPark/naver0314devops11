//첫 컴포넌트는 클래스 형태로 만들어보자
//Hooks 문법이 추가된 이후는 class 형태보다는 function형태로 많이 만든다


import { Component } from 'react';
import car1 from '../mycar1.png';
import car2 from '../mycar2.png';
import car3 from '../mycar3.png';
import './MyStyle.css';

class OneApp extends Component

{
    render(){
        return(
            <div>
                <h1 className="alert alert-danger">OneApp-class형태</h1>
                <h5>Public 의 사진 가져오기</h5>
                {/* public 의 사진은 매핑주소에 따라서 안나올떄도 있다-권장안함 */}
                <img src="./1.jpg" alt="사진1" width={200}/>
                <img src="./2.jpg" alt="사진2"
                style={{width:'200px',border:'5px solid green',
                borderRadius:'50px 20px 100px 10px'}}/>

                <h5>src 폴더의 사진 가져오기</h5>
                <img alt="자동차1" src={car1} className='photo line1'/>
                <img alt="자동차2" src={car2} className='photo line2'/>
                <img alt="자동차3" src={car3} className='photo line3'/>
            </div>
        )
    }
}

// export default OneApp;//default 는 단 한번만 사용가능,import 시에 마음대로 이름을 지정할수 있다.
export {OneApp} //이경우에는 import 시에 정확한 이름으로 import해야한다