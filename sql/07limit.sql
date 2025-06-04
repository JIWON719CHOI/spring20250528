# limit : 조회 레코드(행) 수 제한
SELECT *
FROM Customers
LIMIT 5;

# 가격이 높은 상품 5개 조회
SELECT *
FROM Products
ORDER BY Price DESC
LIMIT 5;

# 나이 많은 직원 2명
SELECT *
FROM Employees
ORDER BY BirthDate
LIMIT 2;

# 연습 : 2번 카테고리에서 가장 저렴한 상품 3개 조회
SELECT *
FROM Products
WHERE CategoryID = 2
ORDER BY Price
LIMIT 3;
# 미국에 사는 고객 중 고객번호가 가장 높은 1명 조회
SELECT CustomerName
FROM Customers
WHERE Country = 'usa'
ORDER BY CustomerID DESC
LIMIT 1;

# LIMIT size : 몇개 행
# LIMIT offset, size : offset 부터 size개 rows (offset은 0부터 시작)

SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 10;

SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 0, 10;

SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 10, 10;

SELECT *
FROM Customers
ORDER BY CustomerID
LIMIT 20, 10;

# 91~82
SELECT *
FROM Customers
ORDER BY CustomerID DESC
LIMIT 0, 10;

# 81~72
SELECT *
FROM Customers
ORDER BY CustomerID DESC
LIMIT 10, 10;

# 71~62
SELECT *
FROM Customers
ORDER BY CustomerID DESC
LIMIT 20, 10;

#연습 : 가격이 두번째로 높은 상품명 조회
SELECT Products.ProductName, Products.Price
FROM Products
ORDER BY Price DESC
LIMIT 1,1; # LIMIT 1, 1 → 1번 인덱스(두 번째 행)부터 1개 추출

# 세번째로 나이가 많은 직원명 조회
SELECT Employees.FirstName, Employees.BirthDate
FROM Employees
ORDER BY BirthDate
LIMIT 2, 1;

# 1번 카테고리에서 두번째로 저렴한 상품명 조회
SELECT ProductName, Price
FROM Products
WHERE CategoryID = 1
ORDER BY Price
LIMIT 1, 1;

