<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.Shouye"%>
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
            <li><a href="/store/GBServlet?action=select">contact</a></li>
          
          
            </ul>
        </div>    
            
            
       </div> 
       
       
       <div class="center_content">
       	<div class="left_content">
        	<div class="crumb_nav">
            <a href="/store/foreground/index.jsp">home</a> &gt;&gt;短裙
            </div>
            <div class="title"><span class="title_icon"><img src="/store/foreground/images/bullet1.gif" alt="" title="" /></span>短裙</div>
        
        	<div class="feat_prod_box_details">
            
            	<div class="prod_img"><a href="#"><img src="/store/foreground/images/duanqun.png" alt="" width="111" height="106" title="" border="0" /></a>
                <br /><br />
                <a href="/store/foreground/images/prod1.gif" rel="lightbox"><img src="/store/foreground/images/zoom.gif" alt="" title="" border="0" /></a>
              </div>
                 <% Shouye sy=(Shouye)session.getAttribute("sy3"); %>
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">更多细节</div>
                    <p class="details"> 新款学院风秋冬季毛呢裙子半身裙群子百褶格子韩版短裙呢子学生裙            </p>
                    <div class="price"><strong>价格:</strong> <span class="red">78.90元</span></div>
                     <form action="/store/CartServlet">
                      <input type="hidden" name="action" value="add"/>
                    <input type="hidden" name="sid" value="<%=sy.getSid() %>"/> &nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;  
                    <input  type="text" name="number" value="1"  style="width:20px;height:20px;"/>
                   <input type="image" name="gm" src="/store/foreground/images/order_now.gif" />
                   </form>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            
              
            <div id="demo" class="demolayout">

                <ul id="demo-nav" class="demolayout">
                <li><a class="active" href="#tab1">更多</a></li>
                <li><a class="" href="#tab2">相似商品</a></li>
                </ul>
    
            <div class="tabs-container">
            
                    <div style="display: block;" class="tab" id="tab1">
                                        <p class="more_details">
廓形: A型<br/>
腰型: 高腰<br/>
货号: 483<br/>
风格: 通勤<br/>
通勤: 韩版<br/>
品牌: other/其他<br/>
裙型: A字裙<br/>
裙长: 短裙<br/>
图案: 纯色<br/>
流行元素/工艺: 口袋 纽扣<br/>
面料: 毛呢<br/>
材质: 棉<br/>
成分含量: 51%(含)-70%(含)<br/>
适用年龄: 18-24周岁<br/>
年份季节: 2016年秋季<br/>
颜色分类: 酒红色 黑色 黑白色<br/>
尺码: S M L XL<br/>


                                        </p>
                            <ul class="list">
                            <li><a href="#">秋冬季新款毛呢短裙高腰纯色金属单排扣一片式口袋A字裙半身裙</a></li>
                            <li><a href="#">新款学院风秋冬季毛呢裙子半身裙群子百褶格子韩版短裙呢子学生裙 </a></li>
                            <li><a href="#">欧美范2016秋冬新款千鸟格子羊毛呢半身裙 高腰a字包臀显瘦短裙女  </a></li>
                            <li><a href="#">2016特价秋冬新款女半身裙大码百褶短裙女裙A字裙格子裙蕾丝短裙  </a></li>                                          
                            </ul>
                                         <p class="more_details">服务承诺:
正品保证  七天无理由退换  赠运费险
                                        </p>                           
                    </div>	
                    
                            <div style="display: none;" class="tab" id="tab2">
                    <div class="new_prod_box">
                      <a href="#">短裙</a>
                        <div class="new_prod_bg">
                        <a href="#"><img src="/store/foreground/fj/duanqun1.PNG" alt="" class="thumb" title="" border="0" /></a>
                        </div>           
                    </div>
                    <!--注释内容-->
   <div class="new_prod_box">
                        <a href="#">短裙</a>
                        <div class="new_prod_bg">
                        <a href="#"><img src="/store/foreground/fj/duanqun2.PNG"  alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>                    
       
                    <div class="new_prod_box">
                        <a href="#">短裙</a>
                        <div class="new_prod_bg">
                        <a href="#"><img src="/store/foreground/fj/duanqun3.PNG"  alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>    
<!--注释内容-->
                    <div class="new_prod_box">
                        <a href="#">短裙</a>
                        <div class="new_prod_bg">
                        <a href="#"><img src="/store/foreground/fj/duanqun4.PNG"  alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="#">短裙</a>
                        <div class="new_prod_bg">
                        <a href="#"><img src="/store/foreground/fj/duanqun5.PNG"  alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="#">短裙</a>
                        <div class="new_prod_bg">
                        <a href="#"><img src="/store/foreground/fj/duanqun6.PNG"  alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div> 
      

  <!--注释内容-->
                   
                    <div class="clear"></div>
                            </div>	
            
            </div>

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
                <p>用户等级：白金</p><br/>
               <p>积分：3066</p><br/>
              
       
                    
                </ul>      
             
             </div>         
             
        
        </div><!--end of right content-->
       
       <div class="clear"></div>
       </div><!--end of center content-->
       
              
       <div class="footer"></div><!--end of right content-->
      

        <div class="right_footer">
        <a href="/store/foreground/index.jsp">home</a>


        <a href="/store/GBServlet?action=select">contact us</a>
       
        </div>
     
       </div>
 
</div>

</body>
<script type="text/javascript">

var tabber1 = new Yetii({
id: 'demo'
});

</script>

</html>