

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gugu
 */
@WebServlet("/gugu")
public class gugu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public gugu() {
        super();
    }
    
    int dan = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dan = Integer.parseInt(request.getParameter("dan"));
		PrintWriter pw = response.getWriter();
		pw.println("<head>");
		for(int i = 1 ; i < 10 ; i++) {
			pw.println("<p>"+dan + " * "+ i + " = " + dan*i +"</p>");
		}
		
		pw.print("</head>");
		pw.flush();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
