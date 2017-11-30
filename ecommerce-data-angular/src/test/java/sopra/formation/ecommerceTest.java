package sopra.formation;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sopra.ecommerce.model.*;
import sopra.ecommerce.repository.AdresseRepository;
import sopra.ecommerce.repository.CategorieRepository;
import sopra.ecommerce.repository.ClientRepository;
import sopra.ecommerce.repository.CommandeRepository;
import sopra.ecommerce.repository.ProduitCommandeRepository;
import sopra.ecommerce.repository.ProduitRepository;
import sopra.ecommerce.repository.UtilisateurRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ecommerceTest {
	
	
	@Autowired
	private AdresseRepository addresseRepo;
	@Autowired
	private CategorieRepository catRepo;
	@Autowired
	private ClientRepository clieRepo;
	@Autowired
	private CommandeRepository commRepo;
	@Autowired
	private ProduitCommandeRepository prodCommRepo;
	@Autowired
	private ProduitRepository prodRepo;
	@Autowired
	private UtilisateurRepository utiRepo;

	
	@Test
	public void testAddData() {
		
		Utilisateur user1 = new Utilisateur(Role.CLIENT, "login1", "mdp1");
		Utilisateur user2 = new Utilisateur(Role.ADMIN_PROD, "login2", "mdp2");
		Utilisateur user3 = new Utilisateur(Role.CLIENT, "login3", "mdp3");
		Adresse ad1 = new Adresse("rue", "codePostal", "ville");
		Adresse ad2 = new Adresse("rue2", "codePostal2", "ville2");
		Adresse ad3 = new Adresse("rue3", "codePostal3", "ville3");
		Client cli1 = new Client("nom", "prenom", "numero", "couriel", "telephone", user1, ad1);
		Client cli2 = new Client("nom2", "prenom2", "numero2", "couriel2", "telephone2", user3, ad2);
		Categorie cat1 = new Categorie("nomcat", "description", "photo");
		Categorie cat2 = new Categorie("nomcat2", "description2", "photo2");
		Categorie cat3 = new Categorie("nomcat3", "description3", "photo3");
		cat3.setCategorieMere(cat1);
		Categorie cat4 = new Categorie("nomcat4", "description'", "photo4");
		cat4.setCategorieMere(cat3);
		
		Produit p1 = new Produit("designation", 1.0D, 2L, "description", cat1);
		Produit p2 = new Produit("designation2", 2.0D, 3L, "description2", cat2);
		Produit p3 = new Produit("designation3", 3.0D, 4L, "description3", cat3);
		Produit p4 = new Produit("designation4", 4.0D, 5L, "description4", cat4);
		Commande c1 = new Commande("numero", new Date(), "commentaires", cli1, ad1, ad1);
		Commande c2 = new Commande("numero2", new Date(), "commentaires2", cli2, ad2, ad2);
		Commande c3 = new Commande("numero3", new Date(), "commentaires3", cli1, ad1, ad2);
		Commande c4 = new Commande("numero4", new Date(), "commentaires4", cli2, ad2, ad3);
		ProduitCommande pc11 = new ProduitCommande(1.0D, 10L, p1, c1);
		ProduitCommande pc12 = new ProduitCommande(9.9D, 5L, p2, c1);
		ProduitCommande pc21 = new ProduitCommande(4.2D, 6L, p3, c2);
		ProduitCommande pc22 = new ProduitCommande(1.0D, 4L, p2, c2);
		ProduitCommande pc23 = new ProduitCommande(2.0D, 3L, p4, c3);
		ProduitCommande pc31 = new ProduitCommande(7.0D, 2L, p4, c4);
		ProduitCommande pc32 = new ProduitCommande(5.0D, 1L, p2, c4);
		
		utiRepo.save(user1);
		utiRepo.save(user2);
		utiRepo.save(user3);
		addresseRepo.save(ad1);
		addresseRepo.save(ad2);
		addresseRepo.save(ad3);
		clieRepo.save(cli1);
		clieRepo.save(cli2);
		catRepo.save(cat1);
		catRepo.save(cat2);
		catRepo.save(cat3);
		catRepo.save(cat4);
		prodRepo.save(p1);
		prodRepo.save(p2);
		prodRepo.save(p3);
		prodRepo.save(p4);
		commRepo.save(c1);
		commRepo.save(c2);
		commRepo.save(c3);
		commRepo.save(c4);
		prodCommRepo.save(pc11);
		prodCommRepo.save(pc12);
		prodCommRepo.save(pc21);
		prodCommRepo.save(pc22);
		prodCommRepo.save(pc23);
		prodCommRepo.save(pc31);
		prodCommRepo.save(pc32);
		
	}
}
