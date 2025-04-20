CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    enabled  boolean      NOT NULL
) ENGINE = InnoDb;
CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username),
    UNIQUE INDEX authorities_idx_1 (username, authority)
) ENGINE = InnoDb;

CREATE TABLE customers
(
    id         bigint(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    firstname  VARCHAR(50)                         NOT NULL,
    lastname   VARCHAR(255)                        NOT NULL,
    email      VARCHAR(255)                        NOT NULL UNIQUE,
    added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
) ENGINE = InnoDb;

INSERT INTO customers (id, firstname, lastname, email, added_date)
VALUES (1, 'Vimukthi', 'Jayawardane', 'vimukthi@slevote.com', '2025-01-29 00:01:01'),
       (2, 'Chanaka', 'Jayawardane', 'chanaka@slevote.com', '2025-01-29 00:01:01'),
       (3, 'Nikini', 'Jayawardane', 'nikini@slevote.com', '2025-01-29 00:01:01'),
       (4, 'Binara', 'Jayawardane', 'binara@slevote.com', '2025-01-29 00:01:01');
