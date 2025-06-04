# WHERE : 행(레코드, 데이터, record, row)을 선택(filter)

# 9개 행
SELECT *
FROM Employees;

# 1개 행
SELECT *
FROM Employees
WHERE EmployeeID = 3;

# 3개 행
SELECT *
FROM Employees
WHERE EmployeeID < 4;

#4개의 행
SELECT *
FROM Employees
WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';

#5개 행
SELECT *
FROM Employees
WHERE Notes LIKE '%BA%';


# 연산자
# = : 같다
SELECT *
FROM Customers;

SELECT *
FROM Customers
WHERE Country = 'UK';

# 연습 : 미국인 고객들 조회
SELECT *
FROM Customers
WHERE Country = 'USA';

# 연습 : 특정 도시에 있는 고객들 조회
SELECT *
FROM Customers
WHERE City = 'London';

SELECT *
FROM Customers
WHERE City = 'london';

SELECT *
FROM Customers
WHERE City = 'LONDON';

# 비교연산자
# !=, <> : 같지 않다.
# >, >=, <, <=
SELECT *
FROM Customers
WHERE City != 'london';

SELECT *
FROM Customers
WHERE City <> 'london';

# 연습 : 미국에 있지 않는 고객들 조회
#        스웨덴에 있지 않는 고객들 조회
SELECT *
FROM Customers
WHERE Country <> 'USA'; # 78 rows
SELECT *
FROM Customers
WHERE Country != 'Sweden';
# 89 rows

# >, >=, <, <=
SELECT *
FROM Customers
WHERE CustomerID < 5; # 수형식은 따옴표 안써도됨 (보통안씀)
SELECT *
FROM Customers
WHERE CustomerID <= 5;
SELECT *
FROM Customers
WHERE CustomerID > 88;
SELECT *
FROM Customers
WHERE CustomerID >= 88;
SELECT *
FROM Customers
WHERE CustomerName >= 'T';
SELECT *
FROM Customers
WHERE CustomerName >= 't';
SELECT *
FROM Customers
WHERE CustomerName < 'D';
SELECT *
FROM Customers
WHERE CustomerName < 'd';

# 연습 :
# Products (상품) 테이블 조회
# Price(가격)이 50 미만인 상품들
SELECT *
FROM Products
WHERE Price < 50;
# 70 rows
# Price(가격)이 80 이상인 상품들
SELECT *
FROM Products
WHERE Price >= 80;
# 4 rows

# Orders (주문) 테이블 조회
# OrderDate(주문날짜) 가 1998년 1월 1일 이후(포함)인 데이터 조회
SELECT *
FROM Orders
WHERE OrderDate >= '1998-01-01';
# 270 rows
# OrderDate(주문날짜) 가 1996년 12월 31일 이전(포함)인 데이터 조회
SELECT *
FROM Orders
WHERE OrderDate <= '1996-12-31';
# 152 rows


# 논리연산자
# AND, OR, NOT

#NOT
SELECT *
FROM Customers
WHERE City = 'Berlin'; # 1row
SELECT *
FROM Customers
WHERE City != 'Berlin'; # 90row

SELECT *
FROM Customers
WHERE NOT (City = 'Berlin'); # 90row

SELECT *
FROM Customers
WHERE NOT City = 'Berlin';
# 90row

# 연습 : 미국에 살지 않는 고객들 조회 (NOT 사용)
SELECT *
FROM Customers
WHERE Country = 'USA'; # 13 rows
SELECT *
FROM Customers
WHERE NOT (Country = 'USA');
# 78 rows

# OR
SELECT *
FROM Customers
WHERE CustomerID = 1
   OR CustomerID = 2;

SELECT *
FROM Customers
WHERE Country = 'USA'
   OR Country = 'UK';

# 연습 : CategoryID가 1 또는 7인 상품들 조회
#       도시 Madrid 또는 Lisboa에 있는 고객들 조회
SELECT *
FROM Products
WHERE CategoryID = 1
   OR CategoryID = 7; # 17 rows

SELECT *
FROM Customers
WHERE City = 'Madrid'
   OR City = 'Lisboa'; # 5 rows

SELECT *
FROM Customers
WHERE City = 'Madrid'
   OR City = 'Lisboa'
   OR City = 'Barcelona';
# 6 rows

# AND
SELECT *
FROM Customers
WHERE CustomerID >= 10
  AND CustomerID < 20;

# 연습 : 1950-01-01 ~ 1959-12-31 사이에 태어난 직원들 조회
SELECT *
FROM Employees
WHERE BirthDate >= '1950-01-01'
  AND BirthDate <= '1959-12-31';
SELECT *
FROM Employees
WHERE BirthDate >= '1950-01-01'
  AND BirthDate < '1960-01-01';
#        50.00(포함) ~ 60.00(포함안함) 가격인 상품들 조회
SELECT *
FROM Products
WHERE Price >= 50.00
  AND Price < 60.00;
#        'B'로 시작하는 이름인 고객들 조회
SELECT *
FROM Customers
WHERE CustomerName >= 'B'
  AND CustomerName < 'C';
# 프랑스에 사는 'B'로 시작하는 이름인 고객들 조회
SELECT *
FROM Customers
WHERE CustomerName >= 'B'
  AND CustomerName < 'C'
  AND Country = 'France';