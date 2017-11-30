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

import sopra.ecommerce.model.Adresse;
import sopra.ecommerce.model.Views;
import sopra.ecommerce.repository.AdresseRepository;

@RestController
public class AdresseController {
	
	@Autowired
	private AdresseRepository adRepo;
	
	
	@GetMapping("/adresses")
	@JsonView(Views.Adresse.class)
	public ResponseEntity<List<Adresse>> findAll() {
		return new ResponseEntity<List<Adresse>>(adRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/adresses/{id}")
	@JsonView(Views.Adresse.class)
	public ResponseEntity<Adresse> findOne(@PathVariable("id") Long id) {
		Adresse tmp = adRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/adresses")
	@JsonView(Views.Adresse.class)
	public ResponseEntity<Adresse> create(@RequestBody Adresse obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = adRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/adresses")
	@JsonView(Views.Adresse.class)
	public ResponseEntity<Adresse> update(@RequestBody Adresse obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = adRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/adresses/{id}")
	@JsonView(Views.Adresse.class)
	public ResponseEntity<Adresse> delete(@PathVariable("id") Long id) {
		Adresse tmp = adRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			adRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	

}
