package com.example.BankApp.DAO;

import com.example.BankApp.model.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BankDAO {
        Account getAccount(int id) throws SQLException, ClassNotFoundException;

        List<Account> getAllAccounts() throws SQLException, ClassNotFoundException;

        boolean saveAccount(Account account) throws SQLException, ClassNotFoundException;

        boolean updateAccount(Account account) throws SQLException, ClassNotFoundException;

        boolean deleteAccount(int id_account) throws SQLException, ClassNotFoundException;
}
