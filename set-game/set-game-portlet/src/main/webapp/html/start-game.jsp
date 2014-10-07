<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects/>

<%
String gameType = ParamUtil.getString(request, "gameType");
String backURL = ParamUtil.getString(request, "backURL");
String ctxPath = request.getContextPath();
%>

<liferay-ui:header title="start-playing" backURL="<%= backURL %>"/>

<div id="<portlet:namespace/>game">
</div>

<aui:script>
AUI().use('aui-base', function(A) {
	var gameNode = A.one('#<portlet:namespace/>game');
	setupSetGame("<%=gameType%>", gameNode.get('id'), "<%=ctxPath%>");
});
</aui:script>