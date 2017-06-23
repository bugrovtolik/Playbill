<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
    <script type="text/javascript">
	function switchInput(type) {
	    var result;
	    switch(type) {
		case 'name': result = '<input type="text" name="value" required>'; break;
		case 'date': result = '<input type="datetime-local" name="value" required>'; break;
		case 'type': 
		case 'place': result = '<select name="value" id="value" required></select>'; break;
	    }
	    return result;
	}
	function enterChange(selectObj) {
	    var input = document.getElementById('input');
	    var value = selectObj.options[selectObj.selectedIndex].value;
	    input.innerHTML = switchInput(value);
	    if(value === 'type') {
		var selectval = document.getElementById("value"); 
		var types = JSON.parse('${types}');

		types.forEach(item => {
		    const newoption = document.createElement("option");
		    Object.assign(newoption, {
			value: item,
			text: item
		    });
		    selectval.appendChild(newoption);
		});
	    }
	    if(value === 'place') {
		var selectval = document.getElementById("value"); 
		var places = JSON.parse('${places}');

		places.forEach(item => {
		    const newoption = document.createElement("option");
		    Object.assign(newoption, {
			value: item,
			text: item
		    });
		    selectval.appendChild(newoption);
		});
	    }
	}
    </script>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/search" method="POST">
    <table border="0px" cellpadding="30" align="center">
	<tr align="center">
	    <td>Search by</td>
	    <td>Enter a value</td>
	</tr>
	<tr>
	    <td>
		<select name="by" required onchange="enterChange(this)">
		    <option value="name">Name</option>
		    <option value="date">Date</option>
		    <option value="type">Type</option>
		    <option value="place">Place</option>
		</select>
	    </td>
	    <td>
		<div id="input">
		    <input type="text" name="value" required>
		</div>
	    </td>
	    <td><input type="submit" align="center" value="Search"/></td>
	</tr>
    </table>
</form>
</body>
</html>