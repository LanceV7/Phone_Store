<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 23/10/2020
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phone store.it - Admin</title>
</head>
<body>

<%@include file="nav.jsp"%>
<div class="card" style="width: 18rem; margin: auto; float: none; margin-bottom: 10px;margin-top: 10px;">
    <form action="Aggiunta" method="post">
        <fieldset>


            <img class="card-img-top" src="https://www.curryflow.com/wp-content/uploads/2020/05/admin-icon-png-14.png-2.jpeg" alt="Card image cap">
            <div class="card-body">

                <h5 class="card-title" style="text-align: center">Benvenuto Admin</h5>
                <p class="card-text" style="text-align: center">Cosa desideri fare?</p>
                <a href="AggiungiProdotto.jsp" class="btn btn-primary">Aggiungere prodotto</a><br>
                <a href="#" class="btn btn-primary">Eliminare il prodotto</a><br>
                <a href="#" class="btn btn-primary">Modifica prodotto</a><br>
                <a href="#" class="btn btn-primary">Elimina utente</a><br>
            </div>
        </fieldset>
    </form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>