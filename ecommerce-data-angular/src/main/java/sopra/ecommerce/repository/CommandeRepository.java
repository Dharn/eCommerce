package sopra.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ecommerce.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
