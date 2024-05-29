package controller.board;

import data.dto.BoardAnswerDto;
import data.service.BoardAnswerService;
import data.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardAnswerController {
    @Autowired
    private BoardAnswerService answerService;
    @Autowired
    private Memberservice memberservice;

    @PostMapping("/ainsert")
    public void insertAnswer(@RequestParam int num, @RequestParam String content,
                             HttpSession session) {
        //로그인한 아이디 얻기
        String myid = (String) session.getAttribute("loginid");
        //아이디에 해당하는 이름 얻기
        String writer = memberservice.getDatabyid(myid).getName();
        //dto 에 필요한 데이터 넣기
        BoardAnswerDto dto = BoardAnswerDto.builder()
                .myid(myid)
                .writer(writer)
                .content(content)
                .num(num).build();

        //db insert
        answerService.insertAnswer(dto);
    }

    @GetMapping("/alist")
    public List<BoardAnswerDto> alist(@RequestParam int num) {
        return answerService.getAnswerData(num);
    }

    @GetMapping("/adelete")
    public void deleteAnswer(@RequestParam int aidx) {
        answerService.deleteAnswer(aidx);
    }
}
