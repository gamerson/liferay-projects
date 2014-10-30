<%@page import="com.liferay.ide.projects.todo.NoSuchTodoException"%>
<%@page import="com.liferay.ide.projects.todo.model.Todo"%>
<%@page import="com.liferay.ide.projects.todo.service.TodoLocalServiceUtil"%>

<%@ include file="/jsp/init.jsp" %>

<%
long todoId = ParamUtil.getLong(request, "todoId");

Todo todo = null;

try {
    todo = TodoLocalServiceUtil.getTodo(todoId);
}
catch( NoSuchTodoException e ) {
}
%>

<liferay-ui:header backURL="<%= backURL %>" title='<%= (todo == null ? "new-todo" : todo.getName()) %>' />

<portlet:actionURL name="updateTodo" var="updateTodoURL" />

<aui:form action="<%= updateTodoURL %>" method="post" name="fm">
    <aui:model-context bean="<%= todo %>" model="<%= Todo.class %>"/>

    <aui:input name="backURL" type="hidden" value="<%= backURL %>" />
    <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
    <aui:input name="todoId" type="hidden" />

    <aui:fieldset>
        <aui:input name="name">
            <aui:validator name="required" />
        </aui:input>

        <aui:input name="description" type="textarea"  />

        <aui:input label="due-date" name="dueDate" />

    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="cancel" />
    </aui:button-row>

</aui:form>