<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administración de Fondos</title>
<link rel="stylesheet" href="resources/styles.css">
</head>
<body>
    <h1>Bienvenido, ${user.name}!</h1>
    <div id="balance">Saldo: $${balance}</div>
    <form action="deposit" method="post">
        <input type="number" name="amount" placeholder="Cantidad">
        <button type="submit">Depositar</button>
    </form>
    <form action="withdraw" method="post">
        <input type="number" name="amount" placeholder="Cantidad">
        <button type="submit">Retirar</button>
    </form>
    <form action="convert" method="post">
        <button type="submit">Convertir a Euros</button>
    </form>
</body>
</html>

