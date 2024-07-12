import { useContext } from "react"; // useContext를 import
import { Button } from "@mui/material"; // "@mui/base" 대신 "@mui/material" 사용 (일반적으로 MUI Button 컴포넌트는 "@mui/material"에서 가져옵니다)
import { ThemeContext } from "./ThemeContext";

const Footer = () => {
    const { isDark, setIsDark } = useContext(ThemeContext); // inDark를 isDark로 변경하여 일관성 유지

    const toggleDarkMode = () => {
        setIsDark(prevMode => !prevMode); // 다크 모드를 토글하는 함수
    };

    return (
        <footer className="footer" style={{ backgroundColor: isDark ? 'pink' : 'cyan' }}>
            <Button variant="contained" color="error"
            onClick={()=>setIsDark(!isDark)}>
                Dark Mode
            </Button>
        </footer>
    );
};

export default Footer;
