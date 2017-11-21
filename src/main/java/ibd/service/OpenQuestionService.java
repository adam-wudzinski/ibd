package ibd.service;

import ibd.persistence.entity.OpenQuestion;
import ibd.persistence.repository.OpenQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenQuestionService {

    @Autowired
    private OpenQuestionRepository openQuestionRepository;

    public List<OpenQuestion> findAll(){
        return openQuestionRepository.findAll();
    }

    public void save(OpenQuestion openQuestion) {
        openQuestionRepository.save(openQuestion);
    }

    public void remove(Long id) {
        openQuestionRepository.delete(id);
    }

    public OpenQuestion findOne(Long id) {
        return openQuestionRepository.findOne(id);
    }
}
