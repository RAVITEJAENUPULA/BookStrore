<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  AdminBean ab=(AdminBean)session.getAttribute("abean");
String ms=(String)request.getAttribute("msg");
out.println("page belongs to "+ab.getfName());
out.println(ms);
%>
<a href="product.html">AddProduct</a>
<a href="viewProducts">ViewAAllProducts</a>
<a href="logout">Logout</a>
</body>
</html>