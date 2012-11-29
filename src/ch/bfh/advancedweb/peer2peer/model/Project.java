package ch.bfh.advancedweb.peer2peer.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

import java.util.Date;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity

public class Project implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private double amount;
	private int duration;
	private boolean status;
	private String mark;
	@Temporal(DATE)
	private Date startdate;
	@Temporal(DATE)
	private Date enddate;
	@Temporal(DATE)
	private Date creationdate;
	private static final long serialVersionUID = 1L;

	public Project() {
		super();
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
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}   
	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
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
   
}
