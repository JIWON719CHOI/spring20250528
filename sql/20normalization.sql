USE mydatabase;

# NORMALIZATION : 정규화(형)

# FIRST NORMAL FORM (1NF): 제1정규화(형)
# SECOND NORMAL FORM (2NF): 2정규형
# THIRD NORMAL FORM (3NF): 3정규화

# 1NF
# 모든 레코드가 유일해야하고
# -> PRIMARY KEY(NOT NULL UNIQUE)컬럼이 적어도 하나 있어야함
# 모든 데이터는 atomic(원자적) 해야 한다

CREATE TABLE table25
(
    name  VARCHAR(10),
    phone VARCHAR(200)
);
INSERT INTO table25
(name, phone)
VALUES ('son', '01099998888');
INSERT INTO table25
(name, phone)
VALUES ('lee', '01099997777,01088886666');
SELECT *
FROM table25;
CREATE TABLE table26
(
    name   VARCHAR(10),
    phone1 VARCHAR(11),
    phone2 VARCHAR(11)
);
INSERT INTO table26
(name, phone1)
VALUES ('son', '01099998888');
INSERT INTO table26
(name, phone1, phone2)
VALUES ('kim', '01088887777', '01055553333');
SELECT *
FROM table26;

ALTER TABLE table26
    ADD COLUMN address VARCHAR(10) AFTER name;
UPDATE table26
SET address = 'seoul'
WHERE name = 'son';
UPDATE table26
SET address = 'busan'
WHERE name = 'kim';

CREATE TABLE table27
(
    name  VARCHAR(10),
    phone VARCHAR(11)
);
INSERT INTO table27
(name, phone)
VALUES ('son', '01099998888'),
       ('kim', '01088887777'),
       ('kim', '01055553333');
ALTER TABLE table26
    DROP COLUMN phone1;
ALTER TABLE table26
    DROP COLUMN phone2;
SELECT *
FROM table27;

CREATE TABLE table28
(
    name    VARCHAR(10),
    address VARCHAR(10),
    work    VARCHAR(10)
);
INSERT INTO table28
(name, address, work)
VALUES ('kim', 'seoul', 'intel');
INSERT INTO table28
(name, address, work)
VALUES ('lee', 'busan', 'intel');
INSERT INTO table28
(name, address, work)
VALUES ('choi', 'seoul', 'tesla');
INSERT INTO table28
(name, address, work)
VALUES ('kim', 'jeju', 'goole');
INSERT INTO table28
(name, address, work)
VALUES ('kim', 'jeju', 'goole');
ALTER TABLE table28
    ADD COLUMN id INT NOT NULL UNIQUE;
SELECT *
FROM table28;

CREATE TABLE table29
(
    id      INT NOT NULL UNIQUE,
    name    VARCHAR(20),
    address VARCHAR(20),
    work    VARCHAR(20)
);
DESC table29;