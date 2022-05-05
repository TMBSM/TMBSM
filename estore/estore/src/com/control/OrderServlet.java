package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemDAOImp;
import com.dao.OrderDAOImp;
import com.entity.Member;
import com.entity.Orders;

import com.my.util.Exchanger;
import com.pagedivide.bean.OrderPageDivide;

@WebServlet(urlPatterns="/OrderServlet",name="OrderServlet")
public class OrderServlet extends HttpServlet {

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
			System.out.println("Order"+action);
			OrderPageDivide pd = new OrderPageDivide();
			 HttpSession session=request.getSession();
			 String pageShowstr=request.getParameter("pageShow");
			int pageShow = 1;
			if (pageShowstr == null) {
				pageShow = 1;
			} else {
				pageShow = Integer.parseInt(pageShowstr);
			}
			List<Orders> list = pd.getPageShow(pageShow);
			if (list.size() == 0) {
			
			   System.out.println("wrong  OrderServlet selectall");
			} else {
               
                session.setAttribute("pageshow", pageShowstr);
			    session.setAttribute("orderlist", list);
			    path="/background/orderlist.jsp";
			}
		}
		
		if(action.equals("update")){
			System.out.println("Order"+action);
			String orderstatusstr=request.getParameter("orderstatus");
			int orderstatus=0;
			if(orderstatusstr==null){
				orderstatus=0;
			}else{
				orderstatus=Integer.parseInt(orderstatusstr);
			}
			System.out.println("Order update"+orderstatus);
			String dstatusstr=request.getParameter("dstatus");
			int dstatus=0;
			if(dstatusstr==null){
				dstatus=0;
			}else{
				dstatus=Integer.parseInt(dstatusstr);
			}
			System.out.println("Order update"+dstatus);
			String paystr=request.getParameter("pay");
			int pay=0;
			if(paystr==null){
				pay=0;
			}else{
				pay=Integer.parseInt(orderstatusstr);
			}
			System.out.println("Order pay  "+pay);
			String oidstr=request.getParameter("oid");
			int oid=1;
			if(oidstr==null){
				System.out.println("wrong  MerServlet update oid");
			}else{
				oid=Integer.parseInt(oidstr);
			}
			System.out.println("Mer update"+oid);
			
				OrderDAOImp odi=new OrderDAOImp();
				odi.update(oid, orderstatus,dstatus,pay);
				 path="/OrderServlet?action=selectall";
			
		}
		
		
		
		
	   if(action.equals("delete")){
		   String oidstr=request.getParameter("oid");
			int oid=1;
			if(oidstr==null){
				System.out.println("wrong  OrderServlet update oid");
			}else{
				oid=Integer.parseInt(oidstr);
			}
			OrderDAOImp odi=new OrderDAOImp();
		     odi.delete(oid);
		     path="/OrderServlet?action=selectall";
		  
	   }
	  if(action.equals("add")){
		  String midstr=request.getParameter("mid");
		    int mid=1;
			if(midstr==null){
				System.out.println("wrong  OrderServlet add mid");
			}else{
				mid=Integer.parseInt(midstr);
			}
			 String sumstr=request.getParameter("sum");
			    double sum=0.00;
				if(sumstr==null){
					System.out.println("wrong  OrderServlet add sum");
				}else{
					sum=Double.parseDouble(sumstr);
				}
		     String orderstatusstr=request.getParameter("orderstatus");
				    int orderstatus=1;
					if(orderstatusstr==null){
						System.out.println("wrong  OrderServlet add orderstatus");
					}else{
						orderstatus=Integer.parseInt(orderstatusstr);
					}
			  String dstatusstr=request.getParameter("dstatus");
					    int dstatus=1;
						if(dstatusstr==null){
							System.out.println("wrong  OrderServlet add dstatus");
						}else{
							dstatus=Integer.parseInt(dstatusstr);
						}
			String paystr=request.getParameter("pay");
					    int pay=1;
						if(paystr==null){
							System.out.println("wrong  OrderServlet add pay");
						}else{
							pay=Integer.parseInt(paystr);
						}
           
			Orders o=new Orders();
			o.setMid(mid);
			o.setDstatus(dstatus);
			o.setSum(sum);
			o.setPay(pay);
		    o.setOrderstatus(orderstatus);
	
		    OrderDAOImp odi=new OrderDAOImp();
		    odi.insert(o);
		    path="/OrderServlet?action=select1";
			
	  }
	  if (action.equals("select1")) {
			System.out.println("Order"+action);
			 HttpSession session=request.getSession();
			 OrderDAOImp odi=new OrderDAOImp();
			 List<Orders> list = odi.selectAll();
			    session.setAttribute("order", list);
			    path="/foreground/html/order.jsp";
			}
	  if(action.equals("deletefg")){
		   String oidstr=request.getParameter("oid");
			int oid=1;
			if(oidstr==null){
				System.out.println("wrong  OrderServlet update oid");
			}else{
				oid=Integer.parseInt(oidstr);
			}
			OrderDAOImp odi=new OrderDAOImp();
		     odi.delete(oid);
		     path="/OrderServlet?action=select1";
		  
	   }
	  if(action.equals("select")){
			String content=request.getParameter("content");
			content=Exchanger.exchange(content);
			OrderDAOImp odi = new OrderDAOImp();
			List<Orders> list = odi.select(content);
			if (list.size() == 0) {
				HttpSession session=request.getSession();
			    session.setAttribute("orderlist", list);
			    path="/background/orderlist.jsp";
			} else {
             HttpSession session=request.getSession();
			    session.setAttribute("orderlist", list);
			    path="/background/orderlist.jsp";
			}
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
