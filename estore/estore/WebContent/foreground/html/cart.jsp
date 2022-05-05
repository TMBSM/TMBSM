<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.Shouye"%>
<%@page import="com.cart.bean.Cart"%>
<%@page import="com.entity.Member"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物商城</title>
<link rel="stylesheet" type="text/css" href="/store/foreground/css/style.css" />
<script src="/store/foreground/js/effects.js"></script>
<script src="/store/foreground/js/java.js"></script>
<script src="/store/foreground/js/lightbox.js"></script>
<script src="/store/foreground/js/prototype.js"></script>
<script src="/store/foreground/js/scriptaculous.js"></script>
<script src="/store/foreground/js/jquery.js"></script>
<script>

$(function(){
	$("#bs").hover(function(){
	
	$(this).css("opacity","0.5").css("color","#F00");


	},function(){
	
	$(this).css("opacity","1").css("color","blue");
	
});
	});
</script>
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
            <li><a href="/store/GBServlet?action=select">contact</a></li>
          
            </ul>
        </div>      
            
            
       </div> 
       
       
       <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet1.gif" alt="" title="" /></span>我的购物车</div>
        <%
				Cart mycart = (Cart) session.getAttribute("mycart");
				if (mycart == null) {
			%>
			<a href="/store/foreground/index.jsp">当前购物车为空，请您继续购物</a>
			<%} %>
		
        	<div class="feat_prod_box_details">
            
            <table class="cart_table">
            	<tr class="cart_title">
                	<td>图片</td>
                	<td>名称</td>
                    <td>价格</td>
                    <td>数量</td>
                    <td>维护</td>               
                </tr> <% Member mem=(Member)session.getAttribute("mem"); %>
                <%
					    Map map = mycart.getCart();
						Set set = map.entrySet();
						Iterator it = set.iterator();
						while (it.hasNext()) {
					Map.Entry<Integer, Shouye> entry = (Map.Entry<Integer, Shouye>) it.next();
							Shouye sy = entry.getValue();
				%>
            	<tr> <form action="/store/CartServlet">
            	<input type="hidden" name="sid" value="<%=sy.getSid()%>"/>
				 <input type="hidden" name="action" value="update"/>
                	<td><a href="/store/MerServlet?action=<%=sy.getSid() %>"><img src="/store/foreground/images/<%=sy.getSpic() %>" alt="" width="81" height="74" class="cart_thumb" title="" border="0" /></a></td>
                	<td><%=sy.getName() %></td>
                    <td><%=sy.getSprice() %></td>
                    <td><input type="text" name="number" value="<%=sy.getNumber()%>" style="width:20px;height:20px;"/></td>
                    <td><input type="submit" value="修改"/> 
                    <a href="/store/CartServlet?action=delete&sid=<%=sy.getSid()%>">删除</a>
                    </td>        </form>      
                </tr> 
                <%} %>         

                <tr>
                <td colspan="4" class="cart_total"><span class="red">运费:</span></td>
                <td> 8元</td>                
                </tr>  
                
                <tr>
                <td colspan="4" class="cart_total"><span class="red">TOTAL:</span></td>
                <td><%=mycart.sum()+8 %></td>                
                </tr>                  
           
            </table>    
            <form action="/store/OrderServlet">
            <a href="/store/foreground/index.jsp" class="continue">&lt; continue</a>          
            <input type="hidden" name="action" value="add"/>
              <input type="hidden" name="mid"  value="<%=mem.getMid() %>"/>
            <input type="hidden" name="sum"  value="<%=mycart.sum()+8 %>"/>
             <input type="hidden" name="orderstatus"  value="1"/>
               <input type="hidden" name="dstatus"  value="0"/>
                 <input type="hidden" name="pay"  value="1"/> &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            	&nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp;&nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; 
            	<input type="image" name="checkout" src="/store/foreground/images/checkout.png" />     
                 </form>
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
             <p id="bs">
              <img src="/store/foreground/images/mall.PNG" alt="" title="" class="right" />
            <br/> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;天猫超市 &nbsp;&nbsp;, &nbsp;&nbsp;品牌直营,<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;新鲜到家 &nbsp;&nbsp;, &nbsp;&nbsp;贴心服务,<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;足不出户轻松搞定一切,<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;惠享品质生活!&nbsp;&nbsp; !<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;「天猫超市」,<br/>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;实惠放心的线上超市!&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; </p>
           
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet4.gif" alt="" title="" /></span>Promotions</div> 
                    <div class="new_prod_box">
                        <a href="#">口红</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="#"><img src="/store/foreground/images/kouhong.png" alt="" width="105" height="90" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="#">空调</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="#"><img src="/store/foreground/images/kongtiao.png" alt="" width="101" height="84" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                      
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="#"><img src="/store/foreground/images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
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
                
             	<div class="title"><span class="title_icon"><img src="/store/foreground/images/wangwang.PNG" alt="" title="" /></span><br/><br/>关于我</div> 
                
                <ul class="list">
                
               <p>用户名：<%=mem.getmName() %></p><br/>
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