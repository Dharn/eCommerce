package sopra.ecommerce.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.ecommerce.model.Client;
import sopra.ecommerce.model.Views;
import sopra.ecommerce.repository.ClientRepository;


@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository cliRepo;
	
	@GetMapping("/clients")
	@JsonView(Views.Client.class)
	public ResponseEntity<List<Client>> findAll() {
		return new ResponseEntity<List<Client>>(cliRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/clients/{id}")
	@JsonView(Views.Client.class)
	public ResponseEntity<Client> findOne(@PathVariable("id") Long id) {
		Client tmp = cliRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@GetMapping("/clients/{id}")
//	@JsonView(Views.ClientWithUtilisateur.class)
//	public ResponseEntity<Client> findOneWithUser(@PathVariable("id") Long id) {
//		Client tmp = cliRepo.findOneWithUser(id); 
//		if (tmp != null) {
//			return new ResponseEntity<>(tmp, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping("/clients/orders/{id}")
	@JsonView(Views.ClientWithCommande.class)
	public ResponseEntity<Client> findOneWithOrder(@PathVariable("id") Long id) {
		Client tmp = cliRepo.findOneWithOrder(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/clients")
	@JsonView(Views.Client.class)
	public ResponseEntity<Client> create(@RequestBody Client obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = cliRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/clients")
	@JsonView(Views.Client.class)
	public ResponseEntity<Client> update(@RequestBody Client obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = cliRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/clients/{id}")
	@JsonView(Views.Client.class)
	public ResponseEntity<Client> delete(@PathVariable("id") Long id) {
		Client tmp = cliRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			cliRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
