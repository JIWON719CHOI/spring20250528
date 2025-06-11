USE mydatabase;

# STRING
# VARCHAR(길이)
CREATE TABLE table4
(
    col1 VARCHAR(1),
    col2 VARCHAR(3),
    col3 VARCHAR(5)
);
INSERT INTO table4
    (col1, col2, col3)
VALUES ('a', 'abc', 'abcde');
INSERT INTO table4
    (col1, col2, col3)
VALUES ('ab', 'abc', 'abcde');
INSERT INTO table4
    (col1, col2, col3)
VALUES ('한', 'abc', 'abcde');
INSERT INTO table4
    (col1, col2, col3)
VALUES ('한글', 'abc', 'abcde');
SELECT *
FROM table4;

# 연습
# id (최대8글자), name(최대20글자) 컬럼이 있는 table5 만들기
# 두 개의 레코드 입력(성공)
# 실패하는 레코드 입력 시도
CREATE TABLE table5
(
    id   VARCHAR(8),
    name VARCHAR(20)
);
INSERT INTO table5
    (id, name)
VALUES ('asdfghjk', 'qwertyyuip');
INSERT INTO table5
    (id, name)
VALUES ('가나다라마바사아', 'qwertyyuip');
INSERT INTO table5
    (id, name)
VALUES ('가나다라마바♥️', 'qwertyyuip');
INSERT INTO table5
    (id, name)
VALUES ('가나다라마바사아자', 'qwertyyuip');
SELECT *
FROM table5;



# NUMBER
# INTEGER (소숫점없는)
# DECIMAL (소숫점있는)
CREATE TABLE table6
(
    col1 INT,
    col2 BIGINT # 2^63 - 1
);
INSERT INTO table6
    (col1, col2)
VALUES (2342432, 234234234);
INSERT INTO table6
    (col1, col2)
VALUES (2147483647, 2147483647);
INSERT INTO table6
    (col1, col2)
VALUES (2147483648, 2147483647);

# 연습
# score(정수), length(큰정수) 컬럼이 있는 table7 번 만들기
# 두 개의 레코드 입력(성공)
# 한 개의 레코드 입력 실패
CREATE TABLE table7
(
    score  INT,
    length BIGINT
);
INSERT INTO table7
    (score, length)
VALUES (234234, 234234);
INSERT INTO table7
    (score, length)
VALUES (2147483647, 234234);
INSERT INTO table7
    (score, length)
VALUES ('2147483647', 234234);
INSERT INTO table7
    (score, length)
VALUES (3.14, 234234);
INSERT INTO table7
    (score, length)
VALUES (2147483648, 234234);
SELECT *
FROM table7;

# DECIMAL(총길이, 소숫점이하길이)
CREATE TABLE table8
(
    col1 INT,
    col2 DECIMAL(5, 1),
    col3 DECIMAL(10, 3),
    col4 DEC(5, 1),
    col5 DEC(10, 3)
);
INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 1234.5, 1234567.123, null, null);
INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 1234.56, 1234567.1234, null, null);
INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 12345.5, 12345678.123, null, null);
INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 1234.5, 12345678.123, null, null);
SELECT *
FROM table8;

# 연습
# score (총길이 4, 소숫점이하2), money(총길이 10, 소숫점이하 3)table9
# 두 개 레코드 입력 성공
# 한 개 레코드 실패
CREATE TABLE table9
(
    score DEC(4, 2),
    money DEC(10, 3)
);
INSERT INTO table9
    (score, money)
VALUES (99.99, 29347.234);
INSERT INTO table9
    (score, money)
VALUES (88.88, 1122937.234);
INSERT INTO table9
    (score, money)
VALUES (100, 1122937.234);
SELECT *
FRom table9;


# DATE,TIME 날짜 시간
# DATE : 날짜
# TIME : 시간

CREATE TABLE table10
(
    col1 DATE,
    col2 TIME,
    col3 DATETIME
);

INSERT INTO table10
    (col1, col2, col3)
VALUES ('2025-06-11', '10:25:50', '2025-06-11 10:25:50');

SELECT *
FROM table10;

CREATE TABLE table11
(
    birth_date Date,
    work_time  Time,
    born       DATETIME
);
INSERT INTO table11(birth_date, work_time, born)
VALUES ('1989-12-07', '20:30:31', '2017-12-25 16:25:37');

SELECT *
FROM table11;

# STRING : VARCHAR(길이)
# NUMBER : INT, BIGINT, DEC(총길이, 소수점이하길이)
# 날짜시간 : DATE, TIME, DATETIME

CREATE TABLE table12
(
    col1 VARCHAR(10),
    col2 INT,
    col3 BIGINT,
    col4 DEC(10, 2),
    col5 DATE,
    col6 TIME,
    col7 DATETIME
);

SELECT *
FROM table13;


