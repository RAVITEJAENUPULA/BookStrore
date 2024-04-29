package test;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;
@SuppressWarnings({ "serial", "unused" })
@WebServlet("/add")
public class ProductStore1 extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs=req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session Expired");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else {
		ProductBean pb=new ProductBean();
		pb.setpCode(req.getParameter("pid"));
		pb.setpName(req.getParameter("pname"));
		pb.setpPrice(Float.parseFloat(req.getParameter("pprice")));
		pb.setpQty(Integer.parseInt(req.getParameter("pqty")));
		int k=new AddProductDAO().insert(pb);
		if(k>0) {
			req.setAttribute("msg", "product added successfully");
			RequestDispatcher rd=req.getRequestDispatcher("AddProduct.jsp");
			rd.include(req, res);
		}
		}

	
}
	

}
