package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemDAOImp;
import com.dao.MerDAOImp;
import com.entity.Member;
import com.entity.Merchandise;
import com.my.util.Exchanger;
import com.pagedivide.bean.MemPageDivide;
import com.pagedivide.bean.MerPageDivide;

@WebServlet(urlPatterns="/MemServlet",name="MemServlet")
public class MemServlet extends HttpServlet {

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
			System.out.println("Mem"+action);
			MemPageDivide pd = new MemPageDivide();
			 HttpSession session=request.getSession();
			 String pageShowstr=request.getParameter("pageShow");
			int pageShow = 1;
			if (pageShowstr == null) {
				pageShow = 1;
			} else {
				pageShow = Integer.parseInt(pageShowstr);
			}
			List<Member> list = pd.getPageShow(pageShow);
			if (list.size() == 0) {
			
			   System.out.println("wrong  MemServlet selectall");
			} else {
               
                session.setAttribute("pageshow", pageShowstr);
			    session.setAttribute("memlist", list);
			    path="/background/memlist.jsp";
			}
		}
		
		if(action.equals("update")){
			System.out.println("Mem"+action);
			String intergalstr=request.getParameter("intergal");
			int intergal=0;
			if(intergalstr==null){
				intergal=0;
			}else{
				intergal=Integer.parseInt(intergalstr);
			}
			System.out.println("Mem update"+intergal);
			String midstr=request.getParameter("mid");
			int mid=1;
			if(midstr==null){
				System.out.println("wrong  MemServlet update mid"+mid);
			}else{
				mid=Integer.parseInt(midstr);
			}
			System.out.println("Mem update"+mid);
			
				MemDAOImp mdi=new MemDAOImp();
			    mdi.update(mid, intergal);
				 path="/MemServlet?action=selectall";
			
		}
		
		
		
		
	   if(action.equals("delete")){
		   String midstr=request.getParameter("mid");
			int mid=1;
			if(midstr==null){
				System.out.println("wrong  MemServlet update mid");
			}else{
				mid=Integer.parseInt(midstr);
			}
			MemDAOImp mdi=new MemDAOImp();
		     mdi.delete(mid);
		     path="/MemServlet?action=selectall";
		  
	   }
	   if(action.equals("add")){
		   String loginname=request.getParameter("loginname");
		   loginname=Exchanger.exchange(loginname);
		   String passwd=request.getParameter("passwd");
		   passwd=Exchanger.exchange(passwd);
		   String mname=request.getParameter("mname");
		   mname=Exchanger.exchange(mname);
		   String phonestr=request.getParameter("phone");
		   phonestr=Exchanger.exchange(phonestr);
		   int phone=0;
		   if(phonestr!=null){
			   phone=Integer.parseInt(phonestr);
		   }
		   String address=request.getParameter("address");
		   address=Exchanger.exchange(address);
		   String email=request.getParameter("email");
		   email=Exchanger.exchange(email);
		   Member mem=new Member();
		   mem.setLoginName(loginname);
		   mem.setLoginPwd(passwd);
		   mem.setmName(mname);
		   mem.setPhone(phone);
		   mem.setAddress(address);
		   mem.setEmail(email);
		   MemDAOImp mdi=new MemDAOImp();
		   mdi.insert(mem);
		   path="/MemServlet?action=selectall";
	   }
	   if(action.equals("register")){
		   String loginname=request.getParameter("loginname");
		   loginname=Exchanger.exchange(loginname);
		   String passwd=request.getParameter("passwd");
		   passwd=Exchanger.exchange(passwd);
		   String mname=request.getParameter("mname");
		   mname=Exchanger.exchange(mname);
		   String phonestr=request.getParameter("phone");
		   phonestr=Exchanger.exchange(phonestr);
		   int phone=0;
		   if(phonestr!=null){
			   phone=Integer.parseInt(phonestr);
		   }
		   String address=request.getParameter("address");
		   address=Exchanger.exchange(address);
		   String email=request.getParameter("email");
		   email=Exchanger.exchange(email);
		   Member mem=new Member();
		   mem.setLoginName(loginname);
		   mem.setLoginPwd(passwd);
		   mem.setmName(mname);
		   mem.setPhone(phone);
		   mem.setAddress(address);
		   mem.setEmail(email);
		   MemDAOImp mdi=new MemDAOImp();
		   mdi.insert(mem);
		   HttpSession session=request.getSession();
		   session.setAttribute("mem", mem);
		   path="/foreground/html/myaccount.jsp";
	   }
	   if(action.equals("isExistA")){
		   String name=request.getParameter("name");
		   name=Exchanger.exchange(name);
		   String passwd=request.getParameter("passwd");
		   passwd=Exchanger.exchange(passwd);
		   System.out.println(passwd);
		   MemDAOImp mdi=new MemDAOImp();
		   boolean flag=mdi.isExistA(name, passwd);
		   if(flag&&name.equals("admin")&&passwd.equals("admin")){
			  System.out.println(flag);
			   path="/MerServlet?action=selectall";
		   }else{
			   path="/background/login.jsp";
		   }
	   }
	   if(action.equals("isExist")){
		   String name=request.getParameter("name");
		   name=Exchanger.exchange(name);
		   String passwd=request.getParameter("passwd");
		   passwd=Exchanger.exchange(passwd);
		   System.out.println(passwd);
		   MemDAOImp mdi=new MemDAOImp();
		   boolean flag=mdi.isExistA(name, passwd);
		   if(flag){
			  System.out.println(flag);
			   Member mem=mdi.selectByName(name);
			  HttpSession session=request.getSession();
			  session.setAttribute("mem", mem);
			   path="/foreground/index.jsp";
		   }else{
			   path="/foreground/index.jsp";
		   }
	   }
	   if(action.equals("select")){
			String content=request.getParameter("content");
			content=Exchanger.exchange(content);
			MemDAOImp mdi = new MemDAOImp();
			List<Member> list = mdi.select(content);
			if (list.size() == 0) {
				HttpSession session=request.getSession();
			    session.setAttribute("memlist", list);
			    path="/background/memlist.jsp";
			} else {
               HttpSession session=request.getSession();
			    session.setAttribute("memlist", list);
			    path="/background/memlist.jsp";
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
