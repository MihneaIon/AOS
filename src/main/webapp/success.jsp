 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="conection.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is my superdupperpage</title>
</head>
<body>

<jsp:useBean id="obj" class="conection.PersonBean"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>

<%
	int status=PersonDAO.insertPerson(obj);
if(status>0)
	out.println("Insert successfully"); 
else
	out.println("Insert Fail, Probably you forgot to insert name or email ");

%>
</body>
</html>