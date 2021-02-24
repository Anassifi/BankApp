package com.example.BankApp.model;

public class Account {
    private int id_account;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String numeroTel;
    private String createdAt;

    public Account(int id_account, String firstName, String lastName, String email, String password, String numeroTel, String createdAt) {
        this.id_account = id_account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.numeroTel = numeroTel;
        this.createdAt = createdAt;
    }

    public Account(String firstName, String lastName, String email, String password, String numeroTel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.numeroTel = numeroTel;
    }

    public Account() {

    }

    public Account(String firstName, String lastName, String email, String password, String numeroTel, int id_account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.numeroTel = numeroTel;
        this.id_account = id_account;
    }

    public Account(String firstname, String lastname, String email, String password, String numerotel, String createdAt) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.numeroTel = numerotel;
        this.createdAt = createdAt;
    }

    public Account(int id, String firstname, String lastname, String email, String password, String numeroTel) {
        this.id_account = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.numeroTel = numeroTel;
    }



    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
