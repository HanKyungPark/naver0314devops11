package day0520.uploadcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadOneController {

    @GetMapping("uploadform1")
    public String upload1() {
        return "upload/uploadform1";
    }

    @PostMapping("/upload1")
    public String uploadPhoto1(
            @RequestParam String title,
            @RequestParam("upload") MultipartFile upload,
            HttpServletRequest request,
            Model model
    )
    {
        //톰캣서버에 배포된 프로젝트에서 이미지가 업로드될 경로구하기
        String realFolder=request.getSession().getServletContext().getRealPath("/resources/upload");
        System.out.println(realFolder);//콘솔로 출력후 탐색기를 열어서 이미지를 확인해주세요

        //업로드할 파일명
        String fileName = upload.getOriginalFilename();

        

        //위의 경로에 해당 파일명을 업로드해보자
        try {
            upload.transferTo(new java.io.File(realFolder, fileName));

            //업로드시 오류가 없다면 model에 저장
            model.addAttribute("title", title);
            model.addAttribute("photo", fileName);

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }

        return "upload/resultphoto1";
    }
}
