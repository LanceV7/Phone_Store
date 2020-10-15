<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 14/10/2020
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.List, model.Prodotto"%>

<%
    List<Prodotto> list =(List<Prodotto>)  request.getAttribute("prodotti");
    int size = list.size();
%>
<div class="card" style="width: 18rem;">
    <%for (Prodotto c : list) { %>
    <img class="card-img-top" src=<%c.getFoto();%>>
    <div class="card-body">
        <h5 class="card-title"><%c.getMarca();%></h5>
        <p class="card-text"><%c.getDescrizione();%></p>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">Disponibilità: <%c.getQuantita();%></li>
        <li class="list-group-item">Prezzo: <%c.getPrezzo();%></li>
    </ul>
    <div class="card-body">
        <a href="#" class="card-link"><i class="fas fa-shopping-cart"></i>AGGIUNGI</a>
        <a href="#" class="card-link"></i>ACQUISTA</a>
    </div>
    <%} %>
</div>