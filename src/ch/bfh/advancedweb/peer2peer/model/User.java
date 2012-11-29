package ch.bfh.advancedweb.peer2peer.model;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;
import java.util.Date;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	@Temporal(DATE)
	private Date birthdate;
	private String country;
	private String city;
	private String street;
	private int postalcode;
	private int phone;
	private double income;
	private double expenses;
	private int exsisting_credits;
	@Temporal(DATE)
	private Date registration_date;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getPostalcode() {
		return postalcode;
	}
	
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public double getIncome() {
		return income;
	}
	
	public void setIncome(double income) {
		this.income = income;
	}
	
	public double getExpenses() {
		return expenses;
	}
	
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	
	public int getExsisting_credits() {
		return exsisting_credits;
	}
	
	public void setExsisting_credits(int exsisting_credits) {
		this.exsisting_credits = exsisting_credits;
	}
	
	public Date getRegistration_date() {
		return registration_date;
	}
	
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
   
}
