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

@WebServlet("/EliminaProdottoServlet")
public class EliminaProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codiceTel"));
        DriverManagerConnectionPool dmcp = (DriverManagerConnectionPool) getServletContext().getAttribute("DriverManager");
        ProdottoModel prodottoModel = new ProdottoModel(dmcp);
        Prodotto prodotto = new Prodotto();
        prodotto.setCodiceTel(id);
        try {
            prodotto = prodottoModel.doRetrieveByKey(id);
            if(prodotto != null && prodotto.getCodiceTel() == id){
                prodottoModel.doDelete(id);
                request.setAttribute("completamentoEliminazioneProdotto","Prodotto Eliminato");
                RequestDispatcher d = getServletContext().getRequestDispatcher("/Admin.jsp");
                d.forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
