package ibd.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibd.persistence.entity.TestQuestion;

public interface TestQuestionRepository extends JpaRepository<TestQuestion,  Long> {
}
