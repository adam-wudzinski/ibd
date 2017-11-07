package ibd.api;

import ibd.persistence.entity.Category;
import ibd.persistence.entity.OpenQuestion;
import ibd.persistence.entity.Subcategory;
import ibd.persistence.entity.TestQuestion;
import ibd.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return apiService.findAllCategories();
    }

    @GetMapping("/subcategories")
    public List<Subcategory> getSubcategories(){
        return apiService.findAllSubcategories();
    }

    @GetMapping("/testquestions")
    public List<TestQuestion> getTestQuestions(){
        return apiService.findAllTestQuestions();
    }

    @GetMapping("/openquestions")
    public List<OpenQuestion> getOpenQuestions(){
        return apiService.findAllOpenQuestions();
    }

}
