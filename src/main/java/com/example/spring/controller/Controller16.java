package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller; // 이 클래스가 Spring MVC 에서 컨트롤러 역할을 한다는 의미. 사용자의 웹 요청을 받아 처리하고 결과(View)를 리턴할 때 사용함.
import org.springframework.ui.Model; // View로 데이터를 전달할 때 사용하는 Spring의 객체. model.addAttribute("key", 값) 으로 뷰(html)에 데이터를 넘길 수 있음.
import org.springframework.web.bind.annotation.*; //@GetMapping, @PostMapping, @RequestMapping 같은 어노테이션을 사용하려면 필요함.
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// JDBC 관련 객체들
import java.sql.Connection; // 데이터베이스 연결
import java.sql.DriverManager; // 연결 도와주는 객체
import java.sql.PreparedStatement; // SQL 실행을 위한 객체
import java.sql.ResultSet;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @GetMapping("sub1")
    public void form() {
        // 아무 리턴도 없으면, 뷰 이름은 URL과 같은 main16/sub1.html로 자동 연결됨. 즉, 입력 폼을 보여주는 용도.
    }

    @PostMapping("sub1")
    // CustomerDto customer: HTML <form>의 name 속성 값들과 자동 매핑됨
    // Model model: 성공/실패 메시지를 뷰에 전달할 때 사용. 지금은 바꿈.
    public String insertCustomer(CustomerDto customer, RedirectAttributes rttr) {

        //멀티라인 문자열 문법 (""")을 사용해 SQL 쿼리문을 작성. ?는 자리표시자 (placeholder)로, 나중에 setString()으로 채워줌.
        // "플레이스홀더(placeholder)"는 텍스트 박스나 입력 필드에 사용자가 값을 입력하기 전에 보여주는 짧은 힌트 메시지를 뜻합니다.
        String sql = """
                    INSERT INTO Customers 
                    (CustomerName, ContactName, Address, PostalCode, City, Country)
                    VALUES (?, ?, ?, ?, ?, ?)
                """;

        // try-with-resources 문법: 자바 7 부터 가능. try-catch는 실무에서 무조건 씀.
        // try 안에서 열면 자동으로 닫아줌. con.close();, pstmt.close(); 안 써도 자동으로 닫힘
        // DriverManager.getConnection(...): DB 연결
        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/w3schools", "root", "1234");
                PreparedStatement pstmt = con.prepareStatement(sql) // SQL 실행 객체 생성
        ) {
            // 위 SQL 쿼리문의 ?에 각각 값을 채움. customer.getXXX()로 입력받은 값을 꺼냄.
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getContactName());
            pstmt.setString(3, customer.getAddress());
            pstmt.setString(4, customer.getPostalCode());
            pstmt.setString(5, customer.getCity());
            pstmt.setString(6, customer.getCountry());

            int rows = pstmt.executeUpdate(); // SQL 실행. 실제로 DB에 INSERT 동작이 수행됨. 성공하면 rows에 영향받은 행의 수(예: 1)가 저장됨.

            // DB에 제대로 한 줄이 insert 됐는지 확인해서, 결과 메시지를 모델에 담음. 이 메시지는 Thymeleaf 뷰에서 ${message}로 표시됨.
            if (rows == 1) {
                rttr.addFlashAttribute("message", "✅ 고객 정보가 성공적으로 저장되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "⚠️ 저장 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
            rttr.addFlashAttribute("message", "❌ 오류 발생: " + e.getMessage());
        }

        // 결과 페이지로 이동. main16/sub1.html을 다시 보여줌. 즉, 입력폼 다시 보여주면서 메시지도 함께 보여주는 방식.
        // GET 으로 리다이렉트해서 새로고침해도 중복 안 됨. ✅ PRG 패턴 적용 (Post-Redirect-Get)
        return "redirect:/main16/sub1";
    }

    // 연습 : 새 공급자 등록 로직 작성. handler method * 2 (get, post), html * 1

    @GetMapping("sub2")
    public void form2() {
    }

    @PostMapping("sub2")
    public String insertCustomer2(SupplierDto supplier, RedirectAttributes rttr) {
        String sql = "INSERT INTO Suppliers (SupplierName, ContactName, Address, City, PostalCode, Country, Phone) VALUES (?, ?, ?, ?, ?, ?, ?) ";
        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/w3schools", "root", "1234");
                PreparedStatement pstmt = con.prepareStatement(sql)
        ) {
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

        return "redirect:/main16/sub2";
    }

    @GetMapping("sub3")
    // 쿼리스트링으로 들어온 id 값을 파라미터로 받고, 뷰에 데이터를 전달할 Model 객체도 받습니다.
    public String form3(Integer id, Model model) throws Exception {

        // id 값이 있을 때만 실행되게 조건을 겁니다 (처음 페이지 열 때는 null일 수 있음).
        if (id != null) {

            // 데이터베이스에서 특정 고객을 조회하는 SQL 문입니다. ?는 나중에 바인딩할 파라미터 자리입니다.
            String sql = """
                        SELECT
                            CustomerID AS id,
                            CustomerName AS name,
                            ContactName,
                            Address,
                            PostalCode,
                            City,
                            Country
                        FROM Customers
                        WHERE CustomerID = ?
                    """;

            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";

            // 데이터베이스와 연결을 맺습니다.
            Connection conn = DriverManager.getConnection(url, username, password);
            // 위 SQL을 실행할 준비된 문장을 만듭니다. SQL 인젝션 방지를 위해 PreparedStatement 사용.
            PreparedStatement statement = conn.prepareStatement(sql);
            // SQL의 첫 번째 ? 자리에 id 값을 넣습니다.
            statement.setInt(1, id);

            // SQL 실행 후 결과를 받아옵니다. SELECT 문이므로 executeQuery()를 사용합니다.
            ResultSet resultSet = statement.executeQuery();

            // 결과가 있을 경우에만 실행합니다. (조회된 고객이 있는 경우)
            if (resultSet.next()) {

                // DTO 객체 생성. 조회한 정보를 담을 객체입니다.
                CustomerDto customer = new CustomerDto();

                // ResultSet 에서 값을 가져와 DTO에 넣습니다.
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setContactName(resultSet.getString("ContactName"));
                customer.setAddress(resultSet.getString("Address"));
                customer.setPostalCode(resultSet.getString("PostalCode"));
                customer.setCity(resultSet.getString("City"));
                customer.setCountry(resultSet.getString("Country"));

                // customer 객체를 모델에 담아서 뷰에서 사용할 수 있도록 전달합니다.
                model.addAttribute("customer", customer);
            }

            resultSet.close();
            statement.close();
            conn.close();
        }

        // 템플릿 파일 main16/sub3.html로 이동합니다 (forward 방식).
        return "main16/sub3";
    }

    // POST 요청을 처리하는 메서드입니다. 고객 삭제 요청을 처리합니다.
    @PostMapping("sub3")
    // 파라미터로 들어온 고객 id와 리다이렉트 시 flash 데이터를 전달할 rttr 객체를 받습니다.
    public String process3(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = "DELETE FROM Customers WHERE CustomerID = ?";
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";

        Connection conn = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id); // ? 자리에 id 설정.

        // 실제 SQL 실행. executeUpdate()는 행의 수를 반환하지만 여기선 반환값은 사용하지 않음.
        statement.executeUpdate(); // delete, update, insert

        statement.close();
        conn.close();

        // 삭제 후에도 id 값을 잠깐 가지고 있게 플래시 속성에 담습니다. (redirect 후에도 1회 사용 가능)
        rttr.addFlashAttribute("message", id + "번 고객 삭제됨!");

        // 다시 조회 페이지로 리다이렉트합니다 (새로고침해도 중복 삭제 방지).
        return "redirect:/main16/sub3";
    }

    // 연습 : 공급자 조회 후 삭제 로직 완성, request handler method * 2, html * 1

    @GetMapping("sub4")
    public String form4(Integer id, Model model) throws Exception {

        // id 값이 있을 때만 DB 조회
        if (id != null) {

            // SQL 쿼리: Suppliers 테이블에서 SupplierID가 일치하는 행을 조회
            // 별칭(alias)를 사용하여 DB 컬럼명과 DTO 필드명 간의 매핑을 맞춥니다.
            String sql = """
                        SELECT
                        SupplierID AS id,
                        SupplierName AS name,
                        ContactName AS contact,
                        Address,
                        City,
                        PostalCode,
                        Country,
                        Phone
                    FROM Suppliers
                    WHERE SupplierID = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";

            // try-with-resources를 사용하여 Connection, PreparedStatement, ResultSet을 안전하게 닫음
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement statement = conn.prepareStatement(sql)) {

                // 첫번째 ?에 id를 바인딩
                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {

                        // 조회된 데이터를 SupplierDto 객체에 담음
                        SupplierDto supplier = new SupplierDto();
                        supplier.setId(resultSet.getInt("id"));
                        supplier.setName(resultSet.getString("name"));
                        supplier.setContact(resultSet.getString("contact"));
                        supplier.setAddress(resultSet.getString("Address"));
                        supplier.setCity(resultSet.getString("City"));
                        supplier.setPostalCode(resultSet.getString("PostalCode"));
                        supplier.setCountry(resultSet.getString("Country"));
                        supplier.setPhone(resultSet.getString("Phone"));

                        // 모델에 supplier 객체 추가하여 뷰로 전달
                        model.addAttribute("supplier", supplier);
                    }
                }
            }
        }
        // 뷰 이름: main16/sub4.html (forward 방식)
        return "main16/sub4";
    }

    // POST 요청: 공급자 삭제 처리
    @PostMapping("sub4")
    public String process4(Integer id, RedirectAttributes rttr) throws Exception {
        // SQL 쿼리: SupplierID가 id와 일치하는 공급자 행 삭제
        String sql = "DELETE FROM Suppliers WHERE SupplierID = ?";
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";

        // try-with-resources로 DB 연결 및 PreparedStatement 생성
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            // executeUpdate()로 삭제 수행 (영향받은 행 수 반환, 여기서는 반환값 미사용)
            statement.executeUpdate();
        }

        // FlashAttribute를 사용해 삭제된 공급자 id를 후속 GET 요청에 전달 (PRG 패턴 적용)
        rttr.addFlashAttribute("message", id + "번 공급자 삭제됨!");

        // redirect를 사용해 GET 요청으로 전환. 경로 앞에 '/'를 붙여 절대 경로 지정.
        return "redirect:/main16/sub4";
    }

    ///  update

    @GetMapping("sub5")
    public String select1(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = "SELECT * FROM Customers WHERE CustomerID = ?";
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        CustomerDto customer = new CustomerDto();
                        customer.setId(resultSet.getInt("CustomerID"));
                        customer.setName(resultSet.getString("CustomerName"));
                        customer.setContactName(resultSet.getString("ContactName"));
                        customer.setAddress(resultSet.getString("Address"));
                        customer.setPostalCode(resultSet.getString("PostalCode"));
                        customer.setCity(resultSet.getString("City"));
                        customer.setCountry(resultSet.getString("Country"));
                        model.addAttribute("customer", customer);
                    }
                }
            }
        }
        return "main16/sub5";
    }

    @PostMapping("sub5")
    public String process5(CustomerDto customer, RedirectAttributes rttr) throws Exception {

//        System.out.println("customer: " + customer);
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address = ?,
                    PostalCode = ?,
                    City = ?,
                    Country = ?
                WHERE CustomerID = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getContactName());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getPostalCode());
            statement.setString(5, customer.getCity());
            statement.setString(6, customer.getCountry());
            statement.setInt(7, customer.getId());
            statement.executeUpdate();

            rttr.addAttribute("id", customer.getId());
        }
        return "redirect:/main16/sub5";
    }
}




