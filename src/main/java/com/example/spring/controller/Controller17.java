package com.example.spring.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main17")
public class Controller17 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    @GetMapping("sub1")
    public String sub1() throws Exception {
        String sql = """
                INSERT INTO table12
                (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?,?,?,?,?,?,?)
                """;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "한글");
            statement.setString(2, "234234");
            statement.setString(3, "9198726");
            statement.setString(4, "987714.12");
            statement.setString(5, "1998-10-10");
            statement.setString(6, "16:10:54");
            statement.setString(7, "2025-06-11 06:48:23");

            statement.executeUpdate();
        }
        return "redirect:/main17/sub1"; // 리다이렉트 혹은 적절한 뷰 반환 권장
    }

    @GetMapping("sub2")
    public String sub2() throws Exception {
        String sql = """
                INSERT INTO table12
                (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?,?,?,?,?,?,?)
                """;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "한글");
            statement.setInt(2, 14578);
            statement.setLong(3, 455445675);
            statement.setDouble(4, 987714.12);
            statement.setDate(5, Date.valueOf("1987-12-04"));
            statement.setTime(6, Time.valueOf("11:12:23"));
            statement.setTimestamp(7, Timestamp.valueOf("2025-06-11 06:48:23"));

            statement.executeUpdate();
        }
        return "redirect:/main17/sub2";
    }

    @GetMapping("sub3")
    public String sub3() throws Exception {
        String sql = "SELECT * FROM table12 LIMIT 1";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("col1")); // VARCHAR
                System.out.println(resultSet.getInt("col2")); // INT
                System.out.println(resultSet.getLong("col3")); // BIGINT
                System.out.println(resultSet.getDouble("col4")); // DEC
                System.out.println(resultSet.getDate("col5")); // DATE
                System.out.println(resultSet.getTime("col6")); // TIME
                System.out.println(resultSet.getTimestamp("col7")); // DATETIME
                System.out.println();
            }
        }
        return "redirect:/main17/sub3";
    }

    @Data
    static class Dto5 {
        private String col1; // VARCHAR
        private Integer col2; // INT
        private Long col3; // BIGINT
        private Double col4; // DEC
        private LocalDate col5; // DATE
        private LocalTime col6; // TIME
        private LocalDateTime col7; // DATETIME
    }

    @GetMapping("sub5")
    public String sub5(Model model) throws Exception {
        String sql = "SELECT * FROM table12 LIMIT 1";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                Dto5 dto5 = new Dto5();
                dto5.setCol1(resultSet.getString("col1"));
                dto5.setCol2(resultSet.getInt("col2"));
                dto5.setCol3(resultSet.getLong("col3"));
                dto5.setCol4(resultSet.getDouble("col4"));
                dto5.setCol5(resultSet.getDate("col5").toLocalDate());
                dto5.setCol6(resultSet.getTime("col6").toLocalTime());
                dto5.setCol7(resultSet.getTimestamp("col7").toLocalDateTime());

                model.addAttribute("data", dto5);
            }
        }

        return "main17/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        return "main17/sub6";
    }

    @PostMapping("sub6")
    public String process6(Dto5 dto5) throws Exception {
//        System.out.println("dto5 = " + dto5);
        String sql = """
                INSERT INTO table12
                (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto5.getCol1());
        statement.setInt(2, dto5.getCol2());
        statement.setLong(3, dto5.getCol3());
        statement.setDouble(4, dto5.getCol4());
        statement.setDate(5, Date.valueOf(dto5.getCol5()));
        statement.setTime(6, Time.valueOf(dto5.getCol6()));
        statement.setTimestamp(7, Timestamp.valueOf(dto5.getCol7()));

        statement.executeUpdate();

        return "redirect:/main17/sub6";
    }

    // 연습
    // name(텍스트), birth_date(날짜), score(소숫점2까지), born_at(날짜시간) table13 만들기
    // html * 1
    // request handler method * 2 (get, post)
    // get /main17/sub7
    // post /main17/sub7

    @Data
    static class Dto7 {
        private String name;
        private LocalDate birthDate;
        private Double score;
        private LocalDateTime bornAt;
    }

    @GetMapping("sub7")
    public String sub7(Model model) throws Exception {

        List<Dto7> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT name, birth_date, score, born_at FROM table13";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Dto7 dto = new Dto7();
                        dto.setName(rs.getString("name"));
                        dto.setBirthDate(rs.getDate("birth_date").toLocalDate());
                        dto.setScore(rs.getDouble("score"));
                        dto.setBornAt(rs.getTimestamp("born_at").toLocalDateTime());
                        list.add(dto);
                    }
                }
            }
        }

        model.addAttribute("list", list);
        return "main17/sub7";
    }


    @PostMapping("sub7")
    public String process7(Dto7 dto7) throws Exception {
        String cSql = """
                CREATE TABLE IF NOT EXISTS table13 (
                  name VARCHAR(50),
                  birth_date DATE,
                  score DECIMAL(10, 2),
                  born_at DATETIME
                )
                """;

        String insertSql = """
                INSERT INTO table13 (name, birth_date, score, born_at)
                VALUES (?, ?, ?, ?)
                """;


        // 위에서 설정한 정보로 DB에 연결
        // try-with-resources 문법을 사용하여 자동으로 연결 종료됨 (close() 호출 필요 없음)
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            // 위에서 정의한 테이블 생성 SQL(cSql)을 실행
            // 테이블이 없으면 생성됨, 있으면 아무 일도 안 일어남
            // executeUpdate()는 테이블을 만들거나 수정할 때 사용됨
            try (PreparedStatement createStmt = connection.prepareStatement(cSql)) {
                createStmt.executeUpdate();
            }

            // insert용 SQL을 실행할 준비
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
                insertStmt.setString(1, dto7.getName());
                insertStmt.setDate(2, Date.valueOf(dto7.getBirthDate()));
                insertStmt.setDouble(3, dto7.getScore());
                insertStmt.setTimestamp(4, Timestamp.valueOf(dto7.getBornAt()));
                insertStmt.executeUpdate();
            }
        }

        return "redirect:/main17/sub7";
    }
}
