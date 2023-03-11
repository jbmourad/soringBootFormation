package edu.mesrs.formationSpringBoot.services;





import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mesrs.formationSpringBoot.entities.Utilisateur;
import edu.mesrs.formationSpringBoot.repositories.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> getAUtilisateurs() {
		// TODO Auto-generated method stub
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findUtilisateurById(Long id) {
		// TODO Auto-generated method stub
		Optional<Utilisateur> utOptional = utilisateurRepository.findById(id);

		if (utOptional.isEmpty()) {
			return null;

		} else {
			return utOptional.get();
		}

	}

	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		Optional<Utilisateur> utOptional = utilisateurRepository.findById(utilisateur.getId());

		if (utOptional.isEmpty()) {
			return null;

		} else {
			return utilisateurRepository.save(utilisateur);
		}
	}

	@Override
	public void delateUtilisateur(Long id) {
		// TODO Auto-generated method stub
		utilisateurRepository.deleteById(id);

	}
	
	@Override
	public List<Utilisateur> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByFirstName(firstName);
	}
	
	@Override
	public List<Utilisateur> findByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByFirstNameAndLastNameWithJPQLWithNamedParameters(firstName, lastName);
	}

	@Override
	public List<Utilisateur> findByAgeIn(List<Integer> ages) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByAgeIn(ages);
	}

	@Override
	public List<Utilisateur> findByStarterDateAfterAndActiveFalse(Date date) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByStarterDateAfterAndActiveFalse(date);
	}

	@Override
	public List<Utilisateur> findByRolesTitre(String titre) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByRolesTitre(titre);
	}

	@Override
	public List<Utilisateur> findByRolesTitreAndAdressesVille(String titre, String ville) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findByRolesTitreAndAdressesVille(titre, ville);
	}





}
