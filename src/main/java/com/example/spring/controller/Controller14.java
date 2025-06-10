package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main14")
public class Controller14 {
    @GetMapping("sub1")
    public String sub1(String keyword, Model model) throws Exception {
        // 직원설명에 특정 keyword가 있는 직원들 조회
        String sql = """
                SELECT *
                FROM Employees
                WHERE Notes LIKE ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");

        List<EmployeeDto> list = new ArrayList<>();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(rs.getInt("EmployeeId"));
            employeeDto.setLastName(rs.getString("LastName"));
            employeeDto.setFirstName(rs.getString("FirstName"));
            employeeDto.setBirthDate(rs.getDate("BirthDate").toLocalDate());
            employeeDto.setPhoto(rs.getString("Photo"));
            employeeDto.setNotes(rs.getString("Notes"));
            list.add(employeeDto);
        }
        model.addAttribute("employeeList", list);


        return "main14/sub1";
    }

    // 연습 : request handler method, html
    // get /main14/sub2
    // 고객명 조회하는 코드 완성
    // sql :
    // SELECT * FROM Customers
    // WHERE CustomerName LIKE '%keyword%'
    //    OR ContactName LIKE '%keyword%'
    //

    @GetMapping("sub2")
    public String sub2(String keyword, Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers WHERE CustomerName LIKE ? OR ContactName LIKE ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");
        statement.setString(2, "%" + keyword + "%");
        List<CustomerDto> list = new ArrayList<>();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("CustomerId"));
            customerDto.setContactName(rs.getString("CustomerName"));
            customerDto.setContactName(rs.getString("ContactName"));
            customerDto.setAddress(rs.getString("Address"));
            customerDto.setPostalCode(rs.getString("PostalCode"));
            customerDto.setCity(rs.getString("City"));
            customerDto.setCountry(rs.getString("Country"));
            list.add(customerDto);
        }
        model.addAttribute("customerList", list);
        return "main14/sub2";
    }

    @GetMapping("sub4")
    public String sub4(@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int page, Model model) throws Exception {

        int pageSize = 10;
        int offset = (page - 1) * pageSize;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 전체 데이터 수 구하기 (검색 포함)
        String countSql = """
                    SELECT COUNT(*) FROM Customers 
                    WHERE CustomerName LIKE ? OR ContactName LIKE ?
                """;
        PreparedStatement countStmt = connection.prepareStatement(countSql);
        countStmt.setString(1, "%" + keyword + "%");
        countStmt.setString(2, "%" + keyword + "%");
        ResultSet countRs = countStmt.executeQuery();
        countRs.next();
        int total = countRs.getInt(1);
        int totalPages = (int) Math.ceil(total / (double) pageSize);

        // 실제 데이터 조회
        String dataSql = """
                    SELECT * FROM Customers
                    WHERE CustomerName LIKE ? OR ContactName LIKE ?
                    LIMIT ? OFFSET ?
                """;
        PreparedStatement dataStmt = connection.prepareStatement(dataSql);
        dataStmt.setString(1, "%" + keyword + "%");
        dataStmt.setString(2, "%" + keyword + "%");
        dataStmt.setInt(3, pageSize);
        dataStmt.setInt(4, offset);
        ResultSet rs = dataStmt.executeQuery();

        List<CustomerDto> list = new ArrayList<>();
        while (rs.next()) {
            CustomerDto dto = new CustomerDto();
            dto.setId(rs.getInt("CustomerId"));
            dto.setName(rs.getString("CustomerName"));
            dto.setContactName(rs.getString("ContactName"));
            dto.setAddress(rs.getString("Address"));
            dto.setPostalCode(rs.getString("PostalCode"));
            dto.setCity(rs.getString("City"));
            dto.setCountry(rs.getString("Country"));
            list.add(dto);
        }

        model.addAttribute("customerList", list);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "main14/sub4";
    }
}