<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>지역 카테고리</h2>

    <s:iterator value="list3" status="stat">

    <s:url id="viewURL" action="admin_areaCatModifyForm">

        <s:param name="no">
            <s:property value="no" />
        </s:param>

        <s:param name="currentPage">
            <s:property value="currentPage" />
        </s:param>

        <s:param name="userReq"> areaCat </s:param>

    </s:url>

       
    <ul>
        <li>
            <s:property value="no" />
            <s:property value="name" />
            <s:property value="cat_code" />
            <s:a href="%{viewURL}"> 수정 </s:a>
        </li>
    </ul>
           
    
    
    </s:iterator>

    <s:property value="pagingHtml" escape="false" />
   		 
   
	<input type="button" value="글쓰기" class="inputb" onClick="javascript:location.href='admin_areaCatForm.action?&currentPage=<s:property value="currentPage" />';">
	