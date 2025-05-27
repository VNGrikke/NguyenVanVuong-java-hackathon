<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Quan li danh muc</h1>

<div>
  <div>
    <a href="category/add">Thêm danh muc</a>

    <form action="category" method="get">
      <input type="text" name="name" placeholder="Tim kiem danh muc">
      <button type="submit">Tìm kiếm</button>
    </form>
  </div>

  <div>
    <table border="1" >
      <thead>
        <tr>
          <th>ID</th>
          <th>Tên danh muc</th>
          <th>Mô tả</th>
          <th>Thao tác</th>
        </tr>
      </thead>
      <tbody>
      <c:if test="${empty categories}">
        <tr>Danh sach trong</tr>
      </c:if>
        <c:forEach items="${categories}" var="category">
          <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td>
              <a>Sửa</a>
              <a>Xóa</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

</div>

</body>
</html>
