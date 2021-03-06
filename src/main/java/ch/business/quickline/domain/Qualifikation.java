package ch.business.quickline.domain;
// default package
// Generated 21.05.2015 20:36:25 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Qualifikation generated by hbm2java
 */
@Entity
@Table(name = "Qualifikation", catalog = "Skillmanager")
public class Qualifikation implements java.io.Serializable {

	private Integer qualifikationId;
	private String qualifikationName;
	private String qualifikationTyp;
	private Set<MitarbeiterQualifikation> mitarbeiterQualifikations = new HashSet<MitarbeiterQualifikation>(
			0);

	public Qualifikation() {
	}

	public Qualifikation(String qualifikationName, String qualifikationTyp) {
		this.qualifikationName = qualifikationName;
		this.qualifikationTyp = qualifikationTyp;
	}

	public Qualifikation(String qualifikationName, String qualifikationTyp,
			Set<MitarbeiterQualifikation> mitarbeiterQualifikations) {
		this.qualifikationName = qualifikationName;
		this.qualifikationTyp = qualifikationTyp;
		this.mitarbeiterQualifikations = mitarbeiterQualifikations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "QualifikationID", unique = true, nullable = false)
	public Integer getQualifikationId() {
		return this.qualifikationId;
	}

	public void setQualifikationId(Integer qualifikationId) {
		this.qualifikationId = qualifikationId;
	}

	@Column(name = "QualifikationName", nullable = false, length = 60)
	public String getQualifikationName() {
		return this.qualifikationName;
	}

	public void setQualifikationName(String qualifikationName) {
		this.qualifikationName = qualifikationName;
	}

	@Column(name = "QualifikationTyp", nullable = false, length = 30)
	public String getQualifikationTyp() {
		return this.qualifikationTyp;
	}

	public void setQualifikationTyp(String qualifikationTyp) {
		this.qualifikationTyp = qualifikationTyp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qualifikation")
	public Set<MitarbeiterQualifikation> getMitarbeiterQualifikations() {
		return this.mitarbeiterQualifikations;
	}

	public void setMitarbeiterQualifikations(
			Set<MitarbeiterQualifikation> mitarbeiterQualifikations) {
		this.mitarbeiterQualifikations = mitarbeiterQualifikations;
	}

}
