package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cart.bean.Cart;
import com.dao.MerDAOImp;
import com.entity.Shouye;
import com.my.util.Exchanger;

@WebServlet(urlPatterns="/CartServlet",name="CartServlet")
public class CartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
	    String action=request.getParameter("action");
	    if(action==null){
	    	action="show";
	    }
	    System.out.println(action);
	    String path="";
	    if(action.equals("show")){
	      path="/foreground/index.jsp";
	    }
	    if(action.equals("add")){
	    	 String sidstr = request.getParameter("sid");
				int sid = -1;
				if (sidstr == null) {
					sid = -1;
				} else {

					sid = Integer.parseInt(sidstr);
					System.out.println(sid);
				}
				String numberstr = request.getParameter("number");
	            numberstr=Exchanger.exchange(numberstr);
				int number = 1;
				if (numberstr == null) {
					number = 1;
				} else {
					number = Integer.parseInt(numberstr);
				}
				MerDAOImp mdi=new MerDAOImp();
				Shouye sy = mdi.selectBySid(sid);//鎵惧埌瀹炰綋绫�
				sy.setNumber(number);//璁剧疆鏁伴噺
				HttpSession session=request.getSession();
				Cart mycart = (Cart) session.getAttribute("mycart");
				if (mycart == null) {//鍒ゆ柇涓�娆″姞鍏ヨ喘鐗╄溅
					mycart = new Cart();//鍒涘缓鏂扮殑璐墿杞�
					mycart.addGood(sy);
					session.setAttribute("mycart", mycart);
				} else {
					mycart.addGood(sy);
					session.setAttribute("mycart", mycart);
				}
			    path="/foreground/html/cart.jsp";
	     }
	    
	    if(action.equals("update")){
	    	 String numberstr=request.getParameter("number"); 
	    	    int number=1; 
	    	    if(numberstr==null){ 
	    	      number=1; 
	    	    }else{ 
	    	     number=Integer.parseInt(numberstr);  
	    	     System.out.println(number);
	    	    }
	    	    String sidstr=request.getParameter("sid"); 
	    	    int sid=-1; 
	    	    if(sidstr==null){ 
	    	      sid=-1; 
	    	    }else{ 
	    	     sid=Integer.parseInt(sidstr); 
	    	    } 
	    	    HttpSession session=request.getSession();
	    	    Cart mycart=(Cart)session.getAttribute("mycart");
	    	    if(mycart!=null){
	    	              mycart.updateGood(sid,number);
	    	        session.setAttribute("mycart",mycart);}else{
	    	        	System.out.println("mycart閲岄潰娌℃湁鏁版嵁");
	    	        }
	    	        path="/foreground/html/cart.jsp";
	    }
	    if(action.equals("delete")){
	    	  String sidstr=request.getParameter("sid"); 
	    	    int sid=-1; 
	    	    if(sidstr==null){ 
	    	      sid=-1; 
	    	    }else{ 
	    	     sid=Integer.parseInt(sidstr); 
	    	     System.out.println(sid);
	    	    } 
	    	    MerDAOImp mdi=new MerDAOImp();
				Shouye sy = mdi.selectBySid(sid);//鎵惧埌瀹炰綋绫�
	    	    HttpSession session=request.getSession();
	    	    Cart mycart=(Cart)session.getAttribute("mycart");
	    	  if(mycart!=null){
	    	               mycart.deleteGood(sy);
	    	        session.setAttribute("mycart",mycart);}else{
	    	        	System.out.println("鍒犻櫎澶辫触");
	    	        }
	    	        path="/foreground/html/cart.jsp";
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
