package sopra.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.ecommerce.model.Adresse;



public interface AdresseRepository extends JpaRepository<Adresse, Long>{
	
}