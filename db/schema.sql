CREATE TABLE if not exists accounts
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    email    VARCHAR NOT NULL UNIQUE,
    phone    VARCHAR NOT NULL UNIQUE
);

CREATE TABLE if not exists tickets
(
    id         SERIAL PRIMARY KEY,
    session_id INT NOT NULL,
    row        INT NOT NULL,
    cell       INT NOT NULL,
    account_id INT NOT NULL REFERENCES accounts (id),
    UNIQUE (account_id, row, cell)
);