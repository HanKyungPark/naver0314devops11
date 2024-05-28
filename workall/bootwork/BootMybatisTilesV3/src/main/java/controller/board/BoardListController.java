package controller.board;

import data.dto.ReBoardDto;
import data.service.ReBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardListController {
    @Autowired
    private ReBoardService boardService;

    @GetMapping("board/list")
    public String list(
            @RequestParam(defaultValue = "1") int currentPage,
            Model model
    ) {
        //총 글의 갯수
        int totalCount=boardService.getTotalCount();
        int perPage = 5;//한페이지당 보여질 글의 갯수
        int perBlock = 5;//현재블력에 보여질 페이지의 갯수
        int start;//db에서 가져올 시작번호
        int startPage;//각 블럭에 보여질 시작페이지
        int totalPage;//총 페이지 수
        int endPage; //각 블럭에 보여질 끝 페이지
        int no; //각 페이지에 보여질 시작번호

        //총 페이지 수
        totalPage = totalCount / perPage + (totalCount % perPage > 0 ? 1 : 0);
        //각 블럭당 시작페이지 구하기
        startPage = (currentPage - 1) / perBlock * perBlock + 1;
        endPage = startPage + perBlock - 1;
        //endPage 가 총 페이지 수 보다 커서는 안된다
        if (endPage > totalPage)
            endPage = totalPage;

        //db에서 가져올 글의 시작번호
        //예 :1페이지 : 0,2페이지 : 5~
        //각 페이지당 5개만 보여질경우 현재 페이지에 따라서 시작번호가 달라지도록 공식 설정
        start = (currentPage - 1) * perPage;

        //각 페이지에 출력할 시작번호
        //총 갯수가 20개일경우 1페이지는 20,2페이지는 15...
        no = totalCount - (currentPage - 1) * perPage;
        //목록 가져오기
        List<ReBoardDto> list = boardService.getPaginList(start, perPage);
        //model 에 필요한 데이타 저장
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list", list);
        //페이지 출력시 필요한 변수들을 모두 request 에 저장한다
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("no", no);


        return "board/boardlist";
    }

}
