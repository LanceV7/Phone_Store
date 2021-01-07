<%@ page import="model.Prodotto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dadea
  Date: 29/10/2020
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phone store.it - Admin</title>
</head>
<body>

<%@include file="nav.jsp"%>

<div class="card" style="width: 18rem; margin: auto; float: none; margin-bottom: 10px;margin-top: 10px;">
    <img class="card-img-top" src="https://www.curryflow.com/wp-content/uploads/2020/05/admin-icon-png-14.png-2.jpeg" alt="Card image cap">
    <div class="card-body">
        <h5 class="card-title" style="text-align: center">Benvenuto Admin</h5>
        <p class="card-text" style="text-align: center">Cosa desideri fare?</p>

            <!--AGGIUNGI PRODOTTO-->
            <!-- Button AggiungiProdotto -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#basicExampleModal">
                Aggiungere Prodotto
            </button>

            <!-- Modal -->
            <div class="modal fade" id="basicExampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog " role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Aggiungere Prodotto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <!-- Inserimento Prodotto -->
                        <form class="text-center border border-light p-5" action="AggiungiProdottoServlet" method="get">
                        <div class="modal-body">



                                <p class="h4 mb-4">Inserisci Prodotto</p>

                                <!-- Name -->
                                <input type="text" id="defaultContactFormName" class="form-control mb-4" name="marca" placeholder="Nome del prodotto">
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
                                        request.removeAttribute("error");
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
                        </div><!--DIV MODAL BODY-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
                            <button type="submit" class="btn btn-primary">Aggiungi Prodotto</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div><!--FINE MODAL ADD-->


            <!--ELIMINA PRODOTTO-->
            <!-- Button EliminaProdotto -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#basicExampleModal2">
                Eliminare Prodotto
            </button>

            <!-- Modal -->
            <div class="modal fade" id="basicExampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel2">Eliminare Prodotto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <!-- Elimina Prodotto -->
                        <form class="text-center border border-light p-5" action="EliminaProdottoServlet" method="get">
                            <div class="modal-body">
                                <p class="h4 mb-4">Elimina Prodotto</p>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">Codice</th>
                                        <th scope="col">Foto</th>
                                        <th scope="col">Nome Prodotto</th>
                                        <th scope="col">Descrizione</th>
                                        <th scope="col">Quantita</th>
                                        <th scope="col">Prezzo</th>
                                        <th scope="col"></th>
                                    </tr>
                                    </thead>
                                    <%
                                        Object obj = request.getAttribute("prodotto");
                                        List<Prodotto> lst = null;
                                        if (obj instanceof List)
                                            lst = (List<Prodotto>) obj;

                                        if(lst != null ? !lst.isEmpty() : false){
                                            for (Prodotto c : lst) { %>
                                    <tbody>
                                    <tr>
                                        <th scope="row"><%c.getCodiceTel();%></th>
                                        <td><%c.getFoto();%></td>
                                        <td><%c.getMarca();%></td>
                                        <td><%c.getDescrizione();%></td>
                                        <td><%c.getQuantita();%></td>
                                        <td><%c.getPrezzo();%></td>
                                        <td><button type="button" onclick="" class="btn btn-default"><i class="fas fa-trash-alt"></i></button></td>
                                    </tr>
                                        <%}
                                         } %>
                                </table>
                            </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
                            <button type="submit" class="btn btn-primary">Elimina Prodotto</button>
                        </div>
                    </form><!--FINE FORM-->
                </div>
                </div>
            </div>
            </div><!--FINE MODAL ADD-->


        <!--MODIFICA PRODOTTO-->
        <!--Button ModificaProdotto-->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#basicExampleModal3">
            Modificare Prodotto
        </button>
        <!-- Modal -->
        <div class="modal fade" id="basicExampleModal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog " role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel3">Modificare Prodotto</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">

                        <!-- Modifica Prodotto -->
                        <form class="text-center border border-light p-5" action="ModificaProdottoServlet" method="get">

                            <p class="h4 mb-4">Modifica Prodotto</p>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
                                <button type="submit" class="btn btn-primary">Modifica</button>
                            </div>
                        </form><!--FINE FORM-->
                    </div>
                </div>
            </div>
        </div><!--FINE MODAL ADD-->

        <!--ELIMINA UTENTE-->
        <!-- Button EliminaUtente -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#basicExampleModal4">
            Eliminare Utente
        </button>

        <!-- Modal -->
        <div class="modal fade" id="basicExampleModal4" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel4">Eliminare Utente</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <!-- Elimina Utente -->
                    <form class="text-center border border-light p-5" action="EliminaUtenteServlet" method="get">
                        <div class="modal-body">
                            <p class="h4 mb-4">Elimina utente</p>
                            <!-- Email -->
                            <input type="text" id="defaultContactFormEmail1" class="form-control mb-4" name="email" placeholder="Inserisci email">
                        </div>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
                    <button type="submit" class="btn btn-primary">Elimina </button>
                </div>
                <%
                    String erroreEliminazioneUtente = (String)request.getAttribute("erroreEliminazioneUtente");
                    if(erroreEliminazioneUtente!=null){
                %>
                <span class="errore"><%=erroreEliminazioneUtente%></span><br/>
                <%
                        request.removeAttribute("error");
                    }
                %>
                <%
                    String completamentoEliminazioneUtente = (String)request.getSession().getAttribute("completamentoEliminazioneUtente");
                    if(completamentoEliminazioneUtente!=null){
                %>
                <span class="successo"><%=completamentoEliminazioneUtente%></span><br/>
                <%
                        request.getSession().setAttribute("completamentoEliminazioneUtente",null);
                    }

                %>
                </form><!--FINE FORM-->
            </div>
        </div>
    </div><!--FINE MODAL ADD-->

</div><!--FINE CARD BODY-->
</div><!--FINE CARD-->
<%@include file="footer.jsp"%>
</body>
</html>

