package sopra.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ecommerce.model.ProduitCommande;

public interface ProduitCommandeRepository extends JpaRepository<ProduitCommande, Long>{

}
