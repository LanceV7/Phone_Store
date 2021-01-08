<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 15/10/2020
  Time: 12:22
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
    <link href="data:image/x-icon;base64,AAABAAEAEBAAAAEACABoBQAAFgAAACgAAAAQAAAAIAAAAAEACAAAAAAAAAEAAAAAAAAAAAAAAAEAAAAAAAD7+/sARUZGABkbGwAbGxsAJCQkAP39/QAbHR0ASEhIABwdHQAdHR0A5OTkAPb29gD///8AHR8fAB4fHwAfHx8A5ubmAPj4+ADf398AISEhAOjo6AD6+voAGhoaACMjIwA9Pj4A/Pz8ABocHAAcHBwA4+PjABMVFQD+/v4AQEBAABweHgAdHh4AHh4eAOXl5QD39/cAHiAgAKqqqgAfICAAICAgAIiIiADn5+cA+fn5ABkZGQDp6ekAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAER4BBiAgICAgICAdGBkMAAwKDwwADBImDBUeKhMVKwwADAkeFRUeKR4rBR4bDCsFHgAPIyghIRohICIVAyoMHgwFEwwEGiUGBg0WJBYeLQwRDA8AIg0CICAGGx4bEQwLDCoJBRMGDQYgIAkqGx4ZDBkMIhkPIAYNBiADDAkMKwAeACIQKA0GBg0GCRUDKgwMDB4TDBcaJQYGDRYLAwwqDBEMDxkiDRogIAYPHhsRDAsMFAkZEwYNBiAgCSobBRkMGQwPBQ8gBg0GIBYMCQwrGQUMIioiDycODggsABYUDAweHhYFHAwMBQwtGRUiHhAMHhUfFhsbLAkJGxssBwwMEQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=" rel="icon" type="image/x-icon" />
    <link rel="stylesheet" href="css/div_css.css">
    <script src="js/validation.js"></script>
    <title>Phone Store- Registrazione</title>

</head>
<body>
<%@include file="nav.jsp"%>
<div class="container" id="verticale">
<!-- Default form register -->
    <%if(request.getAttribute("Error")!=null){ %>
    <div class="alert alert-success" role="alert">
        This is a success alert—check it out!
    </div>
    <% }%>
<form class="text-center border border-dark p-5" action="RegistrazioneServlet" method="post">

    <p class="h4 mb-4">Sign up</p>

    <div class="form-row mb-4">
        <div class="col">
            <!-- First name -->
            <input type="text"   id="defaultRegisterFormFirstName" class="form-control" placeholder="Nome" name="nome" onfocus = "focuser(this.form.name)" onblur = "blurer(this.form.name)" >
        </div>
        <div class="col">
            <!-- Last name -->
            <input type="text"  id="defaultRegisterFormLastName"  class="form-control" placeholder="Cognome" name="cognome" onfocus = "focuser(this.form.surname)" onblur = "blurer(this.form.surname)" >
        </div>
    </div>

    <!-- E-mail -->
    <input type="email" id="defaultRegisterFormEmail" class="form-control mb-4" placeholder="E-mail" name="email" onfocus = "focuser(this.form.email)" onblur = "blurer(this.form.email)" >

    <!-- Password -->
    <input type="password" id="defaultRegisterFormPassword" class="form-control" placeholder="Password" aria-describedby="defaultRegisterFormPasswordHelpBlock" name="password" onfocus = "focuser(this.form.password)" onblur = "blurer(this.form.password)">
    <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
        Almeno 8 caratteri alfanumerici
    </small>

    <!-- Indirizzo -->
    <input type="text" class="form-control" placeholder="Indirizzo" name="indirizzo" >
    <small class="form-text text-muted mb-4">
    </small>

    <!-- Sign in button -->
    <button class="btn btn-dark-green btn-block my-4" type="submit">Sign in</button>


</form>



    <script>
        $(document).ready(function() {
            $.getScript("js/validation.js");

            function validation () {
                var list = new Array (5);
                var flag = true;

                list[0] = new Validator ($("name"), /^[A-Z][a-zA-Z][^#&<>"~;$^%{}?]{1,20}$/,
                    $("nameWarning"), "there shouldn't be any numbers or special characters");
                list[1] = new Validator ($("surname"), /^[A-Z][a-zA-Z][^#&<>"~;$^%{}?]{1,20}$/,
                    $("surnameWarning"), "there shouldn't be any numbers or special characters");
                list[2] = new Validator ($("email"), /^[a-zA-Z0-9.!#$%&’+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)$/,
                    $("emailWarning"), "the inserted value is not an email");
                list[3] = new Validator ($("password"), /^(?=.[0-9])(?=.[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8,})$/,
                    $("passwordWarning"), "the password is too short or weak");


                for (var i = 0; i < 5 ; i++)
                {
                    if (!list[i]["verifier"]())
                        flag = false;
                }

                return flag;
            }
        });
    </script>
</div>
</body>
<%@include file="footer.jsp"%>
</html>
