<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">

    <form:form method="post" action="/anonymous/register" commandName="registerForm"
               class="form-narrow form-horizontal">

        <h2><spring:message code="label.registration"/></h2>

        <div class="form-group">
            <form:label path="username"><spring:message
                    code="label.username"/></form:label>
            <form:errors path="username"><spring:message
                    code="label.username_error"/></form:errors>
            <div class="col-lg-10">
                <form:input path="username" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="email"><spring:message
                    code="label.email"/></form:label>
            <form:errors path="email"><spring:message
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
        <input type="submit" class="btn btn-success"
               value="<spring:message code="label.add_user"/>"/>
    </form:form>

</div>
