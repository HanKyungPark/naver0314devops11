package bit.mycar.controller;

import bit.mycar.data.MycarDto;
import bit.mycar.service.MyCarService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MyCarListController {

    final MyCarService myCarService;
    final NcpObjectStorageService storageService;


    private String buckName = "hankyung133";
    private String folderName = "mycar";


    @GetMapping("/mycar/list")
    public List<MycarDto> list() {

        return myCarService.getAllDatas();
    }

    //사진만 먼저 업로드
    @PostMapping("/mycar/upload")
    public Map<String, String> uploadPhoto(@RequestParam("upload") MultipartFile upload) {
        System.out.println("upload" + upload.getOriginalFilename());
        //스토리지에 업로드후 업로드된 파일명 반환
        String carphoto = storageService.uploadFile(buckName, folderName, upload);
        Map<String, String> map = new HashMap<>();
        map.put("carphoto", carphoto);
        return map;
    }

    //dto 데이타 db 저장(json->dto)
    @PostMapping("/mycar/insert")
    public void insert(@RequestBody MycarDto dto) {

        System.out.println("insert dto >>" + dto);//toString 호출
        myCarService.insertMycar(dto);
    }

    //삭제 함수
    @DeleteMapping("/mycar/delete")
    public void deleteMycar(@RequestParam("num") Long num) {
        System.out.println("delete>>" + num);

        //db삭제전에 스토리지의 사진부터 먼제삭제
        String oldPhotoname = myCarService.getData(num).getCarphoto();
        storageService.deleteFile(buckName, folderName, oldPhotoname);

        //db삭제
        myCarService.deleteMycar(num);

    }

    @PostMapping("/mycar/update")
    public void updateMycar(@RequestBody MycarDto dto) {
        System.out.println("update>>"+dto);
        myCarService.updateMycar(dto);
    }
}
