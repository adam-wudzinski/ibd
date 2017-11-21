package ibd.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibd.persistence.entity.ClosedQuestion;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClosedQuestionRepository extends JpaRepository<ClosedQuestion,  Long> {
}
