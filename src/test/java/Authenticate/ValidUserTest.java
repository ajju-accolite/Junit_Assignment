package Authenticate;
import org.junit.jupiter.api.Test;
import unitTest.ValidCheck;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ValidUserTest {
	
	@Test
    public void TestPassword() {
    	ValidCheck authService = new ValidCheck();
    	String s = authService.authenticateUser("sample@test.com", "passwordtest");
        assertEquals("Wrong password", s);
    }

    @Test
    public void TestEmail() {
        ValidCheck authService = new ValidCheck();
        String s = authService.authenticateUser("check@wrong.com", "1212abcd");
        assertEquals("Invalid email", s);
    }

    

    @Test
    public void TestLoginSuccess() {
    	ValidCheck authService = new ValidCheck();
    	String s = authService.authenticateUser("sample@test.com", "1212abcd");
        assertEquals("Login successful", s);
    }
}