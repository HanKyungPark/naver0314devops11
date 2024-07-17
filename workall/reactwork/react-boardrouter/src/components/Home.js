import { Alert } from "@mui/material";
import mainphoto1 from '../image/1.jpg';
import mainphoto2 from '../image/2.jpg';


const Home=()=>{
    return(
        <div>
            <Alert>Home</Alert>
            <div style={{marginTop:'30px'}}>
                <img alt="" src={mainphoto1}
                style={{width:'200px',height:'200px'}}/>
                <img alt="" src={mainphoto2}
                style={{width:'200px',height:'200px'}}/>
            </div>
        </div>
    )
}
export default Home;