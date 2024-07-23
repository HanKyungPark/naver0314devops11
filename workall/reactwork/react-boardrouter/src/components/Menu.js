import { Button } from "@mui/material";
import { NavLink } from "react-router-dom";

const Menu=()=>{
    return(
        <ul className="main_menu">
            <li>
                <NavLink to={'/'}>Home</NavLink>
                </li>
                <li>
                <NavLink to={'/board/form'}>글쓰기</NavLink>
                </li>
                <li>
                <NavLink to={'/board/list'}>목록</NavLink>
            </li>
            <li>
                <NavLink to={'/post'}>카카오주소</NavLink>
            </li>
            <li>
                <NavLink to={'/sweet'}>SweetAlert</NavLink>
            </li>
            <li>
                <NavLink to={'/reducer1'}>Reducer #1</NavLink>
            </li>
            <li>
                <NavLink to={'/reducer2'}>Reducer #2</NavLink>
            </li>
            <li>
                <NavLink to={'/memo'}>useMemo</NavLink>
            </li>
            <li>
                <NavLink to={'/callback'}>useCallback</NavLink>
            </li>
            <li>
                <NavLink to={'/member/list'}>회원목록</NavLink>
            </li>
            <li>
                <NavLink to={'/member/form'}>회원가입</NavLink>
            </li>
            <li>
                {
                    sessionStorage.token==null?
                    <NavLink to={'/login'}>로그인</NavLink>
                    :
                    <Button variant="contained" color="error"
                    onClick={()=>{
                        sessionStorage.removeItem("token");
                        window.location.reload();
                    }}>로그아웃</Button>
                }
            </li>
        
        </ul>
    )
}
export default Menu;