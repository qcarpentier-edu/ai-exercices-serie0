package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Tester cette URL : http://localhost:8080/serie_0/login?username=admin&password=1234

@WebServlet(
	    urlPatterns = {"/login"},
	    initParams = {
	        @WebInitParam(name = "username", value = "admin"),
	        @WebInitParam(name = "password", value = "1234")
	    }
	)
public class LoginServlet extends HttpServlet {
	private String username;
    private String password;

    @Override
    public void init() throws ServletException {
        username = getServletConfig().getInitParameter("username");
        password = getServletConfig().getInitParameter("password");
        
        if (username == null || password == null)
    		throw new ServletException("Aucun utilisateur ne peut se connecter actuellement.");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");

        String userInput = request.getParameter("username");
        String passInput = request.getParameter("password");

        PrintWriter out = response.getWriter();
        
        if (username.equals(userInput) && password.equals(passInput)) {
            out.println("<html><body>");
            out.println("<h1>Bienvenue, vous êtes connecté avec succès !</h1>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h1>Identifiant ou mot de passe incorrect</h1>");
            out.println("</body></html>");
        }
    }
}
