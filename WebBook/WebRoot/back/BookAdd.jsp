<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BookAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">	
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
     <table align="center" width=90%>
    	 <tr>
      	<td align=right>
      	    
      	  		管理员: admin &nbsp;	  		       	         	    	         	          	  	
      		
      			<a href="<%=basePath%>LogoutSvl">退出</a>
      		      	
      	</td>       	
      </tr>
      <tr>
      	<td align=center>
      	    <a href="#">新书上架</a> &nbsp;  <a href="#">书增加库存</a>  &nbsp;  <a href="#">书下架</a> &nbsp;  <a href="#">用户管理</a>
      	    &nbsp;  <a href="#">修改售价</a> &nbsp; <a href="#">用户购买记录</a>
      	</td>
      	</tr>    	
      <tr><td align="left"><h2>新书上架</h2></td></tr>
      <tr>
      	<td>
      	<form action="<%=basePath%>back/BookAddSvl" method="post"">
      		<table border="0" width=60% align="center">  		
      		
      			<tr><td>书号ISBN</td><td><input type="text" name="isbn"/></td></tr>
       			<tr><td>书名</td><td><input type="text" name="bname"/></td></tr>
       			<tr><td>作者</td><td><input type="text" name="author"/></td></tr>
       			<tr><td>出版社</td><td><input type="text" name="press"/></td></tr>
       			<tr><td>出版日期</td><td><input class="easyui-datebox" name="pdate"/></td></tr>
       			<tr><td>价格</td><td><input class="easyui-numberbox" precision="2" value="0.0" name="price"/></td></tr>
       			<tr><td>图片路径</td><td><input type="text" name="picurl"/></td></tr>
       			<tr><td colspan=2 align=center><input type=submit value=提交 /></td></tr>
       			<tr><td colspan=2> ${msg}</td></tr>
    		</table>
    	</form>
      	</td>
      </tr>
    </table>

  </body>
</html>
