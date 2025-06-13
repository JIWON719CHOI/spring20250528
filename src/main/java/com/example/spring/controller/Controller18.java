package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main18")
public class Controller18 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table53
                """;
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", resultSet.getString("user"));
            map.put("money", resultSet.getInt("money"));
            list.add(map);
        }

        model.addAttribute("list", list);
        return "main18/sub1";
    }

    @PostMapping("sub2")
    public String success1(Model model) throws Exception {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.executeUpdate();
        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement1.executeUpdate();

        return "redirect:/main18/sub1";
    }

    @PostMapping("sub3")
    public String fail1(Model model) throws Exception {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.executeUpdate();

        if (true) throw new Exception("네트워크 연결 끊어짐");

        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement1.executeUpdate();

        return "redirect:/main18/sub1";
    }

    @PostMapping("sub4")
    public String success2(Model model) throws Exception {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.executeUpdate();

        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement1.executeUpdate();

        connection.commit();

        return "redirect:/main18/sub1";
    }

    @PostMapping("sub5")
    public String fail2(Model model) {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            try (connection) {
                connection.setAutoCommit(false);
                try {
                    PreparedStatement statement = connection.prepareStatement(sql1);
                    PreparedStatement statement1 = connection.prepareStatement(sql2);

                    try (statement1; statement) {
                        statement.executeUpdate();

                        if (true) {
                            throw new Exception("네트워크 오류!!");
                        }
                        statement1.executeUpdate();
                    }
                    connection.commit();
                } catch (Exception e) {
                    connection.rollback();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/main18/sub1";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        String sql = "SELECT * FROM table53";
        try (
                Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            List<Map<String, Object>> list = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("user", rs.getString("user"));
                row.put("money", rs.getInt("money"));
                list.add(row);
            }
            model.addAttribute("list", list);
        }
        return "main18/sub6";
    }

    @PostMapping("sub7")
    public String sub7() {
        String sql1 = "UPDATE table53 SET money = money - 500 WHERE user = 'b'";
        String sql2 = "UPDATE table53 SET money = money + 500 WHERE user = 'a'";

        double random = Math.random();

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            conn.setAutoCommit(false); // 트랜잭션 시작

            try (
                    PreparedStatement stmt1 = conn.prepareStatement(sql1);
                    PreparedStatement stmt2 = conn.prepareStatement(sql2)
            ) {
                stmt1.executeUpdate();

                if (random < 0.5) {
                    throw new Exception("강제 네트워크 오류 발생");
                }

                stmt2.executeUpdate();

                conn.commit(); // 모두 성공하면 커밋
            } catch (Exception e) {
                conn.rollback(); // 실패 시 롤백
                System.out.println("롤백 실행됨: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/main18/sub6"; // ✅ 반드시 슬래시 포함!
    }


}