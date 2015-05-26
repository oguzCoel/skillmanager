package ch.business.quickline.domain;
// default package
// Generated 21.05.2015 20:36:25 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * SkillMaster generated by hbm2java
 */
@Entity
@Table(name = "SkillMaster", catalog = "Skillmanager", uniqueConstraints = @UniqueConstraint(columnNames = {
		"Mitarbeiter", "Skill" }))
public class SkillMaster implements java.io.Serializable {

	private Integer skillMasterId;
	private Mitarbeiter mitarbeiter;
	private Skill skill;

	public SkillMaster() {
	}

	public SkillMaster(Mitarbeiter mitarbeiter, Skill skill) {
		this.mitarbeiter = mitarbeiter;
		this.skill = skill;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SkillMasterId", unique = true, nullable = false)
	public Integer getSkillMasterId() {
		return this.skillMasterId;
	}

	public void setSkillMasterId(Integer skillMasterId) {
		this.skillMasterId = skillMasterId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Mitarbeiter", nullable = false)
	public Mitarbeiter getMitarbeiter() {
		return this.mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Skill", nullable = false)
	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	


}
