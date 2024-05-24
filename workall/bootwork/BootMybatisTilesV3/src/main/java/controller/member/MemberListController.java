package controller.member;


import data.dto.MemberDto;
import data.service.Memberservice;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberListController {

    @NonNull
    private Memberservice memberservice;

    @GetMapping({"/member/list"})
    public String memberList(Model model) {

        int totalCount=memberservice.getTotalCount();
        List<MemberDto> list = memberservice.getAllMembers();

        model.addAttribute("list", list);
        model.addAttribute("totalCount",totalCount);

        return "member/memberlist";
    }
    @GetMapping("/member/detail")
    public String detail(@RequestParam int num, Model model) {
        MemberDto dto = memberservice.getData(num);
        model.addAttribute("dto", dto);
        return "member/memberdetail";

    }
}
