package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Benutzer;
import ch.business.quickline.domain.Mitarbeiter;

public interface BenutzerService {
	
	public Benutzer save (Benutzer benutzer);
	public Benutzer findByBenutzerName(String benutzername);
	public Benutzer findByMitarbeiter (Mitarbeiter mitarbeiter);
	public void deleteByMitarbeiter (Mitarbeiter mitarbeiter);
	public List<Benutzer> findAll();

}
