<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="container">

    <H2 style="margin-left: 5em"><spring:message code="label.found"/></H2>

    <c:forEach var="creative" items="${creativeList}">

        <div class="pull-right" style="margin-right: 3em">
            <div>
                <small><strong><spring:message code="label.author"/>: ${creative.author.username}</strong></small>
            </div>
            <div class="pull-left">
                <img class="avatar_profile"
                     src="<c:url value="/general/${creative.author.username}/avatar"/>"
                     width="105" height="105"/>
            </div>
            <div style="margin-top: 150px">
                <strong><spring:message code="label.tags"/>:</strong>
                <c:forEach var="tag" items="${creative.tags}">
                    <small>${tag.tag}</small>
                </c:forEach>

            </div>

        </div>

        <div class="form-narrow">
            <a href="/general/creative/${creative.id}" class="btn-group">

                <img class="img-rounded img-thumbnail" width="430" src="<c:url value="/general/${creative.id}/logo"/>"/>

                <div id="creative_info">
                    <h4>${creative.title}</h4>

                    <p>${creative.description}</p>
                </div>

            </a>
        </div>

    </c:forEach>
</div>