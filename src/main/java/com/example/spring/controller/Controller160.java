package com.example.spring.controller;

import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.*;

@Controller
@RequestMapping("main16")
public class Controller160 {

    private final String url = "jdbc:mysql://localhost:3306/w3schools";
    private final String username = "root";
    private final String password = "1234";

    @GetMapping("sub0")
    public String list(@RequestParam(required = false) Integer id, Model model) throws Exception {

        // 최대 ID 값 가져오기
        String maxSql = "SELECT MAX(SupplierID) FROM Suppliers";
        try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(maxSql)
        ) {
            if (rs.next()) {
                int maxId = rs.getInt(1);
                model.addAttribute("maxId", maxId);
            }
        }

        if (id != null) {
            String sql = "SELECT * FROM Suppliers WHERE SupplierID = ?";
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        SupplierDto dto = new SupplierDto();
                        dto.setId(rs.getInt("SupplierID"));
                        dto.setName(rs.getString("SupplierName"));
                        dto.setContact(rs.getString("ContactName"));
                        dto.setAddress(rs.getString("Address"));
                        dto.setCity(rs.getString("City"));
                        dto.setPostalCode(rs.getString("PostalCode"));
                        dto.setCountry(rs.getString("Country"));
                        dto.setPhone(rs.getString("Phone"));
                        model.addAttribute("supplier", dto);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message", "❌ 오류 발생: " + e.getMessage());
            }
        }
        return "/main16/sub0";
    }

    @PostMapping("sub0/add")
    public String add(SupplierDto supplier, RedirectAttributes rttr) {
        String sql = """
                INSERT INTO Suppliers
                (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, supplier.getName());
            pstmt.setString(2, supplier.getContact());
            pstmt.setString(3, supplier.getAddress());
            pstmt.setString(4, supplier.getCity());
            pstmt.setString(5, supplier.getPostalCode());
            pstmt.setString(6, supplier.getCountry());
            pstmt.setString(7, supplier.getPhone());

            int rows = pstmt.executeUpdate();

            if (rows == 1) {
                rttr.addFlashAttribute("message", "✅ 공급자 정보가 성공적으로 저장되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "⚠️ 저장 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("message", "❌ 오류 발생: " + e.getMessage());
        }
        return "redirect:/main16/sub0";
    }

    @PostMapping("sub0/update")
    public String update(SupplierDto supplier, RedirectAttributes rttr) {
        String sql = """
                UPDATE Suppliers
                SET SupplierName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?,
                    Phone = ?
                WHERE SupplierID = ?
                """;
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getContact());
            stmt.setString(3, supplier.getAddress());
            stmt.setString(4, supplier.getCity());
            stmt.setString(5, supplier.getPostalCode());
            stmt.setString(6, supplier.getCountry());
            stmt.setString(7, supplier.getPhone());
            stmt.setInt(8, supplier.getId());
            stmt.executeUpdate();

            rttr.addFlashAttribute("message", "✅ 공급자 정보가 수정되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("message", "❌ 오류 발생: " + e.getMessage());
        }
        return "redirect:/main16/sub0";
    }

    @PostMapping("sub0/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes rttr) {
        String sql = "DELETE FROM Suppliers WHERE SupplierID = ?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                rttr.addFlashAttribute("message", id + "번 공급자 삭제됨!");
            } else {
                rttr.addFlashAttribute("message", "⚠️ 삭제할 공급자가 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("message", "❌ 오류 발생: " + e.getMessage());
        }
        return "redirect:/main16/sub0";
    }
}
