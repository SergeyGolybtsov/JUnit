package org.example;

public class User {
    private String login;
    private String email;

    public User() {
    }

    public User(String login, String email) {
        if (login.equals(email)){
            throw new IllegalArgumentException("Почта и логин не должны совпадать!");
        }
        this.login = login;

        if (!emailValid(email)) {
            throw new IllegalArgumentException("Укажите актуальную почту!");
        }
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String setLogin(String login) {
        return login;
    }

    public String setEmail(String email) {
        return email;
    }

    private boolean emailValid(String email){
        return email.contains("@") && email.contains(".");
    }
}

