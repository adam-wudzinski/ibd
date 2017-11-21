package ibd.service;

import ibd.persistence.entity.Category;
import ibd.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void remove(Long id) {
        categoryRepository.delete(id);
    }

    public Category findOne(Long id) {
        return categoryRepository.findOne(id);
    }
}
