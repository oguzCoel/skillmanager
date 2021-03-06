package ch.business.quickline.service;

import java.util.List;

import ch.business.quickline.domain.Mitarbeiter;
import ch.business.quickline.domain.Skill;
import ch.business.quickline.domain.SkillMaster;

public interface SkillMasterService {
	
	public List<SkillMaster> findByMitarbeiter (Mitarbeiter mitarbeiter);
	public SkillMaster save(SkillMaster skillMaster);
	public SkillMaster findBySkill(Skill skill);
	public void deleteByMitarbeiter (Mitarbeiter mitarbeiter);
	public void deleteBySkill (Skill skill);

}
