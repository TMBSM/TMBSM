<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.entity.Orders"%>
<%@page import="com.entity.Member"%>
<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		
		<link rel="stylesheet" href="/store/foreground/css/common.min.css" />
		<link rel="stylesheet" href="/store/foreground/css/ms-style.min.css" />
		<link rel="stylesheet" href="/store/foreground/css/personal_member.min.css" />

		<link rel="stylesheet" href="/store/foreground/css/sui.css" />

		<style>
			progress {
				width: 300px;
				border: 1px solid #ffffff;
				background-color: #e6e6e6;
				color: #0064B4;
				/*IE10*/
			}
			
			progress::-moz-progress-bar {
				background: #FFFFFF;
			}
			
			progress::-webkit-progress-bar {
				background: #ccc;
			}
			
			progress::-webkit-progress-value {
				background: #FF7700;
			}
			a{
				color: #000000;
			}
			.sui-table th, .sui-table td {
		    padding: 16px 8px;
		    line-height: 18px;
		    text-align: center;
		    vertical-align: middle;
		    border-top: 1px solid #e6e6e6;
		    
		}
	 .sui-nav.nav-tabs > .active > a {
	    border:1px #fff solid;
	    background-color: #fff;
	     border-bottom-color: transparent; 
	    cursor: default;
	    font-weight: normal;
	    color: #F2873B;
		}
		.sui-nav.nav-tabs > li > a {
		    color: #333333;
		    line-height: 18px;
		    -webkit-border-radius: 3px 3px 0 0;
		    -moz-border-radius: 3px 3px 0 0;
		    border-radius: 3px 3px 0 0;
		    border: 1px #fff solid;
		    border-bottom: 1px #fff solid;
		    height: 30px;
		    width: 80px;
		    text-align: center;
		    padding-top: 10px;
		    font-size: 14px;
		}
		.sui-nav.nav-tabs {
		    border-bottom: 1px solid #CECECE;
		    padding-left: 5px;
		}
	
		.sui-nav.nav-tabs > li {
		    margin-bottom: -1px;
		     background-color: #fff; 
		     border-bottom: 1px #ccc solid;
		}
		.sui-nav.nav-tabs > .active {
		    border-bottom: 0;
		}
		.sui-nav.nav-tabs > li + li {
		    margin-left: -3px;
		}
		</style>
	</head>

	<body class="ms-body"><br/>
		<div id="" class="ng-top-banner"></div>
		<div class="ng-toolbar">
			<div class="ng-toolbar-con wrapper">
				
					
			  <div class="ng-toolbar-right">
					
				<div class="ng-bar-node-box myorder-handle">
						<a href="/store/foreground/index.jsp" class="ng-bar-node ng-bar-node-pr5" target="_blank"><span>返回主页</span></a>
						<div class="ng-down-box ng-d-box myorder-child" style="display:none;">
							
						</div>
					</div>
					<div class="ng-bar-node-box service-handle">
						<a href="/store/foreground/html/contact.jsp" class="ng-bar-node ng-bar-node-service ng-bar-node-fix touch-href ng-bar-node-pr5" rel="nofollow"><span>联系我们</span>
				    </a>
						
					</div>
				</div>
				<div id="ng-minicart-slide-box"></div>
			</div>
			
		</div>
		<header class="ms-header ms-header-inner ms-head-position">
			<article class="ms-header-menu">
				<style type="text/css">
					.nav-manage .list-nav-manage {
						position: absolute;
						padding: 15px 4px 10px 15px;
						left: 0;
						top: -15px;
						width: 90px;
						background: #FFF;
						box-shadow: 1px 1px 2px #e3e3e3, -1px 1px 2px #e3e3e3;
						z-index: 10;
					}
					
					.ms-nav li {
						float: left;
						position: relative;
						padding: 0 20px;
						height: 44px;
						font: 14px/26px "Microsoft YaHei";
						color: #FFF;
						cursor: pointer;
						z-index: 10;
					}
					.sui-table th {
			    font-weight: normal;
			    line-height:40px
					}
						.sui-table td {
			    font-weight: normal;
			    line-height:40px
					}
							</style>
				<div class="header-menu">
					<div class="ms-logo">
						<a class="ms-head-logo" name="Myyigou_index_none_daohangLogo"><span style="font-size: 30px;color: #fff;font-weight: bold;    line-height: 28px;;">我的买啦</span></a>

					</div>
				
					
				</div>

			</article>


		</header>
		<div id="ms-center" class="personal-member">
			<div class="cont">
				<div class="cont-side">
		
					
				<div class="cont-main">
					<div class="main-wrap mt15" style="border: 0px;">
						      <ul class="sui-nav nav-tabs" style="margin-top:0px;width: 1000px;margin-left: 30px;">
								  <li   style="margin-left: -5px;"><a href="#profile" data-toggle="tab">所有订单<span style="margin-left: 20px;color: #ccc;">|</span></a></li>
								 
					  </ul>
							<div class="profile-info">
								<div class="control-group clearfix " style="width: 1020px;margin-bottom: 0px;">
									<div style="margin-top: -60px";>
                                       
									 </div>
									
								</div>
							</div>
							
							
							<div class="tab-content" style="width: 1000px;margin-top: 10px;border:1px #fff solid; border-top:transparent;margin-left: 30px;">
								  <div id="index" class="tab-pane " style="padding: 40px 30px;">
								  </div>
								 
								<% Member mem=(Member)session.getAttribute("mem"); 
								  List list=(List)session.getAttribute("order");
								  Iterator it = list.iterator();
								  while (it.hasNext()) { 
				                    Orders o=(Orders)it.next();
				                    if(mem.getMid()==o.getMid()){
								%>
								 <div style="margin-top: 30px;width: 78%;height: 250px;border: 1px #addff8 solid;">
								 <div style="width: 100%;height: 50px;background-color: #eaf9ff;vertical-align: middle;font-size: 12px;">
								<span style="line-height: 50px;"></span>
								<span style="line-height: 50px;margin-left: 20px;">订单号：<%=o.getOid() %></span>
								<span style="line-height: 50px;margin-left: 100px;">Store</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
							    <span>和我联系</span> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							    <span>订单时间<%=o.getOrderdate().toString() %></span>
								 </div>	
								 <div style="float: left;width: 45%;height: 100px;">
								 	<div style="width: 100%;"><br/>
								 	<img src="/store/foreground/images/mall.PNG" style="height: 100px;float: left;" />
								 	
								 
								    
								    <dl style="float: left; margin-right: 50px; margin-top: 50px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 天猫超市&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								    <a href="/store/foreground/html/contact.jsp">投诉卖家</a> 
								    </dl>
								    </div>
								    <div style="border-top: 0px #addff8 solid;height: 100px;width: 100%;margin-top: 110px;padding-top: 20px;">
								    </div>
								    
								    
								 </div>	
								 
								 <div style="float: left;border-left: 1px #addff8 solid;width:22%;height:200px;text-align: center;">
								 	
								 	<span style="font-weight: bold;margin-top: 50px;display: block;"><%=o.getSum() %></span>
								 	<dl>(含运费:8.00)</dl>
								 
								 </div>
								 <div style="float: left;border-left: 1px #addff8 solid;width: 15%;height:200px;text-align: center ;">
								 	<dl style="margin-top: 40px;">
								 	<% String orderstatus="";
								 	if(o.getOrderstatus() ==0){
								 	  orderstatus="未付款";
								 	}else{
								 	 orderstatus="已付款";
								 	} %>
								 	
								 	<%=orderstatus %></dl><br/>
								 	<dl>
								 		<% String dstatus="";
								 	if(o.getDstatus() ==0){
								 	  dstatus="未发货";
								 	}else if(o.getDstatus() ==1){
								 	 dstatus="已发货";
								 	}else{
								 	 dstatus="已签收";
								 	} %>
								 	<%=dstatus %></dl><br/>
								 	<dl>
								 		<% String pay="";
								 	if(o.getPay() ==0){
								 	  pay="现付";
								 	}else{
								 	 pay="到付";
								 	} %><%=pay %>
								 	</dl>
								 	
								 </div>
								 <div style="float: left;border-left: 1px #addff8 solid;width: 17%;height:200px;text-align: center ;">
								 
								 	<dl style="margin-top: 80px;"><a href="/store/OrderServlet?action=deletefg&&oid=<%=o.getOid() %>">删除</a></dl>
								
								 </div>
								 </div>
					
								 
								 <%}} %>
								 
								
				
								  	
				

			</div>
		</div>
		</div>
		
		<style type="text/css">
			.fenye{
				    border: 1px #ccc solid;
				     padding: 3px; 
				    width: 20px;
			}
			.ng-footer {
				height:514px;
				margin-top: 0;
			}
			
			.ng-s-footer {
				height: 130px;
				background: none;
				text-align: center;
			}
			
			.ng-s-footer p.ng-url-list {
				height: 25px;
				line-height: 25px;
			}
			
			.ng-s-footer p.ng-url-list a {
				color: #666666;
			}
			
			.ng-s-footer p.ng-url-list a:hover {
				color: #f60;
			}
			
			.ng-s-footer .ng-authentication {
				float: none;
				margin: 0 auto;
				height: 25px;
				width: 990px;
				margin-top: 5px;
			}
			
			.ng-s-footer p.ng-copyright {
				float: none;
				width: 100%;
			}
			
			.root1200 .ng-s-footer p.ng-copyright {
				width: 100%;
			}
		</style>
		<script type="text/javascript" src="/store/foreground/js/ms_common.min.js"></script>
	</body>

</html>