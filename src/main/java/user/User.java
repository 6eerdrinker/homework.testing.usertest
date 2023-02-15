package user;

public class User {
    private final String login;
    private final String email;

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public String createUser(String login, String email) {
        if (login == null || email == null) {
            return "Data is not set";
        }
        return login + " " + email;
    }
    public String correctUser(String login, String email) {
        if (login.isBlank() || login.isEmpty()
                || email.isBlank() || email.isEmpty()) {
            return "Not created";
        }
        return login + " " + email;
    }

    public void correctEmail(String email) {
        if (!email.contains("@") && !email.contains(".")) {
            throw new IncorrectFillingException();
        }
    }

    public void loginEmail(String login, String email) {
        if (login.equals(email)) {
            throw new IncorrectFillingException();
        }
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }
}

