<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(document).ready(function () {
        // Handler for .ready() called.
        $('#changeAvatar').click(function () {
            $('#fileInput').click();
        });

        $("#fileInput").change(function () {
            $("#fileForm").submit();
        });
    });
</script>

<div class="container">

    <form:form method="post" action="/user/profile" commandName="userForm"
               class="form-narrow form-horizontal">

        <h4><spring:message code="label.profile"/></h4>

        <div class="form-group">
            <form:label path="email"><spring:message
                    code="label.email"/></form:label>
            <form:errors path="email" cssClass="label-danger"><spring:message
                    code="label.email_error"/></form:errors>
            <div class="col-lg-10">
                <form:input path="email" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="password"><spring:message
                    code="label.password"/></form:label>
            <form:errors path="password"><spring:message
                    code="label.password_error"/></form:errors>
            <div class="col-lg-10">
                <form:password path="password" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="confirmPassword"><spring:message
                    code="label.confirm_password"/></form:label>
            <form:errors path="confirmPassword"><spring:message
                    code="label.re_password_error"/></form:errors>
            <div class="col-lg-10">
                <form:password path="confirmPassword" cssClass="form-control"/>
            </div>
        </div>
        <input type="submit" class="btn btn-default"
               value="<spring:message code="label.save"/>"/>

    </form:form>

    <div class="form-narrow form-horizontal">
        <img class="avatar_profile" src="<c:url value="/user/profile/avatar"/>"
             width="140" height="140"/>
        <a id="changeAvatar" name="changeAvatar"
           class="btn btn-success btn-large" style="display: block; float: right">
            <spring:message code="label.ch_avatar"/>
        </a>
        <form:form modelAttribute="uploadForm" id="fileForm" type="hidden"
                   action="/user/profile/avatar" method="post"
                   enctype="multipart/form-data">
            <input style="visibility: hidden;" type="file" name="file" id="fileInput"/>
        </form:form>
    </div>

</div>

