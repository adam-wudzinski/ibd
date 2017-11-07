package ibd.service;

import ibd.persistence.entity.Category;
import ibd.persistence.entity.OpenQuestion;
import ibd.persistence.entity.Subcategory;
import ibd.persistence.entity.TestQuestion;
import ibd.persistence.repository.CategoryRepository;
import ibd.persistence.repository.OpenQuestionRepository;
import ibd.persistence.repository.SubcategoryRepository;
import ibd.persistence.repository.TestQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubcategoryRepository subcategoryRepository;
    @Autowired
    private OpenQuestionRepository openQuestionRepository;
    @Autowired
    private TestQuestionRepository testQuestionRepository;


    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Subcategory> findAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public List<TestQuestion> findAllTestQuestions() {
        return testQuestionRepository.findAll();
    }

    public List<OpenQuestion> findAllOpenQuestions() {
        return openQuestionRepository.findAll();
    }
}
