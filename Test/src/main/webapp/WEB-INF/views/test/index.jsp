<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 使用 jQuery -->
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/hot-sneaks/jquery-ui.css" rel="stylesheet">
 
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
 
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
 
<html> 
    <head>
        <title>Hello</title>
    </head>
    <body>
        <div id="create">
        	<c:set var="action">
        		<c:url value="/testView/empCreate"/>
        	</c:set>
     	   	<form:form modelAttribute="empForm" method="post" action="${action }">
     	   		姓名：<form:input path="ename" /><br/>
     	   		獎金：<form:input path="comm" /><br/>
     	   		雇用日期：<form:input path="hiredate" id="dateChooser" /><br/>
     	   		工作：<form:select path="jobno" name="jobno">
    		  			<form:options items="${jobAll}" itemLabel="job_title" itemValue="jobno"/>
    		  		</form:select><br/>
     	   		薪水：<form:input path="sal" name="sal" /><br/>
     	   		部門：
     	   			<form:select path="deptno" name="deptno">
    		  			<form:options items="${deptAll}" itemLabel="dname" itemValue="deptno"/>
    		  		</form:select><br/>
     	   		<input type="submit" value="送出新增">
    		</form:form>
<%--         	<form method="post" action="<c:url value='/testView/empCreate' />"> --%>
<!--     			姓名：<input type="text" size="12px" name="ename"/><br/> -->
<!--     			職位：<input type="text" size="12px" name="ejob"/><br/> -->
<!--     			薪水：<input type="text" size="12px" name="esal"/><br/> -->
<!-- 					<input type="submit" value="送出新增"> -->
<!-- 			</FORM> -->
        </div>
        
        <div id="read">
        	<form method="post" action="<c:url value='/testView/empAll' />">
        		<input type="submit" value="全部員工" />
        	</form>
        </div>
        <div id="read">
        	<c:set var="action" >
    			<c:url value='/testView/empByEname' />
   			 </c:set>
        	<form method="post" action="${action}">
        	   <input type="text" name="ename" />
    		   <input type="submit" value="查詢員工ByName" />
    		</form>
        </div>
    </body>
    
    <script language="JavaScript">
        
        $(document).ready(function(){ 
          $.datepicker.regional['zh-TW']={
            dayNames:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
            dayNamesMin:["日","一","二","三","四","五","六"],
            monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
            monthNamesShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
            prevText:"上月",
            nextText:"次月",
            weekHeader:"週"
            };
          $.datepicker.setDefaults($.datepicker.regional["zh-TW"]);
          $("#dateChooser").datepicker({changeYear: true, changeMonth: true});
          });
      </script>
</html>