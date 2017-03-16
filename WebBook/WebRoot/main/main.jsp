<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table align="center" width="90%">
	       <c:if test="${user==null}">
	       		<tr align="right">  <td> <a href="<%=basePath%>LoginSvl"> 登录 </a>    </td> </tr>
           </c:if>
           <c:if test="${user!=null}">
               <tr align="right"><td>welcom you ${user.uname} &nbsp;
                    <c:if test="${user.role==3}">
                         <a href="<%=basePath%>back/BookAddSvl"> 后台 </a> &nbsp;
                    </c:if>
                   <a href="<%=basePath%>LogoutSvl">退出</a>  </td></tr>               
           </c:if>
		   <tr>
                 <td>
                       <h1>北京天安门，你好！</h1>
						 <h2>北京天安门，你好！</h2>
					     <h3>相对地址的图片显示</h3>

							 <img  src="../pic/ant.jpg" />
							 
							 <h3>绝对地址</h3>  
							 
							 <img  src="http://10.0.17.253:8081/WebBook/pic/ant.jpg" />
	   			 </td>
		   </tr>

	   </table>

  </body>
</html>
