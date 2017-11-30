package sopra.ecommerce.model;

public class Views {

	public static class Common {

	}

	public static class Client extends Common {

	}
	public static class ClientWithCommande extends Client {

	}
	public static class ClientWithUtilisateur extends Client {

	}

	public static class Utilisateur extends Common {

	}

	public static class Adresse extends Common {

	}
	public static class AdresseWithClient extends Adresse {

	}

	public static class AdresseWithCommande extends Adresse {

	}
	
	public static class Categorie extends Common {

	}
	public static class CategorieWithCategorieFilles extends Common {

	}
	
	
	public static class CategorieWithPhoto extends Categorie {

	}
	public static class CategorieProduits extends Categorie {

	}
	
	public static class Produit extends Common {

	}
	public static class ProduitCommande extends Common {

	}
	public static class ProduitWithCommande extends Produit {

	}
	public static class ProduitImage extends Produit {

	}
	
	public static class Commande extends Common {

	}
	public static class CommandeAdresse extends Commande {

	}
	public static class CommandeProduitCommande extends Commande {

	}
}
