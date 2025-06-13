USE mydatabase;

# 회원 테이블 먼저 생성
# ID, PW, NOTE
CREATE TABLE table44
(
    username VARCHAR(20) PRIMARY KEY,
    pw       VARCHAR(20),
    notes    VARCHAR(5000)
);

# 게시글 테이블에서 외래키 명시적으로 지정
# 제목, 본문, 작성일시, 회원ID
CREATE TABLE table43
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(255),
    content          VARCHAR(1000),
    create_at        DATETIME,
    table44_username VARCHAR(20),
    FOREIGN KEY (table44_username) REFERENCES table44 (username)
);

SHOW CREATE TABLE table43;
DESC table43;

# 1🆚N, N🆚1

# 1대 1 (잘 보이진 않음)
# 직원정보
CREATE TABLE table45
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(20),
    hire_date DATE,
    school    VARCHAR(20)
);

# 직원 연봉
CREATE TABLE table46
(
    id     INT PRIMARY KEY,
    salary INT,
    FOREIGN KEY (id) REFERENCES table45 (id)
);

# N🆚N
# 학생 테이블
CREATE TABLE table47
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    info VARCHAR(20)
);

# 수업 정보
CREATE TABLE table48
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(20),
    schedule VARCHAR(20),
    info     VARCHAR(20)
);

# 학생수업 (연결,조인,중간테이블)
CREATE TABLE table49
(
    table47_id INT,
    table48_id INT,
    PRIMARY KEY (table47_id, table48_id),
    FOREIGN KEY (table47_id) REFERENCES table47 (id),
    FOREIGN KEY (table48_id) REFERENCES table48 (id)
);

# 연습 : 리팩토링 & 확장된 예시

# 🎬 1. 영화 테이블 (movies)
CREATE TABLE movies
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    title        VARCHAR(100) NOT NULL,
    genre        VARCHAR(50),
    director     VARCHAR(50),
    release_year YEAR,
    info         TEXT
);

# 🎭 2. 배우 테이블 (actors)
CREATE TABLE actors
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    birth_year  YEAR,
    nationality VARCHAR(50),
    contract    DECIMAL(10, 2), -- 계약 금액
    info        TEXT
);

# 🎬👤 3. 영화-배우 연결 테이블 (movie_actor)
CREATE TABLE movie_actor
(
    movie_id INT,
    actor_id INT,
    role     VARCHAR(100), -- 맡은 역할
    PRIMARY KEY (movie_id, actor_id),
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (actor_id) REFERENCES actors (id)
);

# 📦 샘플 데이터 삽입 예시
-- 영화
INSERT INTO movies (title, genre, director, release_year, info)
VALUES ('Inception', 'Sci-Fi', 'Christopher Nolan', 2010, 'Dream within a dream'),
       ('Titanic', 'Romance', 'James Cameron', 1997, 'Ship goes down');

-- 배우
INSERT INTO actors (name, birth_year, nationality, contract, info)
VALUES ('Leonardo DiCaprio', 1974, 'USA', 20000000.00, 'Oscar-winning actor'),
       ('Joseph Gordon-Levitt', 1981, 'USA', 8000000.00, 'Inception main role'),
       ('Kate Winslet', 1975, 'UK', 15000000.00, 'Romantic lead');

-- 연결 (누가 어떤 영화에서 무슨 역할?)
INSERT INTO movie_actor (movie_id, actor_id, role)
VALUES (1, 1, 'Dom Cobb'),    -- Inception: Leonardo
       (1, 2, 'Arthur'),
       (2, 1, 'Jack Dawson'), -- Titanic: Leonardo again
       (2, 3, 'Rose DeWitt Bukater');

# 🔎 확인용 JOIN 쿼리
SELECT m.title AS 영화, a.name AS 배우, ma.role AS 역할
FROM movie_actor ma
         JOIN movies m ON ma.movie_id = m.id
         JOIN actors a ON ma.actor_id = a.id
ORDER BY m.title;





