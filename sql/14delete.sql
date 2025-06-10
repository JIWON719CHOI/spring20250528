SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# DELETE ; 특정 행(row, record)를 삭제

DELETE
FROM Customers
WHERE CustomerID = 95;

DELETE
FROM Customers
WHERE City IS NULL;

