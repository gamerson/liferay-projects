<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>
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
%>

<portlet:actionURL name="startGame" var="beginGameUrl" />

<liferay-ui:header title="set-game" />

<c:if test="<%=themeDisplay.isSignedIn()%>">
    <liferay-ui:message key="please-select-game-size" />

    <aui:form action="<%=beginGameUrl%>" method="post" name="start-game-form">
        <aui:input id="gameType" name="gameType" type="hidden" value="medium" />
        <aui:input id="backURL" name="backURL" type="hidden" value="<%= currentURL %>" />
        <aui:input id="invite" name="invite" type="hidden" value="true" />

        <aui:button-row cssClass="game-type-container">
            <aui:button name="small" value="small" />
            <aui:button cssClass="active" name="medium" value="medium" />
            <aui:button name="large" value="large" />
        </aui:button-row>

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

        A.on('domready', function() {
            var gameType = A.one('#<portlet:namespace/>gameType');
            A.all('div.game-type-container button').each(function(node){
                node.on('click', function(){
                    gameType.set('value',node.get('id'));
                });
            });
        });
    });

    AUI().use('aui', function(A) {
        A.on('domready',function() {
            checkForInvite(function(gameData){
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
