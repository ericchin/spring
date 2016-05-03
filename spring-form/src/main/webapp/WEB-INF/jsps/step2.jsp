<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />

<portlet:actionURL var="formURL">
    <portlet:param name="myaction" value="submit" />
</portlet:actionURL>

<form:form method="post" modelAttribute="form" action="${formURL}">
    <strong>Form ID: </strong>${form.formId}<br/>
    <strong>Email Address: </strong>${form.emailAddress}<br/>

    <hr/>

    <aui:input name="<%= Constants.CMD %>" value="finish" type="hidden" />

    <aui:fieldset>
        <aui:input name="name" />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
    </aui:button-row>
</form:form>