package unitTest;
import java.util.HashMap;

public class ChangePin {
    private ValidMail mailService;
    private HashMap<String, user> users;

    public ChangePin(ValidMail mailService, HashMap<String, user> users) {
        this.mailService = mailService;
        this.users = users;
    }

    public boolean ResetPasswordLink(String email) {
        if (!checkValidMail(email)) {
            return false; 
        }

        if (!users.containsKey(email)) {
            return false;
        }

        user user = users.get(email);
        String resetLink = PasswordResetLink(user);
        return mailService.sendMail(email, "Password Reset Link", resetLink);
    }

    private String PasswordResetLink(user user) {      
        return "https://reset.com/new-password?client=" + user.getEmail();
    }

    private boolean checkValidMail(String email) {
        return email != null && email.contains("@");
    }
}
