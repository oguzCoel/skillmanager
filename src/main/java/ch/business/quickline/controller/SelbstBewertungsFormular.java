package ch.business.quickline.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.MitarbeiterSkill;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.service.BenutzerService;
import ch.business.quickline.service.MitarbeiterSkillService;
import ch.business.quickline.service.SkillService;

@ManagedBean
@Component
@Scope("request")
public class SelbstBewertungsFormular {
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private MitarbeiterSkillService mitarbeiterSkillService;
	
	@Autowired
	private BenutzerService benutzerService;
	
	@Autowired
	private UnternehmenViewController unternehmenViewController;
	
	@Autowired
	private MitarbeiterViewController mitarbeiterViewController;
	

	
	
	
	private MitarbeiterSkill mitarbeiterSkillToInsert = new MitarbeiterSkill();
	private MitarbeiterSkill mitarbeiterSkillToUpdate;
	private List<Skill> skills;
	private Mitarbeiter mitarbeiter;
	private String benutzerName = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	
	
	@PostConstruct
	public void init (){
		
		skills = skillService.findAll();
		mitarbeiter = benutzerService.findByBenutzerName(benutzerName).getMitarbeiter();	
	}


	public MitarbeiterSkill getMitarbeiterSkillToInsert() {
		return mitarbeiterSkillToInsert;
	}


	public void setMitarbeiterSkillToInsert(MitarbeiterSkill mitarbeiterSkill) {
		this.mitarbeiterSkillToInsert = mitarbeiterSkill;
	}


	public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
	public void save(){
		mitarbeiterSkillToInsert.setMitarbeiter(mitarbeiter);
		
		mitarbeiterSkillToUpdate = mitarbeiterSkillService.findByMitarbeiterAndSkill(getMitarbeiterSkillToInsert().getMitarbeiter(), getMitarbeiterSkillToInsert().getSkill());
		
		if(mitarbeiterSkillToUpdate == null){
			mitarbeiterSkillService.save(mitarbeiterSkillToInsert);
			
		}
		
		else { mitarbeiterSkillToUpdate.setMasterBewertung(getMitarbeiterSkillToInsert().getMasterBewertung());
		mitarbeiterSkillToUpdate.setSelbstBewertung(getMitarbeiterSkillToInsert().getSelbstBewertung());
		mitarbeiterSkillService.save(mitarbeiterSkillToUpdate);
		
	
		
		}
		

		unternehmenViewController.init();
		mitarbeiterViewController.setId(mitarbeiter.getMitarbeiterId());
		mitarbeiterViewController.initValues();
		mitarbeiterViewController.init();
		
	}
	

}
