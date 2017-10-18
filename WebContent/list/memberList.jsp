<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>회원 리스트</h2>

    <s:iterator value="list" status="stat">

    <s:url id="viewURL" action="memberModify">

        <s:param name="mem_id">
            <s:property value="mem_id" />
        </s:param>

        <s:param name="currentPage">
            <s:property value="currentPage" />
        </s:param>

        <s:param name="userReq"> member </s:param>

    </s:url>

       
    <ul>
        <li>
            <s:property value="no" />
            <s:property value="mem_id" />
            <s:a href="%{viewURL}">
                <s:property value="mem_name" />
            </s:a>
            <s:property value="todate" />
        </li>
    </ul>
           
    
    </s:iterator>

    <s:property value="pagingHtml" escape="false" />
    
<input type="button" value="글쓰기" class="inputb" onClick="javascript:location.href='memberForm.action?&currentPage=<s:property value="currentPage" />';">