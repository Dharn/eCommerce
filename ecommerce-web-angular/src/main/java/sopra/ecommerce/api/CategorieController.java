package sopra.ecommerce.api;

import java.util.ArrayList;
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

import sopra.ecommerce.model.Categorie;
import sopra.ecommerce.model.Views;
import sopra.ecommerce.repository.CategorieRepository;

@RestController
public class CategorieController {

	@Autowired
	private CategorieRepository catRepo;

	@GetMapping("/categories")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<List<Categorie>> findAll() {
		return new ResponseEntity<List<Categorie>>(catRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping("/categories/{id}")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<Categorie> findOne(@PathVariable("id") Long id) {
		Categorie tmp = catRepo.findOne(id);
		if (tmp != null) {
			return new ResponseEntity<>(tmp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/categories/categorieFilles/{id}")
	@JsonView(Views.CategorieWithCategorieFilles.class)
	public ResponseEntity<Categorie> findOneWithCategoriesFilles(@PathVariable("id") Long id) {
		List<Categorie> tmpall = catRepo.findAllWithCategorieFille();
		for (Categorie categorie : tmpall) {
			if (categorie.getId() == id) {
				
				System.out.println(categorie.getId());
				//System.out.println(categorie.getCategoriesFilles());
				return new ResponseEntity<>(categorie, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/categories")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<Categorie> create(@RequestBody Categorie obj) {
		if (obj.getId() != null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		obj = catRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@PutMapping("/categories")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<Categorie> update(@RequestBody Categorie obj) {
		if (obj.getId() == null) {
			return create(obj);
		}
		obj = catRepo.save(obj);

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/categories/{id}")
	@JsonView(Views.Categorie.class)
	public ResponseEntity<Categorie> delete(@PathVariable("id") Long id) {
		Categorie tmp = catRepo.findOne(id);
		if (tmp == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			catRepo.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
