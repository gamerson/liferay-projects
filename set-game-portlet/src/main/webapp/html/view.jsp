<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />
<portlet:actionURL name="startGame" var="startGameUrl" />

<liferay-ui:header title="set-game" />
<liferay-ui:message key="please-select-game-size" />

<aui:form action="<%=startGameUrl%>" method="post" name="start-game-form">
    <aui:input id="gameType" name="gameType" type="hidden" value="medium"/>
	<aui:button-row cssClass="game-type-container">
		<aui:button name="small" value="small" />
		<aui:button cssClass="active" name="medium" value="medium" />
		<aui:button name="large" value="large" />
	</aui:button-row>
	<aui:button-row>
		<aui:button type="submit" value="start-game"/>
	</aui:button-row>
</aui:form>

<aui:script>
YUI().use('aui-button', function(Y) {
    new Y.ButtonGroup({
        boundingBox : 'div.game-type-container',
        type : 'radio'
    }).render();

    Y.on('domready', function() {
        var gameType = Y.one('#<portlet:namespace/>gameType');
        Y.all('div.game-type-container button').each(function(node){
            node.on('click', function(){
                gameType.setAttribute('value',node.get('id'));
            });
        });
    });
});
</aui:script>
