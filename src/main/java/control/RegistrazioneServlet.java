package control;

import model.DriverManagerConnectionPool;
import model.Utente;
import model.UtenteModel;

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
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {

    UtenteModel utenteModel = new UtenteModel();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String error = "";
        DriverManagerConnectionPool dmcp = (DriverManagerConnectionPool)getServletContext().getAttribute("DriverManager");
        UtenteModel utenteModel = new UtenteModel(dmcp);

        try {
            String email = request.getParameter("email");
            Utente utente = new Utente();

            utente.setEmail(email);
            utente.setNome(request.getParameter("nome"));
            utente.setCognome(request.getParameter("cognome"));
            utente.setIndirizzo(request.getParameter("indirizzo"));
            utente.setPassword(request.getParameter("password"));

            utenteModel.doSave(utente);
            session.setAttribute("login", true);
            session.setAttribute("utente", utente);
            RequestDispatcher d = getServletContext().getRequestDispatcher("/index.jsp");
            d.forward(request, response);

        }catch (SQLIntegrityConstraintViolationException e)
        {  e.printStackTrace();
            request.setAttribute("Error",new Boolean(true));

        }catch (SQLException throwables) {
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
