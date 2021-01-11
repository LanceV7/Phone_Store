package control;

import model.DriverManagerConnectionPool;
import model.Prodotto;
import model.ProdottoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/addProduct")
public class AggiungiProdottoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String marca = request.getParameter("marca");
        String nome= request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        int quantita = Integer.parseInt(request.getParameter("quantita"));
        double prezzo = Double.parseDouble((request.getParameter("prezzo")));
        String foto = request.getParameter("foto");

        ProdottoModel prodottoModel = new ProdottoModel();
        Prodotto prodotto = new Prodotto();

        prodotto.setMarca(marca);
        prodotto.setNome(nome);
        prodotto.setDescrizione(descrizione);
        prodotto.setQuantita(quantita);
        prodotto.setPrezzo(prezzo);
        prodotto.setFoto(foto);
        try {
            prodottoModel.doSave(prodotto);
            request.getSession().setAttribute("update", "Prodotto inserito");
            response.sendRedirect("Admin.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        out.write("Error: GET method is used but POST method is required");
        out.close();
    }
}

