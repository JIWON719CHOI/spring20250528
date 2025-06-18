USE jpa;

SELECT *
FROM customer;

INSERT INTO customer
    (customer_name, contact_name, address, city, postal_code, country)
SELECT customer_name, contact_name, address, city, postal_code, country
FROM customer;

SELECT COUNT(*)
FROM customer;

CREATE TABLE my_table20
(
    name  VARCHAR(30),
    money INT,
    PRIMARY KEY (name)
);

INSERT INTO my_table20
    (name, money)
VALUES ('Gojo', 10000),
       ('Geto', 10000);

CREATE TABLE my_table21
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(20),
    address     VARCHAR(20),
    inserted_at DATETIME DEFAULT NOW() NOT NULL
);

INSERT INTO my_table21
    (name, address)
VALUES ('Gojo', 'Kyoto'),
       ('Geto', 'Tokyo');

INSERT INTO my_table21
    (name, address)
VALUES ('Ieiri', 'Tokyo');

SELECT *
FROM my_table21;

CREATE TABLE my_table22
(
    name    VARCHAR(20),
    address VARCHAR(20),
    country VARCHAR(20),
    PRIMARY KEY (name)
);

INSERT INTO my_table22
    (name, address, country)
VALUES ('Gojo', 'Tokyo', 'Japan');

CREATE TABLE my_table23
(
    name    VARCHAR(30),
    address VARCHAR(30),
    country VARCHAR(30),
    info    VARCHAR(30),
    PRIMARY KEY (name, address)
);

CREATE TABLE my_table24
(
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    age      INT          NULL,
    name     VARCHAR(255) NOT NULL,
    address  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_my_table24 PRIMARY KEY (name, address)
);



CREATE TABLE my_table26
(
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    author        VARCHAR(255) NULL,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    CONSTRAINT pk_my_table26 PRIMARY KEY (first_name, last_name)
);

# foreign key 외래키, 참조키 FK

CREATE TABLE my_table27
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(30),
    info          VARCHAR(300)
);

CREATE TABLE my_table28
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(30),
    price        INT,
    unit         VARCHAR(30),
    category_id  INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES my_table27 (id)
);

# 직원정보
CREATE TABLE my_table29
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(10),
    last_name  VARCHAR(10),
    birth_date DATE
);

# 다 대 1 @ManyToOne @JoinCol

# 주문정보
CREATE TABLE my_table30
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    order_date  DATE,
    info        VARCHAR(20),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES my_table29 (id)
);