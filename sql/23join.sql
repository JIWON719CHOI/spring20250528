USE mydatabase;

CREATE TABLE table34
(
    name VARCHAR(1)
);

CREATE TABLE table35
(
    score INT
);

INSERT INTO table34 (name)
VALUES ('a'),
       ('b'),
       ('c'),
       ('d'),
       ('c');

INSERT INTO table35 (score)
VALUES (5),
       (4),
       (3),
       (3),
       (5);

# 25 개의 레코드가 나오는 이유:
SELECT *
FROM table34,
     table35;

# 행 500, 열9
SELECT *
FROM w3schools.Products,
     w3schools.Categories;

SELECT *
FROM w3schools.Products
         JOIN w3schools.Categories;

# Cartesian Product (카테시안 곱)

CREATE TABLE table36
(
    `대회`  VARCHAR(20),
    `연도`  INT,
    `우승자` VARCHAR(30),
    PRIMARY KEY (`대회`, `연도`)
);

CREATE TABLE table37
(
    `우승자`  VARCHAR(30),
    `생년월일` VARCHAR(100),
    PRIMARY KEY (`우승자`)
);

INSERT INTO table36 (대회, 연도, 우승자)
VALUES ('D', '1998', 'Chip'),
       ('I', '1998', 'Al'),
       ('C', '1999', 'Bob'),
       ('D', '1999', 'Al'),
       ('I', '1999', 'Chip');

INSERT INTO table37 (우승자, 생년월일)
VALUES ('Chip', '1977-03-14'),
       ('Al', '1975-07-21'),
       ('Bob', '1968-09-28');

SELECT *
FROM table36;

SELECT *
FROM table37;

SELECT *
FROM table36,
     table37;

# 카테시안 곱
SELECT *
FROM table36
         JOIN table37;

SELECT *
FROM table36
         JOIN table37
WHERE table36.우승자 = table37.우승자;

SELECT *
FROM table36
         JOIN table37 ON table36.우승자 = table37.우승자;

# ALIAS : 별칭
SELECT `대회` AS congress, `연도` year, t6.`우승자`, `생년월일`
FROM table36 AS t6
         JOIN table37 t7 ON t6.우승자 = t7.우승자;

#
SELECT *
FROM w3schools.Products;
SELECT *
FROM w3schools.Categories;

SELECT C.CategoryName, P.ProductName
FROM w3schools.Products P
         JOIN w3schools.Categories C on P.CategoryID = C.CategoryID
ORDER BY C.CategoryName, P.ProductName;

# 공급자별 공급하는 상품 목록
SELECT S.SupplierName, P.ProductName
FROM w3schools.Suppliers S
         JOIN w3schools.Products P on S.SupplierID = P.SupplierID
ORDER BY S.SupplierName, P.ProductName;

# 주문별 처리 직원
SELECT O.OrderID, O.OrderDate, E.FirstName, E.LastName
FROM w3schools.Orders O
         JOIN w3schools.Employees E on O.EmployeeID = E.EmployeeID
WHERE E.EmployeeID = 3;

# 연습 : 1번 고객이 주문한 날짜들 조회
SELECT C.CustomerID, C.CustomerName, O.OrderDate
FROM w3schools.Customers C
         JOIN w3schools.Orders O on C.CustomerID = O.CustomerID
WHERE C.CustomerID = 1
ORDER BY O.OrderDate;

# 고객별 주문 건수
SELECT c.CustomerID, c.CustomerName, COUNT(*)
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY c.CustomerID
;
# 주문이 20건 이상인 고객들
SELECT c.CustomerID, c.CustomerName, COUNT(*)
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
HAVING COUNT(*) >= 20
ORDER BY c.CustomerID
;

# 연습
# 직원 별 주문 처리 건수
SELECT E.EmployeeID, E.FirstName, COUNT(*) COUNT
FROM w3schools.Orders O
         JOIN w3schools.Employees E
              on O.EmployeeID = E.EmployeeID
GROUP BY E.EmployeeID
ORDER BY COUNT DESC;


# 카테고리별 상품의 평균가격
SELECT C.CategoryID, C.CategoryName, AVG(Price)
FROM w3schools.Categories C
         JOIN w3schools.Products P on C.CategoryID = P.CategoryID
GROUP BY C.CategoryID
ORDER BY C.CategoryID;