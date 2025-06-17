USE jpa;

# db의 table 명과 컬럼 명은 lower_snake_case
CREATE TABLE my_table1
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30),
    city    VARCHAR(30),
    address VARCHAR(30)
);

INSERT INTO my_table1(name, city, address)
VALUES ('kim', 'seoul', '강남'),
       ('lee', 'busan', '신촌'),
       ('park', 'jeju', '명동'),
       ('choi', 'suwon', '마포'),
       ('son', 'dokdo', '홍대');

CREATE TABLE my_table2
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30),
    address VARCHAR(30),
    city    VARCHAR(30)
);

INSERT INTO my_table2 (name, address, city)
SELECT name, address, city
FROM my_table1;

SELECT *
FROM my_table2;

CREATE TABLE my_table3
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(30),
    info  VARCHAR(30),
    nick  VARCHAR(30)
);

INSERT INTO my_table3 (email, info, nick)
VALUES ('gmail', 'Jujutsu', 'Gojo');

SELECT *
FROM my_table3;

ALTER TABLE my_table3
    ADD COLUMN country VARCHAR(30);

ALTER TABLE my_table3
    ADD COLUMN home_address VARCHAR(30);

ALTER TABLE my_table3
    ADD COLUMN work_address VARCHAR(30);

CREATE TABLE my_table4
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(30),
    score      DEC(10, 2),
    birth_date DATE,
    start_at   TIME,
    created_at DATETIME
);

INSERT INTO my_table4 (name, score, birth_date, start_at, created_at)
VALUES ('Gojo', 99.99, '1989-12-07', '12:12:12', '2017-12-24 18:25:00');

SELECT *
FROM my_table4;

CREATE TABLE my_table5
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    address     VARCHAR(30),
    hired_date  DATE,
    inserted_at DATETIME,
    height      DEC(10, 2),
    score       INT
);

INSERT INTO my_table5
    (address, hired_date, inserted_at, height, score)
VALUES ('Tokyo', '2008-03-02', '2018-06-01 13:12:20', 193.6, 100);

SELECT *
FROM my_table5;

CREATE TABLE my_table6
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    city        VARCHAR(30),
    score       INT,
    weight      DEC(10, 2),
    birth_date  DATE,
    start_at    TIME,
    inserted_at DATETIME
);

INSERT INTO my_table6
    (city, score, weight, birth_date, start_at, inserted_at)
VALUES ('Tokyo', 100, 83.52, '1989-12-07', '20:15:11', '2017-12-24 22:10:31');

CREATE TABLE my_table8
(
    id          INT AUTO_INCREMENT NOT NULL,
    address     VARCHAR(255)       NULL,
    salary      DOUBLE             NULL,
    inserted_at datetime           NULL,
    hire_date   date               NULL,
    CONSTRAINT pk_my_table8 PRIMARY KEY (id)
);

INSERT INTO my_table8
    (address, salary, inserted_at, hire_date)
VALUES ('Tokyo', 999.99, '2025-06-16 14:35:00', '2007-08-08');

SELECT *
FROM my_table8;

CREATE TABLE my_table10
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(30),
    city       VARCHAR(30),
    birth_date DATE
);

SELECT *
FROM my_table10
WHERE id = 1;

INSERT INTO my_table10
    (name, city, birth_date)
VALUES ('Gojo', 'Kyoto', '1989-12-07');

CREATE TABLE my_tale13
(
    id        INT AUTO_INCREMENT NOT NULL,
    address   VARCHAR(255)       NULL,
    price     INT                NULL,
    insert_at datetime           NULL,
    CONSTRAINT pk_my_tale13 PRIMARY KEY (id)
);

CREATE TABLE my_table14
(
    id    INT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)       NULL,
    score DOUBLE             NULL,
    city  VARCHAR(255)       NULL,
    CONSTRAINT pk_my_table14 PRIMARY KEY (id)
);

INSERT INTO my_table14
    (name, score, city)
VALUES ('Gojo', 99.99, 'Kyoto'),
       ('Geto', 88.88, 'Tokyo'),
       ('Ieiri', 77.77, 'Tokyo');

DESC w3schools.Employees;

CREATE TABLE employee
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    last_name  VARCHAR(255),
    first_name VARCHAR(255),
    birth_date DATE,
    photo      VARCHAR(255),
    notes      VARCHAR(5000)
);


INSERT INTO jpa.employee
    (last_name, first_name, birth_date, photo, notes)
SELECT LastName, FirstName, BirthDate, Photo, Notes
FROM w3schools.Employees;

DESC w3schools.Suppliers;

CREATE TABLE supplier
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(255),
    contact_name  VARCHAR(255),
    address       VARCHAR(255),
    city          VARCHAR(255),
    postal_code   VARCHAR(255),
    country       VARCHAR(255),
    phone         VARCHAR(255)
);

INSERT INTO jpa.supplier
(supplier_name, contact_name, address, city, postal_code, country, phone)
SELECT suppliername, contactname, address, city, postalcode, country, phone
FROM w3schools.Suppliers;

DESC w3schools.Products;

CREATE TABLE product
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255),
    supplier_id  INT,
    category_id  INT,
    unit         VARCHAR(255),
    price        DEC(10, 2)
);

INSERT INTO jpa.product
    (product_name, supplier_id, category_id, unit, price)
SELECT productname, supplierid, categoryid, unit, price
FROM w3schools.Products;


