package ru.job4j.models;

import java.util.Objects;
import java.util.StringJoiner;

public class Ticket {
    private int id;
    private int sessionId;
    private int row;
    private int cell;
    private int accountId;

    public Ticket(int id, int sessionId, int row, int cell, int accountId) {
        this.id = id;
        this.sessionId = sessionId;
        this.row = row;
        this.cell = cell;
        this.accountId = accountId;
    }

    public Ticket(int sessionId, int row, int cell, int accountId) {
        this.sessionId = sessionId;
        this.row = row;
        this.cell = cell;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return id == ticket.id
                && sessionId == ticket.sessionId
                && row == ticket.row
                && cell == ticket.cell
                && accountId == ticket.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionId, row, cell, accountId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ticket.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("sessionId=" + sessionId)
                .add("row=" + row)
                .add("cell=" + cell)
                .add("accountId=" + accountId)
                .toString();
    }
}

