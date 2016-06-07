<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html> 
    <head>
        <title>Hello</title>
    </head>
    <body>
    <h1>All Employee</h1>
    	<table border="5">
    	<tr>
        <c:forEach var="empForm" items="${empForm}" varStatus="status">
        	<td>
    		   <table border="3">
    		  		<tr>
    		  			<td>EmpNo:</td>
    		  			<td>${empForm.empno}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>Comm:</td>
    		  			<td>${empForm.comm}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>Ename:</td>
    		  			<td>${empForm.ename}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>HireDate:</td>
    		  			<td>${empForm.hiredate}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>Job:</td>
    		  			<td>
    		  				${empForm.jobno.job_title}
    		  			</td>
    		  		</tr>	
    		  		<tr>
    		  			<td>Sal:</td>
    		  			<td>${empForm.sal}</td>
    		  		</tr>
    		  		<tr>
    		  			<td>Dept:</td>
    		  			<td>
    		  				${empForm.deptno.dname}
<%--     		  				<c:forEach var="deptAll" items="${deptAll}" varStatus="status"> --%>
<%--     		  					${deptAll.deptno eq empForm.deptno ? deptAll.dname : ""} --%>
<%--     		  				</c:forEach>	 --%>
    		  			</td>
    		  		</tr>	
<!--     		  		<tr> -->
<!--     		  			<td colspan="2"> -->
<%-- 							<form method="post" action="<c:url value='/testView/empUpdatePage' />"> --%>
<%--         						<input type="hidden" value="${empAll.empno}" name="empno" /> --%>
<!--         						<input type="submit" value="資料修改" /> -->
<!--         					</form> -->
<%--         					<form method="post" action="<c:url value='/testView/empDelete' />"> --%>
<%--         						<input type="hidden" value="${empAll.empno}" name="empno" /> --%>
<!--         						<input type="submit" value="刪除" /> -->
<!--         					</form> -->
<!--         				</td> -->
<!--         			</tr> -->
    		  		   		   
    		   </table>
    		</td>
      		  </c:forEach>
      		</tr>
      	</table> 
    </body>
</html>