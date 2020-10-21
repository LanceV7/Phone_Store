<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 14/10/2020
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- meta -->
    <meta charset=utf-8>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>

    <!-- css -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/custom.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<!-- nav -->
<nav class="navbar navbar-expand-lg navbar-expand-sm navbar navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="index.jsp">
        <img src="img/logo-phonestore-bianco.png" width="250" height="50" class="d-inline-block align-top" alt="">
    </a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            &emsp;&emsp;
            <li class="nav-item  dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Brand</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="Samsung.jsp"><img class = "img-fluid" src="img/1024px-Samsung_Logo.svg.png"></a>
                    <a class="dropdown-item" href="Apple.jsp"><img class="img-fluid" src="img/59-591019_apple-logo-png-photos-apple-logo-and-name.png"></a>
                    <a class="dropdown-item" href="Huawei.jsp"><img class="img-fluid" src="img/Huawei-Logo.png"></a>
                    <a class="dropdown-item" href="Honor.jsp"><img class="img-fluid" src="img/1200px-LOGO_Honor.svg.png"></a>
                    <a class="dropdown-item" href="Xiaomi.jsp"><img class="img-fluid" src="img/Xiaomi-Logo.png"></a>
                </div>
            </li>
            &emsp;&emsp;
            <li class="navListSearch">
                <div >
                    <form class="form-inline my-2 my-lg-0" role="search" action="/search/" method="post">
                        <div class="form-group">
                            <input type="text" name="request" class="form-control" placeholder="Cerca un prodotto">
                        </div>
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerca</button>
                    </form>
                </div>
            </li>
        </ul>
        <a class="navbar-brand" href="Login.jsp">
            <img src="img/guest-32.png" width="30" height="30" class="d-inline-block align-top" alt=""> User</a>
        &emsp;&emsp;
        <a class="navbar-brand" href="Carrello.jsp">
            <img src="img/cart-64.png" width="30" height="30" class="d-inline-block align-top" alt=""> Carrello</a>
    </div>
</nav>
<%
%>
</body>
</html>
