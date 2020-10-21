package control;

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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Utente utente = new Utente();
        utente.setEmail(email);
        utente.setPassword(password);
        UtenteModel utenteModel = new UtenteModel();
        try {
            utente = utenteModel.doRetrieveByKey(email);
            if(utente!=null && utente.getEmail().equals(email) && utente.getPassword().equals(password)){
                session.setAttribute("login", true);
                session.setAttribute("utente",utente);
                response.sendRedirect("index.jsp");
            }else{
                String errore="Email o password ";
                request.setAttribute("errore", errore);
                RequestDispatcher d = getServletContext().getRequestDispatcher("../Login.jsp");
                d.forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        out.write("Error: GET method is used but POST method is required");
        out.close();
    }
}