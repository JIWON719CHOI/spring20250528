USE jpa;

SELECT *
FROM w3schools.Customers;
DESC w3schools.Customers;

CREATE TABLE customer
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255),
    contact_name  VARCHAR(255),
    address       VARCHAR(255),
    city          VARCHAR(255),
    postal_code   VARCHAR(255),
    country       VARCHAR(255)
);

INSERT INTO customer
    (customer_name, contact_name, address, city, postal_code, country)
SELECT customername, contactname, address, city, postalcode, country
FROM w3schools.Customers;

SELECT * FROM jpa.customer;



