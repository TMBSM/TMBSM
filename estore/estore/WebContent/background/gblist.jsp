<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.Category"%>
<%@page import="com.entity.Guestbook"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="./background/css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="./background/js/jquery.js"></script>
<script src="./background/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
</head>
<body>
<!--header-->
<header>
 <h1><img src="./background/images/admin_logo.png"/></h1>
 <ul class="rt_nav">
   <li><a href="/store/MerServlet?action=selectall" target="_blank" class="website_icon">站点首页</a></li>
  <li><a href="/store/GBServlet?action=selectall" class="admin_icon">DeathGhost</a></li>
  <li><a href="/store/background/login.html" class="quit_icon">安全退出</a></li>
 </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="#">起始页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>商品信息</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="/store/MerServlet?action=selectall">商品列表</a></dd>
    <dd><a href="/store/CateServlet?actionselectall">商品分类</a></dd>
    <dd><a href="/store/background/meradd.html">商品添加</a></dd>

   </dl>
  </li>
  <li>
   <dl>
    <dt>订单信息</dt>
    <dd><a href="/store/OrderServlet?action=selectall">订单列表</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>会员管理</dt>
    <dd><a href="/store/MemServlet?action=selectall">会员列表</a></dd>
    <dd><a href="/store/background/memadd.html">添加会员</a></dd>
    <dd><a href="/store/MLServlet?action=selectall">会员等级</a></dd>
   </dl>
  </li>
  
  <li>
   <dl>
   <dt>配送方式管理</dt>
    <dd><a href="/store/DelServlet?action=selectall">配送方式列表</a></dd>
    <dd><a href="/store/background/deladd.html">添加配送方式</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>Contact us</dt>
    <dd><a href="/store/GBServlet?action=selectall" class="active">留言板回复</a></dd>
   </dl>
  </li>
  <li>
   <p class="btm_infor">© 望唐集团 版权所有</p>
  </li>
 </ul>
</aside>
<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">

   
      <!--tabCont-->
      <div class="admin_tab_cont" style="display:block;">
      <!--左右分栏：左侧栏目-->
     
       <!--左右分栏：右侧栏-->
       <div algin="center">
           <table class="table fl">
            <tr>
             <th>会员编号</th>
             <th>留言内容</th>
             <th>回复内容</th>
             <th>维护</th>
            </tr>
            <% List list = (List) session.getAttribute("gblist");
				Iterator it = list.iterator();
				while (it.hasNext()) { 
				Guestbook gb=(Guestbook)it.next();
				%>
				<form action="/store/GBServlet">
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="wid" value=<%=gb.getWid() %>>
            <tr>
            <td><%=gb.getMid()%></td>
             <td class="center"><%=gb.getContent() %></td> 
             <td>  <input type="text" class="textbox textbox_295"  name="answerContent" value=<%=gb.getAnswerContent() %>></td>
            <td> <input type="submit" value="修改"></form>
             <a href="/store/GBServlet?action=delete&wid=<%=gb.getWid() %>" class="inner_btn">删除</a></td>
            </tr>
           <%} %>
           </table>
       </div>
      </div>
   
    <!--结束：以下内容则可删除，仅为素材引用参考-->
 </div>
</section>
</body>
</html>
