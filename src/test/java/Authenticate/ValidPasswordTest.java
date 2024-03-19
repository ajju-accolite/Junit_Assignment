package Authenticate;
import unitTest.user;
import unitTest.ValidMail;
import unitTest.ChangePin;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;


public class ValidPasswordTest {

    @Test
    public void PasswordResetLinkForValidMailTest() {
    	ValidMail mockMailService = mock(ValidMail.class);
        when(mockMailService.sendMail(anyString(), anyString(), anyString())).thenReturn(true);
        HashMap<String, user> mockUsers = new HashMap<>();
        user user = new user("check@sample.com", "oldPassword");
        mockUsers.put("check@sample.com", user);
        ChangePin passwordResetService = new ChangePin(mockMailService, mockUsers);
        boolean result = passwordResetService.ResetPasswordLink("check@sample.com");
        verify(mockMailService).sendMail(eq("check@sample.com"), eq("Password Reset Link"), anyString());
        assertTrue(result);
    }

    @Test
    public void PasswordResetLinkForInvalidmailTest() {
    	ValidMail mockMailService = mock(ValidMail.class);
        when(mockMailService.sendMail(anyString(), anyString(), anyString())).thenReturn(true);
        HashMap<String, user> mockUsers = new HashMap<>();
        ChangePin passwordResetService = new ChangePin(mockMailService, mockUsers);
        boolean result = passwordResetService.ResetPasswordLink("check@wrong.com");
        verify(mockMailService, never()).sendMail(anyString(), anyString(), anyString());
        assertFalse(result);
    }

    @Test
    public void PasswordResetLinkForValidEmailNotInMapTest() {
        
    	ValidMail mockMailService = mock(ValidMail.class);
        when(mockMailService.sendMail(anyString(), anyString(), anyString())).thenReturn(true);    
        HashMap<String, user> mockUsers = new HashMap<>();   
        ChangePin passwordResetService = new ChangePin(mockMailService, mockUsers);
        boolean result = passwordResetService.ResetPasswordLink("check@sample.com");
        verify(mockMailService, never()).sendMail(anyString(), anyString(), anyString());
        assertFalse(result);
    }
}




