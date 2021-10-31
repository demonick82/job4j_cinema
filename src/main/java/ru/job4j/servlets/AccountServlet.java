package ru.job4j.servlets;

import ru.job4j.models.Account;
import ru.job4j.models.Ticket;
import ru.job4j.store.PsqlStore;
import ru.job4j.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Store store = PsqlStore.instOf();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int id = Integer.parseInt(req.getParameter("id"));
        int row = Integer.parseInt(req.getParameter("row"));
        int cell = Integer.parseInt(req.getParameter("cell"));
        store.saveAccount(new Account(name, email, phone));
        int userId = store.selectAccountForEmail(email).getId();
        store.saveTicket(new Ticket(id, row, cell, userId));
    }
}
