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
        </ul>
    )
}
export default Menu;