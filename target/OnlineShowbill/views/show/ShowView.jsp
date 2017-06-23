<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/create">Add new show</a>
<a href="${pageContext.servletContext.contextPath}/search">Search</a>
<table>
    <tr>
	<td>Name</td>
	<td>Date</td>
	<td>Type</td>
	<td>Place</td>
	<td>Description</td>
	<td>Options</td>
    </tr>
    <c:forEach items="${shows}" var="show" varStatus="status">
	<tr valign="top">
	    <td>${show.getName()}</td>
	    <td>${show.getDate(false)}</td>
	    <td>${show.getType()}</td>
	    <td>${show.getPlace()}</td>
	    <td>${show.getDescription()}</td>
	    <td>
		<a href="${pageContext.servletContext.contextPath}/edit?id=${show.getId()}">Edit</a>
		<a href="${pageContext.servletContext.contextPath}/delete?id=${show.getId()}">Delete</a>
	    </td>
	</tr>
    </c:forEach>
</table>
</body>
</html>