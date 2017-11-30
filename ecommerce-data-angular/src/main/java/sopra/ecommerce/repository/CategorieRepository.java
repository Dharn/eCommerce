package sopra.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sopra.ecommerce.model.Categorie;


@Transactional
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

	
	@Query("select distinct c from Categorie c left join fetch c.categoriesFilles cf")
	public List<Categorie> findAllWithCategorieFille();

	
}
