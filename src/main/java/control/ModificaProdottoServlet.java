package control;

import model.DriverManagerConnectionPool;
import model.Prodotto;
import model.ProdottoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DriverManagerConnectionPool dmcp= (DriverManagerConnectionPool)getServletContext().getAttribute("DriverManager");
        ProdottoModel prodotto = new ProdottoModel(dmcp);
        Prodotto bean= new Prodotto();
        bean.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
        bean.setQuantita(Integer.parseInt(request.getParameter("quantita")));
        try {
            prodotto.doUpdate(bean);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
