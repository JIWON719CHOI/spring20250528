USE mydatabase;

CREATE TABLE table38
(
    id INT
);

INSERT INTO table38(id)
VALUES (9),
       (8),
       (7);

SELECT *
FROM table34;
SELECT *
FROM table35;
SELECT *
FROM table38;


SELECT *
FROM table34
         JOIN table35
         JOIN table38;

SELECT *
FROM w3schools.Products P
         JOIN w3schools.Categories C ON P.CategoryID = C.CategoryID
         JOIN w3schools.Suppliers S ON P.SupplierID = S.SupplierID;

# 카테고리 별 공급자 정보
SELECT DISTINCT S.SupplierName, C.CategoryName
FROM w3schools.Products P
         JOIN w3schools.Categories C on P.CategoryID = C.CategoryID
         JOIN w3schools.Suppliers S ON P.SupplierID = S.SupplierID
ORDER BY S.SupplierName;

SELECT DISTINCT H.ShipperName, C.CustomerName
FROM w3schools.Orders O
         JOIN w3schools.Customers C on O.CustomerID = C.CustomerID
         JOIN w3schools.Shippers H ON O.ShipperID = H.ShipperID
ORDER BY H.ShipperName, C.CustomerName;

# 연습 : 1996-07-05 에 주문된 상품명 목록
# 조합 : Orders, OrderDetails, Products
SELECT P.ProductName, O.OrderDate
FROM w3schools.Orders O
         JOIN w3schools.OrderDetails D ON O.OrderID = D.OrderID
         JOIN w3schools.Products P ON D.ProductID = P.ProductID
WHERE O.OrderDate = '1996-07-05'
ORDER BY O.OrderDate, P.ProductName;

# 연습 : Tofu 상품을 어떤 고객이 언제 주문했는지 조회
# 조합 : Orders, Products, Customers, OrderDetails
SELECT P.ProductName, D.Quantity, C.CustomerName, O.OrderDate
FROM w3schools.Orders O
         JOIN w3schools.OrderDetails D ON O.OrderID = D.OrderID
         JOIN w3schools.Products P on D.ProductID = P.ProductID
         JOIN w3schools.Customers C on O.CustomerID = C.CustomerID
WHERE P.ProductName = 'Tofu'
ORDER BY O.OrderDate, C.CustomerName;

# 우수고객 선정 조회 : 고객별 주문 금액
# 조합 : Orders, OrdersDetails, Products, Customers
SELECT C.CustomerName, SUM(D.Quantity * P.Price) M
FROM w3schools.Orders O
         JOIN w3schools.OrderDetails D
              ON O.OrderID = D.OrderID
         JOIN w3schools.Products P
              ON P.ProductID = D.ProductID
         JOIN w3schools.Customers C
              ON O.CustomerID = C.CustomerID
GROUP BY C.CustomerID
ORDER BY M DESC;

# 연습 : 우수직원 1997-09 에 가장 많은 주문을 처리한 직원 조회 (가격기준)
# 조합 :
SELECT E.FirstName, SUM(D.Quantity * P.Price) M
FROM w3schools.Orders O
         JOIN w3schools.OrderDetails D ON O.OrderID = D.OrderID
         JOIN w3schools.Products P ON P.ProductID = D.ProductID
         JOIN w3schools.Employees E ON O.EmployeeID = E.EmployeeID
WHERE O.OrderDate >= '1997-09-01' AND O.OrderDate < '1997-10-01'
GROUP BY E.EmployeeID
ORDER BY M DESC;


