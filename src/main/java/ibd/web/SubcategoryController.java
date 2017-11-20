package ibd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subcategories")
public class SubcategoryController {

    @RequestMapping("")
    public String listAll(Model model){
        return "subcategories/list";
    }
}
