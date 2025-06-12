USE mydatabase;

CREATE TABLE table39
(
    col1 INT
);
CREATE TABLE table40
(
    col_a INT
);
INSERT INTO table39(col1)
VALUES (1),
       (2),
       (3),
       (4),
       (5);
INSERT INTO table40(col_a)
VALUES (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9);

# Cartesian Product
SELECT *
FROM table39
         JOIN table40;

# Inner Join
SELECT *
FROM table39
         JOIN table40 ON table39.col1 = table40.col_a;

# Left Join
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = table40.col_a;

# Right (outer) Join
SELECT *
FROM table39
         RIGHT JOIN table40 on table39.col1 = table40.col_a;

#
ALTER TABLE table39
    ADD COLUMN name VARCHAR(10);

SELECT *
FROM table39;

ALTER TABLE table40
    ADD COLUMN toy VARCHAR(10);

SELECT *
FROM table40;

# 연습

# 장난감이 있는 사람들
# inner join
SELECT *
FROM table39
         JOIN table40 ON table39.col1 = table40.col_a;

# 장난감 있 + 장난감이 없는 사람들
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = table40.col_a
WHERE col_a IS NULL;

# 주인 있는 장난감과 주인이 없는 장난감
SELECT *
FROM table39
         RIGHT JOIN table40 on table39.col1 = table40.col_a;

# 주인 없는 장난감
SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = table40.col_a
WHERE col1 IS NULL;

# Inner Join
SELECT *
FROM w3schools.Customers C
         JOIN w3schools.Orders O ON C.CustomerID = O.CustomerID;

# Left Join
SELECT *
FROM w3schools.Customers C
         LEFT JOIN w3schools.Orders O ON C.CustomerID = O.CustomerID;

# 주문한 적 없는 고객들
SELECT *
FROM w3schools.Customers C
         LEFT JOIN w3schools.Orders O ON C.CustomerID = O.CustomerID
WHERE OrderID IS NULL;

# 연습 :
DELETE
FROM w3schools.Orders
WHERE EmployeeID IN (2, 3);

# 주문을 처리한 적 없는 직원들
SELECT *
FROM w3schools.Employees E
         LEFT JOIN w3schools.Orders O on E.EmployeeID = O.EmployeeID
WHERE OrderID IS NULL;

# union
SELECT col1
FROM table39
UNION
SELECT col_a
FROM table40;

# FULL OUTER JOIN
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = col_a

UNION

SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = col_a;

# 연습 : 한번도 주문된 적 없는 상품들 이름 조회
DELETE
FROM w3schools.OrderDetails
WHERE ProductID IN (10, 20, 30, 40);

SELECT P.ProductName , D.Quantity
FROM w3schools.Products P
         LEFT JOIN w3schools.OrderDetails D on P.ProductID = D.ProductID
WHERE OrderDetailID IS NULL;






