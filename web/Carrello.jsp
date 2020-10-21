<%--
  Created by IntelliJ IDEA.
  User: vince
  Date: 14/10/2020
  Time: 11:54
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

    <title> Phone Store- Carrello</title>
</head>
<body>
<%@include file="nav.jsp"%>
</body>
<!--Section: Block Content-->
<section>

    <!--Grid row-->
    <div class="row">

        <!--Grid column-->
        <div class="col-lg-7">

            <!-- Card -->
            <div class="mb-3">
                <div class="pt-4 wish-list">

                    <h5 class="mb-4"> (<span>2</span> oggetti)</h5>

                    <div class="row mb-4">
                        <div class="col-md-5 col-lg-3 col-xl-3">
                            <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                                <img class="img-fluid w-100"
                                     src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12a.jpg" alt="Sample">
                                <a href="#!">
                                    <div class="mask">
                                        <img class="img-fluid w-100"
                                             src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12.jpg">
                                        <div class="mask rgba-black-slight"></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-7 col-lg-9 col-xl-9">
                            <div>
                                <div class="d-flex justify-content-between">
                                    <div>
                                        <h5>Blue denim shirt</h5>
                                        <p class="mb-3 text-muted text-uppercase small">Shirt - blue</p>
                                        <p class="mb-2 text-muted text-uppercase small">Color: blue</p>
                                        <p class="mb-3 text-muted text-uppercase small">Size: M</p>
                                    </div>
                                    <div>
                                        <div class="def-number-input number-input safari_only mb-0 w-100">
                                            <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                    class="minus decrease"></button>
                                            <input class="quantity" min="0" name="quantity" value="1" type="number">
                                            <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                    class="plus increase"></button>
                                        </div>
                                        <small id="passwordHelpBlock" class="form-text text-muted text-center">
                                            (Note, 1 piece)
                                        </small>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <a href="#!" type="button" class="card-link-secondary small text-uppercase mr-3"><i
                                                class="fas fa-trash-alt mr-1"></i> Remove item </a>
                                    </div>
                                    <p class="mb-0"><span><strong id="summary">$17.99</strong></span></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <div class="row mb-4">
                        <div class="col-md-5 col-lg-3 col-xl-3">
                            <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                                <img class="img-fluid w-100"
                                     src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13a.jpg" alt="Sample">
                                <a href="#!">
                                    <div class="mask">
                                        <img class="img-fluid w-100"
                                             src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg">
                                        <div class="mask rgba-black-slight"></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-7 col-lg-9 col-xl-9">
                            <div>
                                <div class="d-flex justify-content-between">
                                    <div>
                                        <h5>Red hoodie</h5>
                                        <p class="mb-3 text-muted text-uppercase small">Shirt - red</p>
                                        <p class="mb-2 text-muted text-uppercase small">Color: red</p>
                                        <p class="mb-3 text-muted text-uppercase small">Size: M</p>
                                    </div>
                                    <div>
                                        <div class="def-number-input number-input safari_only mb-0 w-100">
                                            <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                                                    class="minus"></button>
                                            <input class="quantity" min="0" name="quantity" value="1" type="number">
                                            <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                                                    class="plus"></button>
                                        </div>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <a href="#!" type="button" class="card-link-secondary small text-uppercase mr-3"><i
                                                class="fas fa-trash-alt mr-1"></i> Remove item </a>
                                    </div>
                                    <p class="mb-0"><span><strong>$35.99</strong></span></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <p class="text-primary mb-0"><i class="fas fa-info-circle mr-1"></i> Non ritardare l'acquisto, aggiungendo
                        articoli al carrello non significa prenotarli</p>

                </div>
            </div>
            <!-- Card -->

            <!-- Card -->
            <div class="mb-3">
                <div class="pt-4">

                    <h5 class="mb-4">Spedizione prevista per</h5>

                    <p class="mb-0"> Thu., 12.03. - Mon., 16.03.</p>
                </div>
            </div>
            <!-- Card -->

            <!-- Card -->
            <div class="mb-3">
                <div class="pt-4">

                    <h5 class="mb-4">Accettiamo :</h5>

                    <img class="mr-2" width="45px"
                         src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/visa.svg"
                         alt="Visa">
                    <img class="mr-2" width="45px"
                         src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/amex.svg"
                         alt="American Express">
                    <img class="mr-2" width="45px"
                         src="https://mdbootstrap.com/wp-content/plugins/woocommerce-gateway-stripe/assets/images/mastercard.svg"
                         alt="Mastercard">
                    <img class="mr-2" width="45px"
                         src="https://mdbootstrap.com/wp-content/plugins/woocommerce/includes/gateways/paypal/assets/images/paypal.png"
                         alt="PayPal acceptance mark">
                </div>
            </div>
            <!-- Card -->

        </div>
        <!--Grid column-->

        <!--Grid column-->
        <div class="col-lg-4">

            <!-- Card -->
            <div class="mb-3">
                <div class="pt-4">

                    <h5 class="mb-3">Riepilogo </h5>

                    <ul class="list-group list-group-flush">
                        <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                            Totale parziale
                            <span>$25.98</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                            Spedizione
                            <span>Gratis</span>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                            <div>
                                <strong>Totale </strong>
                            </div>
                            <span><strong>$53.98</strong></span>
                        </li>
                    </ul>

                    <button type="button" class="btn btn-dark-green btn-block">Checkout</button>

                </div>
            </div>
            <!-- Card -->

        </div>
        <!--Grid column-->

    </div>
    <!-- Grid row -->

</section>
<!--Section: Block Content-->

<%@include file="footer.jsp"%>
</html>
