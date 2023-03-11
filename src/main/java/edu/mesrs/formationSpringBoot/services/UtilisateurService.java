package edu.mesrs.formationSpringBoot.services;


import java.util.Date;
import java.util.List;

import edu.mesrs.formationSpringBoot.entities.Utilisateur;

public interface UtilisateurService {

	//methode crund basiques
	public List<Utilisateur> getAUtilisateurs();
	public Utilisateur findUtilisateurById(Long id);
	public Utilisateur createUtilisateur(Utilisateur utilisateur);
	public Utilisateur updateUtilisateur(Utilisateur utilisateur);
	public void delateUtilisateur(Long id);
	 
	//méthode avancées
	
	public List<Utilisateur> findByFirstName(String firstName);
	public List<Utilisateur> findByFirstNameAndLastName(String firstName, String LastName);
	
	public List<Utilisateur> findByAgeIn(List<Integer> ages);

	public List<Utilisateur> findByStarterDateAfterAndActiveFalse(Date date);

	public List<Utilisateur> findByRolesTitre(String titre); 

	public List<Utilisateur> findByRolesTitreAndAdressesVille(String titre, String ville); 

}
