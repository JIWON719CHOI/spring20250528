package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.ProductDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {

    // paging

    @GetMapping("sub1")
    public String sub1(@RequestParam(defaultValue = "1") Integer page, Model model) throws SQLException {
        // 한 페이지에 10개씩
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        // 총 고객 수
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        // offset : (page - 1) * 10
//        statement.setInt(1, 0); // 1page
//        statement.setInt(1, 10); // 2page
//        statement.setInt(1, 20); // 3page
        int offset = (page - 1) * 10;
        statement.setInt(1, offset);
        statement.setInt(2, 10);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count"); // 총 고객수
        int lastPage = (count - 1) / 10 + 1; // 마지막 페이지 번호

        model.addAttribute("lastPage", lastPage);


        ResultSet rs = statement.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("CustomerID"));
            customerDto.setPostalCode(rs.getString("PostalCode"));
            customerDto.setCity(rs.getString("City"));
            customerDto.setCountry(rs.getString("Country"));
            customerDto.setContactName(rs.getString("ContactName"));
            customerDto.setName(rs.getString("CustomerName"));
            customerDto.setAddress(rs.getString("Address"));
            list.add(customerDto);
        }
        model.addAttribute("customerList", list);


        return "main15/sub1";
    }

    // 연습:
    // 한 페이지에 5개의 공급자가 출력되도록 코드 작성 (정렬은 공급자 번호 순)
    // request handler method, html
    @GetMapping("sub2")
    public String sub2(@RequestParam(defaultValue = "1") Integer page, Model model) throws Exception {
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Suppliers
                """;
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierID
                LIMIT ?, ?
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count");// 총 레코드 수
        int lastPage = (count - 1) / 5 + 1; // 마지막 페이지 번호

        model.addAttribute("lastPage", lastPage);

        PreparedStatement statement = connection.prepareStatement(sql);

        int offset = (page - 1) * 5;
        statement.setInt(1, offset);
        statement.setInt(2, 5);

        ResultSet resultSet = statement.executeQuery();
        List<SupplierDto> list = new ArrayList<>();
        while (resultSet.next()) {
            SupplierDto supplierDto = new SupplierDto();
            supplierDto.setId(resultSet.getInt("SupplierID"));
            supplierDto.setName(resultSet.getString("SupplierName"));
            supplierDto.setContact(resultSet.getString("ContactName"));
            supplierDto.setAddress(resultSet.getString("Address"));
            supplierDto.setCity(resultSet.getString("City"));
            supplierDto.setPostalCode(resultSet.getString("PostalCode"));
            supplierDto.setCountry(resultSet.getString("Country"));
            supplierDto.setPhone(resultSet.getString("Phone"));
            list.add(supplierDto);
        }
        model.addAttribute("supplierList", list);

        return "main15/sub2";
    }

    // 검색 + 페이징
    @GetMapping("sub3")
    public String sub3(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "") String keyword, Model model) throws Exception {

        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                WHERE CustomerName LIKE ?
                   OR ContactName LIKE ?
                """;
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ?
                   OR ContactName LIKE ?
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement countStmt = connection.prepareStatement(countSql);
        countStmt.setString(1, "%" + keyword + "%");
        countStmt.setString(2, "%" + keyword + "%");

        PreparedStatement selectStmt = connection.prepareStatement(sql);
        selectStmt.setString(1, "%" + keyword + "%");
        selectStmt.setString(2, "%" + keyword + "%");

        int offset = (page - 1) * 5;
        selectStmt.setInt(3, offset);
        selectStmt.setInt(4, 5);

        ResultSet rs1 = countStmt.executeQuery();
        rs1.next();
        int count = rs1.getInt("count"); // 총 레코드 수
        int lastPage = (count - 1) / 5 + 1; // 마지막 페이지
        int rightPage = ((page - 1) / 10 + 1) * 10; // 오른쪽 페이지번호
        int leftPage = rightPage - 9; // 왼쪽 페이지 번호
        int prevPage = leftPage - 10;
        int nextPage = rightPage + 1;
        rightPage = Math.min(rightPage, lastPage); // 오른쪽 페이지번호는 마지막보다 클수없음
        model.addAttribute("lastPage", lastPage); // 마지막 페이지
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);


        ResultSet rs2 = selectStmt.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs2.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs2.getInt("CustomerID"));
            customerDto.setName(rs2.getString("CustomerName"));
            customerDto.setContactName(rs2.getString("ContactName"));
            customerDto.setAddress(rs2.getString("Address"));
            customerDto.setCity(rs2.getString("City"));
            customerDto.setPostalCode(rs2.getString("PostalCode"));
            customerDto.setCountry(rs2.getString("Country"));
            list.add(customerDto);

        }
        model.addAttribute("customerList", list);

        return "main15/sub3";

    }

    // 연습 : 상품명 조회 로직 작성 (w/paging)

    @GetMapping("sub4") // 🔹어노테이션, 브라우저에서 URL로 검색할 때 주로 GET 방식이 사용
    public String sub4(@RequestParam(defaultValue = "1") Integer page, // 🔹@RequestParam: URL의 파라미터를 받는 Spring 어노테이션. Integer: 정수형 객체, null을 허용하기 위해 기본형 int 대신 사용.
                       @RequestParam(defaultValue = "") String keyword,
                       Model model) throws Exception { // 🔹Controller → View로 데이터를 전달할 때 사용하는 Spring의 객체입니다. 역할: 이 객체에 담긴 데이터가 HTML 뷰(Thymeleaf)에서 ${}로 표시됩니다.

        //🔹 DB 연결 설정 : 자바에서 MySQL DB에 연결하기 위해 사용하는 JDBC 기본 설정.
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password); // Connection: DB 연결을 나타내는 객체. DriverManager.getConnection(...): 실제로 연결을 시도하는 메서드입니다.
        // ⚠️주의점: 보안상 실제 서비스에서는 이렇게 직접 연결하지 않고, DataSource를 사용합니다.

        //🔹전체 개수 구하는 쿼리 (검색어 포함) LIKE ? 는 검색어를 포함하는 조건.
        String countSql = "SELECT COUNT(*) AS count FROM Products WHERE ProductName LIKE ?";

        //🔹검색 + 페이징용 SELECT 쿼리 LIMIT ?, ? 는 (offset, pageSize)를 의미함.
        String sql = "SELECT * FROM Products WHERE ProductName LIKE ? ORDER BY ProductID LIMIT ?, ?";

        //🔹 개수 세는 PreparedStatement (안전한 방식: SQL 인젝션 방지를 위한 바인딩 방식.) ?는 바인딩 파라미터 자리.
        PreparedStatement countStmt = connection.prepareStatement(countSql);
        countStmt.setString(1, "%" + keyword + "%"); // setString(1, ...): 첫 번째 ? 자리에 값을 넣는 코드.

        //🔹 총 검색 결과 개수 가져오기
        ResultSet rs1 = countStmt.executeQuery(); // executeQuery(): SELECT 쿼리 실행.
        rs1.next(); // 결과 셋의 첫 줄로 이동.
        int count = rs1.getInt("count"); // getInt("count"): SELECT COUNT(*) 결과를 정수로 읽음.

        //🔹 페이징 계산
        int lastPage = (count - 1) / 5 + 1; // 전체 결과를 5개씩 나눴을 때 마지막 페이지 번호.

        int prevPage = Math.max(1, page - 1); // 이전 페이지 번호 (최소 1)
        int nextPage = Math.min(lastPage, page + 1); // 다음 페이지 번호 (최대 lastPage)

        int leftPage = ((page - 1) / 10) * 10 + 1;
        int rightPage = Math.min(leftPage + 9, lastPage); // leftPage ~ rightPage: 현재 페이지 기준으로 보여줄 페이지 번호들 범위

        //🔹 model 등록 : 뷰에서 페이지 번호들 표시할 때 사용합니다.
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("rightPage", rightPage);


        //🔹 실제 페이지별 결과 조회용 PreparedStatement
        PreparedStatement selectStmt = connection.prepareStatement(sql);
        selectStmt.setString(1, "%" + keyword + "%");

        int offset = (page - 1) * 5; // 첫 번째 ? → 검색어
        selectStmt.setInt(2, offset); // 두 번째 ? → offset (건너뛸 개수)
        selectStmt.setInt(3, 5); // 세 번째 ? → LIMIT (가져올 개수, 고정 5개)

        //🔹 결과 받아서 리스트에 저장 : 반복문을 통해 ResultSet 에서 한 줄씩 읽어와서 ProductDto 객체로 변환.
        ResultSet rs2 = selectStmt.executeQuery();
        List<ProductDto> list = new ArrayList<>();
        while (rs2.next()) {
            ProductDto productDto = new ProductDto();
            productDto.setId(rs2.getInt("ProductID"));
            productDto.setName(rs2.getString("ProductName"));
            productDto.setSupplier(rs2.getInt("SupplierID"));
            productDto.setCategory(rs2.getInt("CategoryID"));
            productDto.setUnit(rs2.getString("Unit"));
            productDto.setPrice(rs2.getDouble("Price"));
            list.add(productDto);
        }

        //🔹 모델에 데이터 리스트 추가 : 뷰에서 ${productList}로 사용하기 위함.
        model.addAttribute("productList", list);

        //🔹 뷰 이름 반환 : Thymeleaf 템플릿
        return "main15/sub4";
    }

}