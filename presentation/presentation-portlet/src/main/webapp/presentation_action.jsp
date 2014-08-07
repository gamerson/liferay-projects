<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="javax.print.attribute.standard.PresentationDirection"%>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

JournalArticle article = (JournalArticle)row.getObject();

%>

<liferay-ui:icon-menu>
<portlet:renderURL var="presentUrl" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
    <portlet:param name="key" value="<%=String.valueOf(article.getPrimaryKey()) %>" />
    <portlet:param name="mvcPath" value="/presentation/present.jsp" />
</portlet:renderURL>

	<liferay-ui:icon
		image="view"
		message="view-presentation"
		target="_blank"
		url="<%=presentUrl %>"
	/>

	<portlet:actionURL name="deletePresentation" var="deleteURL">
		<portlet:param name="articleId" value="<%= String.valueOf(article.getArticleId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		url="<%= deleteURL %>"
	/>
</liferay-ui:icon-menu>