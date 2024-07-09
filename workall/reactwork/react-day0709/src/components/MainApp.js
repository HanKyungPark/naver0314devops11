import 'bootstrap/dist/css/bootstrap.min.css';
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import SixApp from "./SixApp";
import { useState } from "react";
import SevenApp from './SevenApp';
import EightApp from './EightApp';


const Main=()=>{
    const [idx,setIdx]=useState(8);

    return(
        <div>
    <select className="form-select" style={{width:'200px'}}
    onChange={(e)=>setIdx(Number(e.target.value))}>
            <option value={1}>OneApp-styled-components</option>
            <option value={2}>TwoApp-이미지불러오기</option>
            <option value={3}>ThreeApp</option>
            <option value={4}>FourApp-mui의 Card</option>
            <option value={5}>FiveApp-useEffect</option>
            <option value={6}>SixApp-map반복문</option>
            <option value={7}>SevenApp</option>
            <option value={8}selected>EightApp</option>
    </select>
    <br/>

{
        idx===1?<OneApp/>:idx===2?<TwoApp/>:
        idx===3?<ThreeApp/>:idx===4?<FourApp/>:
        idx===5?<FiveApp/>:idx===6?<SixApp/>:
        idx===7?<SevenApp/>:<EightApp/>
}
</div>
    );
}

export default Main;