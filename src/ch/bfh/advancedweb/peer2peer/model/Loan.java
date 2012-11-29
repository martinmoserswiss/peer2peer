package ch.bfh.advancedweb.peer2peer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
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
	private double interest_rate;
	private boolean status;
	private static final long serialVersionUID = 1L;

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
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
   
}
