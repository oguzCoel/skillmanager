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
 * ProjektTask generated by hbm2java
 */
@Entity
@Table(name = "ProjektTask", catalog = "Skillmanager", uniqueConstraints = @UniqueConstraint(columnNames = {
		"Projekt", "Task" }))
public class ProjektTask implements java.io.Serializable {

	private Integer projektTaskId;
	private Projekt projekt;
	private Task task;

	public ProjektTask() {
	}

	public ProjektTask(Projekt projekt, Task task) {
		this.projekt = projekt;
		this.task = task;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ProjektTaskId", unique = true, nullable = false)
	public Integer getProjektTaskId() {
		return this.projektTaskId;
	}

	public void setProjektTaskId(Integer projektTaskId) {
		this.projektTaskId = projektTaskId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Projekt", nullable = false)
	public Projekt getProjekt() {
		return this.projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Task", nullable = false)
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
