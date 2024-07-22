import { Alert, Button } from "@mui/material";
import Swal from "sweetalert2";
import xmas1 from '../image/1.jpg';
import xmas2 from '../image/2.jpg';
import xmas4 from '../image/4.jpg';


const SweetAlertApp=()=>{
    const buttonEvent1=()=>{
        Swal.fire('안녕하세요')//기본

    }
    const buttonEvent2=()=>{
        Swal.fire({
            title:"Swal Test #2",
            //text:"줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>"
            html:"줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>줄바꿈을 해볼까요<br/>",
            icon:"success" /*warning, success,info, error*/,
            confirmButtonColor:"#abcabc",
            confirmButtonText:"확인",
            showCancelButton:true,
            cancelButtonColor:"orange",
            cancelButtonText:"취소"
        }).then(result=>{
            if(result.isConfirmed){
                Swal.fire("처리했습니다")
            }else{
                Swal.fire("취소했습니다")
            }
        })
        
    }
    const buttonEvent3=()=>{
        Swal.fire({
            title:'사진넣기',
            html:`<h5>사진을 넣어보세요</h5>
            <img alt ='' src=${xmas2}`,
            imageUrl:xmas1,
            icon:'success'
            
        })
        
    }
    const buttonEvent4=()=>{
        Swal.fire({
            title:"Input Email Address",
            input:'email',
            inputLabel:"Your Email Address",
            inputPlaceholder:"Enter Your email address",
            showCancelButton:true,
            cancelButtonColor:"orange",
            cancelButtonText:"Cancel"
        })
        
    }
    const buttonEvent5=()=>{
        
    }
    return(
        <div>
            <Alert>SweetAlert 공부하기</Alert>
            <Button variant="contained" color="error" size="small"
            onClick={buttonEvent1}>SweetAlert #1</Button>
            <br/><br/>
            <Button variant="contained" color="error" size="small"
            onClick={buttonEvent2}>SweetAlert #2</Button>
            <br/><br/>
            <Button variant="contained" color="error" size="small"
            onClick={buttonEvent3}>SweetAlert #3</Button>
            <br/><br/>
            <Button variant="contained" color="error" size="small"
            onClick={buttonEvent4}>SweetAlert #4</Button>
            <br/><br/>
            <Button variant="contained" color="error" size="small"
            onClick={buttonEvent5}>SweetAlert #5</Button>
        </div>
    )
}
export default SweetAlertApp;
