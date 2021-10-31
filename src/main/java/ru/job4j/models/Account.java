package ru.job4j.models;

import java.util.Objects;
import java.util.StringJoiner;

public class Account {
    private int id;
    private String userName;
    private String email;
    private String phone;

    public Account(int id, String userName, String email, String phone) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
    }

    public Account(String userName, String email, String phone) {
        this.userName = userName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return id == account.id
                && Objects.equals(userName, account.userName)
                && Objects.equals(email, account.email)
                && Objects.equals(phone, account.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, phone);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userName='" + userName + "'")
                .add("email='" + email + "'")
                .add("phone='" + phone + "'")
                .toString();
    }
}
