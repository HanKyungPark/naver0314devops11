package controller.result;

import data.dto.ResultDto;
import data.service.ResultService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class resultController {

    @Autowired
    private ResultService resultService;
    @GetMapping("/resultinsert")
    public String resultInsert(@ModelAttribute ResultDto resultDto , Model model,
                               HttpSession session) {

    }
}
