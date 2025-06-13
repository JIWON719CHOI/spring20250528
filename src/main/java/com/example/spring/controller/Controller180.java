package com.example.spring.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Controller180 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    // 계좌 목록 + 폼 페이지
    @GetMapping("main180/sub1")
    public String showAccounts(Model model) {
        List<Account> accounts = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_account");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setOwner(rs.getString("owner"));
                account.setBalance(rs.getInt("balance"));
                accounts.add(account);
            }

        } catch (Exception e) {
            model.addAttribute("message", "DB 오류: " + e.getMessage());
        }

        model.addAttribute("accounts", accounts);
        return "main180/sub1";
    }

    // 계좌 생성
    @PostMapping("main180/create")
    public String createAccount(@RequestParam String owner,
                                @RequestParam int amount,
                                Model model) {
        String sql = "INSERT INTO bank_account (owner, balance) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, owner);
            stmt.setInt(2, amount);
            stmt.executeUpdate();
            model.addAttribute("message", "계좌 생성 성공!");
            model.addAttribute("messageType", "success");

        } catch (Exception e) {
            model.addAttribute("message", "생성 실패: " + e.getMessage());
            model.addAttribute("messageType", "error");
        }

        return "main180/sub2";
    }


    // 계좌 삭제
    @PostMapping("main180/delete")
    public String deleteAccount(@RequestParam int id, Model model) {
        String sql = "DELETE FROM bank_account WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int deleted = stmt.executeUpdate();

            if (deleted == 1) {
                model.addAttribute("message", "삭제 성공!");
            } else {
                model.addAttribute("message", "해당 ID 없음");
            }

        } catch (Exception e) {
            model.addAttribute("message", "삭제 실패: " + e.getMessage());
        }

        return "main180/sub2";
    }

    // 송금
    @PostMapping("main180/transfer")
    public String transfer(@RequestParam int from,
                           @RequestParam int to,
                           @RequestParam int amount,
                           Model model) {

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            conn.setAutoCommit(false);

            try {
                String withdraw = "UPDATE bank_account SET balance = balance - ? WHERE id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(withdraw)) {
                    stmt.setInt(1, amount);
                    stmt.setInt(2, from);
                    int updated = stmt.executeUpdate();
                    if (updated != 1) throw new SQLException("출금 실패");
                }

                String deposit = "UPDATE bank_account SET balance = balance + ? WHERE id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(deposit)) {
                    stmt.setInt(1, amount);
                    stmt.setInt(2, to);
                    int updated = stmt.executeUpdate();
                    if (updated != 1) throw new SQLException("입금 실패");
                }

                conn.commit();
                model.addAttribute("message", "송금 성공!");

            } catch (Exception e) {
                conn.rollback();
                model.addAttribute("message", "송금 실패: " + e.getMessage());
            }

        } catch (Exception e) {
            model.addAttribute("message", "DB 연결 실패: " + e.getMessage());
        }

        return "main180/sub2";
    }

    // 내부 클래스: Account
    @Data
    static class Account {
        private int id;
        private String owner;
        private int balance;
    }
}
