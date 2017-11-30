package sopra.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "userr")
@SequenceGenerator(name = "sequenceUtilisateur",sequenceName="sequence_utilisateur")
public class Utilisateur {

	@Id
	@GeneratedValue(generator = "sequenceUtilisateur")
	@Column(name = "id")
	@JsonView(Views.Common.class)
	private Long id;

	@Version
	@JsonView(Views.Common.class)
	private int version;

	@JsonView(Views.Common.class)
	@Enumerated(EnumType.STRING)
	private Role role;

	@JsonView(Views.Common.class)
	private String login;

	@JsonView(Views.Common.class)
	private String motDePasse;
	
	@OneToOne(mappedBy = "utilisateur")
	@JsonView(Views.Utilisateur.class)
	private Client client;

	

	
	public Utilisateur(Role role, String login, String motDePasse) {
		super();
		this.role = role;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Utilisateur() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


}
