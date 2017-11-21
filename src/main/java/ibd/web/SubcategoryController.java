package ibd.web;

import ibd.persistence.entity.Subcategory;
import ibd.service.CategoryService;
import ibd.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subcategories")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("")
    public String listAll(Model model){
        model.addAttribute("subcategories", subcategoryService.findAll());
        return "subcategories/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("subcategory", new Subcategory());
        model.addAttribute("categories", categoryService.findAll());
        return "subcategories/add";
    }

    @PostMapping("/add")
    public String postAdd(@ModelAttribute Subcategory subcategory){
        subcategoryService.save(subcategory);
        return "redirect:/subcategories";
    }

    @GetMapping("/delete")
    public String remove(@RequestParam Long id){
        subcategoryService.remove(id);
        return "redirect:/subcategories";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model){
        model.addAttribute("subcategory", subcategoryService.findOne(id));
        model.addAttribute("categories", categoryService.findAll());
        return "subcategories/edit";
    }

    @PostMapping("/edit")
    public String postEdit(@ModelAttribute Subcategory subcategory){
        subcategoryService.save(subcategory);
        return "redirect:/subcategories";
    }
}
