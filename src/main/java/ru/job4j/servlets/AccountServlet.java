package ru.job4j.servlets;

import org.postgresql.util.PSQLException;
import ru.job4j.models.Account;
import ru.job4j.models.Ticket;
import ru.job4j.store.PsqlStore;
import ru.job4j.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        Store store = PsqlStore.instOf();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        int id = Integer.parseInt(req.getParameter("id"));
        int row = Integer.parseInt(req.getParameter("row"));
        int cell = Integer.parseInt(req.getParameter("cell"));
        try {
            store.saveAccount(new Account(name, email, phone));
            int userId = store.selectAccountForEmail(email).getId();
            store.saveTicket(new Ticket(id, row, cell, userId));
        } catch (Exception e) {
            writer.print(409);
        }
    }
}
