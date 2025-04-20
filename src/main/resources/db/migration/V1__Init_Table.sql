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

CREATE TABLE party
  (
      partyid BIGINT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
      name VARCHAR(150)  NOT NULL,
      address VARCHAR(255) NOT NULL,
      secretaryname  VARCHAR(150) NOT NULL,
      secretaryaddress  VARCHAR(250),
      telephone  VARCHAR(15) NOT NULL,
      logo_url  VARCHAR(250),
      acknowledged INTEGER(2) NOT NULL DEFAULT 0
  ) ENGINE = InnoDb;

  insert into party
          (acknowledged,name, address,secretaryname, logo_url, telephone) values
          (1,'United National Party', 'No 02, Colombo02, Western Province', 'Ranil Wick','../../dist/img/elephant.jpeg', '01123456783'),
          (1,'Samagi Jana Balawegaya', 'No 02, Colombo02, Western Province', 'Dilan Perera','../../dist/img/chair.png', '01123456783'),
          (1,'New Democratic Front', 'No 02, Colombo02, Western Province', 'Suren Fernando','../../dist/img/kite.jpeg', '01123456783'),
          (1,'National People Party', 'No 05, Colombo07, Western Province', 'Anura De Silva','../../dist/img/umbrella.jpg', '01123323283');


  CREATE TABLE member
  (
      memberid BIGINT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
      fullname VARCHAR(150)  NOT NULL,
      imageurl VARCHAR(255),
      qualification VARCHAR(100),
      partyid BIGINT(50) NOT NULL
  ) ENGINE = InnoDb;

  CREATE TABLE voter
      (
          voterid BIGINT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
          name VARCHAR(150)  NOT NULL,
          nic VARCHAR(15)  NOT NULL,
          address VARCHAR(255) NOT NULL,
          district  VARCHAR(100) NOT NULL,
          province  VARCHAR(100) NOT NULL,
          postalcode  VARCHAR(6) NOT NULL,
          status  VARCHAR(10) NOT NULL,
          officeid  VARCHAR(15) NOT NULL
      ) ENGINE = InnoDb;

  CREATE TABLE voting
        (
            votingid BIGINT(50) NOT NULL PRIMARY KEY AUTO_INCREMENT,
            voterid BIGINT(150)  NOT NULL,
            memberid BIGINT(15)  NOT NULL
        ) ENGINE = InnoDb;