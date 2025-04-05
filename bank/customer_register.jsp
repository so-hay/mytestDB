<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>新規顧客登録</title>
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body class="bg-gray-200">

    <div class="container mx-auto mt-10">
      <h1 class="text-3xl font-bold text-center mb-10">新規顧客登録</h1>

      <form action="<%= reqest.getContextPath() %>/customer/register" method="post"
        class="space-y-6 bg-white shadow-md rounded-lg p-8">
      <div class="flex flex-col">
        <label for="no" class="text-lg font-semibold">顧客番号</label>
        <input type="text" id="no" name="no" class="mt-1 block w-full
          px-4 py-2 border border-gray-300 rounded-lg shadow-sm" placeholder="顧客番号を入力">
      </div>

      <div class="flex flex-col">
        <label for="name" class="text-lg font-semibold">名前</label>
        <input type="text" id="name" name="name" class="mt-1 block w-full
         px-4 py-2 border border-gray-300 rounded-lg shadow-sm" placeholder="名前を入力">
      </div>

      <div class="flex flex-col">
        <label for="money" class="text-lg font-semibold">残高</label>
        <input type="number" id="money" name="money" class="mt-1 block w-full
         px-4 py-2 border border-gray-300 rounded-lg shadow-sm" placeholder="残高を入力">
      </div>

      <div class="flex justify-between">
        <button type="submit" class="bg-green-500
         text-white px-4 py-2 rounded-lg hover:bg-green-700">登録する</button>
         <a href="<%= request.getContextPath() %>/customer/list"
          class="bg-gray-300 text-gray-700 px-4 py-2 rounded-lg hover:bg-gray-400">
          キャンセル</a>
      </div>
      </form>
    </div>
  </body>
</html>