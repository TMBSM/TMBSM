package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MlevelDAOImp;
import com.entity.Mlevel;




@WebServlet(urlPatterns="/MLServlet",name="MLServlet")
public class MLServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action == null) {
			action = "selectall";
		}
		String path="";
		
		if (action.equals("selectall")) {
			System.out.println("ML"+action);
			MlevelDAOImp mdi=new MlevelDAOImp();
			List<Mlevel> list = mdi.selectAll();
		 
			if (list.size() == 0) {
			
			   System.out.println("wrong MLServlet selectall");
			} else {
               
             HttpSession session=request.getSession();
			    session.setAttribute("MLlist", list);
			    path="/background/mlevel.jsp";
			}
		}
		
		if(action.equals("update")){
			System.out.println("ML"+action);
			String favourablestr=request.getParameter("favourable");
			System.out.println("ML update"+favourablestr);
			String lidstr=request.getParameter("lid");
			int lid=1;
			if(lidstr==null){
				System.out.println("wrong  MLServlet update lid");
			}else{
				lid=Integer.parseInt(lidstr);
			}
			System.out.println("ML update"+lid);
			double favourable=0;
			if(favourablestr==null){
				System.out.println("wrong  MLServlet update is");
			}else{
				favourable=Double.parseDouble(favourablestr);
			}
				MlevelDAOImp mdi=new MlevelDAOImp();
				mdi.update(lid, favourable);
				 path="/MLServlet?action=selectall";
			}
		
		
		   if(action.equals("delete")){
			   String lidstr=request.getParameter("lid");
				int lid=1;
				if(lidstr==null){
					System.out.println("wrong  MLServlet update lid");
				}else{
					lid=Integer.parseInt(lidstr);
				}
				MlevelDAOImp mdi=new MlevelDAOImp();
			     mdi.delete(lid);
			     path="/MLServlet?action=selectall";
			  
		   }
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
