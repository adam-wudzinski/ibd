package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.entity.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long>{
}
