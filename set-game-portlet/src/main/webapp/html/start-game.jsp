<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects/>

<%
String gameType = ParamUtil.getString(request, "gameType");
%>


<div id="<portlet:namespace/>-game">
</div>

<aui:script>
YUI().use('aui-base', function(Y) {
    Y.on('domready', function(){

    });
});
</aui:script>