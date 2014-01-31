<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(document).ready(function () {
        // Handler for .ready() called.
        $('#changeLogo').click(function () {
            $('#fileInput').click();
        });

        $("#fileInput").change(function () {
            $("#fileForm").submit();
        });
    });
</script>

<div class="container">

    <H2 style="margin-left: 5em"><spring:message code="label.create"/></H2>

    <form:form method="post" action="/user/creative/new" commandName="creativeForm"
               class="form-narrow form-horizontal" enctype="multipart/form-data">

        <form:errors path="*" cssClass="errorblock" element="div"/>

        <div class="form-group">
            <form:label path="title"><spring:message
                    code="label.title"/></form:label>
            <form:errors cssClass="error" path="title"/>
            <div class="col-lg-10">
                <form:input path="title" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="description"><spring:message
                    code="label.description"/></form:label>
            <form:errors cssClass="error" path="description"/>
            <div class="col-lg-10">
                <form:textarea path="description" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="tags"><spring:message
                    code="label.tags"/></form:label>
            <form:errors cssClass="error" path="tags"/>
            <div class="col-lg-10">
                <form:input path="tags" id="w-input-tag" cssClass="form-control"/>
            </div>
        </div>

        <a id="changeLogo" name="changeLogo"
           class="btn btn-default btn-block">
            <spring:message code="label.logo"/>
        </a>
        <form:form modelAttribute="uploadForm" id="fileForm">
            <input style="visibility: hidden;" type="file" name="logo" id="fileInput"/>
            <input type="submit" class="btn btn-success"
                   value="<spring:message code="label.save"/>"/>
        </form:form>


    </form:form>

</div>

<script>
    $(document).ready(function () {

        $('#w-input-tag').autocomplete({
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