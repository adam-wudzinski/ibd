package ibd.web;

import ibd.persistence.entity.ClosedQuestion;
import ibd.service.SubcategoryService;
import ibd.service.ClosedQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/closed-questions")
public class ClosedQuestionController {

    @Autowired
    private ClosedQuestionService closedQuestionService;
    @Autowired
    private SubcategoryService subcategoryService;

    @RequestMapping("")
    public String listAll(Model model){
        model.addAttribute("questions", closedQuestionService.findAll());
        return "closed-questions/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("closedQuestion", new ClosedQuestion());
        model.addAttribute("subcategories", subcategoryService.findAll());
        return "closed-questions/add";
    }

    @PostMapping("/add")
    public String postAdd(@Valid ClosedQuestion question, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("subcategories", subcategoryService.findAll());
            return "closed-questions/add";
        }
        closedQuestionService.save(question);
        return "redirect:/closed-questions";
    }

    @GetMapping("/delete")
    public String remove(@RequestParam Long id){
        closedQuestionService.remove(id);
        return "redirect:/closed-questions";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model){
        model.addAttribute("closedQuestion", closedQuestionService.findOne(id));
        model.addAttribute("subcategories", subcategoryService.findAll());
        return "closed-questions/edit";
    }

    @PostMapping("/edit")
    public String postEdit(@Valid ClosedQuestion question, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("subcategories", subcategoryService.findAll());
            return "closed-questions/edit";
        }
        closedQuestionService.save(question);
        return "redirect:/closed-questions";
    }
}
