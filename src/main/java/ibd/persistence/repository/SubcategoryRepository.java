package ibd.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ibd.persistence.entity.Subcategory;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long>{
}
