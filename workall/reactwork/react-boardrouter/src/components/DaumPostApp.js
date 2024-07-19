import { Alert, Button, Dialog } from "@mui/material";
import React, { useState } from "react";
import DaumPostcode from 'react-daum-postcode'
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
const DaumPostApp=()=>{
    const [openPostcode,setOpenPostcode]=useState(false);
    const [address,setAddress]=useState('');
    const [open, setOpen] = useState(false);

    const [openPostcode2,setOpenPostcode2]=useState(false);
    const [address2,setAddress2]=useState('');

    const addrhandle={
        clickButton:()=>{
            setOpenPostcode(current=>!current);
        },

        //주소 선택 이벤트
        selectAddress:(data)=>{
            console.dir(data);

            setAddress(`
            주소 :${data.address}
            아파트명(빌딩명) : ${data.buildingName},
            우편번호 :${data.zonecode}`);
            setOpenPostcode(false);
        }
    }

    const handleClose = () => {
        setOpen(false);
      };

    const addrhandle2={
        clickButton:()=>{
            setOpenPostcode(current=>!current);
            setOpen(true);
        },

        //주소 선택 이벤트
        selectAddress:(data)=>{
            console.dir(data);
            
            setAddress2(`
            주소 :${data.address}
            아파트명(빌딩명) : ${data.buildingName},
            우편번호 :${data.zonecode}`);
            setOpenPostcode2(false);
            //다이얼로그 닫기
            setOpen(false);
        }
    }
    return(
        <div>
            <Alert>카카오 주소 나타내기</Alert>
            <h4>카카오 주소 나타내기</h4>
            <Button variant="contained" color="success" size="small"
            onClick={addrhandle.clickButton}>주소검색</Button>

            <h3>{address}</h3>
            {
                openPostcode &&
                <DaumPostcode
                onComplete={addrhandle.selectAddress}//갑승ㄹ 선택할경우 실행되는 이벤트
                autoClose={false}//값을 선택할 경우 사용되는 DOM 을 제거하여 자동으로 닫힘 설정
                defaultQuery="강남대로 94길 20" // 팝업을 열떄 기본적으로 입력되는 검색어
                />
            }
            <hr/>
            <h4>카카오 주소 나타내기 #2</h4>
            <Button variant="contained" color="success" size="small"
            onClick={addrhandle2.clickButton}>주소검색2</Button>

            <h3>{address2}</h3>

            <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
      >
        <DialogTitle id="alert-dialog-title">
          카카오 주소 검색
        </DialogTitle>
        <DialogContent>
          {/* <DialogContentText id="alert-dialog-description">
            
          </DialogContentText> */}
          
                <DaumPostcode
                onComplete={addrhandle.selectAddress}//갑승ㄹ 선택할경우 실행되는 이벤트
                autoClose={false}//값을 선택할 경우 사용되는 DOM 을 제거하여 자동으로 닫힘 설정
                defaultQuery="반포자이" // 팝업을 열떄 기본적으로 입력되는 검색어
                />

        </DialogContent>
        <DialogActions>
          
          <Button onClick={handleClose} autoFocus>
            닫기
          </Button>
        </DialogActions>
      </Dialog>
        </div>
    )
}
export default DaumPostApp;