package control;

import model.Prodotto;
import model.ProdottoModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProdottoServlet extends HttpServlet {

    private final ProdottoModel prodottoModel = new ProdottoModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int codiceTel = Integer.parseInt(req.getParameter("codiceTel"));
        Prodotto prodotto = null;
        try {
            prodotto = prodottoModel.doRetrieveByKey(codiceTel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("prodotto", prodotto);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ProdottoCard.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
