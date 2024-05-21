package member.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")//공통매핑
@RequiredArgsConstructor
public class MemberListController {

   // @Autowired

    @NonNull
    private MemberService memberService;

    @GetMapping("/list")
    public String list(Model model){

        int totalCount;//총 갯수
        List<MemberDto> list=memberService.getAllMembers();

        totalCount= memberService.getTotalCount();
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list", list);

        return "member/memberlist";
    }

}
