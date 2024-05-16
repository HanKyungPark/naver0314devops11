package com.bitcamp.study;

import data.dto.ShopDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Locale locale, Model model) {
        ShopDto dto1=new ShopDto();
        dto1.setSang("머리띠");
        dto1.setPhoto("30.jpg");
        dto1.setPrice(13000);
        dto1.setSu(3);

        ShopDto dto2=new ShopDto("머리끈", "26.jpg", 9000, 5);

        model.addAttribute("dto1",dto1);
        model.addAttribute("dto2",dto2);

        System.out.println(dto1.toString());
        System.out.println(dto2);//toString 생략 가능

        model.addAttribute("msg","Hello SpringFramework!!!");
        model.addAttribute("today", new Date());
        return "home";
    }
}