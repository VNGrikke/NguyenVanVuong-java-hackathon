<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Them phong ban</h1>
<form:form action="/category/save" method="post" modelAttribute="categoryDto">
    <label>Name</label>
    <form:input path="name"/> <br>
    <form:errors path="name"/> <br>
    <c:if test="${not empty error}">${error}</c:if>
    <label>Description</label>
    <form:input path="description"/><br>

    <label>Status</label>
    <form:select path="status">
        <form:option value="">Select</form:option>
        <form:option value="1">Active</form:option>
        <form:option value="0">Inactive</form:option>
    </form:select>

    <button type="submit">submit</button>
    <button type="button" onclick="window.location.href='/list-category'">back</button>
</form:form>

</body>
</html>
