# ORDER BY : 조회 결과 순서 결정

# 고객번호 오름차순
SELECT *
FROM Customers
ORDER BY CustomerID;

# 고객 이름 오름차순
SELECT *
FROM Customers
ORDER BY CustomerName;

# 연습 : 상품 가격 오름차순 조회
SELECT *
FROM Products
ORDER BY Price;

SELECT CustomerName, City, Country
FROM Customers
ORDER BY Country, City;

# 연습: 카테고리별, 가격별 오름차순으로 상품 조회
SELECT CategoryID, Price, ProductName
FROM Products
ORDER BY CategoryID, Price;

# 기본 오름차순(ASCENDING, ASC)
SELECT CategoryID, Price, ProductName
FROM Products
ORDER BY CategoryID ASC, Price ASC;

# 내림차순 (DESCENDING, DESC)
SELECT *
FROM Products
ORDER BY Price DESC;

# 연습 : 생일 역순 직원 조회
SELECT *
FROM Employees
ORDER BY BirthDate DESC;
# 카테고리(오름차순), 가격(내림차순) 순서로 상품 조회
SELECT CategoryID, Price, ProductName
FROM Products
ORDER BY CategoryID, Price DESC;


#
SELECT Country, City, CustomerName
FROM Customers;

SELECT Country, City, CustomerName
FROM Customers
ORDER BY Country, City;

# 컬럼의 순서 사용
SELECT Country, City, CustomerName
FROM Customers
ORDER BY 1, 2;

SELECT ProductName, CategoryID, Price
FROM Products
ORDER BY Price DESC;

SELECT ProductName, CategoryID, Price
FROM Products
ORDER BY 3 DESC;