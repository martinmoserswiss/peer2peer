package ch.bfh.advancedweb.peer2peer.view;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ch.bfh.advancedweb.peer2peer.controller.ManageAccountController;
import ch.bfh.advancedweb.peer2peer.controller.RegisterController;
import ch.bfh.advancedweb.peer2peer.controller.UserController;
import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@SessionScoped
public class ManageAccountBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String old_password;
	private String new_password;
	private String c_new_password;
	
	private String email;
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
	private ManageAccountController manageAccountController;

	private String message;
	
	public ManageAccountBean(){
		
	}
	
	public String changePassword(){
		
		if(this.userController.getUser().getPassword().equals(this.old_password)){
			if(this.getNew_password().equals(this.getC_new_password())){
				this.userController.getUser().setPassword(this.getNew_password());
				
				this.manageAccountController = new ManageAccountController();
				this.manageAccountController.changePassword(this.userController.getUser());
		
				// TODO: Give a information-message, that password succesfully changed
				
			}
			else{
				// TODO: Give an error-message, that both new passwords were wrong
			}
		}
		else{
			// TODO: Give an error-message, that something went wrong (wrong password)
		}
		
		return "home";
	}
	
	public void loadContactInformation(){
		
		this.email = this.userController.getUser().getEmail();
		this.firstname = this.userController.getUser().getFirstname();
		this.lastname = this.userController.getUser().getLastname();
		Date date = this.userController.getUser().getBirthdate();
		this.birthdate1 = date.getDay();
		this.birthdate2 = date.getMonth();
		this.birthdate3 = date.getYear();
		this.country = this.userController.getUser().getCountry();
		this.city = this.userController.getUser().getCity();
		this.street = this.userController.getUser().getStreet();
		this.postalcode = this.userController.getUser().getPostalcode();
		this.phone = this.userController.getUser().getPhone();
		this.income = this.userController.getUser().getIncome();
		this.expenses = this.userController.getUser().getExpenses();
		this.existing_credits = this.userController.getUser().getExsisting_credits();
		
	}
	
	public void changeContactInformation(){
		
		String old_email = this.userController.getUser().getEmail();
		
		
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public String getMessage(){
		return this.message;
	}

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	public String getC_new_password() {
		return c_new_password;
	}

	public void setC_new_password(String c_new_password) {
		this.c_new_password = c_new_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setMessage(String message) {
		this.message = message;
	}

	public ManageAccountController getManageAccountController() {
		return manageAccountController;
	}

	public void setManageAccountController(
			ManageAccountController manageAccountController) {
		this.manageAccountController = manageAccountController;
	}

}
