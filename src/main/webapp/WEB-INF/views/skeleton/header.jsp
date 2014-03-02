<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="navbar navbar-inverse navbar-fixed-top" id="navbar">


    <div style="margin-top: 15px; text-align: center; min-width: 1000px" class="list-inline">

        <form method="post" action="/search" class="navbar-search pull-left" style="margin-left: 1em">
            <input name="term" class="search-query" id="w-input-search-tag"
                   placeholder="<spring:message code="label.search"/>"/>
        </form>

        <li><a href="/"><spring:message code="label.home"/></a></li>
        <security:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN">
            <li><a href="/anonymous/register"><spring:message code="label.registration"/></a></li>
            <li><a href="/anonymous/login"><spring:message code="label.login"/></a></li>
        </security:authorize>
        <security:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
            <li><a href="/user/profile"><security:authentication property="principal.username"/></a></li>
            <li><a href="<c:url value="j_spring_security_logout"/>"><spring:message code="label.logout"/></a></li>
        </security:authorize>
        <security:authorize ifAnyGranted="ROLE_ADMIN">
            <li><a href="/admin" class="badge"><spring:message code="label.administrator"/></a></li>
        </security:authorize>

        <div id="nav_lang" class="list-inline pull-right">
            <li><a href="?lang=en" class="badge btn-success">en</a></li>
            <li><a href="?lang=ru" class="badge btn-success">ru</a></li>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {

        $('#w-input-search-tag').autocomplete({
            serviceUrl: '${pageContext.request.contextPath}/getTags',
            paramName: "query",
            delimiter: ",",
            transformResult: function (response) {
                return {
                    suggestions: $.map($.parseJSON(response), function (item) {
                        return { value: item.tagName, data: item.id };
                    })
                };
            }
        });
    });
</script>

