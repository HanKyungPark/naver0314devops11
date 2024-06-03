package controller.user;

import data.dto.UserDto;
import data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserFormController {

    @Autowired
    private UserService userService;
    @GetMapping("/insert")
    public String insert(
            @ModelAttribute UserDto dto) {
            userService.insertUser(dto);
            return "redirect:/";
    }




}
