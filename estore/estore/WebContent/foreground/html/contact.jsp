<%@page import="java.awt.Menu"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.Member"%>
<%@page import="com.entity.Guestbook"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物商城</title>
<link rel="stylesheet" type="text/css" href="/store/foreground/css/style.css" />
 
</head>
<body>
<div id="wrap">

       <div class="header">
       		<div class="logo"><a href="/store/foreground/index.jsp"><img src="/store/foreground/images/newlogo.gif" alt="" width="272" height="98" title="" border="0" /></a></div> 
        <div id="menu">
            <ul>                                                         
            <li><a href="/store/foreground/index.jsp">home</a></li>
            <li class="divider"></li>
            <li><a href="/store/foreground/html/myaccount.jsp">my accout</a></li>
            <li class="divider"></li>
            <li><a href="/store/foreground/html/register.jsp">register</a></li>
            <li class="divider"></li>
            <li class="selected"><a href="/store/foreground/html/contact.jsp">contact</a></li>
            </ul>
        </div>     
            
            
       </div> 
       
       
       <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet1.gif" alt="" title="" /></span>联系我们</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
               亲，收到您的付款，我们将尽快为您安排发货。快递发什么快递，到您那大约几天左右可以到，期间我们会随时为您追踪快递的。货物收到后请及时联系我们，有什么问题随时联系沟通，如果产品有什么问题或者您对我们有什么不满意的地方店内有7天无条件售后，让您购物无忧。                            
            </p>
            <body>
            <% Member mem=(Member)session.getAttribute("mem"); %>
  <form action="/store/GBServlet">
  <input type="hidden" name="action" value="add"/>
  <input type="hidden" name="mid" value="<%=mem.getMid() %>"/>
<p>  输入您的留言：
<BR>
 <input type="textarea" name ="content" WRAP ="physcial" style="width:300px;height:120px;">

<BR>
<input type="submit" value="提交信息" name ="submit">
</form>
<% List list = (List) session.getAttribute("gb");
				Iterator it = list.iterator();
				
				%> 
</div>	
           <div id="div1">
              
                <table>
               <% while (it.hasNext()) { 
				Guestbook gb=(Guestbook)it.next(); %>
				<tr>
				<%if(gb.getMid()==mem.getMid() ){ %>
				<td>id:<%=gb.getMid()%> </td>
				<td>留言：<%=gb.getContent()%> </td>
				<td>回复内容：<%=gb.getAnswerContent() %></td>
				
				<%} %></tr>
				<%} %>
                
               </table>
          </div>  
        <div class="clear"></div>
        </div><!--end of left content-->
        
        <div class="right_content">
        
                	<div class="languages_box">
            <span class="red">Languages:</span>
            <a href="#"><img src="/store/foreground/images/gb.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="/store/foreground/images/fr.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="/store/foreground/images/de.gif" alt="" title="" border="0" /></a>
            </div>
                <div class="currency">
                <span class="red">Currency: </span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#"><strong>USD</strong></a>
                </div>
                
                
              
             <div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet3.gif" alt="" title="" /></span>About Our Shop</div> 
             <div class="about">
             <p>
             <img src="/store/foreground/images/mall.PNG" alt="" title="" class="right" />
            <br/> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;天猫超市 &nbsp;&nbsp;, &nbsp;&nbsp;品牌直营,<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;新鲜到家 &nbsp;&nbsp;, &nbsp;&nbsp;贴心服务,<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;足不出户轻松搞定一切,<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;惠享品质生活!&nbsp;&nbsp; !<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;「天猫超市」,<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;实惠放心的线上超市!&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; </p>
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet4.gif" alt="" title="" /></span>Promotions</div> 
                    <div class="new_prod_box">
                        <a href="/store/MerServlet?action=select5">笔筒</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="/store/MerServlet?action=select5"><img src="/store/foreground/images/bitong.png" alt="" width="113" height="81" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="#">电饭锅e</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="#"><img src="/store/foreground/images/dianfanguo.png" alt="" width="110" height="89" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="#">护手霜</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="#"><img src="/store/foreground/images/hushoushuang.png" alt="" width="109" height="83" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>              
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet5.gif" alt="" title="" /></span>商品分类</div> 
                
                <ul class="list" >    
                <li><a href="/store/foreground/clothes.html">服饰</a></li><br/>
                <li><a href="/store/foreground/electrical.html">家电</a></li><br/>
                <li><a href="/store/foreground/food.html">食品</a></li><br/>
                <li><a href="/store/foreground/stationery.html">文具</a></li><br/>
                <li><a href="/store/foreground/makeup.html">化妆品</a></li><br/>
                  </ul>
                
             	<div class="title"><span class="title_icon"><img src="/store/foregroundimages/wangwang.PNG" alt="" title="" /></span><br/><br/>关于我</div> 
                
                <ul class="list">
                
               <p>用户名：<%=mem.getLoginName() %></p><br/>
                <p>用户等级：<%=mem.getMlevel() %></p><br/>
               <p>积分：<%=mem.getIntergal() %></p><br/>
              
       
                    
                </ul>      
             
             </div>         
             
        
        </div><!--end of right content-->
       
       <div class="clear"></div>
       </div><!--end of center content-->
       
              
       <div class="footer">

        <div class="right_footer">
        <a href="/store/foreground/index.jsp">home</a>

        <a href="/store/GBServlet?action=select">contact us</a>
        </div>
     
       </div>
    

</div>
</body>
</html>