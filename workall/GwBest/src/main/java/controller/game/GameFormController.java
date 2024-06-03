package controller.game;

import data.dto.GameDto;
import data.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class GameFormController {

    @Autowired
    private GameService gameService;
    @GetMapping("/gameinsert")
    public String gameInsert(@ModelAttribute GameDto gameDto, Model model,
                             HttpSession session) {
        session.setAttribute("id",id);
        model.addAttribute("id", id);
        gameService.insertGame(gameDto);
        return "/*";
    }


}
