<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<div id="<portlet:namespace/>main" ng-controller="MainCtrl" ng-cloak>
    <div ng-hide="model.isSignedIn">
        <span language="you-must-be-logged-in-to-use"></span>
    </div>
    <div ng-include src="page" ng-show="model.isSignedIn"></div>
</div>

<aui:script use="liferay-portlet-url,liferay-service,liferay-language,aui-base">
    Liferay.bootstrap('<portlet:namespace />main', '<portlet:namespace />');
</aui:script>
