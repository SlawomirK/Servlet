<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zasoby biblioteki</title>
</head>
<body>
<h5>autor: Sławomir Kobyliński s12410</h5>
<center>
<h1>Witam w systemie sprawdzającym zasoby biblioteczne  </h1>
<h4>Dostepnych jest prawie 100 pozycji wśród nich np </h4>
<h4>"Zabić drozda" – Harper Lee </h4>
<h4>"Wichrowe Wzgórza" – Emily Bronte </h4>
<h4>"Rok 1984" – George Orwell i kilkadziesiąt innych..</h4>
<h4>Aby sprawdzić czy książka jest dostępna prosze wpisać tytuł lub autora i zatwierdzić</h4>
<h4>Zostanie zwrócona lista pozycji zawierających szukaną frazę</h4>

<form method="get" action="http://localhost:8080/TPO4_KS_S12410/start">
Autor/tytuł:<input type="text" name="tytul" size=110/>
<input type="submit" value="Wyslij"/>
<br>
</form>
</center>
</body>
</html>