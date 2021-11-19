
package com.natan.linkeeper.model;

public class User {

    private String login;
    private String password;

    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean matches(String login, String password) {
        boolean loginMatches = this.login.equals(login);
        boolean passwordMatches = this.password.equals(password);

        return (loginMatches && passwordMatches);
    }
}
