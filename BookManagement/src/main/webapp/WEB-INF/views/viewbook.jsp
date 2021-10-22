<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.center {
  margin-left: auto;
  margin-right: auto;
}
</style>
</head>
<body>

<h1 style="text-align: center;">Books List</h1><br>

<table class="center" border="2" width="70%" cellpadding="2"  background-position: center; background-size: cover;">  
<th>Id</th><th>Name</th><th>Author</th><th>Price</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="book" items="${list}">   
   
   <td>${book.id}</td>  
   <td>${book.name}</td>  
   <td>${book.author}</td>  
   <td>${book.price}</td> 
   <td><a href="editbook/${book.id}">Edit</a></td>  
   <td><a href="deletebook/${book.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <section style="text-align: center;">
   <a style="text-align: center;" href="bookform" >Add New Book</a>
	</section>
	
</body>
</html>