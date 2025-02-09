package test;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
	AdminBean ab=new AdminLoginDA0().login(req);
	if(ab==null) {
		req.setAttribute("msg","Invalid Login Process..<br>");
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		rd.forward(req, res);
	}
	else {
		HttpSession hs=req.getSession();
		hs.setAttribute("abean", ab);
		RequestDispatcher rd=req.getRequestDispatcher("LogSuccess.jsp");
		rd.forward(req, res);
	}
}
}
