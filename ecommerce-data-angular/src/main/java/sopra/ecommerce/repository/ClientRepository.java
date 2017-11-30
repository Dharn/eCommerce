package sopra.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sopra.ecommerce.model.Client;
import sopra.ecommerce.model.Role;
import sopra.ecommerce.model.Utilisateur;


@Transactional
public interface ClientRepository  extends JpaRepository<Client, Long>{
	
	@Query("select c from Client c left join fetch c.utilisateur u where c.id = :id")
	public Client findOneWithUser(@Param("id") Long id);
	
	
	@Query("select distinct c from Client c left join fetch c.commandes co where c.id = :id")
	public Client findOneWithOrder(@Param("id") Long id);
	
}
