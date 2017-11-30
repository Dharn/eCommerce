package sopra.ecommerce.model;

import java.util.ArrayList;
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
@Table(name = "product")
@SequenceGenerator(name = "sequenceProduit",sequenceName="sequence_produit")
public class Produit {
	
	
	@Id
	@GeneratedValue(generator = "sequenceProduit")
	@Column(name = "id")
	@JsonView(Views.Common.class)
	private Long id;

	@Version
	@JsonView(Views.Common.class)
	private int version;
	
	@JsonView(Views.Common.class)
	private String designation;
	
	@JsonView(Views.Common.class)
	private Double prix;
	
	@JsonView(Views.Common.class)
	private Long stock;
	
	@JsonView(Views.Common.class)
	private String description;
	
	@JsonView(Views.ProduitImage.class)
	private Byte[] image;
	
	
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	@JsonView(Views.Categorie.class)
	private Categorie categorie;
	
	@OneToMany(mappedBy = "produit")
	@JsonView({Views.ProduitWithCommande.class})
	private List<ProduitCommande> commandes = new ArrayList<>();

	
	
	public Produit(){
		
	}
	
	
	
	public Produit(String designation, Double prix, Long stock, String description, Categorie categorie) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.stock = stock;
		this.description = description;
		this.categorie = categorie;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<ProduitCommande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<ProduitCommande> commandes) {
		this.commandes = commandes;
	}
	
	
	

}
