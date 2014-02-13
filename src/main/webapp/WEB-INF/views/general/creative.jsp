<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<script>
    $(function () {
        var root = $('#sortable');
        $("#sortable").sortable({
            revert: true
        });
        $('> *', root).each(function (index) {
            this.id = 'item-' + index;
        });
        root.sortable({
            'update': function (event, ui) {
                var order = $(this).sortable('serialize');
                $.cookies.set('sortable', order);
            }
        });
        var c = $.cookies.get('sortable');
        if (c) {
            $.each(c.split('&'), function () {
                var id = this.replace('[]=', '-');
                $('#' + id).appendTo(root);
            });
        }
    });
</script>

<div class="container">

    <div style="display: inline-block; margin-bottom: 20px">
        <div class="label label-primary pull-left" style="margin-top: 30px">
            <spring:message code="label.author"/>: ${creative.author.username}
        </div>
        <H2 style="margin-left: 5em; display: block; float: left">
            <spring:message code="label.heads"/></H2>
    </div>

    <ul id="sortable">
        <c:forEach var="head" items="${creative.heads}">
            <li class="ui-state-default nav">
                <div class="container-fluid" style="text-align: center">
                    <div class="accordion" id="accordion${head.id}">
                        <div class="accordion-group">
                            <div class="accordion-heading">
                                <a class="accordion-toggle btn btn-group-lg badge panel-title"
                                   data-toggle="collapse"
                                   data-parent="#accordion${head.id}" href="#collapse${head.id}">
                                        ${head.title}
                                </a>
                            </div>
                            <div id="collapse${head.id}" class="accordion-body collapse">
                                <div class="accordion-inner">

                                    <div class="wmd-panel">
                                        <textarea id="wmd-input${head.id}"
                                                  class="wmd-input hidden">${head.content}
                                        </textarea>
                                    </div>
                                    <div id="wmd-preview${head.id}" class="wmd-panel wmd-preview well"></div>

                                    <script type="text/javascript">
                                        (function () {
                                            var converter1 = Markdown.getSanitizingConverter();

                                            converter1.hooks.chain("preBlockGamut", function (text, rbg) {
                                                return text.replace(/^ {0,3}""" *\n((?:.*?\n)+?) {0,3}""" *$/gm, function (whole, inner) {
                                                    return "<blockquote>" + rbg(inner) + "</blockquote>\n";
                                                });
                                            });

                                            var editor1 = new Markdown.Editor(converter1, ${head.id});
                                            editor1.run();

                                        })();
                                    </script>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>

    <c:if test="${creative.author.username == pageContext['request'].userPrincipal.name}">
        <div class="label control-label">
            <a href="/user/creative/${creative.id}/add_head">
                <spring:message code="label.add_head"/>
            </a>
        </div>
    </c:if>

    <div style="margin-top: 100px">
        <c:forEach var="comment" items="${creative.comments}">
            <div class="form-narrow">
                <c:if test="${comment.user.username == pageContext['request'].userPrincipal.name}">
                    <div class="badge alert-danger pull-right">
                        <form action="<c:url value="/general/creative/${creativeId}/remove_comment"/>"
                              method="POST">
                            <input type="hidden" name="commentId" value="${comment.id}">
                            <input type="submit"
                                   value="<spring:message code="label.delete"/>">
                        </form>
                    </div>
                </c:if>
                <ul class="media-list">
                    <li class="media">

                        <img class="pull-left avatar_profile"
                             src="<c:url value="/general/${comment.user.username}/avatar"/>"
                             width="70" height="70"/>

                        <div class="media-body" style="word-wrap: break-word">
                            <h4 class="media-heading"> ${comment.user.username}</h4>
                                ${comment.comment}
                        </div>


                    </li>
                </ul>
            </div>
        </c:forEach>
    </div>


    <security:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
        <form:form method="post" action="/general/creative/${creative.id}/add_comment"
                   commandName="commentForm">
            <form:errors cssClass="error" path="comment"/>
            <div class="form-narrow" style="margin-top: 70px">
                <ul class="media-list">
                    <li class="media">
                        <img width="100" height="100" class="pull-left avatar_profile"
                             src="<c:url value="/user/profile/avatar"/>"/>

                        <div class="media-body">
                            <h4 class="media-heading"><spring:message code="label.comment"/></h4>
                            <form:textarea path="comment" rows="4" cols="37"/>
                        </div>
                        <input type="submit"
                               value="<spring:message code="label.add"/>"
                               class="btn btn-block"
                               style="margin-top: 20px"/>
                    </li>
                </ul>
            </div>
        </form:form>
    </security:authorize>

</div>







