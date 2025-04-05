package bank.servlet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.annotation.WebServlet;
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.sql.DataSource;

import bank.data.CustomerDAO;
import bank.data.Customer

import java.IOException;
import java.sql.Connection;
import java.sql.SQLException;

// import javax.sql.DataSource;
// import javax.sql.rowset.serial.SerialException;

;

@WebServlet("/Customer/register")
public class CustomerRegisterServlet extends HttpServlet {

  @Resource(name = "jdbc/PostgresDB")
  private DataSource dataSource;

  @Override
  public void deGet(HttpServletRequest request, HttpServletResponse response)
         throws SecurityException, IOException {
      //新規登録フォームを表示
       
request.getRequestDispatcher("/bank/customer_register.jsp").forward(request, response);
}
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
       throws SecurityException, IOException {

    try (Connection connection = dataSource.getConnection()){
      String no = request.getParameter("no");
      String name = request.getParameter("name");
      int money = request.getParameter("money");

      Customer customer = new Customer(no, name, money);

      connection.setAutoCommit(false);
      CustomerDAO customerDAO = new CustoerDAO(connection);
      customerDAO.saveCustomer(customer);

      //コミット
      connection.commit();

      //登録後、子きゃっく一覧画面にリダイレクト
      response.sendRedirect(request.getContextPath() + "/customer/list");
    }catch (SQLException e){
      throw new SerialException("顧客の登録に失敗しました", e);
    }
  }
}