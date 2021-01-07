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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AggiungiProdottoServlet")
public class AggiungiProdottoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codiceTel"));
        String marca = request.getParameter("marca");
        String descrizione = request.getParameter("descrizione");
        int quantita = Integer.parseInt(request.getParameter("quantita"));
        double prezzo = Double.parseDouble((request.getParameter("prezzo")));
        String foto = request.getParameter("foto");

        DriverManagerConnectionPool dmcp = (DriverManagerConnectionPool) getServletContext().getAttribute("DriverManager");
        ProdottoModel prodottoModel = new ProdottoModel(dmcp);
        Prodotto prodotto = new Prodotto();

        prodotto.setCodiceTel(id);
        prodotto.setMarca(marca);
        prodotto.setDescrizione(descrizione);
        prodotto.setQuantita(quantita);
        prodotto.setPrezzo(prezzo);
        prodotto.setFoto(foto);

        try {
            prodotto = prodottoModel.doRetrieveByKey(id);
            if(prodotto != null && !prodotto.getMarca().equals(marca)){
                prodottoModel.doSave(prodotto);
                request.getSession().setAttribute("add", "Prodotto inserito");
                response.sendRedirect("Admin.jsp");
            } else{
                request.setAttribute("error", "Impossibile aggiungere prodotto");
                RequestDispatcher d = getServletContext().getRequestDispatcher("/Admin/OperazioniAdmin.jsp");
                d.forward(request, response);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
