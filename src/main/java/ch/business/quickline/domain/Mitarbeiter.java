package ch.business.quickline.domain;


import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Mitarbeiter", catalog = "Skillmanager")
public class Mitarbeiter implements java.io.Serializable {

	private Integer mitarbeiterId;
	private Abteilung abteilung;
	private String mitarbeiterVorname;
	private String mitarbeiterNachname;
	private Date mitarbeiterGeburtsDatum;
	private Date mitarbeiterAnstellungsDatum;
	private String mitarbeiterAdresse;
	private int mitarbeiterHausNummer;
	private int mitarbeiterPlz;
	private String mitarbeiterWohnort;
	private Set<Benutzer> benutzers = new HashSet<Benutzer>(0);
	private Set<MitarbeiterSkill> mitarbeiterSkills = new HashSet<MitarbeiterSkill>(
			0);
	private Set<Skill> skills = new HashSet<Skill>(0);
	private Set<Task> tasks = new HashSet<Task>(0);
	private Set<Qualifikation> qualifikations = new HashSet<Qualifikation>(0);

	public Mitarbeiter() {
	}

	public Mitarbeiter(Abteilung abteilung, String mitarbeiterVorname,
			String mitarbeiterNachname, Date mitarbeiterGeburtsDatum,
			Date mitarbeiterAnstellungsDatum, String mitarbeiterAdresse,
			int mitarbeiterHausNummer, int mitarbeiterPlz,
			String mitarbeiterWohnort) {
		this.abteilung = abteilung;
		this.mitarbeiterVorname = mitarbeiterVorname;
		this.mitarbeiterNachname = mitarbeiterNachname;
		this.mitarbeiterGeburtsDatum = mitarbeiterGeburtsDatum;
		this.mitarbeiterAnstellungsDatum = mitarbeiterAnstellungsDatum;
		this.mitarbeiterAdresse = mitarbeiterAdresse;
		this.mitarbeiterHausNummer = mitarbeiterHausNummer;
		this.mitarbeiterPlz = mitarbeiterPlz;
		this.mitarbeiterWohnort = mitarbeiterWohnort;
	}

	public Mitarbeiter(Abteilung abteilung, String mitarbeiterVorname,
			String mitarbeiterNachname, Date mitarbeiterGeburtsDatum,
			Date mitarbeiterAnstellungsDatum, String mitarbeiterAdresse,
			int mitarbeiterHausNummer, int mitarbeiterPlz,
			String mitarbeiterWohnort, Set<Benutzer> benutzers,
			Set<MitarbeiterSkill> mitarbeiterSkills, Set<Skill> skills,
			Set<Task> tasks, Set<Qualifikation> qualifikations) {
		this.abteilung = abteilung;
		this.mitarbeiterVorname = mitarbeiterVorname;
		this.mitarbeiterNachname = mitarbeiterNachname;
		this.mitarbeiterGeburtsDatum = mitarbeiterGeburtsDatum;
		this.mitarbeiterAnstellungsDatum = mitarbeiterAnstellungsDatum;
		this.mitarbeiterAdresse = mitarbeiterAdresse;
		this.mitarbeiterHausNummer = mitarbeiterHausNummer;
		this.mitarbeiterPlz = mitarbeiterPlz;
		this.mitarbeiterWohnort = mitarbeiterWohnort;
		this.benutzers = benutzers;
		this.mitarbeiterSkills = mitarbeiterSkills;
		this.skills = skills;
		this.tasks = tasks;
		this.qualifikations = qualifikations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MitarbeiterID", unique = true, nullable = false)
	public Integer getMitarbeiterId() {
		return this.mitarbeiterId;
	}

	public void setMitarbeiterId(Integer mitarbeiterId) {
		this.mitarbeiterId = mitarbeiterId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MitarbeiterAbteilung", nullable = false)
	public Abteilung getAbteilung() {
		return this.abteilung;
	}

	public void setAbteilung(Abteilung abteilung) {
		this.abteilung = abteilung;
	}

	@Column(name = "MitarbeiterVorname", nullable = false, length = 30)
	public String getMitarbeiterVorname() {
		return this.mitarbeiterVorname;
	}

	public void setMitarbeiterVorname(String mitarbeiterVorname) {
		this.mitarbeiterVorname = mitarbeiterVorname;
	}

	@Column(name = "MitarbeiterNachname", nullable = false, length = 30)
	public String getMitarbeiterNachname() {
		return this.mitarbeiterNachname;
	}

	public void setMitarbeiterNachname(String mitarbeiterNachname) {
		this.mitarbeiterNachname = mitarbeiterNachname;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MitarbeiterGeburtsDatum", nullable = false, length = 10)
	public Date getMitarbeiterGeburtsDatum() {
		return this.mitarbeiterGeburtsDatum;
	}

	public void setMitarbeiterGeburtsDatum(Date mitarbeiterGeburtsDatum) {
		this.mitarbeiterGeburtsDatum = mitarbeiterGeburtsDatum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MitarbeiterAnstellungsDatum", nullable = false, length = 10)
	public Date getMitarbeiterAnstellungsDatum() {
		return this.mitarbeiterAnstellungsDatum;
	}

	public void setMitarbeiterAnstellungsDatum(Date mitarbeiterAnstellungsDatum) {
		this.mitarbeiterAnstellungsDatum = mitarbeiterAnstellungsDatum;
	}

	@Column(name = "MitarbeiterAdresse", nullable = false, length = 30)
	public String getMitarbeiterAdresse() {
		return this.mitarbeiterAdresse;
	}

	public void setMitarbeiterAdresse(String mitarbeiterAdresse) {
		this.mitarbeiterAdresse = mitarbeiterAdresse;
	}

	@Column(name = "MitarbeiterHausNummer", nullable = false)
	public int getMitarbeiterHausNummer() {
		return this.mitarbeiterHausNummer;
	}

	public void setMitarbeiterHausNummer(int mitarbeiterHausNummer) {
		this.mitarbeiterHausNummer = mitarbeiterHausNummer;
	}

	@Column(name = "MitarbeiterPLZ", nullable = false)
	public int getMitarbeiterPlz() {
		return this.mitarbeiterPlz;
	}

	public void setMitarbeiterPlz(int mitarbeiterPlz) {
		this.mitarbeiterPlz = mitarbeiterPlz;
	}

	@Column(name = "MitarbeiterWohnort", nullable = false, length = 30)
	public String getMitarbeiterWohnort() {
		return this.mitarbeiterWohnort;
	}

	public void setMitarbeiterWohnort(String mitarbeiterWohnort) {
		this.mitarbeiterWohnort = mitarbeiterWohnort;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
	public Set<Benutzer> getBenutzers() {
		return this.benutzers;
	}

	public void setBenutzers(Set<Benutzer> benutzers) {
		this.benutzers = benutzers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
	public Set<MitarbeiterSkill> getMitarbeiterSkills() {
		return this.mitarbeiterSkills;
	}

	public void setMitarbeiterSkills(Set<MitarbeiterSkill> mitarbeiterSkills) {
		this.mitarbeiterSkills = mitarbeiterSkills;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SkillMaster", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Mitarbeiter", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Skill", nullable = false, updatable = false) })
	public Set<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MitarbeiterTask", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Mitarbeiter", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Task", nullable = false, updatable = false) })
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MitarbeiterQualifikation", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Mitarbeiter", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Qualifikation", nullable = false, updatable = false) })
	public Set<Qualifikation> getQualifikations() {
		return this.qualifikations;
	}

	public void setQualifikations(Set<Qualifikation> qualifikations) {
		this.qualifikations = qualifikations;
	}

}
