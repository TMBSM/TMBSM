<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物商城</title>
<link rel="stylesheet" type="text/css" href="/store/foreground/css/style.css" />
<script>
window.onload=function(){
	
	//页面时钟
	
	var div2=document.getElementById("clock");
	function fun1()
	{
		var date=new Date();
		div2.innerHTML=date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	}
	setInterval(fun1,1000);
}
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
            <div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet1.gif" alt="" title="" /></span>我的账户</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
                如果您第一次使用本系统，请先按照下面的步骤注册新账号：<br/>
（1）新用户注册；<a href="/store/foreground/html/register.jsp">点击转向注册页面</a><br/>
（2）收取确认信函，点击信函中的超链接激活新账号；<br/>
（3）用您填写的账户和密码登录本系统，进入本系统您的账户。
如果您已经注册过，请在下面的输入框中填写账户和密码，登录进入本系统。
           <br/> </p>
            
              	<div class="contact_form">
                <div class="form_subtitle">登陆账户</div>
                 <form name="login" action="/store/MemServlet">  
                 <input type="hidden" name="action" value="isExist"/>        
                    <div class="form_row">
                    <label class="contact"><strong>账户:</strong></label>
                    <input type="text" class="contact_input" name="name" />
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>密码:</strong></label>
                    <input type="text" class="contact_input" name="passwd"/>
                    </div>                     

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" />
                        记住密码
                        </div>
                    </div> 

                    
                    <div class="form_row">
                    <input type="submit" class="register" value="登录" />
                    </div>   
                    
                  </form>     
                   
                </div>  
    <center><div id="clock" ></div></center>

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
                        <a href="#">电饭锅</a>
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
                
             	<div class="title"><span class="title_icon"><img src="/store/foreground/images/wangwang.PNG" alt="" title="" /></span><br/><br/>关于我</div> 
                
                <ul class="list">
                
               <p>用户名：HLZ</p><br/>
                <p>用户等级：V1</p><br/>
               <p>积分：3066</p><br/>
              
       
                    
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