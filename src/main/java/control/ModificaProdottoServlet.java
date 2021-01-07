package control;

import model.DriverManagerConnectionPool;
import model.Prodotto;
import model.ProdottoModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codiceTel"));
        int quantita = Integer.parseInt(request.getParameter("quantita"));
        double prezzo = Double.parseDouble(request.getParameter("prezzo"));
        DriverManagerConnectionPool dmcp = (DriverManagerConnectionPool)getServletContext().getAttribute("DriverManager");
        ProdottoModel prodottoModel = new ProdottoModel(dmcp);
        Prodotto prodotto = new Prodotto();

        prodotto.setCodiceTel(id);
        try {
            prodotto = prodottoModel.doRetrieveByKey(id);
            if(prodotto!=null && prodotto.getCodiceTel() == id){
                prodotto.setPrezzo(prezzo);
                prodotto.setQuantita(quantita);
                prodottoModel.doUpdate(prodotto);

                request.setAttribute("modificaCompletata", "Modifica avvenuta con successo");
                RequestDispatcher d = getServletContext().getRequestDispatcher("Admin.jsp");
                d.forward(request,response);
            }else{
                request.setAttribute("erroreModifica","Impossibile modifica prodotto");
                RequestDispatcher d = getServletContext().getRequestDispatcher("Admin.jsp");
                d.forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
