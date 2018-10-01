package ru.core.domain;

public class ClientForm {
    private String login;

    private String password;

    private String fullName;

    private Character sex;

    public ClientForm(String login, String password, String fullName, Character sex) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.sex = sex;
    }

    public ClientForm(){}

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }
}
