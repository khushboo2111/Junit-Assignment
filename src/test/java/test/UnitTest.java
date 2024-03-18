package test;
import java.util.ArrayList;
import java.util.HashMap;

import list.*;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;




public class UnitTest {
	
	private static SendEmailImpl auth;
	@BeforeAll
	public static void initiateAuth()
	{
		auth = new SendEmailImpl();
		auth.Register("guptakhushboo@gmail.com", "user@1234");
		auth.Register("guptaakash@gmail.com", "user@2111");
	}

	
	@Test
	public void testValidUserExist() {
		Assertions.assertEquals(true, auth.userExist("guptakhushboo@gmail.com"));
		Assertions.assertEquals(true, auth.userExist("guptaakash@gmail.com"));
		
	}
	@Test
	public void testInvalidUserExist() {
		Assertions.assertEquals(false, auth.userExist(""));
		Assertions.assertEquals(false, auth.userExist("guptaakashgmail.com"));
	}
	@Test
	public void testValidRegister() {
		Assertions.assertEquals(true, auth.Register("guptaadi@gmail.com", "user@1235"));
		Assertions.assertEquals(true, auth.Register("adisingh@gmail.com", "user@1235"));
	}
	
	@Test
	public void testInvalidRegister() {
		Assertions.assertEquals(false, auth.Register("guptakhushboo@gmail.com", "user@1234"));
		Assertions.assertEquals(false, auth.Register("guptakhushboo@gmail.com", "user123"));
		Assertions.assertEquals(false, auth.Register("guptakhushboo@gmail.com", "user123"));
		Assertions.assertEquals(false, auth.Register("guptakhushboo@gmail.com", ""));
		Assertions.assertEquals(false, auth.Register("", "user@1234"));
		Assertions.assertEquals(false, auth.Register("guptaakashgmail.com", "user@2111"));
	}

	@Test
	public void testValidLogin() {
		Assertions.assertEquals(true, auth.Login("guptakhushboo@gmail.com", "user@1234") );
		Assertions.assertEquals(true, auth.Login("guptaakash@gmail.com", "user@2111"));
		
	}
	
	@Test
	public void testInvalidLogin() {
		Assertions.assertEquals(false, auth.Login("guptakhushboo@gmail.com", "use1234") );
		Assertions.assertEquals(false, auth.Login("guptakhushboo@gmail.com", "user123"));
		Assertions.assertEquals(false, auth.Login("guptakhushboo@gmail.com", ""));
		Assertions.assertEquals(false, auth.Login("", "user@1234"));
		Assertions.assertEquals(false, auth.Login("guptaakashgmail.com", "user@2111"));
	}
	
	@Test
	public void testValidForgotPassword() {
		Assertions.assertEquals(true, auth.newPassword("guptakhushboo@gmail.com", "user@1234"));
		Assertions.assertEquals(true, auth.newPassword("guptaakash@gmail.com", "user@2111"));
	}
	
	@Test
	public void testInvalidForgotPassword() {
		Assertions.assertEquals(false, auth.newPassword("guptakhushboo@gmail.com", "user123"));
		Assertions.assertEquals(false, auth.newPassword("guptakhushboo@gmail.com", "user123"));
		Assertions.assertEquals(false, auth.newPassword("guptakhushboo@gmail.com", ""));
		Assertions.assertEquals(false, auth.newPassword("", "user@1234"));
	}
	
	
	
}
