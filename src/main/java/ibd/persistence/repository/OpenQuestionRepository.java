package ibd.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibd.persistence.entity.OpenQuestion;

public interface OpenQuestionRepository extends JpaRepository<OpenQuestion, Long> {
}
