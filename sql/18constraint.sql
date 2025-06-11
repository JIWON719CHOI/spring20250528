# 제약사항(Constraint) : 컬럼에 입력 가능한 값을 제한

# NOT NULL : null 허용 안함
CREATE TABLE table14
(
    col1 INT,
    col2 INT NOT NULL
);
INSERT INTO table14(col1, col2)
VALUES (null, 1);

SELECT *
FROM table14;

CREATE TABLE table15
(
    name    VARCHAR(50)  NOT NULL,
    address VARCHAR(200) NOT NULL
);

INSERT INTO table15(name, address)
VALUES ('엄마', '집');

SELECT *
FROM table15;


# DEFAULT : 값 안주면 기본값
CREATE TABLE table16
(
    col1 VARCHAR(10),
    col2 VARCHAR(20) DEFAULT 'anonymous'
);

INSERT INTO table16 (col1, col2)
VALUES ('qwer', '');

INSERT INTO table16 (col1, col2)
VALUES (null, 'what');

INSERT INTO table16 (col1)
VALUES ('hey');

SELECT *
FROM table16;

CREATE TABLE table17
(
    col1 VARCHAR(10)          DEFAULT 'val1',
    col2 VARCHAR(10) NOT NULL DEFAULT 'val2'
);
INSERT INTO table17
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO table17
    (col1, col2)
VALUES (null, 'def');

INSERT INTO table17
    (col1, col2)
VALUES ('abc', null);

INSERT INTO table17
    (col2)
VALUES ('zxc');

INSERT INTO table17
    (col1)
VALUES ('iop');

SELECT *
FROM table17;

#연습
# (name varchar not null), (score int not null default 0) table18 만들기
CREATE TABLE table18
(
    name  VARCHAR(10) NOT NULL,
    score INT         NOT NULL DEFAULT 0
);

INSERT INTO table18(name)
VALUES ('HONG');

SELECT *
FROM table18;


# UNIQUE : 중복 허용 안함
CREATE TABLE table19
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) UNIQUE
);

INSERT INTO table19(col1, col2)
VALUES ('abc', 'abc');

INSERT INTO table19(col1, col2)
VALUES ('bbc', 'aac');

INSERT INTO table19(col1, col2)
VALUES ('bbc', 'aaa');

SELECT *
FROM table19;

CREATE TABLE table21
(
    name  VARCHAR(10) NOT NULL UNIQUE,
    score INT         NOT NULL DEFAULT 0
);
INSERT INTO table21(name)
VALUES ('wow');
SELECT *
FROM table21;

# 테이블의 구조 보기
DESCRIBE table21;
SHOW CREATE TABLE table19;

# 연습
DESCRIBE w3schools.Products;
SHOW CREATE TABLE w3schools.Products;


# Primary Key : 주키(PK), 키
# Foreign Key : 외래키(FK), 참조키


