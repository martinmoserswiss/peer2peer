package ch.bfh.advancedweb.peer2peer.view;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ch.bfh.advancedweb.peer2peer.controller.RegisterController;
import ch.bfh.advancedweb.peer2peer.controller.UserController;
import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@SessionScoped
public class RegisterBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String c_email;
	private String password;
	private String c_password;
	private String firstname;
	private String lastname;
	private int birthdate1;
	private int birthdate2;
	private int birthdate3;
	private String country;
	private String city;
	private String street;
	private int postalcode;
	private String phone;
	private double income;
	private double expenses;
	private int existing_credits;
	
	
	@ManagedProperty("#{userController}")
	private UserController userController;
	private RegisterController registerController;

	private String message;
	
	public RegisterBean(){
		
	}
	
	public String register() throws ParseException{
		
		User user = new User();
		
		//TODO: Password & Email Vergleich
		//TODO: Datum aus Birthday1, 2, 3 erstellen
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date birthdate = sdf.parse(this.birthdate1+"."+this.birthdate2+"."+this.birthdate3);
		
		user.setEmail(this.email);
		user.setPassword(this.password);
		user.setFirstname(this.firstname);
		user.setLastname(this.lastname);
		user.setBirthdate(birthdate);
		
		if(this.country.equals("CH"))user.setCountry("Schweiz");
		else user.setCountry("Deutschland (Bundesrep.)");

		user.setCity(this.city);
		user.setStreet(this.street);
		user.setPostalcode(this.postalcode);
		user.setPhone(this.phone);
		user.setIncome(this.income);
		user.setExpenses(this.expenses);
		user.setExsisting_credits(this.existing_credits);

		user.setRegistration_date(new Date());
		
		this.registerController = new RegisterController();
		this.registerController.register(user);
		
		return "login";
		
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public String getMessage(){
		return this.message;
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

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getBirthdate1() {
		return birthdate1;
	}

	public void setBirthdate1(int birthdate1) {
		this.birthdate1 = birthdate1;
	}

	public int getBirthdate2() {
		return birthdate2;
	}

	public void setBirthdate2(int birthdate2) {
		this.birthdate2 = birthdate2;
	}

	public int getBirthdate3() {
		return birthdate3;
	}

	public void setBirthdate3(int birthdate3) {
		this.birthdate3 = birthdate3;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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

	public int getExisting_credits() {
		return existing_credits;
	}

	public void setExisting_credits(int existing_credits) {
		this.existing_credits = existing_credits;
	}

	public RegisterController getRegisterController() {
		return registerController;
	}

	public void setRegisterController(RegisterController registerController) {
		this.registerController = registerController;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
