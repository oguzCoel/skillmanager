package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.BenutzerRole;
import ch.business.quickline.domain.Mitarbeiter;

public interface BenutzerRoleRepository extends JpaRepository<BenutzerRole, Integer>{
	
	public BenutzerRole findByBenutzer(Benutzer benutzer);
	public BenutzerRole save(BenutzerRole benutzerRole);
	public Integer deleteByBenutzer(Benutzer benutzer);

}
