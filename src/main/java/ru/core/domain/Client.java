package ru.core.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
@Data
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientSeq")
    @SequenceGenerator(name="clientSeq", sequenceName = "CLIENTS_SEQ_ID", allocationSize = 1)
    private Integer id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String fullName;

    @Column
    private Character sex;

    /*public Client(String login, String password, String fullName, Character sex) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.sex = sex;
    }

    public Client() {

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
    }*/
}
