package com.bitcamp.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class HomeController {

    //@RequestMapping 을 써도 되는데 get 이나 post 방식에 따라
    //@GetMapping, @PostMapping 이 스프링버전 5부터 추가됨
    @GetMapping("/")
    public String hello() {
        return "start";
    }
        //Model 에 데이타를 저장하고 포워드 파일명을 리턴하는 두가지 방법

        //@GetMapping(/board/list") //board/list.do 도 해당하는 메서드가 호출
    @GetMapping("/board/list.do") //이경우는 /board/list.do 라고 정확히 써야만 호출
    public String hello2(Model model) {
        model.addAttribute("msg", "안녕하세요 반가워요!!");
        return "result1";
    }

    @GetMapping("/guest/list")
    public ModelAndView hello3()
    {
        ModelAndView mview=new ModelAndView();
        mview.addObject("today", new Date());
        mview.setViewName("result2");
        return mview;
    }


}

//{
//    @RequestMapping("/")
//    public String home(Locale locale, Model model) {
//        ShopDto dto1=new ShopDto();
//        dto1.setSang("머리띠");
//        dto1.setPhoto("30.jpg");
//        dto1.setPrice(13000);
//        dto1.setSu(3);
//
//        ShopDto dto2=new ShopDto("머리끈", "26.jpg", 9000, 5);
//
//        model.addAttribute("dto1",dto1);
//        model.addAttribute("dto2",dto2);
//
//        System.out.println(dto1.toString());
//        System.out.println(dto2);//toString 생략 가능
//
//        model.addAttribute("msg","Hello SpringFramework!!!");
//        model.addAttribute("today", new Date());
//        return "home";
//    }
//}