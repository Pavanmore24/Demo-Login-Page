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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	out.print("<a href='index.html'> Login </a> <br>");
	out.print("<a href='ProfileServlet'> Profile </a> <br>");
	out.print("<a href='LogoutServlet'> Logout </a> <br>");
	
	String name=request.getParameter("uname");
	String pass=request.getParameter("pass");
	
	if(name.equals("root") && pass.equals("root")) {
		HttpSession session=request.getSession();
		session.setAttribute("username",name);
		out.print("<h1> Welcome login success !!</h1>");
	}else {
		out.print("<h1> Invalid credential relogin please!! </h1>");
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request, response);
	}
	
	
	
	}

}
