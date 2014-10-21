<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<%
PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);
String currentURL = currentURLObj.toString();
String host = PortalUtil.getPortalURL(request);
%>

<portlet:actionURL name="startGame" var="beginGameUrl" />

<liferay-ui:header title="set-game" />

<c:if test="<%=themeDisplay.isSignedIn()%>">
    <aui:form action="<%=beginGameUrl%>" method="post" name="start-game-form">
        <aui:input id="backURL" name="backURL" type="hidden" value="<%= currentURL %>" />
        <aui:input id="invite" name="invite" type="hidden" value="true" />

        <aui:input label="invite-player" name="invitePlayer" type="text" value="test.dlc.1@liferay.com" />

        <aui:button-row>
            <aui:button type="submit" value="start-game"/>
        </aui:button-row>
    </aui:form>

    <aui:script>
    AUI().use('aui-button', function(A) {
        new A.ButtonGroup({
            boundingBox : 'div.game-type-container',
            type : 'radio'
        }).render();
    });

    AUI().use('aui', function(A) {
        A.on('domready',function() {
            checkForInvite("<%=host%>", function(){
                if( confirm("You have been invited to a Set game. Would you like to join now?") ) {
                    var form = A.one('#<portlet:namespace/>start-game-form');
                    var invite = A.one('#<portlet:namespace/>invite');
                    invite.set('value', false);
                    form.submit();
                }
            });
        });
    });
    </aui:script>

</c:if>
<c:if test="<%=!themeDisplay.isSignedIn()%>">
    <liferay-ui:message key="please-sign-in" />
</c:if>
