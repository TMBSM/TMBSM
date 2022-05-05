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

import com.dao.DeliveryDAOImp;
import com.dao.MemDAOImp;
import com.entity.Delivery;
import com.entity.Member;
import com.my.util.Exchanger;



@WebServlet(urlPatterns="/DelServlet",name="DelServlet")
public class DelServlet extends HttpServlet {

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
			System.out.println("Del"+action);
			DeliveryDAOImp ddi=new DeliveryDAOImp();
			List<Delivery> list = ddi.selectAll();
		 
			if (list.size() == 0) {
			
			   System.out.println("wrong  DeliveryServlet selectall");
			} else {
               
             HttpSession session=request.getSession();
			    session.setAttribute("dellist", list);
			    path="/background/delivery.jsp";
			}
		}
		
		if(action.equals("update")){
			System.out.println("Del"+action);
			String dpricestr=request.getParameter("dprice");
			System.out.println("Del update"+dpricestr);
			double dprice=0;
			if(dpricestr!=null){
				dprice=Double.parseDouble(dpricestr);
				}
			String didstr=request.getParameter("did");
			int did=1;
			if(didstr==null){
				System.out.println("wrong  DelServlet update did");
			}else{
				did=Integer.parseInt(didstr);
			}
			System.out.println("Del update"+did);
			
				DeliveryDAOImp ddi=new DeliveryDAOImp();
				ddi.update(did, dprice);
				 path="/DelServlet?action=selectall";
			}
		
		
		   if(action.equals("delete")){
			   String didstr=request.getParameter("did");
				int did=1;
				if(didstr==null){
					System.out.println("wrong  DelServlet update cid");
				}else{
					did=Integer.parseInt(didstr);
				}
				DeliveryDAOImp ddi=new DeliveryDAOImp();
			     ddi.delete(did);
			     path="/DelServlet?action=selectall";
			  
		   }
		   if(action.equals("add")){
			   String dname=request.getParameter("dname");
			   dname=Exchanger.exchange(dname);
			   String dpricestr=request.getParameter("dprice");
			   dpricestr=Exchanger.exchange(dpricestr);
			   double dprice=0;
			   if(dpricestr!=null){
				   dprice=Double.parseDouble(dpricestr);
			   }
			   Delivery de=new Delivery();
			   de.setDname(dname);
			   de.setDprice(dprice);
			   DeliveryDAOImp ddi=new DeliveryDAOImp();
			   ddi.insert(de);
			   path="/DelServlet?action=selectall";
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
