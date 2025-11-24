package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<a href='index.html'> Login </a> <br>");
		out.print("<a href='ProfileServlet'> Profile </a> <br>");
		out.print("<a href='LogoutServlet'> Logout </a> <br>");
		HttpSession session=request.getSession(false);
		
		
		out.print("<h1> Logout Success!!!</h1>");
		out.print("<h1>" +session.getAttribute("username")+"</h1>");
		
		session.invalidate();
	
	
	}

}
