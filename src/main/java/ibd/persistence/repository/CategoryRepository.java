package ibd.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibd.persistence.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
