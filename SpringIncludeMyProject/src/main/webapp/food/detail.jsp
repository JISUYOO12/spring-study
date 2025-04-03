<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
   jdk => 오라클 (X) => 11~14 
   => openjdk 
 --%>
 
 <%--
 	private int fno;
	private String poster,name,type,address,price;
  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table class="table">
   <tr>
    <td class="text-center" colspan="3">
     <img src="https://www.menupan.com${vo.poster }" style="width:650px;height:350px">
    </td>
   </tr>
   <tr>
    <td class="text-center" colspan="3"><h3>${vo.name}</h3></td>
    <td class="text-center" colspan="3"><h3>${vo.type}</h3></td>
    <td class="text-center" colspan="3"><h3>${vo.price}</h3></td>
    <td class="text-center" colspan="3"><h3>${vo.address}</h3></td>

   </tr>


  </table>
  
</body>
</html>