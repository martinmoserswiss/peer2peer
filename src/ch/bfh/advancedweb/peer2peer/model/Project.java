package ch.bfh.advancedweb.peer2peer.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.DATE;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
public class Project implements Serializable {

	  
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String projectName;
	private double amount; // Betrag in Franken
	private int duration; // Dauer in
	
	@Enumerated(EnumType.STRING)
    private ProjectStatus status;
	
	private int mark;
	@Temporal(DATE)
	private Date startdate;
	@Temporal(DATE)
	private Date enddate;
	@Temporal(DATE)
	private Date creationdate;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "project")
	private List<Loan> loans;
	
	private User user;

	public Project() {
		super();
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}   
	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}   
	
	public Date getStartdate() {
		return startdate;
	}
	
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
	public Date getEnddate() {
		return enddate;
	}
	
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	public Date getCreationdate() {
		return creationdate;
	}
	
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ProjectStatus getStatus() {
		return status;
	}
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
   
}
