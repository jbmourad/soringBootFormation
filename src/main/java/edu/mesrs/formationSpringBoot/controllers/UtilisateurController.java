package edu.mesrs.formationSpringBoot.controllers;


import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mesrs.formationSpringBoot.entities.Utilisateur;
import edu.mesrs.formationSpringBoot.requests.FirstNameAndLastNameRequest;
import edu.mesrs.formationSpringBoot.services.UtilisateurService;

@RestController
@RequestMapping("/utilisateur") // localhost:8080/utilisateur
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurService.getAUtilisateurs();
	}
	
	@GetMapping(path="/{id}") //localhost:8080/utilisateur/3
	public ResponseEntity<Utilisateur>  findUtilisateurById(@PathVariable Long id) {
		Utilisateur utilisateur=utilisateurService.findUtilisateurById(id);
		if (utilisateur==null) {
			return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/findByFirstName/{firstName}")  //localhost:8080/utilisateur/findByFirstNameAndLastName/firstName
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByFirstName(@PathVariable String firstName) {
		List<Utilisateur>  utilisateurs=utilisateurService.findByFirstName(firstName);
		if (utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/findByFirstNameAndLastName/{firstName}/{lastName}") //localhost:8080/utilisateur/findByFirstNameAndLastName/firstName/lastName
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
		List<Utilisateur>  utilisateurs=utilisateurService.findByFirstNameAndLastName(firstName, lastName);
		if (utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/findByFirstNameAndLastNameWithRB") //localhost:8080/utilisateur/findByFirstNameAndLastNameWithRB
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByFirstNameAndLastName(@RequestBody FirstNameAndLastNameRequest firstNameAndLastNameRequest) {
		List<Utilisateur>  utilisateurs=utilisateurService.findByFirstNameAndLastName(firstNameAndLastNameRequest.getFirstName(), firstNameAndLastNameRequest.getLastName());
		if (utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
//	@GetMapping(path="/findByIdWithRequestParam") //localhost:8080/utilisateur/findByIdWithRequestParam?id=2
//	public ResponseEntity<Utilisateur>  findUtilisateurById(@RequestParam Long id) {
//		Utilisateur utilisateur=utilisateurService.findUtilisateurById(id);
//		if (utilisateur==null) {
//			return new ResponseEntity<Utilisateur>(HttpStatus.NO_CONTENT);
//		}else {
//			return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
//		}
//	}
//	
	
	
	@PostMapping
	public Utilisateur createUtlisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.createUtilisateur(utilisateur);
	}
	
	@PutMapping
	public Utilisateur updateUtlisateur(@RequestBody Utilisateur utilisateur)  {
		return utilisateurService.updateUtilisateur(utilisateur);
	}
	


	@DeleteMapping(path="/{id}") //localhost:8080/utilisateur/3
	public void deleteUtlisateur(@PathVariable Long id) {
		utilisateurService.delateUtilisateur(id);
	}
	
	
	@GetMapping(path="/findByAge") //localhost:8080/utilisateur/findByAge
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByAge(@RequestBody List<Integer> ages) {
		List<Utilisateur>  utilisateurs=utilisateurService.findByAgeIn(ages);
		if (utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
		
	}
	
	
	@GetMapping(path="/findByStarterDateAndActiveFalse/{date}")  //localhost:8080/utilisateur/findByFirstNameAndLastName/firstName
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByStartDateAndActiveFalse(@PathVariable Date date) {
		List<Utilisateur>  utilisateurs=utilisateurService.findByStarterDateAfterAndActiveFalse(date);
		if (utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	@GetMapping(path="/findByRoleTitre/{titre}")  //localhost:8080/utilisateur/findByRoleTitre/titre
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByRole(@PathVariable String titre) {
		List<Utilisateur>  utilisateurs=utilisateurService.findByRolesTitre(titre);
		if (utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
	
	@GetMapping(path="/findByRoleTitreAndAdresseVille/{titre}/{ville}") //localhost:8080/utilisateur/findByFirstNameAndLastName/firstName/lastName
	public ResponseEntity<List<Utilisateur>>  findUtilisateurByRoleAndVille(@PathVariable String titre, @PathVariable String ville) {
		List<Utilisateur>  utilisateurs=utilisateurService.findByRolesTitreAndAdressesVille(titre, ville);
		if (utilisateurs.isEmpty()) {
			return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
		}
	}
	
}
