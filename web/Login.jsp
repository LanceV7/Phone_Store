<%@ page contentType="text/html;charset=UTF-8" %>
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

    <title>Phone Store- Login</title>
</head>
<body>
<%@include file="nav.jsp"%>

<!-- Default form login -->
<div class="container" id="verticale">
<form class="text-center border border-dark p-5" action="LoginServlet" method="post">

    <p class="h4 mb-4">Sign in</p>

    <!-- Email -->
    <input type="email" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="E-mail" name="email">

    <!-- Password -->
    <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password" name="password">

    <div class="d-flex justify-content-around">
        <div>
            <!-- Remember me -->
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
            </div>
        </div>
    </div>

    <!-- Sign in button -->
    <button class="btn btn-dark-green btn-block my-4" type="submit">Sign in</button>

    <!-- Register -->
    <p>Not a member?
        <a href="Registrazione.jsp">Register</a>
    </p>
</form>
</div>
</body>
<%@include file="footer.jsp"%>
</html>
