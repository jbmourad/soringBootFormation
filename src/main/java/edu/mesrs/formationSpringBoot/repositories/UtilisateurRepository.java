package edu.mesrs.formationSpringBoot.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mesrs.formationSpringBoot.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	public List<Utilisateur> findByFirstName(String firstName);
	
	public List<Utilisateur> findByFirstNameAndLastName(String firstName, String LastName);
	
	@Query("SELECT u FROM Utilisateur u WHERE u.firstName LIKE ?1 OR u.lastName LIKE ?2")
	public List<Utilisateur> findByFirstNameAndLastNameWithJPQL(String firstName, String LastName);

	@Query("SELECT u FROM Utilisateur u WHERE u.firstName LIKE :myFirstName OR u.lastName LIKE :myLastName")
	public List<Utilisateur> findByFirstNameAndLastNameWithJPQLWithNamedParameters(@Param(value="myFirstName") String firstName, @Param(value="myLastName")String LastName);

	public List<Utilisateur> findByAgeIn(List<Integer> ages);
	
	public List<Utilisateur> findByStarterDateAfterAndActiveFalse(Date date);

	public List<Utilisateur> findByRolesTitre(String titre); 
	public List<Utilisateur> findByRolesTitreAndAdressesVille(String titre, String ville); 
	
}
