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

import com.dao.GuestbookDAOImp;
import com.dao.MemDAOImp;
import com.entity.Guestbook;
import com.entity.Member;
import com.my.util.Exchanger;


@WebServlet(urlPatterns="/GBServlet",name="GBServlet")
public class GBServlet extends HttpServlet {

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
			System.out.println("GB"+action);
			GuestbookDAOImp cdi=new GuestbookDAOImp();
			List<Guestbook> list = cdi.selectAll();
		 
			if (list.size() == 0) {
			
			   System.out.println("wrong  GBServlet selectall");
			} else {
               
             HttpSession session=request.getSession();
			    session.setAttribute("gblist", list);
			    path="/background/gblist.jsp";
			}
		}
		if (action.equals("select")) {
			System.out.println("GB"+action);
			GuestbookDAOImp cdi=new GuestbookDAOImp();
			List<Guestbook> list = cdi.selectAll();
		 
		
               
             HttpSession session=request.getSession();
			    session.setAttribute("gb", list);
			    path="/foreground/html/contact.jsp";
			
		}
		if(action.equals("update")){
			System.out.println("GB"+action);
			String answerContent=request.getParameter("answerContent");
			System.out.println("GB update"+answerContent);
			String widstr=request.getParameter("wid");
			int wid=1;
			if(widstr==null){
				System.out.println("wrong  GBServlet update wid");
			}else{
				wid=Integer.parseInt(widstr);
			}
			System.out.println("GB update"+wid);
			if(answerContent==null){
				System.out.println("wrong  GBServlet update answerContent");
			}else{
				GuestbookDAOImp cdi=new GuestbookDAOImp();
				cdi.update(wid, answerContent);
				 path="/GBServlet?action=selectall";
			}}
		
		
		   if(action.equals("delete")){
			   String widstr=request.getParameter("wid");
				int wid=1;
				if(widstr==null){
					System.out.println("wrong  GBServlet update wid");
				}else{
					wid=Integer.parseInt(widstr);
				}
				GuestbookDAOImp cdi=new GuestbookDAOImp();
			     cdi.delete(wid);
			     path="/GBServlet?action=selectall";
			  
		   }
		   if(action.equals("add")){
			   String content=request.getParameter("content");
			   content=Exchanger.exchange(content);
			   String midstr=request.getParameter("mid");
			   midstr=Exchanger.exchange(midstr);
			   int mid=0;
			   if(midstr!=null){
				   mid=Integer.parseInt(midstr);
			   }
			   GuestbookDAOImp gbdi=new GuestbookDAOImp();
			   Guestbook gb=new Guestbook();
			   gb.setMid(mid);
			   gb.setContent(content);
			   gbdi.insert(gb);
			   path="/GBServlet?action=select";
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
