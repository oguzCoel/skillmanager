package ch.business.quickline.domain;


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


@Entity
@Table(name = "Gruppe", catalog = "Skillmanager")
public class Gruppe implements java.io.Serializable {

	private Integer gruppeId;
	private String gruppeName;
	private Set<Skill> skills = new HashSet<Skill>(0);

	public Gruppe() {
	}

	public Gruppe(String gruppeName) {
		this.gruppeName = gruppeName;
	}

	public Gruppe(String gruppeName, Set<Skill> skills) {
		this.gruppeName = gruppeName;
		this.skills = skills;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "GruppeID", unique = true, nullable = false)
	public Integer getGruppeId() {
		return this.gruppeId;
	}

	public void setGruppeId(Integer gruppeId) {
		this.gruppeId = gruppeId;
	}

	@Column(name = "GruppeName", nullable = false, length = 30)
	public String getGruppeName() {
		return this.gruppeName;
	}

	public void setGruppeName(String gruppeName) {
		this.gruppeName = gruppeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gruppe")
	public Set<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

}
