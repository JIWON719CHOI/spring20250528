# LIKE (~같은)
# % _ : wildcard

# % : 0개이상 아무거나
# _ : 1개 아무거나

# u로 시작하는 국가에 있는 고객들 조회
SELECT *
FROM Customers
WHERE Country LIKE 'u%';

# a로 시작하는 고객명 조회
SELECT *
FROM Customers
WHERE CustomerName LIKE 'a%';

# a로 시작하고 a로 끝나는 고객명
SELECT *
FROM Customers
WHERE CustomerName LIKE 'a%a';

# to가 있는 고객명
# 가장 많이 쓰이는 패턴
SELECT *
FROM Customers
WHERE CustomerName LIKE '%to%';

# 10번대 고객들
SELECT *
FROM Customers
WHERE CustomerID LIKE '1_';

# 1997년 12월에 주문한 주문들
SELECT *
FROM Orders
WHERE OrderDate LIKE '1997-12-__';

# 연습
# 직원설명에 college 가 포함된 직원들 조회
SELECT *
FROM Employees
WHERE Notes LIKE '%college%';
# C로 시작하는 상품명인 상품 조회
SELECT *
FROM Products
WHERE ProductName LIKE 'c%';