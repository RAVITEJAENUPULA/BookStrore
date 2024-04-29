<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("al");
out.println("page belongs to "+ab.getfName()+"<br>");
if(al.size()==0){
	out.println("products not available...<br>");
}
else{
	Iterator<ProductBean> it=al.iterator();
	while(it.hasNext()){
		ProductBean pb=(ProductBean)it.next();
		out.println(pb.getpCode()+"&nbsp&nbsp"+pb.getpName()+"&nbsp&nbsp"+pb.getpPrice()  +"&nbsp&nbsp"+pb.getpQty()+"<a href='editProduct?pcode="+pb.getpCode()+"'>Edit</a>"+"&nbsp&nbsp"+"<a href='deleteProduct?pcode="+pb.getpCode()+"'>delete</a>"+"&nbsp&nbsp");
	}
}
%>
</body>
</html>