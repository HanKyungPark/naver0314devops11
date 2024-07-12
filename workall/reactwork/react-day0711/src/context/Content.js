import { useContext } from "react";
import { ThemeContext } from "./ThemeContext"; // ThemeContext를 올바르게 가져옵니다.
import { UserContext } from "./UserContext";

const Content = () => {
    const { isDark } = useContext(ThemeContext); // inDark를 isDark로 변경하여 일관성 유지.
    const myname = useContext(UserContext);

    return (
        <div className="content" style={{ backgroundColor: isDark ? 'gray' : 'white' }}>
            <h1>{myname}님과 리액트 공부중</h1>
        </div>
    );
};

export default Content;
