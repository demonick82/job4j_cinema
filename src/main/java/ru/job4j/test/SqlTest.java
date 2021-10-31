package ru.job4j.test;

import ru.job4j.models.Account;
import ru.job4j.models.Ticket;
import ru.job4j.store.MemStore;
import ru.job4j.store.PsqlStore;
import ru.job4j.store.Store;

public class SqlTest {
    public static void main(String[] args) {
        Store store = MemStore.instOf();
        Store store1 = PsqlStore.instOf();

        Ticket ticket = new Ticket(1, 1, 1, 1, 1);
        System.out.println(store.selectAccountForEmail("user@mail.ru"));
        System.out.println(store1.findAllTickets());
    }
}
