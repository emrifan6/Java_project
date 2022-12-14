<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>Read the textbox value</h1>
    <hr />
    <% for (String car : cars) { out.println(car); } %>
    <c:forEach item="${cars}" var="car" varStatus="status">
      <tr>
        <td>${car}</td>
      </tr>
    </c:forEach>
  </body>
</html>
