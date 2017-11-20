package ibd.web;

import ibd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("")
    public String listAll(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "categories/list";
    }



}
