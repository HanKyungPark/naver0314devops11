package controller.board;

import data.dto.ReBoardDto;
import data.service.ReBoardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import naver.cloud.NcpObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardUpdateController {

    @NonNull
    private ReBoardService boardService;

    private String bucketName="bitcamp-bucket-56";
    private String folderName = "photocommon";

    @Autowired
    private NcpObjectStorageService storageService;

    @GetMapping("/updateform")
    public String updateForm(
            @RequestParam int num,
            @RequestParam int currentPage,
            Model model
    ) {

        model.addAttribute("currentPage", currentPage);
        //dto 얻기
        ReBoardDto dto = boardService.getData(num);
        model.addAttribute("dto", dto);
        return "board/updateform";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ReBoardDto dto,
                         @RequestParam("upload") MultipartFile upload,
                         @RequestParam int currentPage,
                         HttpServletRequest request) {

        //업로드 경로
//        String saveFolder = request.getSession().getServletContext().getRealPath("/save");
//        //업로드 안했을경우 null 값 보내서 수정시 컬럼제외
//        String uploadphoto = null;
//        if (!upload.getOriginalFilename().equals("")) {
//            //확장자 분리
//            String ext = upload.getOriginalFilename().split("\\.")[1];
//            uploadphoto = java.util.UUID.randomUUID() + "." + ext;
//
//            //업로드
//            try {
//                upload.transferTo(new File(saveFolder + "/" + uploadphoto));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        String uploadphoto= storageService.uploadFile(bucketName,folderName,upload);

        //dto 사진변경
        dto.setUploadphoto(uploadphoto);
        boardService.updateBoard(dto);
        return "redirect:./detail?num=" + dto.getNum() + "&currentPage=" + currentPage;
    }
}
