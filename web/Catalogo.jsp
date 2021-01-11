<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 21/10/2020
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="nav.jsp"%>
<%
    String cat= request.getParameter("cat");
    String srch= request.getParameter("srch");
    String url=null;
    if(cat != null){
        url="?cat="+ cat;

%>
    <p>
        Ricerca Per Categoria
    </p>

<%
    }else if(srch!= null){
        url="?srch="+srch.replace(' ','+');


        %>
<p>
    Ricerca Per Chiave
</p>


<% }
   request.setAttribute("url",url);
%>
<div id="main"class="mb-1"></div>
<%@include file = "footer.jsp" %>
<script src="js/add.js"></script>
<script>$.getJSON("prova${url}", function (json) {

    $.each(json, function() {
        $("#main").append(constractCard(this))

    })
})</script>
</body>
</html>
