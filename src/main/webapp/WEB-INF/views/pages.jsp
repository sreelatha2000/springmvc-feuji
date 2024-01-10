<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <div>
      <p>
       <h1>${headerName}</h1>
      </p>
     </div>
  <div>
   <form:form method="POST" action="/pages" modelAttribute="page" enctype="multipart/form-data">
    <table>
           <tr>
            <td>name</td>
            <td><form:input type="text" path="bookName"></form:input></td>
           </tr>
           <tr>
            <td>author</td>
            <td><form:input type="text" path="author"></form:input> </td>
           </tr>
           <tr>
            <td colspan=2><input type="submit" value="Save"> </td>
           </tr>
          </table>
   </form:form>
  </div>
</body>
</html>