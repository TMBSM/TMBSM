<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<script>
var x,y
var step=18 //这里是相邻两个字之间的间隔
var flag=0
var message="欢迎注册！！"; //这里放需要显示的文字
message=message.split("") //将字符串分解为数组
var xpos=new Array() //创建数组，以记录每个位置的x坐标
for (i=0;i<=message.length-1;i++) { //给每个元素先赋一个初始值
xpos[i]=-50
}
var ypos=new Array() //创建数组，以记录每个位置的y坐标
for (i=0;i<=message.length-1;i++) {
ypos[i]=-200
}
function movehandler(e){ //处理鼠标移动事件
x = (document.layers) ? e.pageX : document.body.scrollLeft+event.clientX //根据浏览器的不同，记录鼠标的水平位置
y = (document.layers) ? e.pageY : document.body.scrollTop+event.clientY //记录鼠标的垂直位置
flag=1 //鼠标位置已经改变，需要重新计算
}
function makesnake() {
if (flag==1 && document.all) { //如果是IE
for (i=message.length-1; i>=1; i--) { //处理坐标队列
xpos[i]=xpos[i-1]+step //将每一座标数据前移一格，并加上字符间距
ypos[i]=ypos[i-1]
}
xpos[0]=x+step //将新数据写进坐标数据队列尾部
ypos[0]=y
for (i=0; i<message.length-1; i++) {
var thisspan = eval("span"+(i)+".style")// 生成当前操作对象spanx.style
thisspan.posLeft=xpos[i]
thisspan.posTop=ypos[i]
}
}
else if (flag==1 && document.layers) { //如果是NS
for (i=message.length-1; i>=1; i--) { //处理坐标队列
xpos[i]=xpos[i-1]+step //将每一座标数据前移一格，并加上字符间距
ypos[i]=ypos[i-1]
}
xpos[0]=x+step //将新数据写进坐标数据队列尾部
ypos[0]=y
for (i=0; i<message.length-1; i++) { //根据数组的数据改变每一个字所在的层的坐标
var thisspan = eval("document.span"+i) //生成当前操作对象document.spanx
thisspan.left=xpos[i]
thisspan.top=ypos[i]
}
}
var timer=setTimeout("makesnake()",30) //30毫秒后再次根据情况调整各字符位置
}
</script>
</head>
<body bgcolor="ffffff" onload="makesnake()">
<script>
<!-- Beginning of JavaScript -
//这里为每个字生成一个span作为容器
for (i=0;i<=message.length-1;i++) {
document.write("<span id='span"+i+"' class='spanstyle'>")
document.write(message[i])
document.write("</span>")
}
//规定鼠标移动事件的处理过程
if (document.layers){
document.captureEvents(Event.MOUSEMOVE);
}
document.onmousemove = movehandler;
// - End of JavaScript - -->
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
            <div class="title"><span class="title_icon"><img src=/store/foreground/images/bullet1.gif" alt="" title="" /></span>Register</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
            在您开始注册之前，请先阅读以下条款：<br/> 
            一、遵守中华人民共和国法律法令和其他相关法规，不可发布破坏宪法和法律、法规的信息。<br/>
二、遵守公安部关于《计算机信息网络国际联网安全保护管理办法》的规定，自觉维护计算机信息网络的安全。<br/> 
 
三、企业或个人发布的信息要真实有效、准确完整，并不得有引人误解或者虚假的陈述。 <br/>

四、本网站建站宗旨是为医药行业供需双方搭建商务平台。网站所发布的信息是供上网人员参考，并不对信息真伪承担责任，且网站不参与任何交易过程。因此，供需双方应对交易行为自行负责。<br/> 
五、用户注册成功后，请妥善保管您的用户名和密码，以备下次发布、修改信息使用。<br/>
            </p>
            
              	<div class="contact_form">
                <div class="form_subtitle">create new account</div>
                 <form  action="/store/MemServlet">
                 <input type="hidden" name="action" value="register"/>          
                    <div class="form_row">
                    <label class="contact"><strong>用户名:</strong></label>
                    <input type="text" class="contact_input" name="loginname"/>
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>密码:</strong></label>
                    <input type="text" class="contact_input" name="passwd" />
                    </div> 
                    <div class="form_row">
                    <label class="contact"><strong>真实姓名:</strong></label>
                    <input type="text" class="contact_input" name="mname"/>
                    </div>
                    <div class="form_row">
                    <label class="contact"><strong>邮箱:</strong></label>
                    <input type="text" class="contact_input" name="email"/>
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>电话:</strong></label>
                    <input type="text" class="contact_input" name="phone" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>地址:</strong></label>
                    <input type="text" class="contact_input" name="address"/>
                    </div>                    

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" />
                        我同意 <a href="#">terms &amp; conditions</a>                        </div>
                    </div> 

                    
                    <div class="form_row">
                    <input type="submit" class="register" value="register" />
                    </div>   
                  </form>     
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
                
               <p>用户名：HZL</p><br/>
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