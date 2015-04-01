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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Benutzer", catalog = "Skillmanager")
public class Benutzer implements java.io.Serializable {

	private Integer benutzerId;
	private Mitarbeiter mitarbeiter;
	private String benutzerName;
	private String benutzerPasswort;
	private String benutzerEmail;
	private Set<Role> roles = new HashSet<Role>(0);

	public Benutzer() {
	}

	public Benutzer(Mitarbeiter mitarbeiter, String benutzerName,
			String benutzerPasswort, String benutzerEmail) {
		this.mitarbeiter = mitarbeiter;
		this.benutzerName = benutzerName;
		this.benutzerPasswort = benutzerPasswort;
		this.benutzerEmail = benutzerEmail;
	}

	public Benutzer(Mitarbeiter mitarbeiter, String benutzerName,
			String benutzerPasswort, String benutzerEmail, Set<Role> roles) {
		this.mitarbeiter = mitarbeiter;
		this.benutzerName = benutzerName;
		this.benutzerPasswort = benutzerPasswort;
		this.benutzerEmail = benutzerEmail;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BenutzerID", unique = true, nullable = false)
	public Integer getBenutzerId() {
		return this.benutzerId;
	}

	public void setBenutzerId(Integer benutzerId) {
		this.benutzerId = benutzerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Mitarbeiter", nullable = false)
	public Mitarbeiter getMitarbeiter() {
		return this.mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	@Column(name = "BenutzerName", nullable = false, length = 30)
	public String getBenutzerName() {
		return this.benutzerName;
	}

	public void setBenutzerName(String benutzerName) {
		this.benutzerName = benutzerName;
	}

	@Column(name = "BenutzerPasswort", nullable = false, length = 30)
	public String getBenutzerPasswort() {
		return this.benutzerPasswort;
	}

	public void setBenutzerPasswort(String benutzerPasswort) {
		this.benutzerPasswort = benutzerPasswort;
	}

	@Column(name = "BenutzerEmail", nullable = false, length = 30)
	public String getBenutzerEmail() {
		return this.benutzerEmail;
	}

	public void setBenutzerEmail(String benutzerEmail) {
		this.benutzerEmail = benutzerEmail;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "BenutzerRole", catalog = "Skillmanager", joinColumns = { @JoinColumn(name = "Benutzer", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Role", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
