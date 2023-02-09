package user;

public class User {
    private final String login;
    private final String email;

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public String realUser(String login, String email) {
        if (login != null &&  !login.isBlank()
                && email != null &&  !email.isBlank()) {
            login = "correct";
            email = "correct";
        }else {
            return "incorrect";}
        return "User created '%s' '%s'!".formatted(login, email);}


    public String correctEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            email = "correct";
        }else {
            return "incorrect";}
        return email;
    }

    public String loginEmail(String login, String email) {
        if (login.equals(email)) {
            login = "incorrect";
            email = "incorrect";
        }else {
            return "correct";
        }
        return "User not created '%s' '%s'!".formatted(login, email);
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }
}

