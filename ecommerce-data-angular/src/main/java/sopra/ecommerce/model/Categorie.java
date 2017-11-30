package sopra.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "category")
@SequenceGenerator(name = "sequenceCategorie",sequenceName="sequence_categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(generator = "sequenceCategorie")
	@Column(name = "id")
	@JsonView(Views.Common.class)
	private Long id;

	@Version
	@JsonView(Views.Common.class)
	private int version;
	
	@JsonView(Views.Common.class)
	private String nom;
	
	@JsonView(Views.Common.class)
	private String description;
	
	@JsonView(Views.Common.class)
	private String photo;
	
	
	@OneToMany(mappedBy = "categorieMere")
	@JsonView(Views.CategorieWithCategorieFilles.class)
	private List<Categorie> categoriesFilles;
	
	
	@ManyToOne
	@JoinColumn(name = "categorieMere_id")
	@JsonView(Views.Categorie.class)
	private Categorie categorieMere;
	
	@OneToMany(mappedBy = "categorie")
	@JsonView(Views.CategorieProduits.class)
	private List<Produit> produits;

	
	
	
	

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Categorie( String nom, String description, String photo) {

		this.nom = nom;
		this.description = description;
		this.photo = photo;
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


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public List<Categorie> getCategoriesFilles() {
		return categoriesFilles;
	}


	public void setCategoriesFilles(List<Categorie> categoriesFilles) {
		this.categoriesFilles = categoriesFilles;
	}


	public Categorie getCategorieMere() {
		return categorieMere;
	}


	public void setCategorieMere(Categorie categorieMere) {
		this.categorieMere = categorieMere;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}




}
