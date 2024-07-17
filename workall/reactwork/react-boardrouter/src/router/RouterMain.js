import { Route, Routes } from "react-router-dom";
import Menu from "../components/Menu";
import '../components/MyStyle.css';

import BoardForm from "../components/BoardForm";
import BoardList from "../components/BoardList";
import BoardDetail from "../components/BoardDetail";
import Home  from "../components/Home";
const RouterMain=()=>{
    return(
        <div>
            <Menu/>
            <br style={{clear:'both'}}/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/board">
                    <Route path="form" element={<BoardForm/>}/>
                    <Route path="list" element={<BoardList/>}/>
                    <Route path="detail/:boardnum" element={<BoardDetail/>}/>
                </Route>
            </Routes>
        </div>
    )
}
export default RouterMain;