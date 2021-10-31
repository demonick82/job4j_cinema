package ru.job4j.store;

import ru.job4j.models.Account;
import ru.job4j.models.Ticket;

import java.util.Collection;

public interface Store {

    void saveAccount(Account account);

    void deleteAccount(Account account);

    Collection<Ticket> findAllTickets();

    Account selectAccountForEmail(String email);

    void saveTicket(Ticket ticket);

    void deleteTicket(Ticket ticket);

}
