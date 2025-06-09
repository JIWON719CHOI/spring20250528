# GROUP BY : 특정 컬럼값 기준으로 결과를 나눔

SELECT CategoryID, SUM(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;

# 연습:
# 카테고리별 상품가격의 평균
SELECT CategoryID, AVG(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;
# 카테고리별 최고상품 가격
SELECT CategoryID, MAX(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;
# 카테고리별 최저상품 가격
SELECT CategoryID, MIN(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;
# 카테고리별 상품의 갯수
SELECT CategoryID, COUNT(*)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;
# 국가별 고객 수
SELECT Country, COUNT(*)
FROM Customers
GROUP BY Country
ORDER BY Country;

# 국가,도시별 고객 수
SELECT Country, City, COUNT(*)
FROM Customers
GROUP BY Country, City
ORDER BY Country, City;

SELECT SupplierID, CategoryID, COUNT(*)
FROM Products
GROUP BY SupplierID, CategoryID
ORDER BY SupplierID, CategoryID;

# 집계함수 사용 후 조건 설정
SELECT Country, COUNT(*)
FROM Customers
GROUP BY Country;

# 서브쿼리 사용 (나중에)
SELECT *
FROM (SELECT Country, COUNT(*) AS C
      FROM Customers
      GROUP BY Country) T
WHERE C >= 10;

# HAVING : 집계함수 사용 후 결과 FILTERING
SELECT Country, COUNT(*)
FROM Customers
GROUP BY Country
HAVING COUNT(*) >= 10;

# AS : 컬럼(또는 TABLE) 의 별칭
SELECT Country, COUNT(*) AS 고객수
FROM Customers
GROUP BY Country
HAVING 고객수 >= 10;

# 평균 상품 가격이 50 보다 큰 카테고리들 조회
SELECT CategoryID, AVG(Price) AS 평균값
FROM Products
GROUP BY CategoryID
HAVING 평균값 >= 50;

# 연습 :
# 고객수가 1명인 국가들 조회
SELECT Country, COUNT(*) AS 고객수
FROM Customers
GROUP BY Country
HAVING 고객수 = 1;
# 상품의 평균가격이 30미만인 카테고리들 조회
SELECT CategoryID, AVG(Price) AS 평균가격
FROM Products
GROUP BY CategoryID
HAVING 평균가격 < 30
ORDER BY CategoryID;
# 100건이상 처리한 직원 조회(Orders, EmployeeID)
SELECT EmployeeID, COUNT(*) AS 처리건
FROM Orders
GROUP BY EmployeeID
HAVING 처리건 >= 100
ORDER BY EmployeeID;