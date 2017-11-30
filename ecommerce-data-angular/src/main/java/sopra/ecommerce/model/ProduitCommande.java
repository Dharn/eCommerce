package sopra.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;




@Entity
@Table(name = "product_order", uniqueConstraints = @UniqueConstraint(columnNames = { "product_id", "order_id" }))
@SequenceGenerator(name = "sequenceProduitCommande",sequenceName="sequence_produit_commande")
public class ProduitCommande {
	
	@Id @GeneratedValue(generator="sequenceProduitCommande")
	@Column(name="id")
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	@Column(name="version")
	@JsonView(Views.Common.class)
	private int version;
	
	@Column(name="tarif")
	@JsonView(Views.Common.class)
	private Double prixUnitaire;
	
	@Column(name="duree")
	@JsonView(Views.Common.class)
	private Long quantite;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonView(Views.ProduitCommande.class)
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonView(Views.ProduitCommande.class)
	private Commande commande;

	
	
	
	public ProduitCommande() {

	}
	
	public ProduitCommande(Double prixUnitaire, Long quantite, Produit produit, Commande commande) {
		super();
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
		this.produit = produit;
		this.commande = commande;
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


	public Double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Long getQuantite() {
		return quantite;
	}

	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
