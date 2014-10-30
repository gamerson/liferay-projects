<%@page import="com.liferay.portal.service.ReleaseLocalServiceUtil"%>
<%@page import="com.liferay.ide.projects.todo.service.TodoLocalServiceUtil"%>
<%@ include file="/jsp/init.jsp" %>

<%
int buildNumber = ReleaseLocalServiceUtil.getRelease( 1 ).getBuildNumber();
%>
<c:if test="<%=themeDisplay.isSignedIn()%>">
    <aui:nav-bar>
        <aui:nav>
            <portlet:renderURL var="addTodoURL">
                <portlet:param name="mvcPath" value="/html/edit.jsp" />
                <portlet:param name="redirect" value="<%= currentURL %>" />
            </portlet:renderURL>

            <aui:nav-item href="<%= addTodoURL %>" label="add" iconCssClass="icon-plus" />
        </aui:nav>
    </aui:nav-bar>

    <liferay-ui:search-container
        emptyResultsMessage="there-are-no-todos"
        headerNames="title"
    >
      <liferay-ui:search-container-results
        results="<%= TodoLocalServiceUtil.getUnfinishedUserTodos(themeDisplay.getUserId()) %>"
        total="<%= TodoLocalServiceUtil.getUnfinishedUserTodosCount(themeDisplay.getUserId()) %>"
      />

      <liferay-ui:search-container-row
        className="com.liferay.ide.projects.todo.model.Todo"
        modelVar="aTodo"
        >
            <liferay-ui:search-container-column-text name="name" />
            <liferay-ui:search-container-column-text name="description" />
            <liferay-ui:search-container-column-date name="dueDate" value="<%= aTodo.getDueDate() %>" />
            <liferay-ui:search-container-column-jsp align="right" path="/jsp/todo_action.jsp" />
      </liferay-ui:search-container-row>

      <liferay-ui:search-iterator />
    </liferay-ui:search-container>

   <liferay-ui:message key="liferay-version" /> : <%= buildNumber %> |
   <liferay-ui:message key="company-id" /> : <%= themeDisplay.getCompanyId() %> |
   <liferay-ui:message key="user-name" /> : <%= themeDisplay.getUser().getFullName() %>
</c:if>
<c:if test="<%=!themeDisplay.isSignedIn()%>">
    <a href="<%= themeDisplay.getURLSignIn() %>">
        <liferay-ui:message key="you-must-be-logged-in-to-use" />
    </a>
</c:if>