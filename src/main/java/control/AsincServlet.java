package control;

import com.google.gson.GsonBuilder;
import model.Prodotto;
import model.ProdottoModel;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/prova")
public class AsincServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        ProdottoModel p = new ProdottoModel();
        List<Prodotto> list = null;
        try {
            String cat= req.getParameter("cat");
            String srch= req.getParameter("srch");
            if(cat != null)
                list=p.doRetrieveByCat(cat);
            else if(srch!= null)
                list=p.doRetrieveBySrch(srch);
            else
                list = p.doRetrieveAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("application/json");
        response.getWriter().write(new GsonBuilder().create().toJson(list));
    }
}