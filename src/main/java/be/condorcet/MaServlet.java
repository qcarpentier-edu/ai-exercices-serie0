package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MaServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    out.write("<html><head><title>Bienvenue</title></head>"
	            + "<body><h1>Bienvenue</h1>"
	            + "<p>Bonjour ");
	    
	    if (name != null && name.length() > 0)
	        out.write(name + " !");
	    else
	        out.write("cher inconnu.");
	    
	    out.write("</p></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
