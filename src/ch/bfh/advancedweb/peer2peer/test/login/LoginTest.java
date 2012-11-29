package ch.bfh.advancedweb.peer2peer.test.login;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.controller.UserController;
import ch.bfh.advancedweb.peer2peer.model.User;

public class LoginTest {

	@Test
	public void test() {
		
		UserController userController = new UserController();
		assertTrue(userController.isValid("martin", "1234"));
		
	}

}
