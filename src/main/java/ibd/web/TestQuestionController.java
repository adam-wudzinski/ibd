package ibd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-questions")
public class TestQuestionController {

    @RequestMapping("")
    public String listAll(Model model){
        return "/test-questions/list";
    }
}
