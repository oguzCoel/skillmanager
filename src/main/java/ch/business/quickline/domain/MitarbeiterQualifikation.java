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
 * MitarbeiterQualifikation generated by hbm2java
 */
@Entity
@Table(name = "MitarbeiterQualifikation", catalog = "Skillmanager", uniqueConstraints = @UniqueConstraint(columnNames = {
		"Mitarbeiter", "Qualifikation" }))
public class MitarbeiterQualifikation implements java.io.Serializable {

	private Integer mitarbeiterQualifikationId;
	private Mitarbeiter mitarbeiter;
	private Qualifikation qualifikation;

	public MitarbeiterQualifikation() {
	}

	public MitarbeiterQualifikation(Mitarbeiter mitarbeiter,
			Qualifikation qualifikation) {
		this.mitarbeiter = mitarbeiter;
		this.qualifikation = qualifikation;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MitarbeiterQualifikationId", unique = true, nullable = false)
	public Integer getMitarbeiterQualifikationId() {
		return this.mitarbeiterQualifikationId;
	}

	public void setMitarbeiterQualifikationId(Integer mitarbeiterQualifikationId) {
		this.mitarbeiterQualifikationId = mitarbeiterQualifikationId;
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
	@JoinColumn(name = "Qualifikation", nullable = false)
	public Qualifikation getQualifikation() {
		return this.qualifikation;
	}

	public void setQualifikation(Qualifikation qualifikation) {
		this.qualifikation = qualifikation;
	}

}