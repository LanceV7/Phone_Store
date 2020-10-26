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
    Object obj = request.getAttribute("prodotto");
    List<Prodotto> lst = null;
    if (obj instanceof List)
    lst = (List<Prodotto>) obj;

    if(lst != null ? !lst.isEmpty() : false){
        for (Prodotto c : lst) { %>
    <div class="card" style="width: 18rem;">
    <img class="card-img-top "width="10%" height="5%" src=<%c.getFoto();%>>
    <div class="card-body">
        <h5 class="card-title"><%c.getMarca();%></h5>
        <p class="card-text"><%c.getDescrizione();%></p>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">Disponibilità: <%c.getQuantita();%></li>
        <li class="list-group-item">Prezzo: <%c.getPrezzo();%></li>
    </ul>
    <div class="card-body">
        <a href="#" class="card-link 1" ><i class="fas fa-shopping-cart"></i>AGGIUNGI</a>
        <a href="#" class="card-link 2" >ACQUISTA</a>
    </div>
    </div>
    <%}
        } %>
