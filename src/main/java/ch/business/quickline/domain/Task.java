package ch.business.quickline.domain;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Task", catalog = "Skillmanager")
public class Task implements java.io.Serializable {

	private Integer taskId;
	private String taskName;
	private String taskBeschreibung;
	private Set<Abteilung> abteilungs = new HashSet<Abteilung>(0);
	private Set<Skill> skills = new HashSet<Skill>(0);
	private Set<Projekt> projekts = new HashSet<Projekt>(0);
	private Set<Mitarbeiter> mitarbeiters = new HashSet<Mitarbeiter>(0);

	public Task() {
	}

	public Task(String taskName, String taskBeschreibung) {
		this.taskName = taskName;
		this.taskBeschreibung = taskBeschreibung;
	}

	public Task(String taskName, String taskBeschreibung,
			Set<Abteilung> abteilungs, Set<Skill> skills,
			Set<Projekt> projekts, Set<Mitarbeiter> mitarbeiters) {
		this.taskName = taskName;
		this.taskBeschreibung = taskBeschreibung;
		this.abteilungs = abteilungs;
		this.skills = skills;
		this.projekts = projekts;
		this.mitarbeiters = mitarbeiters;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TaskID", unique = true, nullable = false)
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Column(name = "TaskName", nullable = false, length = 30)
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "TaskBeschreibung", nullable = false, length = 500)
	public String getTaskBeschreibung() {
		return this.taskBeschreibung;
	}

	public void setTaskBeschreibung(String taskBeschreibung) {
		this.taskBeschreibung = taskBeschreibung;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AbteilungTask", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Task", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Abteilung", nullable = false, updatable = false) })
	public Set<Abteilung> getAbteilungs() {
		return this.abteilungs;
	}

	public void setAbteilungs(Set<Abteilung> abteilungs) {
		this.abteilungs = abteilungs;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SkillTask", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Task", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Skill", nullable = false, updatable = false) })
	public Set<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ProjektTask", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Task", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Projekt", nullable = false, updatable = false) })
	public Set<Projekt> getProjekts() {
		return this.projekts;
	}

	public void setProjekts(Set<Projekt> projekts) {
		this.projekts = projekts;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MitarbeiterTask", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Task", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Mitarbeiter", nullable = false, updatable = false) })
	public Set<Mitarbeiter> getMitarbeiters() {
		return this.mitarbeiters;
	}

	public void setMitarbeiters(Set<Mitarbeiter> mitarbeiters) {
		this.mitarbeiters = mitarbeiters;
	}

}
