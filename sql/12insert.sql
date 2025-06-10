SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# INSERT INTO 새 데이터(record, row) 입력
INSERT INTO Customers
(customerid, customername, contactname, address, city, postalcode, country)
    VALUE ('92', 'Gojo', 'Satoru', 'Tokyo', 'Shibuya', '89-12-07', 'Japan');

INSERT INTO Customers
(customerid, customername, contactname, address, city, postalcode, country)
    VALUE ('93', 'Geto', 'Suguru', 'Kyoto', 'Osaka', '89-12-07', 'Japan');

INSERT INTO Customers
(customerid, customername, contactname, address, city, postalcode, country)
    VALUE ('94', 'Itadori', 'Yuji', 'Chiba', 'Tokyo', '89-12-07', 'Japan');

INSERT INTO Customers
(customerid, customername, contactname, address, city, postalcode, country)
    VALUE ('95', 'Fushiguro', 'Megumi', 'Tokyo', 'Shinjuku', '89-12-07', 'Japan');

# null 값이 없다....
UPDATE Customers
SET City = NULL
WHERE CustomerID = 92;

# 빈 스트링
UPDATE Customers
SET City = ''
WHERE CustomerID = 93;

# DELETE 기존 데이터 삭제

# UPDATE 기존 데이터 수정
UPDATE Customers
SET PostalCode = 'J-123-456'
WHERE CustomerID IN (92, 93, 94, 95);
