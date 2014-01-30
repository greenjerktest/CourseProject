<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <link rel="stylesheet" href="/resources/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="/resources/css/core.css" type="text/css"/>
    <link rel="stylesheet" href="/resources/pagedown/css/demo.css" type="text/css"/>
    <link rel="stylesheet" href="/resources/css/courseproject.css" type="text/css"/>

    <script type="text/javascript" src="/resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="/resources/js/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap-collapse.js"></script>
    <script type="text/javascript" src="/resources/pagedown/Markdown.Converter.js"></script>
    <script type="text/javascript" src="/resources/pagedown/Markdown.Sanitizer.js"></script>
    <script type="text/javascript" src="/resources/pagedown/Markdown.Editor.js"></script>

</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="footer"/>
</body>
</html>