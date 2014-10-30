<%@page import="com.liferay.ide.projects.todo.model.Todo"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="/jsp/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Todo todo = (Todo) row.getObject();
%>

<liferay-ui:icon-menu>
    <portlet:renderURL var="editURL">
        <portlet:param name="mvcPath" value="/html/edit.jsp" />
        <portlet:param name="todoId" value="<%= String.valueOf(todo.getTodoId()) %>" />
        <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:renderURL>

    <liferay-ui:icon
        image="edit"
        url="<%= editURL %>"
    />

    <portlet:actionURL name="finishTodo" var="finishURL">
        <portlet:param name="todoId" value="<%= String.valueOf(todo.getTodoId()) %>" />
        <portlet:param name="redirect" value="<%= currentURL %>" />
    </portlet:actionURL>

    <liferay-ui:icon
        message="finish"
        url="<%= finishURL %>"
    />
</liferay-ui:icon-menu>