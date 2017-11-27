package ibd.web;

import ibd.persistence.entity.Category;
import ibd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String listAll(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "categories/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("category", new Category());
        return "categories/add";
    }

    @PostMapping("/add")
    public String postAdd(@Valid Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "categories/add";
        }
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete")
    public String remove(@RequestParam Long id){
        categoryService.remove(id);
        return "redirect:/categories";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model){
        model.addAttribute("category", categoryService.findOne(id));
        return "categories/edit";
    }

    @PostMapping("/edit")
    public String postEdit(@Valid Category category, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "categories/edit";
        }
        categoryService.save(category);
        return "redirect:/categories";
    }

}
