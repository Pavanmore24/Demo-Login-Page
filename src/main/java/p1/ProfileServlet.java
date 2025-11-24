package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProfileServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<a href='index.html'> Login </a> <br>");
		out.print("<a href='LoginServlet'> Profile </a> <br>");
		out.print("<a href='LogoutServlet'> Logout </a> <br>");
		
		HttpSession session=request.getSession(false);
		
		if(session!=null) {
			out.print("<h1> Welcome to Profile</h1> <br>");
			out.print("<h1> "+ session.getAttribute("username")+"</h1>");
		}else {
			out.print("<h1>Session timeout please Relogin !!</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	
	}

}
