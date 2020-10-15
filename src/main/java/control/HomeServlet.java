package control;

import model.Categoria;
import model.CategoriaModel;
import model.Prodotto;
import model.ProdottoModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "", loadOnStartup = 1)
public class HomeServlet extends javax.servlet.http.HttpServlet {
    private final ProdottoModel prodottoModel = new ProdottoModel();


    @Override
    public void init() throws ServletException {
        CategoriaModel categoriaModel = new CategoriaModel();

        ArrayList<Categoria> categorie = null;
        try {
            categorie = categoriaModel.doRetrieveAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().setAttribute("categorie", categorie);
        super.init();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<Prodotto> prodotti = null;
        try {
            prodotti = prodottoModel.doRetrieveAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("prodotti", prodotti);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB_INF/index.jsp");
        requestDispatcher.forward(request,response);
    }


}
