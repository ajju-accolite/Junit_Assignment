package unitTest;

import java.util.HashMap;

public class ValidCheck {
    private HashMap<String, user> users;

    public ValidCheck() {
        users = new HashMap<>();
        users.put("sample@test.com", new user("sample@test.com", "1212abcd"));    }

    public String authenticateUser(String email, String password) {
        if (!users.containsKey(email)) {
            return "Invalid email";
        }

        user user = users.get(email);
        if (!password.equals(user.getPassword())) {
            return "Wrong password";
        }

        return "Login successful";
    }
}