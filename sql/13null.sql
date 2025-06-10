# NULL 값이 없다

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# SUM, COUNT, MIN, MAX, AVG
# 집계 함수는 NULL 을 집계에 포함하지 않음.

SELECT COUNT(City)
FROM Customers;

# 2222.71
SELECT SUM(Price)
FROM Products;

# 28.866364
SELECT AVG(Price)
FROM Products;

INSERT INTO Products
    (ProductName)
    VALUE ('커피');

# NULL 인 컬럼 조회
SELECT *
FROM Customers
WHERE ContactName = 'SATORU'
ORDER BY CustomerID DESC;

SELECT *
FROM Customers
# WHERE City = NULL 이거 안되용!
WHERE City IS NULL
ORDER BY CustomerID DESC;

SELECT *
FROM Customers
WHERE City IS NOT NULL
ORDER BY CustomerID DESC;

# IFNULL : NULL 인 경우 다른 값으로 조회
SELECT ProductID,
       ProductName,
       SupplierID,
       IFNULL(CategoryID, '미정') CategoryID,
       IFNULL(Unit, '없다')       Unit,
       IFNULL(Price, 0)         Price
FROM Products
ORDER BY ProductID DESC;

# 연습
# 카테고리 테이블 조회, description이 null 이면 '정해지지 않음'으로 조회
SELECT CategoryID, CategoryName, IFNULL(Description, '정해지지 않음') Description
FROM Categories
ORDER BY CategoryID DESC;
# description 컬럼으로 COUNT()함수 결과 조회, NULL도 count에 포함되도록
SELECT COUNT(IFNULL(Description, '')) count
FROM Categories;


