# Transaction : 업무 단위, 세부 업무들은 모두 실패 or 성공 해야 함.
## rollback : 되돌리기
## commit : 반영하기

# a가 b에게 500원 송금 -> a의 돈에서 500원 -차감.
# UPDATE account_table
# SET money = money - 500
# WHERE user = 'a';

# b의 돈에서 500원 +더함
# UPDATE account_table
# SET money = money + 500
# WHERE user = 'b';

# 실습

USE mydatabase;
CREATE TABLE table53
(
    user  VARCHAR(20),
    money INT
);

INSERT INTO table53(user, money)
VALUES ('a', 10000),
       ('b', 10000);

UPDATE table53
SET money = money - 500
WHERE user = 'a';
UPDATE table53
SET money = money + 500
WHERE user = 'b';

# 현재 트랜잭션 되돌림(마지막 커밋 상태로 되돌림)
ROLLBACK;

# 현재 트랜잭션 적용(반영)
COMMIT;

SELECT *
FROM table53;

INSERT INTO table53 (user, money)
VALUES ('a', 1000),
       ('b', 1000);

# 내가 스스로 만들어보기 Controller180
CREATE TABLE bank_account
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    owner   VARCHAR(100),
    balance INT
);

# 만들어보기 bankController
CREATE TABLE transaction_history
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    from_id INT      NOT NULL,
    to_id   INT      NOT NULL,
    amount  INT      NOT NULL,
    time    DATETIME NOT NULL
);

ALTER TABLE transaction_history
    ADD FOREIGN KEY (from_id) REFERENCES bank_account (id),
    ADD FOREIGN KEY (to_id) REFERENCES bank_account (id);

