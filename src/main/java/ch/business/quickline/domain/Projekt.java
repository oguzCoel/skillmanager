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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Projekt", catalog = "Skillmanager")
public class Projekt implements java.io.Serializable {

	private Integer projektId;
	private String projektName;
	private String projektBeschreibung;
	private Date projektBeginn;
	private Date projektEnde;
	private Set<Task> tasks = new HashSet<Task>(0);
	private Set<Abteilung> abteilungs = new HashSet<Abteilung>(0);

	public Projekt() {
	}

	public Projekt(String projektName, String projektBeschreibung) {
		this.projektName = projektName;
		this.projektBeschreibung = projektBeschreibung;
	}

	public Projekt(String projektName, String projektBeschreibung,
			Date projektBeginn, Date projektEnde, Set<Task> tasks,
			Set<Abteilung> abteilungs) {
		this.projektName = projektName;
		this.projektBeschreibung = projektBeschreibung;
		this.projektBeginn = projektBeginn;
		this.projektEnde = projektEnde;
		this.tasks = tasks;
		this.abteilungs = abteilungs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ProjektID", unique = true, nullable = false)
	public Integer getProjektId() {
		return this.projektId;
	}

	public void setProjektId(Integer projektId) {
		this.projektId = projektId;
	}

	@Column(name = "ProjektName", nullable = false, length = 30)
	public String getProjektName() {
		return this.projektName;
	}

	public void setProjektName(String projektName) {
		this.projektName = projektName;
	}

	@Column(name = "ProjektBeschreibung", nullable = false, length = 500)
	public String getProjektBeschreibung() {
		return this.projektBeschreibung;
	}

	public void setProjektBeschreibung(String projektBeschreibung) {
		this.projektBeschreibung = projektBeschreibung;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ProjektBeginn", length = 10)
	public Date getProjektBeginn() {
		return this.projektBeginn;
	}

	public void setProjektBeginn(Date projektBeginn) {
		this.projektBeginn = projektBeginn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ProjektEnde", length = 10)
	public Date getProjektEnde() {
		return this.projektEnde;
	}

	public void setProjektEnde(Date projektEnde) {
		this.projektEnde = projektEnde;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ProjektTask", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Projekt", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Task", nullable = false, updatable = false) })
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AbteilungProjekt", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Projekt", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Abteilung", nullable = false, updatable = false) })
	public Set<Abteilung> getAbteilungs() {
		return this.abteilungs;
	}

	public void setAbteilungs(Set<Abteilung> abteilungs) {
		this.abteilungs = abteilungs;
	}

}
