<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista pacjentów</title>
</head>
<body>
<%@page import="ryba.*"%>
<%@page import="java.util.*" %>
<%
PatientManager pm = new PatientManager();
List<Patient> patients = pm.getAllPatients();
%>
<% for(Patient p : patients) {%>
<%=p.getId()%>. <%=p.getName()%> <%=p.getLastname()%><BR />
<%}%>
</body>
</html>