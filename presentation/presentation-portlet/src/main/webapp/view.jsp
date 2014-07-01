<%--
/**
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ page import="java.util.Locale"%>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<liferay-ui:search-container>
	<liferay-ui:search-container-results
 		results="<%= JournalArticleLocalServiceUtil.getJournalArticles(-1, -1) %>"
 		total="<%= JournalArticleLocalServiceUtil.getJournalArticlesCount() %>"
 	/> 
		
 	<liferay-ui:search-container-row
 		className="com.liferay.portlet.journal.model.JournalArticle"
 		modelVar="aJournalArticle" 
 	>
 		<liferay-ui:search-container-column-text
			name="id"
			value="<%= aJournalArticle.getArticleId() %>"
		/>
 		<liferay-ui:search-container-column-text
			name="title"
			value="<%= aJournalArticle.getTitleCurrentValue() %>"
		/>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/presentation_action.jsp"
		/>
 	</liferay-ui:search-container-row>

 	<liferay-ui:search-iterator />
 </liferay-ui:search-container>