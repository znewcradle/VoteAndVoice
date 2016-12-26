<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
  <h1>input your user id and password:</h1>
  <form action="<%=response.encodeURL("Login") %>" method="post">
    <h2>user id:<input type="text" name="u_id" /> </h2>
    <h2>password:<input type="password" name="u_pwd" /> </h2>
    <button type="submit" name="submitLogin">sign up</button>
  </form>
</body>
</html>