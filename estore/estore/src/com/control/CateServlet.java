package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CateDAOImp;
import com.dao.MerDAOImp;
import com.entity.Category;
import com.my.util.Exchanger;


@WebServlet(urlPatterns="/CateServlet",name="CateServlet")
public class CateServlet extends HttpServlet {

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
			System.out.println("Cate"+action);
			CateDAOImp cdi=new CateDAOImp();
			List<Category> list = cdi.selectAll();
		 
			if (list.size() == 0) {
			
			   System.out.println("wrong  CateServlet selectall");
			} else {
               
             HttpSession session=request.getSession();
			    session.setAttribute("catelist", list);
			    path="/background/mercategory.jsp";
			}
		}
		
		if(action.equals("update")){
			System.out.println("Cate"+action);
			String cdesc=request.getParameter("cdesc");
			String teststr = request.getQueryString();
//			cdesc = URLDecoder.decode(cdesc,"utf-8");
//			cdesc=Exchanger.exchange(cdesc);
			System.out.println("Cate update"+cdesc);
			String cidstr=request.getParameter("cid");
			
			int cid=1;
			if(cidstr==null){
				System.out.println("wrong  CateServlet update cid");
			}else{
				cid=Integer.parseInt(cidstr);
			}
			System.out.println("Mer update"+cid);
			if(cdesc==null){
				System.out.println("wrong  CateServlet update is");
			}else{
				CateDAOImp cdi=new CateDAOImp();
				cdi.update(cid, cdesc);
				 path="/CateServlet?action=selectall";
			}}
		
		
		   if(action.equals("delete")){
			   String cidstr=request.getParameter("cid");
				int cid=1;
				if(cidstr==null){
					System.out.println("wrong  CateServlet update cid");
				}else{
					cid=Integer.parseInt(cidstr);
				}
				CateDAOImp cdi=new CateDAOImp();
			     cdi.delete(cid);
			     path="/CateServlet?action=selectall";
			  
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
