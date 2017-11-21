package ibd.service;

import ibd.persistence.entity.Subcategory;
import ibd.persistence.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public List<Subcategory> findAll(){
        return subcategoryRepository.findAll();
    }

    public void save(Subcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }

    public void remove(Long id) {
        subcategoryRepository.delete(id);
    }

    public Subcategory findOne(Long id) {
        return subcategoryRepository.findOne(id);
    }
}
