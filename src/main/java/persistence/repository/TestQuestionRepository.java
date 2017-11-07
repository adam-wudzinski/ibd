package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.entity.TestQuestion;

public interface TestQuestionRepository extends JpaRepository<TestQuestion,  Long> {
}
