<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/edit?id=${show.getId()}" method="POST">
    <input type="hidden" name="id" value="${show.getId()}">
    <table>
	<tr>
	    <td align="right" >Name : </td>
	    <td>
		<input type="text" name="name" required value="${show.getName()}">
	    </td>
	</tr>
	<tr>
	    <td align="right" >Date and time : </td>
	    <td>
		<input type="datetime-local" name="datetime" required value="${show.getDate(true)}">
	    </td>
	</tr>
	<tr>
	    <td align="right" >Type : </td>
	    <td>
		<select name="type" required>
		    <c:forEach items="${types}" var="type" varStatus="status">
			<option value="${type}">${type}</option>
		    </c:forEach>
		</select>
	    </td>
	</tr>
	<tr>
	    <td align="right" >Place : </td>
	    <td>
		<select name="place" required>
		    <c:forEach items="${places}" var="place" varStatus="status">
			<option value="${place}">${place}</option>
		    </c:forEach>
		</select>
	    </td>
	</tr>
	<tr>
	    <td align="right" >Description : </td>
	    <td>
		<input type="text" name="description" value="${show.getDescription()}">
	    </td>
	</tr>
	<tr>
	    <td><input type="submit" align="center" value="Submit"/></td>
	</tr>
    </table>
</form>
</body>
</html>