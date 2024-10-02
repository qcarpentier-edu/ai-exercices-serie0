package be.condorcet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String apiKey;
	private String connectionString;
       
    public MaServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	
    	apiKey = getInitParameter("api-key");
    	if (apiKey == null)
    		throw new ServletException("L'API Key n'est pas accessible");
    	
    	ServletContext context = getServletContext();
    	connectionString = context.getInitParameter("connection-string");
    	if (connectionString == null)
    		throw new ServletException("La chaîne de connexion n'est pas accessible.");
    };
    
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
	    
	    out.write("/<p>");
	    out.write("<p>L'API Key est " + apiKey + "</p>");
	    out.write("<p>La chaîne de connexion est " + connectionString + "</p>");
	    out.write("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
