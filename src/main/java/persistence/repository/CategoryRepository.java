package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
