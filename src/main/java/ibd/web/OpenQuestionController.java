package ibd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/open-questions")
public class OpenQuestionController {

    @RequestMapping("")
    public String listAll(Model model){
        return "/open-questions/list";
    }
}
