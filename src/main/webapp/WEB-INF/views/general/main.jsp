<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <div class="list-inline">
        <li><a class="btn btn-primary btn-sm"
               style="margin-bottom: 10px"
               href="/user/creative/new"><spring:message code="label.create"/></a></li>
        <li><H2 style="margin-left: 3em"><spring:message code="label.creatives"/></H2></li>
    </div>

    <br/>

    <c:forEach var="creative" items="${creatives}">

        <div class="pull-right well" style="margin-right: 3em">
            <div>
                <small><strong><spring:message code="label.author"/>: ${creative.author.username}</strong></small>
            </div>
            <div class="pull-left">
                <img class="avatar_profile"
                     src="<c:url value="/general/${creative.author.username}/avatar"/>"
                     width="105" height="105"/>
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

            <div>
                <strong><spring:message code="label.tags"/>:</strong>
                <c:forEach var="tag" items="${creative.tags}">
                    <small>${tag.tagName}</small>
                </c:forEach>

            </div>
        </div>

    </c:forEach>

</div>