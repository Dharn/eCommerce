package sopra.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sopra.ecommerce.model.Adresse;
import sopra.ecommerce.model.Utilisateur;
import sopra.ecommerce.model.Role;


@Transactional
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	@Query("select u from Utilisateur u where u.role = :role")
	List<Utilisateur> findAllByRole(@Param("role") Role role);
	
	@Query("select u from Utilisateur u where u.role = :role")
	List<Utilisateur> findOneWithCustomer(@Param("role") Role role);
}
