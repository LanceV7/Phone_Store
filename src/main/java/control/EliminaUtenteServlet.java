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
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EliminaUtenteServlet")
public class EliminaUtenteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        DriverManagerConnectionPool dmcp = (DriverManagerConnectionPool) getServletContext().getAttribute("DriverManager");
        UtenteModel utenteModel = new UtenteModel(dmcp);
        Utente utente = new Utente();
        utente.setEmail(email);
        utente = utenteModel.doRetrieveByEmail(email);

            try {
                if(utente != null && utente.getEmail().equals(email)) {
                    utenteModel.doDelete(email);
                    request.setAttribute("completamentoEliminazioneUtente", "Utente eliminato");
                    RequestDispatcher d = getServletContext().getRequestDispatcher("Admin.jsp");
                    d.forward(request, response);
                }else {
                    request.setAttribute("erroreEliminazioneUtente","Impossibile eliminare l'utente");
                    RequestDispatcher d = getServletContext().getRequestDispatcher("Admin.jsp");
                    d.forward(request, response);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
