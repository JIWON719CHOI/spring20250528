# aggregate function(group function) : 집계함수 (그룹함수)

# SUM(), COUNT(), MIN(), MAX(), AVG()

# SUM() : 합계

# 모든 상품의 가격의 합계
SELECT SUM(Price)
FROM Products;

# 1번 카테고리 상품의 가격의 합계
SELECT SUM(Price)
FROM Products
WHERE CategoryID = 1;

# 특정주문 ID에 대해 주문된 상품 수
SELECT SUM(Quantity)
FROM OrderDetails
WHERE OrderID = 10248;

# 특정 상품의 주문 갯수
SELECT SUM(Quantity)
FROM OrderDetails
WHERE ProductID = 11;

# 연습 : 3번 카테고리의 상품 가격의 합
SELECT SUM(Price)
FROM Products
WHERE CategoryID = 3;

# COUNT() : 특정 컬럼의 데이터가 몇 개인지
SELECT COUNT(CustomerID)
FROM Customers
WHERE Country = 'uk';

SELECT COUNT(Country)
FROM Customers
WHERE Country = 'uk';

# COUNT(*) : 조회 결과 수
SELECT COUNT(*)
FROM Customers
WHERE Country = 'uk';

# 연습 :
# 미국에 사는 고객 수 조회
SELECT COUNT(*)
FROM Customers
WHERE Country = 'usa';
# 1950년대에 태어난 직원 수
SELECT COUNT(*)
FROM Employees
WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';
# 2번 카테고리의 상품 수
SELECT COUNT(*)
FROM Products
WHERE CategoryID = 2;


# 91개
SELECT COUNT(Country)
FROM Customers;

# 21개
SELECT COUNT(DISTINCT Country)
FROM Customers;

# MIN() : 특정 컬럼에서 가장 작은 값
# MAX() : 가장 큰 값
SELECT MIN(Price)
FROM Products;
SELECT MAX(Price)
FROM Products;
SELECT MIN(BirthDate)
FROM Employees;
SELECT MAX(BirthDate)
FROM Employees;
SELECT MIN(CustomerName)
FROM Customers;
SELECT MAX(CustomerName)
FROM Customers;

#연습 :
# 1번 카테고리에서 가장 비싼 상품의 가격
SELECT MAX(Price)
FROM Products
WHERE CategoryID = 1;

SELECT *
FROM Products
WHERE CategoryID = 1
ORDER BY Price DESC
LIMIT 1;

SELECT *
FROM Products
WHERE Price = (SELECT MAX(Price)
               FROM Products
               WHERE CategoryID = 1)
  AND CategoryID = 1;


# 2번 카테고리에서 가장 저렴한 상품의 가격
SELECT MIN(Price)
FROM Products
WHERE CategoryID = 2;
SELECT *
FROM Products
WHERE CategoryID = 2
ORDER BY Price
LIMIT 1;
SELECT *
FROM Products
WHERE Price = (SELECT MIN(Price)
               FROM Products
               WHERE CategoryID = 2)
  AND CategoryID = 2;


# AVG() : 평균
SELECT AVG(Price)
FROM Products;
SELECT AVG(Price)
FROM Products
WHERE CategoryID = 1;
# 연습 : 2번카테고리 상품 가격의 평균
SELECT AVG(Price)
FROM Products
WHERE CategoryID = 2;