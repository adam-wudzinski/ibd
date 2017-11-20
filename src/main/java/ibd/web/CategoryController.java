package ibd.web;

import ibd.persistence.entity.Category;
import ibd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String listAll(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "categories/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("category", new Category());
        return "categories/add";
    }

    @PostMapping("/add")
    public String postAdd(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }

    @DeleteMapping("/")
    public String remove(@RequestParam Long id){
        categoryService.remove(id);
        return "redirect:/categories";
    }

}