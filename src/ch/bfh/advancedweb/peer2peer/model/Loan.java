package ch.bfh.advancedweb.peer2peer.model;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Loan
 *
 */
@Entity

public class Loan implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private double interest_rate; // Zinssatz
	@Enumerated(EnumType.STRING)
    private LoanStatus status;
	private static final long serialVersionUID = 1L;
	
	private Project project;
	
	private User user;

	public Loan() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public double getInterest_rate() {
		return this.interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}   
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LoanStatus getStatus() {
		return status;
	}
	public void setStatus(LoanStatus status) {
		this.status = status;
	}

	
   
}
