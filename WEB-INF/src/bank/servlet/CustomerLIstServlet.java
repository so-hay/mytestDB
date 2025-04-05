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
import java.util.List;

@WebServlet("/customer/list")
public class CustomerListServlet extends HttpServlet {

  @Resource(name = "jdbc/PostgresDB")
  private DataSource dataSource;

  @Override
  public void deGet(HttpServletRequest request, HttpServletResponse response)
         throws SecurityException, IOException {
      try (Connection connection = dataSource.getConnection()) {
        CustomerDAO customerDAO = new CustomerDAO(connection);
        List<Customer> customers = customerDAO.getCustomers();
        request.setAttribute("customers", customers);

request.getRequestDispatcher("/bank/customer_list.jsp").forward(request, response);
} catch (SQLException e) {
    throw new ServerException("顧客情報の取得に失敗しました", e);
    }   
  }
}