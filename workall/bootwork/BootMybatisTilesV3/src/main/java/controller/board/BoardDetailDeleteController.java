package controller.board;

import data.dto.ReBoardDto;
import data.service.Memberservice;
import data.service.ReBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardDetailDeleteController {

    @Autowired
    private ReBoardService boardService;

    @Autowired
    private Memberservice memberservice;

    @GetMapping("/detail")
    public String detail(
            @RequestParam int num,
            @RequestParam int currentPage,
            Model model
    ) {

        //조회수 증가
        boardService.updateReadcount(num);
        //num 에 해당하는 글 가져오기
        ReBoardDto dto = boardService.getData(num);
        //해당 아이디가 갖고 있는 프로픨 사진 가져오기
        String profile_photo = memberservice.getDatabyid(dto.getMyid()).getPhoto();

        model.addAttribute("profile_photo", profile_photo);
        model.addAttribute("dto", dto);
        model.addAttribute("currentPage",currentPage );

        return "board/detailpage";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int num, @RequestParam int currentPage) {
        boardService.deleteBoard(num);

        return "redirect:./list?currentPage=" + currentPage;
    }

}
