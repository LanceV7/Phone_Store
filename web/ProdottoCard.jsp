<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 14/10/2020
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.List, model.Prodotto"%>
<link rel="stylesheet" href="css/index.css">


<%
    Object obj = request.getAttribute("prodotto");
    List<Prodotto> lst = null;
    if (obj instanceof List)
        lst = (List<Prodotto>) obj;

    if(lst != null ? !lst.isEmpty() : false){
        for (Prodotto c : lst) { %>

<!-- Page Content -->
<div class="container">
    <!-- Project One -->
    <div class="row">
        <div class="col-md-5">
            <a href="#">
                <img class="img-fluid rounded mb-3 mb-md-0" src=<%c.getFoto();%> alt="">
            </a>
        </div>
        <div class="col-md-5">
            <h2><%c.getNome();%></h2>
            <p><%c.getDescrizione();%></p>
            <p><%c.getQuantita();%></p>

            <a class="btn btn-primary" href="Prodotto?id=<%c.getCodiceTel();%>}">Visualizza</a>
        </div>
    </div>
    <!-- /.row -->

</div>



<%}
} %>