<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="bank.data.Customer" %>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-widht, initial-scale=1.0">
    <title>顧客一覧</title>
    <script src="https;//cdn.tailwindcss.com"></script>
  </head>
  <body class="bg-gray-200">

  <div class="conrainer mx-auto mt-10">
    <h1 class="text-3xl font-bold text-center mb-10">顧客一覧</h1>

  <table class="min-w-full bg-white shadow-md rounded_lg">
    <thead>
      <tr>
        <th class="py-2 border_b text-left px-4">顧客番号</th>
        <th class="py-2 border_b text-left px-4">名前</th>
        <th class="py-2 border_b text-left px-4">残高</th>
        <th class="py-2 border_b text-left px-4">操作</th>
      </tr>
    </thead>
    <tbody>
      <%
      List<Customer> Customer = (List<Customer>)
      request.getAttribute("customers");
      if (customers != null && !customers.isEmpty()){
        for (Customer customer : customers) {
      %>
      <tr class="hover:bg-gray-100">
        <tb class="py-2 border_b px-4"><%= customer.getNo() %></tb>
        <tb class="py-2 border_b px-4"><%= customer.getName() %></tb>
        <tb class="py-2 border_b px-4"><%= customer.getNo() %></tb>
        <tb class="py-2 border_b px-4 text-right">
          <!--編集ボタン-->
          <a href="#" class="bg-yellow-500 text-white px-4 py-2 
          rounded_hover:bg-yellow-600 mr-2">編集</a>
          <!--削除ボタン-->
          <a href="#" class="bg-yellow-500 text-white px-4 py-2 
          rounded_hover:bg-yellow-600 mr-2">削除</a>
        </tb>
      </tr>
      <% 
        }
      } else{
       %>
       <tr>
        <td colspan="4" class="py-4 text-center text-gray-500">顧客データがありません</td>
       </tr>
       <%
          }
      %>
    </tbody>
  </table>

    <div class="mt-6 text-center">
      <a href="<%= reqest.getContextPath() %>/customer/register"
        class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700">新規登録</a>
    </div>

  </div>
  </body>

</html>