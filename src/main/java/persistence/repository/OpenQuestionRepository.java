package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.entity.OpenQuestion;

public interface OpenQuestionRepository extends JpaRepository<OpenQuestion, Long> {
}
