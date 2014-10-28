<%@page import="com.liferay.ide.projects.todo.service.TodoLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<aui:nav-bar>
    <aui:nav>
        <portlet:renderURL var="addTodoURL">
            <portlet:param name="mvnPath" value="/edit.jsp" />
            <portlet:param name="redirect" value="<%= currentURL %>" />
        </portlet:renderURL>

        <aui:nav-item href="<%= addTodoURL %>" label="add" />
    </aui:nav>
</aui:nav-bar>

<liferay-ui:search-container
    emptyResultsMessage="there-are-no-todos"
    headerNames="title"
>
	<liferay-ui:search-container-results
		results="<%= TodoLocalServiceUtil.getUserTodos(themeDisplay.getUserId()) %>"
		total="<%= TodoLocalServiceUtil.getUserTodosCount(themeDisplay.getUserId()) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.ide.projects.todo.model.Todo"
		modelVar="aTodo"
    >

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>