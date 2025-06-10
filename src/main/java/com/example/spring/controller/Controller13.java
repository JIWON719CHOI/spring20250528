package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.ProductDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@Controller
@RequestMapping("main13")
public class Controller13 {
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        // 1. request 분석/가공
        //    @GetMapping, @PostMapping, @RequestParam

        // 2. request 처리 (business logic)
        //    CRUD
        // 2.1 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 2.2 쿼리(sql) 실행
        String sql = """
                SELECT CustomerName
                FROM Customers
                WHERE CustomerID = 1
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        // 2.3 결과 처리
        String name = "";
        if (resultSet.next()) {
            name = resultSet.getString("CustomerName");
        }

        // 3. 결과를 Model(or RedirectAttributes)에 담고
        //     model.addAttribute(), rttr.addFlashAttribute(), rttr.addAttribute()
        //     session.setAttribute()
        model.addAttribute("name", name);

        // 4. view로 forwarding
        //    다른 경로로 redirection
        return "main13/sub1";
    }

    //연습 : 상품번호 1번인 상품명  조회/출력
    // get main13/sub2
    // /main13/sub2.html
    @GetMapping("sub2")
    public String sub2(Model model) throws Exception {

        // 2.1 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT ProductName
                FROM Products
                WHERE ProductID = 10
                """;
        // 실행준비
        PreparedStatement statement = connection.prepareStatement(sql);
        // 실행
        ResultSet resultSet = statement.executeQuery();
        // 결과처리
        String name = "";
        if (resultSet.next()) {
            name = resultSet.getString("ProductName");
        }

        model.addAttribute("productName", name);
        return "main13/sub2";
    }

    @GetMapping("sub3")
    public String sub3(Model model) throws Exception {
        // 2.1 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT LastName
                FROM Employees
                """;
        // 실행준비
        PreparedStatement statement = connection.prepareStatement(sql);
        // 실행
        ResultSet resultSet = statement.executeQuery();
        // ResultSet :
        //  table 형태의 결과
        //  내부에 행(row)를 가리키는 커서가 있음
        //  next() 호출하면 다음 행으로 커서를 이동
        //  get...() : 컬럼 값을 얻는 메소드

        resultSet.next(); // 1번째 행 가리킴 (true 리턴)
        String name1 = resultSet.getString("LastName");
        resultSet.next(); // 2번째 행 가리킴 (true 리턴)
        String name2 = resultSet.getString("LastName");
        resultSet.next(); // 3번째 행 가리킴 (true 리턴)
        String name3 = resultSet.getString("LastName");
        resultSet.next(); // 4번째 행 가리킴 (true 리턴)
        String name4 = resultSet.getString("LastName");
        resultSet.next(); // 5번째 행 가리킴 (true 리턴)
        String name5 = resultSet.getString("LastName");
        resultSet.next(); // 6번째 행 가리킴 (true 리턴)
        String name6 = resultSet.getString("LastName");
        resultSet.next(); // 7번째 행 가리킴 (true 리턴)
        String name7 = resultSet.getString("LastName");
        resultSet.next(); // 8번째 행 가리킴 (true 리턴)
        String name8 = resultSet.getString("LastName");
        resultSet.next(); // 9번째 행 가리킴 (true 리턴)
        String name9 = resultSet.getString("LastName");
        resultSet.next(); // 10번째 행 가리킴 (없으니까 false 리턴)

        var list = List.of(name1, name2, name3, name4, name5, name6, name7, name8, name9);

        model.addAttribute("nameList", list);
        return "main13/sub3";
    }

    @GetMapping("sub4")
    public String sub4(Model model) throws Exception {
        // 2.1 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT FirstName
                FROM Employees
                """;
        // 실행준비
        PreparedStatement statement = connection.prepareStatement(sql);
        // 실행
        ResultSet resultSet = statement.executeQuery();
        // ResultSet :
        //  table 형태의 결과
        //  내부에 행(row)를 가리키는 커서가 있음
        //  next() 호출하면 다음 행으로 커서를 이동
        //  get...() : 컬럼 값을 얻는 메소드

        var list = new ArrayList<String>();

        while (resultSet.next()) {
            String name = resultSet.getString("FirstName");

            list.add(name);
        }

        model.addAttribute("nameList", list);
        return "main13/sub3";
    }

    // 연습
    // get /main13/sub5
    // Categories 테이블의 CategoryName 들을 조회해서
    // main13/sub5.html 에서 출력하기

    @GetMapping("sub5")
    public String sub5(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT CategoryName
                FROM Categories
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<String>();
        while (resultSet.next()) {
            String name = resultSet.getString("CategoryName");
            list.add(name);
        }
        model.addAttribute("nameList", list);
        return "main13/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT Price
                FROM Products
                ORDER BY Price
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
//        var list = new ArrayList<String>();
//        while (resultSet.next()) {
//            String price = resultSet.getString("Price");
//            list.add(price);
//        }

        // 모든 데이터는 String 으로 얻어 오는 것이 가능하지만, 특별한 이유가 없다면 type에 맞는 get... 메소드 사용하라.
        var list = new ArrayList<Double>();
        while (resultSet.next()) {
            double price = resultSet.getDouble("Price");
            list.add(price);
        }
        model.addAttribute("priceList", list);
        return "main13/sub6";
    }

    // 연습 :
    // get /main13/sub7
    // OrderDetails 에서 수량(Quantity) 상위 5개 조회해서
    // main13/sub7.html 에서 보여주기

    @GetMapping("sub7")
    public String sub7(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT Quantity, OrderDetailID, OrderID, ProductID
                FROM OrderDetails
                ORDER BY Quantity DESC LIMIT 5
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<Double>();
        while (resultSet.next()) {
            double quantity = resultSet.getDouble("Quantity");
            list.add(quantity);
        }
        model.addAttribute("quantityList", list);
        return "main13/sub7";
    }

    @GetMapping("sub8")
    public String sub8(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT LastName, FirstName
                FROM Employees
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Map<String, String>>();
        while (resultSet.next()) {
            String lastname = resultSet.getString("LastName");
            String firstname = resultSet.getString("FirstName");

            var name = new HashMap<String, String>();
            name.put("LastName", lastname);
            name.put("FirstName", firstname);
            list.add(name);
        }
        model.addAttribute("nameList", list);
        return "main13/sub8";
    }

    // 연습
    // get /main13/sub9
    // 고객테이블에서 미국,영국에 사는 고객이름과 국가를 조회해서
    // main13/sub9.html 에서 출력

    @GetMapping("sub9")
    public String sub9(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT CustomerName, Country
                FROM Customers
                WHERE Country IN('USA', 'UK')
                ORDER BY Country, CustomerName
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<Map<String, String>>();
        while (resultSet.next()) {
            String name = resultSet.getString("CustomerName");
            String country = resultSet.getString("Country");
            Map<String, String> map = new HashMap<>();
            map.put("CustomerName", name);
            map.put("Country", country);
            list.add(map);
        }
        model.addAttribute("nameList", list);
        return "main13/sub9";
    }

    @GetMapping("sub10")
    public String sub10(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT *
                FROM Products
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Map<String, Object>>();
        while (resultSet.next()) {
            int productId = resultSet.getInt("ProductId");
            String productName = resultSet.getString("ProductName");
            int supplierID = resultSet.getInt("SupplierID");
            int categoryID = resultSet.getInt("CategoryID");
            String unit = resultSet.getString("Unit");
            double price = resultSet.getDouble("Price");

            Map<String, Object> map = new HashMap<>();
            map.put("productId", productId);
            map.put("productName", productName);
            map.put("supplierID", supplierID);
            map.put("categoryID", categoryID);
            map.put("unit", unit);
            map.put("price", price);
            list.add(map);
        }
        model.addAttribute("productList", list);
        return "main13/sub10";
    }

    // 연습
    // get /main13/sub11
    // 모든 고객의 정보를 출력하는 코드 작성
    // main13/sub11.html 에서.
    @GetMapping("sub11")
    public String sub11(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<Map<String, Object>>();
        while (resultSet.next()) {

            String customerName = resultSet.getString("CustomerName");
            int customerID = resultSet.getInt("CustomerID");
            String contactName = resultSet.getString("ContactName");
            String address = resultSet.getString("Address");
            String city = resultSet.getString("City");
            String country = resultSet.getString("Country");
            String postalCode = resultSet.getString("PostalCode");

            Map<String, Object> map = new HashMap<>();
            map.put("customerName", customerName);
            map.put("customerID", customerID);
            map.put("contactName", contactName);
            map.put("address", address);
            map.put("city", city);
            map.put("country", country);
            map.put("postalCode", postalCode);
            list.add(map);
        }

        model.addAttribute("customerList", list);
        return "main13/sub11";
    }

    @GetMapping("sub12")
    public String sub12(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<CustomerDto>();

        while (resultSet.next()) {
            String customerName = resultSet.getString("CustomerName");
            int customerID = resultSet.getInt("CustomerID");
            String contactName = resultSet.getString("ContactName");
            String address = resultSet.getString("Address");
            String city = resultSet.getString("City");
            String country = resultSet.getString("Country");
            String postalCode = resultSet.getString("PostalCode");

            CustomerDto dto = new CustomerDto();
            dto.setId(customerID);
            dto.setContactName(customerName);
            dto.setContactName(contactName);
            dto.setAddress(address);
            dto.setCity(city);
            dto.setPostalCode(postalCode);
            dto.setCountry(country);

            list.add(dto);
        }
        model.addAttribute("customerList", list);
        return "main13/sub12";
    }

    // 연습
    // dto, html, request handler method
    // 모든 상품 조회, 출력
    // get /main13/sub13
    // main13/sub13.html
    // ProductDto

    @GetMapping("sub13")
    public String sub13(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT *
                FROM Products
                ORDER BY CategoryID, SupplierID, Price, ProductID
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<ProductDto>();
        while (resultSet.next()) {
            int productId = resultSet.getInt("ProductId");
            String productName = resultSet.getString("ProductName");
            int supplierID = resultSet.getInt("SupplierID");
            int categoryID = resultSet.getInt("CategoryID");
            String unit = resultSet.getString("Unit");
            double price = resultSet.getDouble("Price");

            ProductDto dto = new ProductDto();
            dto.setId(productId);
            dto.setName(productName);
            dto.setSupplier(supplierID);
            dto.setCategory(categoryID);
            dto.setUnit(unit);
            dto.setPrice(price);

            list.add(dto);
        }
        model.addAttribute("productList", list);
        return "main13/sub13";
    }

    @GetMapping("sub14")
    public String sub14(Model model) throws Exception {
        // ? : 변경 가능한 부분
        String sql = """
                SELECT *
                FROM Products
                WHERE Price < ?
                """;

        // 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);

        // PreparedStatement.execute....() : 쿼리 실행
        // PreparedStatement.set...(index, value) : ? 채우는 메소드
        statement.setDouble(1, 20.00);

        // 실행
        ResultSet resultSet = statement.executeQuery();

        // 결과 처리
        var list = new ArrayList<ProductDto>();
        while (resultSet.next()) {
            ProductDto dto = new ProductDto();
            dto.setId(resultSet.getInt("ProductId"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);
        }
        model.addAttribute("productList", list);
        return "main13/sub13";
    }

    // /main13/sub15?price=10.00
    @GetMapping("sub15")
    public String sub15(Model model,
                        @RequestParam(defaultValue = "100.00")
                        Double price) throws Exception {
        // ? : 변경 가능한 부분
        String sql = """
                SELECT *
                FROM Products
                WHERE Price < ?
                """;

        // 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);

        // PreparedStatement.execute....() : 쿼리 실행
        // PreparedStatement.set...(index, value) : ? 채우는 메소드
        statement.setDouble(1, price);

        // 실행
        ResultSet resultSet = statement.executeQuery();

        // 결과 처리
        var list = new ArrayList<ProductDto>();
        while (resultSet.next()) {
            ProductDto dto = new ProductDto();
            dto.setId(resultSet.getInt("ProductId"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);
        }
        model.addAttribute("productList", list);
        return "main13/sub15";
    }

    // 연습 : 특정 카테고리 번호의 상품들 조회 후 출력
    // request handler method, html
    // get /main13/sub16
    // main13/sub16.html

    @GetMapping("sub16")
    public String sub16(@RequestParam(required = false) Integer categoryId, Model model) throws Exception {
        String sql;
        if (categoryId == null) {
            sql = "SELECT * FROM Products";
        } else {
            sql = "SELECT * FROM Products WHERE CategoryID = ?";
        }

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        if (categoryId != null) {
            statement.setInt(1, categoryId);
        }

        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<ProductDto>();
        while (resultSet.next()) {
            ProductDto dto = new ProductDto();
            dto.setId(resultSet.getInt("ProductID"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);
        }
        model.addAttribute("productList", list);
        return "main13/sub16";
    }

    @GetMapping("sub17")
    public String sub17(
            @RequestParam(defaultValue = "10.00")
            Double price,
            @RequestParam(defaultValue = "1")
            Integer categoryId,
            Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                WHERE Price < ?
                  AND CategoryID = ?
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, price);
        statement.setInt(2, categoryId);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<ProductDto>();
        while (resultSet.next()) {
            ProductDto dto = new ProductDto();
            dto.setId(resultSet.getInt("ProductId"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);

        }
        model.addAttribute("productList", list);
        return "main13/sub17";
    }

    // 연습
    // 특정 가격 사이의 상품들 조회,출력 코드
    // 낮은가격~높은가격
    // request handler method, html(main13/sub18.html)
    // get /main13/sub18

    @GetMapping("sub18")
    public String sub18(
            @RequestParam(defaultValue = "0.00")
            Double min,
            @RequestParam(defaultValue = "10.00")
            Double max, Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                WHERE Price BETWEEN ? AND ?
                ORDER BY Price
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, min);
        statement.setDouble(2, max);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<ProductDto>();
        while (resultSet.next()) {
            ProductDto dto = new ProductDto();
            dto.setId(resultSet.getInt("ProductId"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);

        }
        model.addAttribute("productList", list);
        return "main13/sub18";
    }

    @GetMapping("sub19")
    public String sub19(String country, Model model) throws Exception {
        String countrySql = """
                SELECT DISTINCT Country
                FROM Customers
                ORDER BY Country
                """;

        String sql = """
                SELECT *
                FROM Customers
                WHERE Country = ?
                ORDER BY City
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 국가 조회
        PreparedStatement statement1 = connection.prepareStatement(countrySql);
        ResultSet resultSet1 = statement1.executeQuery();
        var list1 = new ArrayList<String>();
        while (resultSet1.next()) {
            list1.add(resultSet1.getString("Country"));
        }
        model.addAttribute("countryList", list1);

        // 고객 조회
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, country);

        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<CustomerDto>();

        while (resultSet.next()) {
            CustomerDto dto = new CustomerDto();
            dto.setId(resultSet.getInt("customerId"));
            dto.setContactName(resultSet.getString("customerName"));
            dto.setCity(resultSet.getString("City"));
            dto.setCountry(resultSet.getString("Country"));
            dto.setContactName(resultSet.getString("ContactName"));
            dto.setPostalCode(resultSet.getString("PostalCode"));
            dto.setAddress(resultSet.getString("Address"));
            list.add(dto);
        }
        model.addAttribute("customerList", list);
        return "main13/sub19";
    }

    // 연습
    // request handler method, SupplierDto, html(main13/sub20.html)
    // 특정 국가에 있는 공급자들 조회
    // get /main13/sub20

    @GetMapping("sub20")
    public String sub20(String country, Model model) throws Exception {
        String countrySql = """
                SELECT DISTINCT Country
                FROM Suppliers
                ORDER BY Country
                """;
        String sql = """
                SELECT *
                FROM Suppliers
                WHERE Country = ?
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement1 = connection.prepareStatement(countrySql);
        ResultSet resultSet1 = statement1.executeQuery();
        var list1 = new ArrayList<String>();
        while (resultSet1.next()) {
            list1.add(resultSet1.getString("Country"));

        }
        model.addAttribute("countryList", list1);


        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, country);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<SupplierDto>();
        while (resultSet.next()) {
            SupplierDto dto = new SupplierDto();
            dto.setId(resultSet.getInt("SupplierId"));
            dto.setName(resultSet.getString("SupplierName"));
            dto.setCity(resultSet.getString("City"));
            dto.setCountry(resultSet.getString("Country"));
            dto.setAddress(resultSet.getString("Address"));
            dto.setPostalCode(resultSet.getString("PostalCode"));
            dto.setPhone(resultSet.getString("Phone"));
            dto.setContact(resultSet.getString("ContactName"));
            list.add(dto);
        }
        model.addAttribute("supplierList", list);
        return "main13/sub20";
    }



}