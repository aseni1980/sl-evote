CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    enabled  BOOLEAN      NOT NULL
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
    id         BIGINT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
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

 CREATE TABLE voters
 (
     username VARCHAR(50)  NOT NULL PRIMARY KEY,
     password VARCHAR(255) NOT NULL,
     enabled  BOOLEAN      NOT NULL
 ) ENGINE = InnoDb;

CREATE TABLE party
  (
      partyid BIGINT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
      name VARCHAR(150)  NOT NULL,
      address VARCHAR(255) NOT NULL,
      secretaryname  VARCHAR(150) NOT NULL,
      secretaryaddress  VARCHAR(250),
      telephone  VARCHAR(15) NOT NULL,
      logo_url  VARCHAR(250),
     -- constitution_url  VARCHAR(250) NOT NULL,
     -- members_list_url  VARCHAR(250) NOT NULL,
    --  bank_statement_url  VARCHAR(250) NOT NULL,
     -- party_policy_url  VARCHAR(250) NOT NULL,
      acknowledged INTEGER(2) NOT NULL DEFAULT 0
  ) ENGINE = InnoDb;

  CREATE TABLE member
  (
      memberid BIGINT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
      fullname VARCHAR(150)  NOT NULL,
      -- nic VARCHAR(15)  NOT NULL,
      imageurl VARCHAR(255),
      qualification VARCHAR(100),
      partyid BIGINT(50) NOT NULL
  ) ENGINE = InnoDb;