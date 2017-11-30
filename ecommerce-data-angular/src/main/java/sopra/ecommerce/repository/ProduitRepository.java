package sopra.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ecommerce.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long>{

}
