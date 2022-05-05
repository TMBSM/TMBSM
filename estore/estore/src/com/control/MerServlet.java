package com.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.MerDAOImp;
import com.dao.OrderDAOImp;
import com.entity.Merchandise;
import com.entity.Orders;
import com.entity.Shouye;
import com.my.util.Exchanger;
import com.pagedivide.bean.MerPageDivide;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@WebServlet(urlPatterns="/MerServlet",name="MerServlet")
public class MerServlet extends HttpServlet {


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
			System.out.println("Mer"+action);
			MerPageDivide pd = new MerPageDivide();
			 HttpSession session=request.getSession();
			 String pageShowstr=request.getParameter("pageShow");
			int pageShow = 1;
			if (pageShowstr == null) {
				pageShow = 1;
			} else {
				pageShow = Integer.parseInt(pageShowstr);
			}
			List<Merchandise> list = pd.getPageShow(pageShow);
			if (list.size() == 0) {
			
			   System.out.println("wrong  MerServlet selectall");
			} else {
               
                session.setAttribute("pageshow", pageShowstr);
			    session.setAttribute("merlist", list);
			    path="/background/merlist.jsp";
			}
		}
		
		if(action.equals("update")){
			System.out.println("Mer"+action);
			String is=request.getParameter("special");
			int special=0;
			if(is==null){
				special=0;
			}else{
				special=Integer.parseInt(is);
			}
			System.out.println("Mer update"+special);
			String gidstr=request.getParameter("gid");
			int gid=1;
			if(gidstr==null){
				System.out.println("wrong  MerServlet update gid");
			}else{
				gid=Integer.parseInt(gidstr);
			}
			System.out.println("Mer update"+gid);
			if(is==null){
				System.out.println("wrong  MerServlet update is");
			}else{
				MerDAOImp mdi=new MerDAOImp();
				mdi.update(gid, special);
				 path="/MerServlet?action=selectall";
			}
		}
		
		
		
		
	   if(action.equals("delete")){
		   String gidstr=request.getParameter("gid");
			int gid=1;
			if(gidstr==null){
				System.out.println("wrong  MerServlet update gid");
			}else{
				gid=Integer.parseInt(gidstr);
			}
			MerDAOImp mdi=new MerDAOImp();
		     mdi.delete(gid);
		     path="/MerServlet?action=selectall";
		  
	   }
	   if(action.equals("add")){
		   System.out.println("         add  ");   
				String mername=request.getParameter("mername");
//				   mername=Exchanger.exchange(mername);
				   String categorystr=request.getParameter("category");
//				   categorystr=Exchanger.exchange(categorystr);
				   int category=0;
				   if(categorystr.equals("椋熷搧")){
					    category=1;
				   }else if(categorystr.equals("鍖栧鍝�")){
					   category=2;
				   }else if(categorystr.equals("瀹剁數")){
					   category=3;
				   }else if(categorystr.equals("鏂囧叿")){
					   category=4;
				   }else{
					   category=5;
				   }
				   String pricestr=request.getParameter("price");
//				   pricestr=Exchanger.exchange(pricestr);
				   double price=0;
				   if(pricestr!=null){
					   price=Double.parseDouble(pricestr);
				   }
				   String spricestr=request.getParameter("sprice");
//				   spricestr=Exchanger.exchange(spricestr);
				   double sprice=0;
				   if(spricestr!=null){
					   sprice=Double.parseDouble(spricestr);
				   }
				   String picture=request.getParameter("picture");
//				   picture=Exchanger.exchange(picture);
				   String merdesc=request.getParameter("merdesc");
//				   merdesc=Exchanger.exchange(merdesc);
				   String manufacturer=request.getParameter("manufacturer");
//				   manufacturer=Exchanger.exchange(manufacturer);
				   String specialstr=request.getParameter("special");
//				   specialstr=Exchanger.exchange(specialstr);
				   int special=0;
				   if(specialstr!=null){
					   special=Integer.parseInt(specialstr);
				   }
				   
				   Merchandise mer=new Merchandise();
				   System.out.println(mer.toString());
				   mer.setCategory(category);
				   mer.setManufacturer(manufacturer);
				   mer.setMername(mername);
				   mer.setPicture(picture);
				   mer.setPrice(price);
				   mer.setSprice(sprice);
				   mer.setSpecial(special);
				   mer.setMerdesc(merdesc);
				   MerDAOImp mdi=new MerDAOImp();
				   mdi.insert(mer);
				  
		  
	            
	           path="/MerServlet?action=selectall";
			
	   }
	
	   if (action.equals("select1")) {
			System.out.println("Mer"+action);
			 HttpSession session=request.getSession();
			MerDAOImp mdi=new MerDAOImp();
			Shouye sy1=mdi.selectBySid(1);
			    session.setAttribute("sy1", sy1);
			    path="/foreground/html/details1.jsp";
			}
	   if (action.equals("select2")) {
			System.out.println("Mer"+action);
			 HttpSession session=request.getSession();
			MerDAOImp mdi=new MerDAOImp();
			Shouye sy2=mdi.selectBySid(2);
			    session.setAttribute("sy2", sy2);
			    path="/foreground/html/details2.jsp";
			}
	   if (action.equals("select3")) {
			System.out.println("Mer"+action);
			 HttpSession session=request.getSession();
			MerDAOImp mdi=new MerDAOImp();
			Shouye sy3=mdi.selectBySid(3);
			    session.setAttribute("sy3", sy3);
			    path="/foreground/html/details3.jsp";
			}
	   if (action.equals("select4")) {
			System.out.println("Mer"+action);
			 HttpSession session=request.getSession();
			MerDAOImp mdi=new MerDAOImp();
			Shouye sy4=mdi.selectBySid(4);
			    session.setAttribute("sy4", sy4);
			    path="/foreground/html/details4.jsp";
			}
	   if (action.equals("select5")) {
			System.out.println("Mer"+action);
			 HttpSession session=request.getSession();
			MerDAOImp mdi=new MerDAOImp();
			Shouye sy=mdi.selectBySid(5);
			    session.setAttribute("sy5", sy);
			    path="/foreground/html/details5.jsp";
			}
	   if(action.equals("select")){
			String content=request.getParameter("content");
//			content=Exchanger.exchange(content);
			MerDAOImp mdi = new MerDAOImp();
			List<Merchandise> list = mdi.select(content);
			if (list.size() == 0) {
				HttpSession session=request.getSession();
			    session.setAttribute("merlist", list);
			    path="/background/merlist.jsp";
			} else {
            HttpSession session=request.getSession();
			    session.setAttribute("merlist", list);
			    path="/background/merlist.jsp";
			}
		}
	   
	   //上面都没执行
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
