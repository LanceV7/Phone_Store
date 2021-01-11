<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 30/10/2020
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PhoneStore.it - Aggiungi Prodotto</title>
</head>
<body>
<%@include file="nav.jsp"%>
<!-- Default form contact -->
<form class="text-center border border-light p-5" action="addProduct" method="POST">

    <p class="h4 mb-4">Inserisci Prodotto</p>

    <!-- Marca -->
    <input type="text" id="defaultContactFormName" class="form-control mb-4" name="marca" placeholder="Marca del prodotto">
    <!-- Nome -->
    <input type="text" id="defaultContactFormName" class="form-control mb-4" name="nome" placeholder="Nome del prodotto">
    <!-- Descrizione -->
    <div class="form-group">
        <textarea class="form-control rounded-0" id="exampleFormControlTextarea2" rows="3" name="descrizione" placeholder="Descrizione"></textarea>
    </div>
    <!-- Quantita -->
    <input type="number" name="quantita" class="form-control mb-4" placeholder="Inserisci la quantità">
    <!-- Prezzo -->
    <input type="number" name="prezzo" class="form-control mb-4" placeholder="Inserisci il prezzo">
    <!-- Foto -->
    <input type="url" name="foto" id="defaultContactFormEmail" class="form-control mb-4" placeholder="Url dell'immagine">

    <%
        String erroreInserimentoProdotto = (String)request.getAttribute("error");
        if(erroreInserimentoProdotto!=null){
    %>
    <span class="errore"><%=erroreInserimentoProdotto%></span><br/>
    <%
        }
    %>
    <%
        String completamentoProdotto = (String)request.getSession().getAttribute("add");
        if(completamentoProdotto!=null){
    %>
    <span class="successo"><%=completamentoProdotto%></span><br/>
    <%
            request.getSession().setAttribute("completamentoProdotto",null);
        }

    %>


    <!-- Send button -->
    <input class="btn btn-info btn-block" id = "btn" type="submit"></input>

</form>
<!--Aggiungere script per evitare inserimenti errati-->
<script>
    $("#btn").submit(function (event) {
        alert("we strunz volevi!!")
        event.preventDefault()
        return false
    })
</script>
<!-- Default form contact -->
<%@include file="footer.jsp"%>
</body>

</html>