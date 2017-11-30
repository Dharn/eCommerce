package sopra.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "customer")
@SequenceGenerator(name = "sequenceClient",sequenceName="sequence_client")
public class Client {
	
	@Id
	@GeneratedValue(generator = "sequenceClient")
	@Column(name = "id")
	@JsonView(Views.Common.class)
	private Long id;

	@Version
	@JsonView(Views.Common.class)
	private int version;
	
	@JsonView(Views.Common.class)
	private String nom;
	
	@JsonView(Views.Common.class)
	private String prenom;
	
	@JsonView(Views.Common.class)
	private String numero;
	
	@JsonView(Views.Common.class)
	private String couriel;
	
	@JsonView(Views.Common.class)
	private String telephone;
	
	
	
	
	@OneToOne
	@JoinColumn(name="utilisateur_id")
	@JsonView(Views.ClientWithUtilisateur.class)
	private Utilisateur utilisateur;
	
	
	@OneToOne
	@JoinColumn(name="adresse_id")
	@JsonView(Views.Adresse.class)
	private Adresse adresse;

	@OneToMany(mappedBy = "client")
	@JsonView({Views.ClientWithCommande.class})
	private List<Commande> commandes = new ArrayList<>();
	
	
	
	
	public Client(){
		
	}
	
	
	
	public Client(String nom, String prenom, String numero, String couriel, String telephone, Utilisateur utilisateur,
			Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.couriel = couriel;
		this.telephone = telephone;
		this.utilisateur = utilisateur;
		this.adresse = adresse;
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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getCouriel() {
		return couriel;
	}


	public void setCouriel(String couriel) {
		this.couriel = couriel;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public List<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

}
