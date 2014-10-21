<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects/>

<%
String backURL = ParamUtil.getString(request, "backURL");
long startUserId = ParamUtil.getLong(request, "startUserId");
long inviteUserId = ParamUtil.getLong(request, "inviteUserId");
boolean invite = ParamUtil.getBoolean(request, "invite");
String ctxPath = request.getContextPath();
%>

<liferay-ui:header title="start-playing" backURL="<%= backURL %>"/>

<div class="left-div" id="<portlet:namespace/>game">
    <liferay-ui:message key="waiting-for-other-player" />
</div>
<div class="right-div">
    <p>Sets found</p>
    <p>You: <span id="score">0</span></p>
    <p>Opponent: <span id="otherscore">0</span></p>
</div>
<div style='clear:both;'>&nbsp;</div>

<aui:script>
AUI().use('aui-base', function(A) {
    var gameNode = A.one('#<portlet:namespace/>game');
    startGame(gameNode.get('id'), "<%=ctxPath%>", "<%=invite%>", "<%=startUserId%>", "<%=inviteUserId%>");
});
</aui:script>