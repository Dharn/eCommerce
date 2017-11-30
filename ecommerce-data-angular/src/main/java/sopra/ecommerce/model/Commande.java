package sopra.ecommerce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "orderr")
@SequenceGenerator(name = "sequenceCommande",sequenceName="sequence_commande")
public class Commande {
	
	
	@Id
	@GeneratedValue(generator = "sequenceCommande")
	@Column(name = "id")
	@JsonView(Views.Common.class)
	private Long id;

	@Version
	@JsonView(Views.Common.class)
	private int version;
	
	@JsonView(Views.Common.class)
	private String numero;
	
	@JsonView(Views.Common.class)
	private Double prixTotal;
	
	@JsonView(Views.Common.class)
	private Date dtCommande;
	
	@JsonView(Views.Common.class)
	private String Commentaires;
	
	@OneToMany(mappedBy = "commande")
	@JsonView(Views.CommandeProduitCommande.class)
	private List<ProduitCommande> produits; 
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonView(Views.Commande.class)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "billing_address_id")
	@JsonView(Views.CommandeAdresse.class)
	private Adresse adresseFacturation;
	
	@ManyToOne
	@JoinColumn(name = "delivery_address_id")
	@JsonView(Views.CommandeAdresse.class)
	private Adresse adresseLivraison;

	
	
	
	
	
	
	
	public Commande(String numero, Date dtCommande, String commentaires, Client client, Adresse adresseFacturation,
			Adresse adresseLivraison) {
		super();
		this.numero = numero;
		this.dtCommande = dtCommande;
		Commentaires = commentaires;
		this.client = client;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
	}

	public Commande() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Date getDtCommande() {
		return dtCommande;
	}

	public void setDtCommande(Date dtCommande) {
		this.dtCommande = dtCommande;
	}

	public String getCommentaires() {
		return Commentaires;
	}

	public void setCommentaires(String commentaires) {
		Commentaires = commentaires;
	}

	public List<ProduitCommande> getProduits() {
		return produits;
	}

	public void setProduits(List<ProduitCommande> produits) {
		this.produits = produits;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}
	

}
