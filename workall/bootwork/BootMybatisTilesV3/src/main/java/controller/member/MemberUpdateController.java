package controller.member;

import data.dto.MemberDto;
import data.service.Memberservice;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberUpdateController {

    @NonNull
    private Memberservice memberservice;

    @ResponseBody
    @PostMapping("/upload")
    public Map<String,String> uploadPhoto(
            @RequestParam("upload")MultipartFile upload,
            @RequestParam int num,
            HttpServletRequest request
            ) {

        String savePath = request.getSession().getServletContext().getRealPath("/save");

        //업로드한 파일의 확장자 분리
        String ext = upload.getOriginalFilename().split("\\.")[1];
        //업로드할 파일명
        String photo = UUID.randomUUID() + "." + ext;

        //실제 업로드
        try {
            upload.transferTo(new File(savePath+"/"+photo));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //db 에서 photo 수정
        memberservice.updateMember(num, photo);
        Map<String, String> map = new HashMap<>();
        map.put("photoname", photo);
        return map;
    }
    @GetMapping("/updateform")
    public String updateMember2(@RequestParam int num, Model model) {

        model.addAttribute("dto", memberservice.getData(num));
        return "member/memberupdate";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDto dto) {
        memberservice.updateMember2(dto);
        return "redirect:./detail?num="+dto.getNum();
    }

    @ResponseBody
    @PostMapping("/delete")
    public Map<String, String> delete(@RequestParam int num, @RequestParam String passwd) {
        Map<String, String> map= new HashMap<>();
        //비번이 맞으면 데이타 삭제
        boolean b = memberservice.inEqualPassCheck(num, passwd);

        if (b) {
            memberservice.deleteMember(num);
        }
        map.put("status",b?"success":"fail");
        return map;
    }



}
