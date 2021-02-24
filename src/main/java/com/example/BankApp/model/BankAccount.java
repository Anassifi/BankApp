package com.example.BankApp.model;

public class BankAccount extends Account{

    private int accountNumber;
    private int solde;
    private String accountType;

    public BankAccount(int id_account, String firstName, String lastName, String email, String password, String numeroTel, String createdAt) {
        super(id_account, firstName, lastName, email, password, numeroTel, createdAt);
    }

    public BankAccount (int accountNumber, int solde, String accountType) {
        super();
        this.accountNumber = accountNumber;
        this.solde = solde;
        this.accountType = accountType;

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
