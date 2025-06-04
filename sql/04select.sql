# SELECT : 조회할 열(columns) 지정
# FROM : 테이블명 지정
# WHERE : 행(records)를 필터링

# * : 모든 컬럼
SELECT *
FROM Customers;

# 지정된 열 (작성한 순서대로 열이 나열됨)
SELECT Customers.CustomerName, Country, city
FROM Customers;

# 멕시코와 미국 고객
SELECT CustomerName, Country, City, Address
FROM Customers
WHERE Country IN('USA', 'Mexico');

# 60년대 직원 이름
SELECT Employees.BirthDate, Employees.LastName, Employees.FirstName
From Employees
WHERE BirthDate BETWEEN '1960-01-01' AND '1969-12-31';

# 가격 10~19.99 사이
SELECT Products.Price, Products.ProductName, Products.CategoryID
FROM Products
WHERE Price BETWEEN 10.00 AND 19.99;