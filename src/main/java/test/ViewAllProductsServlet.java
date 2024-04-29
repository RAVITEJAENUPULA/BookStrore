package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/viewProducts")
public class ViewAllProductsServlet extends HttpServlet {
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else {
			ArrayList<ProductBean> al = new ViewAllProducctsDAO().retrieve();

					hs.setAttribute("al", al);
					RequestDispatcher rd =req.getRequestDispatcher("ViewAllProducts.jsp");
                    rd.forward(req, res);
		}
}
}
