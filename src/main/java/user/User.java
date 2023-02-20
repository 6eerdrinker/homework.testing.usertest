package user;

public class User {
    private String login;
    private String email;

    public User(String login, String email) {
        checkLogin(login, email);
        checkEmail(email);
        this.login = login;
        this.email = email;
        }

    public User() {
    }

    public void checkEmail(String email) {
        if (email == null) {
            throw new IncorrectFillingException("Email must not be null");
        } else if (!email.contains("@") && !email.contains(".") || email.isBlank()) {
            throw new IncorrectFillingException("Email must contain @ and ., and not be empty");
        }
    }

    public String checkLogin(String login, String email) {
        if (login == null) {
            throw new IncorrectFillingException("Login must not be null");
        } else if (login.equals(email) || login.isEmpty() || login.isBlank()) {
            throw new IncorrectFillingException("Login cannot be identical to email and be empty");
        }
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }
}
