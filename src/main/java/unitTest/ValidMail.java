package unitTest;


public class ValidMail {
    public boolean sendMail(String to, String subject, String body) {

        System.out.println("Mail Send to : " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);

        return true; 
    }
}
