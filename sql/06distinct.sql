# distinct

# 91개 rows
SELECT DISTINCT Country
FROM Customers
ORDER BY Country;

SELECT DISTINCT Country, City
FROM Customers
ORDER BY Country, City;

# Suppliers 가 있는 국가들 중복 제거 오름차순 조회
SELECT DISTINCT Suppliers.Country
FROM Suppliers
ORDER BY Country;

# 고객 있는 도시 중복 제거 오름차순
SELECT Distinct Customers.City
FROM Customers
ORDER BY 1;
