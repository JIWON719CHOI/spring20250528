// Controller: BankController.java
package com.example.spring.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BankController {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    @GetMapping("/accounts")
    public String listAccounts(Model model) {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM bank_account";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setOwner(rs.getString("owner"));
                account.setBalance(rs.getInt("balance"));
                accounts.add(account);
            }
        } catch (Exception e) {
            model.addAttribute("error", "DB 오류: " + e.getMessage());
        }

        model.addAttribute("accounts", accounts);
        return "bank/list";
    }

    @PostMapping("/accounts/create")
    public String createAccount(@RequestParam String owner,
                                @RequestParam int amount,
                                Model model) {
        String sql = "INSERT INTO bank_account (owner, balance) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, owner);
            stmt.setInt(2, amount);
            stmt.executeUpdate();
            model.addAttribute("message", "계좌 생성 성공");
            model.addAttribute("messageType", "success");
        } catch (Exception e) {
            model.addAttribute("message", "생성 실패: " + e.getMessage());
            model.addAttribute("messageType", "error");
        }

        return "bank/result";
    }

    @PostMapping("/accounts/delete")
    public String deleteAccount(@RequestParam int id, Model model) {
        String sql = "DELETE FROM bank_account WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int result = stmt.executeUpdate();
            model.addAttribute("message", result == 1 ? "삭제 성공" : "해당 계좌 없음");
            model.addAttribute("messageType", result == 1 ? "success" : "error");
        } catch (Exception e) {
            model.addAttribute("message", "삭제 실패: " + e.getMessage());
            model.addAttribute("messageType", "error");
        }

        return "bank/result";
    }

    @PostMapping("/accounts/transfer")
    public String transfer(@RequestParam int from,
                           @RequestParam int to,
                           @RequestParam int amount,
                           Model model) {

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            conn.setAutoCommit(false);

            try {
                // 잔액 확인
                String checkSql = "SELECT balance FROM bank_account WHERE id = ?";
                try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                    checkStmt.setInt(1, from);
                    try (ResultSet rs = checkStmt.executeQuery()) {
                        if (rs.next()) {
                            int balance = rs.getInt("balance");
                            if (balance < amount) {
                                throw new SQLException("잔액 부족");
                            }
                        } else {
                            throw new SQLException("보내는 계좌 없음");
                        }
                    }
                }

                // 출금
                String withdraw = "UPDATE bank_account SET balance = balance - ? WHERE id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(withdraw)) {
                    stmt.setInt(1, amount);
                    stmt.setInt(2, from);
                    stmt.executeUpdate();
                }

                // 입금
                String deposit = "UPDATE bank_account SET balance = balance + ? WHERE id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(deposit)) {
                    stmt.setInt(1, amount);
                    stmt.setInt(2, to);
                    stmt.executeUpdate();
                }

                // 거래 기록 저장
                String historySql = "INSERT INTO transaction_history (from_id, to_id, amount, time) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(historySql)) {
                    stmt.setInt(1, from);
                    stmt.setInt(2, to);
                    stmt.setInt(3, amount);
                    stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
                    stmt.executeUpdate();
                }

                conn.commit();
                model.addAttribute("message", "송금 성공");
                model.addAttribute("messageType", "success");

            } catch (Exception e) {
                conn.rollback();
                model.addAttribute("message", "송금 실패: " + e.getMessage());
                model.addAttribute("messageType", "error");
            }
        } catch (Exception e) {
            model.addAttribute("message", "DB 오류: " + e.getMessage());
            model.addAttribute("messageType", "error");
        }

        return "bank/result";
    }

    @GetMapping("/accounts/history")
    public String showHistory(Model model) {
        List<History> historyList = new ArrayList<>();
        String sql = "SELECT * FROM transaction_history ORDER BY time DESC";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                History h = new History();
                h.setId(rs.getInt("id"));
                h.setFromId(rs.getInt("from_id"));
                h.setToId(rs.getInt("to_id"));
                h.setAmount(rs.getInt("amount"));
                h.setTime(rs.getTimestamp("time").toLocalDateTime());
                historyList.add(h);
            }
        } catch (Exception e) {
            model.addAttribute("message", "조회 실패: " + e.getMessage());
        }

        model.addAttribute("historyList", historyList);
        return "bank/history";
    }

    @Data
    static class Account {
        private int id;
        private String owner;
        private int balance;
    }

    @Data
    static class History {
        private int id;
        private int fromId;
        private int toId;
        private int amount;
        private LocalDateTime time;
    }
}
