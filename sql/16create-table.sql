# DATABASE : 테이블을 모아놓은 공간
# CREATE DATABASE : 데이터베이스 만들기
CREATE DATABASE mydatabase;

# database(schema) 사용하기
USE mydatabase;

# CREATE TABLE : 테이블 만들기

CREATE TABLE table1
(
    id int
);

# DROP TABLE : 테이블 삭제하기 ⚠️매우 주의!
DROP TABLE table1;

#
CREATE TABLE table2 #테이블명
(#둥근 괄호 안에서 [컬럼명] 나열.
    name    varchar(255),
    country varchar(255),
    phone   varchar(255)
);

INSERT INTO table2
    (name, country, phone)
VALUES ('Gojo', 'Japan', '1207');

SElECT *
FROM table2;

# 테이블명, 컬럼명 작성 규칙 (회사마다 다르긴 함)
# 소문자, _ (lower_snake_case)
CREATE TABLE my_table1
(
    name            VARCHAR(255),
    address         VARCHAR(255),
    last_name       VARCHAR(255),
    nick_name       VARCHAR(255),
    home_address    VARCHAR(255),
    my_work_address VARCHAR(255)
);

# 연습 : table3 만들기 id, name, address, team... 4개 컬럼 존재
# 2개의 레코드 입력(insert) 하기

CREATE TABLE table3
(
    id      VARCHAR(255),
    name    VARCHAR(255),
    address VARCHAR(255),
    team    VARCHAR(255)
);

INSERT INTO table3
    (name, address, team)
VALUES ('Satoru', 'Tokyo', 'Jujutsu');

INSERT INTO table3
    (id)
    VALUE ('1');

SELECT *
FROM table3;

# DROP TABLE : 테이블 삭제하기
DROP TABLE my_table1;
DROP TABLE table3;

