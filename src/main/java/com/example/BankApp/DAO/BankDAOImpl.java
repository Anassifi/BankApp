package com.example.BankApp.DAO;

import com.example.BankApp.model.Account;
import com.example.BankApp.postgreConnection.PgConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankDAOImpl implements BankDAO{

    private static final String FIND_ALL_ACCOUNTS = "SELECT * FROM ACCOUNTS;";
    private static final String FIND_A_ACCOUNT = "SELECT firstname, lastname, email, password, numerotel FROM accounts WHERE id_account = ?";
    private static final String INSERT_AN_ACCOUNT = "INSERT INTO ACCOUNTS (firstname, lastname, email, password, numerotel) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_AN_ACCOUNT = "UPDATE ACCOUNTS SET firstname = ?, lastname=?, email=?, password=?, numerotel=? where id_account=?;";
    private static final String DELETE_AN_ACCOUNT = "DELETE FROM ACCOUNTS WHERE id_account = ?;";

    List<Account> accounts;

    public BankDAOImpl(){}

    @Override
    public Account getAccount(int id) throws SQLException {
        Account account = null;

        PreparedStatement ps = PgConnection.connect().prepareStatement(FIND_A_ACCOUNT);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String numerotel = rs.getString("numerotel");

            account = new Account(firstname, lastname, email, password, numerotel);
        }

        return account;
    }

    @Override
    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();

        String query = FIND_ALL_ACCOUNTS;

        PreparedStatement ps = PgConnection.connect().prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            int id_account = rs.getInt("id_account");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String numerotel = rs.getString("numerotel");
            String createdAt = rs.getString("created_on");
            accounts.add(new Account(id_account ,firstname, lastname, email, password, numerotel, createdAt));
        }

        return accounts;
    }

    @Override
    public boolean saveAccount(Account account) throws SQLException {

        PreparedStatement ps = PgConnection.connect().prepareStatement(INSERT_AN_ACCOUNT);

        ps.setString(1, account.getFirstName());
        ps.setString(2, account.getLastName());
        ps.setString(3, account.getEmail());
        ps.setString(4, account.getPassword());
        ps.setString(5, account.getNumeroTel());

        boolean rowSave = ps.executeUpdate() > 0;
        ps.close();

        return rowSave;
    }

    @Override
    public boolean updateAccount(Account account) throws SQLException {
        // "UPDATE ACCOUNTS SET firstname = ?, lastname=?, email=?, password=?, numerotel=? where id_account=?;"
        PreparedStatement ps = PgConnection.connect().prepareStatement(UPDATE_AN_ACCOUNT);

        ps.setString(1, account.getFirstName());
        ps.setString(2, account.getLastName());
        ps.setString(3, account.getEmail());
        ps.setString(4, account.getPassword());
        ps.setString(5, account.getNumeroTel());
        ps.setInt(6, account.getId_account());

        boolean updateRow = ps.executeUpdate() > 0;
        ps.close();

        return updateRow;
    }

    @Override
    public boolean deleteAccount(int id) throws SQLException {

        PreparedStatement ps = PgConnection.connect().prepareStatement(DELETE_AN_ACCOUNT);

        ps.setInt(1, id);

        boolean deleteRow = ps.executeUpdate() > 0;

        return deleteRow;
    }
}
