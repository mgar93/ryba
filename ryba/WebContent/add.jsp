<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dodaj pacjenta</title>
</head>
<body>
<f:view>
<form action="AddServlet" method="post">
Imię: <input type="text" name="name" /><br />
Nazwisko: <input type="text" name="lastname" /><br />
Pesel:<input type="number" name="pesel" /><br />
Data urodzenia: <input type="date" name="date" /><br />
Adres: <input type="text" name="address" /><br />
Telefon: <INPUT type="tel" name="tel"/><br />
Waga:<input type="number" name="mass" /><br />
Wzrost:<input type="number" name="size" /><br />
<input type="submit" />
</form>
</f:view>
</body>
</html>
</jsp:root>