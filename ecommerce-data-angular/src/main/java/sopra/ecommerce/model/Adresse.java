package sopra.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "address")
@SequenceGenerator(name = "sequenceAdresse",sequenceName="sequence_adresse")
public class Adresse {
	
	@Id
	@GeneratedValue(generator = "sequenceAdresse")
	@Column(name = "id")
	@JsonView(Views.Common.class)
	private Long id;

	@Version
	@JsonView(Views.Common.class)
	private int version;
	
	
	@JsonView(Views.Common.class)
	private String rue;
	@JsonView(Views.Common.class)
	private String codePostal;
	@JsonView(Views.Common.class)
	private String ville;
	
	
	
	@OneToOne(mappedBy = "adresse")
	@JsonView(Views.AdresseWithClient.class)
	private Client client;
	
	
	




	public Adresse() {
		super();
	}
	
	

	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
