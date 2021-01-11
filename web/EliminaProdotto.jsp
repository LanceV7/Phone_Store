<%@ page import="model.Prodotto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 11/01/2021
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="nav.jsp"%>
<!--Table-->
<form action="EliminaProdottoServlet" method="post">
<table id="tablePreview" class="table table-sm">
    <!--Table head-->
    <thead class="thead-dark>
    <tr id="1">
        <th>#</th>
        <th>Marca</th>
        <th>Nome</th>
        <th>Descrizione</th>
        <th>Prezzo</th>
        <th>Quantità</th>
        <th></th>
    </tr>
    </thead>
    <!--Table head-->
    <!--Table body-->
    <tbody id="main">
    <%
        Object obj = request.getAttribute("prodotto");
        List<Prodotto> lst = null;
        if (obj instanceof List)
            lst = (List<Prodotto>) obj;

        if(lst != null ? !lst.isEmpty() : false){
            for (Prodotto c : lst) { %>
    <tr id="2">
        <th scope="row"><%c.getCodiceTel();%></th>
        <td id="marca"><%c.getMarca();%></td>
        <td id="nome"><%c.getNome();%></td>
        <td id="descrizione"><%c.getDescrizione();%></td>
        <td id="prezzo"><%c.getPrezzo();%></td>
        <td id="qt"><%c.getQuantita();%></td>
        <td><button type="submit">Elimina</button></td>
    </tr>
    </tbody>
    <!--Table body-->
</table>
<!--Table-->
<%}
} %>

</form>
<%@include file="footer.jsp"%>
</body>
<script src="js/EliminaPr.js"></script>
<script>$.getJSON("prova", function (json) {

    $.each(json, function() {
        $("#main").append(constractCard(this))

    })
})</script>

</html>
