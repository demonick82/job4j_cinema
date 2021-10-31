package ru.job4j.store;

import ru.job4j.models.Account;
import ru.job4j.models.Ticket;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemStore implements Store {
    private static final MemStore INST = new MemStore();
    private final Map<Integer, Ticket> tickets = new ConcurrentHashMap<>();
    private final Map<Integer, Ticket> accounts = new ConcurrentHashMap<>();


    private MemStore() {
        tickets.put(1, new Ticket(1, 1, 1, 1, 1));
        tickets.put(2, new Ticket(2, 1, 1, 2, 2));
        tickets.put(3, new Ticket(3, 1, 1, 3, 3));
    }

    public static MemStore instOf() {
        return INST;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void deleteAccount(Account account) {

    }

    @Override
    public Collection<Ticket> findAllTickets() {
        return tickets.values();
    }

    @Override
    public Account selectAccountForEmail(String email) {
        return null;
    }


    @Override
    public void saveTicket(Ticket ticket) {

    }


    @Override
    public void deleteTicket(Ticket ticket) {

    }
}
