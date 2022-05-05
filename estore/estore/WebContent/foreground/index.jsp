<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>购物商城</title>
<link rel="stylesheet" type="text/css" href="/store/foreground/css/style.css" />
<link rel="stylesheet" href="/store/foreground/css/lightbox.css" type="text/css" media="screen" />

<script src="/store/foreground/js/prototype.js" type="text/javascript"></script>
	<script src="/store/foreground/js/scriptaculous.js?load=effects" type="text/javascript"></script>
	<script src="/store/foreground/js/lightbox.js" type="text/javascript"></script>
    <script type="text/javascript" src="/store/foreground/js/java.js"></script>
<script src="/store/foreground/js/jquery.js"></script>

</head>
<body>

<div id="wrap">

       <div class="header">
       		<div class="logo"><a href="/store/foreground/index.jsp"><img src="/store/foreground/images/newlogo.gif" alt="" width="272" height="98" title="" border="0" /></a></div>            
        <div id="menu">    
            <ul>                                                        
            <li class="selected"><a href="/store/foreground/index.jsp">home</a></li>
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
        	
            <div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet1.gif" alt="" title="" /></span>Featured products</div>
        
        	<div class="feat_prod_box">
            
            	<div class="prod_img"><a href="/store/foreground/index.jsp"><img src="/store/foreground/images/prod1.gif" alt="" width="134" height="128" title="" border="0" /></a>
                <br/> 
                <a href="/store/foreground/images/prod1.gif" rel="css/lightbox"><img src="/store/foreground/images/zoom.gif" alt="" title="" border="0" /></a><br/>
           	   </div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">小米5</div>
                    <p class="details">正品Samsung/三星 Galaxy S6 Edge SM-G9250曲屏全网通4G智能手机</p>
                    <a href="/store/MerServlet?action=select1" class="more">- 更多 -</a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            
            
        	<div class="feat_prod_box">
            
            	<div class="prod_img"><a href="/store/foreground/index.jsp"><img src="/store/foreground/images/guogan.png" alt="" width="129" height="126" title="" border="0" /></a>
                 <br/> 
                <a href="/store/foreground/images/guogan.png" rel="css/lightbox"><img src="/store/foreground/images/zoom.gif" alt="" title="" border="0" /></a><br/>
                </div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">菠萝干</div>
                    <p class="details">【良品铺子-菠萝片100g*3袋】凤梨干果脯果干菠萝圈小零食包邮</p>
                     <a href="/store/MerServlet?action=select2" class="more">- 更多 -</a>
                     <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>      
            
            
            
           <div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet2.gif" alt="" title="" /></span>New products</div> 
           
           <div class="new_products">
           
                    <div class="new_prod_box">
                        <a href="/store/MerServlet?action=select3">短裙</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/new_icon.gif" alt="" title="" /></span>
                        <a href="/store/MerServlet?action=select3"><img src="/store/foreground/images/duanqun.png" alt="" width="120" height="91" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="#">风衣</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/new_icon.gif" alt="" title="" /></span>
                        <a href="#"><img src="/store/foreground/images/fengyi.png" alt="" width="110" height="88" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="#">棉服e</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/new_icon.gif" alt="" title="" /></span>
                        <a href="#"><img src="/store/foreground/images/mianfu.png" alt="" width="104" height="91" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="/store/MerServlet?action=select4">短袖</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/new_icon.gif" alt="" title="" /></span>
                        <a href="/store/MerServlet?action=select4"><img src="/store/foreground/images/duanxiu.png" alt="" width="107" height="92" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="#">坚果</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/new_icon.gif" alt="" title="" /></span>
                        <a href="#"><img src="/store/foreground/images/jianguo.png" alt="" width="107" height="90" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="#">毛衣</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/new_icon.gif" alt="" title="" /></span>
                        <a href="#"><img src="/store/foreground/images/maoyi.png" alt="" width="110" height="95" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>                    
                    
                              
            
            </div> 
          
            
        <div class="clear"></div>
        </div><!--end of left content-->
        
        <div class="right_content">
        	<div class="languages_box">
            <span class="red">Languages:</span>
            <a href="#" class="selected"><img src="/store/foreground/images/gb.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="/store/foreground/images/fr.gif" alt="" title="" border="0" /></a>
            <a href="#"><img src="/store/foreground/images/de.gif" alt="" title="" border="0" /></a>
            </div>
                <div class="currency">
                <span class="red">Currency: </span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#" class="selected">USD</a>
                </div>
       
             <div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet3.gif" alt="" title="" /></span>our shop</div> 
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
                        <a href="/store/foreground/html/details.html">护手霜</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="/store/foreground/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="/store/foreground/html/details.html"><img src="/store/foreground/images/hushoushuang.png" alt="" width="109" height="83" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>              
             
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet5.gif" alt="" title="" /></span>商品分类</div> 
                
                <ul class="list" >
                
              <ul class="list" >
                  <li><a href="/store/foreground/clothes.html">服饰</a></li><br/>
                <li><a href="/store/foreground/electrical.html">家电</a></li><br/>
                <li><a href="/store/foreground/food.html">食品</a></li><br/>
                <li><a href="/store/foreground/stationery.html">文具</a></li><br/>
                <li><a href="/store/foreground/makeup.html">化妆品</a></li><br/>        
                </ul>

                                              
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