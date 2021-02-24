package com.example.BankApp.controller;

import com.example.BankApp.DAO.BankDAO;
import com.example.BankApp.DAO.BankDAOImpl;
import com.example.BankApp.model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class AccountController extends HttpServlet {

    private BankDAOImpl bankDAOImpl;

    public void init() {
        bankDAOImpl = new BankDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("doGet");
        String action = req.getServletPath();
        System.out.println(action);

        switch(action) {
            case "/new":
                showNewAccount(req, res);
                System.out.println("new account");
                break;
            case "/insert":
                System.out.println("insert account");
                try {
                    insertAccount(req, res);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete":
                System.out.println("delete account");
                try {
                    deleteAccount(req, res);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit":
                try {
                    System.out.println("Account edited");
                    showEditAccount(req, res);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "/update":
                try {
                    System.out.println("Account updated!");
                    updateAccount(req, res);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listAccounts(req, res);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
    private void listAccounts(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, ClassNotFoundException {
        List<Account> accounts = bankDAOImpl.getAllAccounts();
        request.setAttribute("accounts", accounts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/account-list.jsp");
        dispatcher.forward(request, response);
}

    private void showNewAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/account-form.jsp");
       dispatcher.forward(request, response);

    }

    private void showEditAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Account existingAccount = bankDAOImpl.getAccount(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/account-form.jsp");
        request.setAttribute("account", existingAccount);
        dispatcher.forward(request, response);

    }

    private void insertAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String numeroTel = request.getParameter("numerotel");

        Account newAccount = new Account(firstname, lastname, email, password, numeroTel);
        bankDAOImpl.saveAccount(newAccount);

        response.sendRedirect("account");
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("id = "+ id);
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String numeroTel = request.getParameter("numerotel");

        Account account = new Account(firstname, lastname, email, password, numeroTel, id);

        bankDAOImpl.updateAccount(account);
        response.sendRedirect("account");
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        bankDAOImpl.deleteAccount(id);
        response.sendRedirect("account");
    }




}
