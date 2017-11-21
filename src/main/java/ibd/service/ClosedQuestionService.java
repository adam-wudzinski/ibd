package ibd.service;

import ibd.persistence.entity.ClosedQuestion;
import ibd.persistence.repository.ClosedQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClosedQuestionService {

    @Autowired
    private ClosedQuestionRepository testQuestionRepository;

    public List<ClosedQuestion> findAll(){
        return testQuestionRepository.findAll();
    }

    public void save(ClosedQuestion testQuestion) {
        testQuestionRepository.save(testQuestion);
    }

    public void remove(Long id) {
        testQuestionRepository.delete(id);
    }

    public ClosedQuestion findOne(Long id) {
        return testQuestionRepository.findOne(id);
    }
}
