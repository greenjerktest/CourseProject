<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="container">
    <c:forEach var="user" items="${users}">
    <div class="form-narrow form-horizontal">
            <div class="form-group">
                <table>
                    <tr>
                        <td><h5 style="font-weight: bold; margin-right: 15px">${user.username}</h5></td>
                        <td>${user.email}</td>
                    </tr>
                </table>

                <form action="<c:url value="/admin/delete_user"/>" method="POST">
                    <input type="hidden" name="username" value="${user.username}">
                    <input type="submit"
                           value="<spring:message code="label.delete"/>"
                           class="btn btn-block btn-danger">
                </form>
                <form action="<c:url value="/admin/block_user"/>" method="POST">
                    <input type="hidden" name="username" value="${user.username}">
                    <input type="submit"
                           value="<spring:message code="label.block"/>"
                           class="btn btn-block">
                </form>
            </div>


    </div>
    </c:forEach>
</div>
