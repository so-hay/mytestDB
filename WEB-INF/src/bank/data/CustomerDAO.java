package  bank.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

  private Connection connection;

  public CustomerDAO(Connection connection) {
    this.connection = connection;
  }
  //顧客リストの取得
  public List<Customer> getCustomers() throws SQLException{
    List<Customer> customers = new ArrayList<>();
    String sql = "SELECT no, name, money FROM customer"; //顧客テーブルのデータを取得

    try (PreparedStatement stmt = connection.prepareStatement(sql)){
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          Customer customer = new Customer();
          customer.setNo(rs.getString("no"));
          customer.setName(rs.getString("name"));
          customer.setMoney(rs.getInt("money"));
          customers.add(customer);
        }
      }
    }
    return customers;
  }
  //顧客情報の保存（新規登録）
  public  void saveCustomer(Customer customer)throws  SQLException {
    String sql = "INSERT INTO customer (no, name, money) VALUES (?, ?, ?,)";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setString(1, customer.getNo());
      stmt.setString(2, customer.getName());
      stmt.setInt(3, customer.getMoney());
      stmt.executeUpdate();
    }
  }
}