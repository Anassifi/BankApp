package com.example.BankApp.test;

import com.example.BankApp.DAO.BankDAOImpl;
import com.example.BankApp.model.Account;
import java.sql.SQLException;
import java.util.List;


public class test {
    public static void main(String[] args) throws SQLException {
        BankDAOImpl test = new BankDAOImpl();
        List<Account> ls = test.getAllAccounts();

        for(Account l : ls) {
            System.out.println(l.getFirstName());
        }


        System.out.println("Update Method successfully!");
    }
}
