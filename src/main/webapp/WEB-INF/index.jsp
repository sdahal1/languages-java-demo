<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
    <h1>Hello Languages!</h1>
    <table class="table table-dark">
        <thead>
          <tr>
            
            <th scope="col">Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Version</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items='${ allZeLangs }' var='lang'>
            <tr>  
                <td><a href="">${lang.name}</a></td>
                <td>${lang.creator}</td>
                <td>${lang.currentVersion}</td>
                <td><a href="/">View Language Details</a> | <a href="/languages/edit/${lang.id}">Edit</a> | <a href="">Delete</a></td>
            </tr>
        </c:forEach>


         
        </tbody>
      </table>


      
  
    <h1>New Language</h1>
    <form:form action="/languages" method="post" modelAttribute="language">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:textarea path="creator"/>
        </p>
        <p>
            <form:label path="currentVersion">Current Version</form:label>
            <form:errors path="currentVersion"/>
            <form:input type = "number" path="currentVersion" step="0.00001"/>
        </p>
        
        <input type="submit" value="Submit"/>
    </form:form>    

</body>
</html>