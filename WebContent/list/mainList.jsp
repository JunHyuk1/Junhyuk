<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 


    <s:iterator value="list2" status="stat">
	
	    <ul>

	      	<li>
		      	<h2>카테고리 이름 들어갈 곳</h2> <br>
		      	<s:property value="#stat.index" />
		      	<s:property value="name" />
	      	</li> 
	      	
	      	<li>
	      		<s:iterator value="list2[#stat.index]" status="stat2">
	      			<s:property value="name" />
	      		</s:iterator>
	      	</li>

	    </ul>
           
    </s:iterator>
   
 
 
 