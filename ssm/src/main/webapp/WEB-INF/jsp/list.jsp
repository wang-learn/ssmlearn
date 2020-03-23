
<%--
  Created by IntelliJ IDEA.
  User: 24230
  Date: 2020/3/23
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%-- jstl
    标签	描述
    <c:out>	用于在JSP中显示数据，就像<%= ... >
    <c:set>	用于保存数据
    <c:remove>	用于删除数据
    <c:catch>	用来处理产生错误的异常状况，并且将错误信息储存起来
    <c:if>	与我们在一般程序中用的if一样
        <c:if> 标签必须要有test属性，当test中的表达式结果为true时，
        则会执行本体内容；如果为false，则不会执行。
        例如：${requestScope.username = = 'admin'}，
        如果requestScope.username等admin时，结果为true；
        若它的内容不等于admin时，则为false。
    <c:choose>	本身只当做<c:when>和<c:otherwise>的父标签
    <c:when>	<c:choose>的子标签，用来判断条件是否成立
    <c:otherwise>	<c:choose>的子标签，接在<c:when>标签后，当<c:when>标签判断为false时被执行
    <c:import>	检索一个绝对或相对 URL，然后将其内容暴露给页面
    <c:forEach>	基础迭代标签，接受多种集合类型
        属 性	描 述	是否必须	缺省值
        items	进行循环的项目	否	无
        begin	开始条件	否	0
        end	结束条件	否	集合中的最后一个项目
        step	步长	否	1
        var	代表当前项目的变量名	否	无
        varStatus	显示循环状态的变量	否	无
    <c:forTokens>	根据指定的分隔符来分隔内容并迭代输出
    <c:param>	用来给包含或重定向的页面传递参数
    <c:redirect>	重定向至一个新的URL.
    <c:url>	使用可选的查询参数来创造一个URL
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.ssmlearn.wang.entity.Book" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>list</title>
</head>
<body>
    ${lists}
</body>
</html>
