package ibd.web;

import ibd.persistence.entity.ClosedQuestion;
import ibd.service.SubcategoryService;
import ibd.service.ClosedQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("question", new ClosedQuestion());
        model.addAttribute("subcategories", subcategoryService.findAll());
        return "closed-questions/add";
    }

    @PostMapping("/add")
    public String postAdd(@ModelAttribute ClosedQuestion question){
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
        model.addAttribute("question", closedQuestionService.findOne(id));
        model.addAttribute("subcategories", subcategoryService.findAll());
        return "closed-questions/edit";
    }

    @PostMapping("/edit")
    public String postEdit(@ModelAttribute ClosedQuestion question){
        closedQuestionService.save(question);
        return "redirect:/closed-questions";
    }
}
