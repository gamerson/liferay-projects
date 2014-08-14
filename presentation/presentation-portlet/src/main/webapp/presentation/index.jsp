<%@page import="com.liferay.portal.layoutconfiguration.util.RuntimePageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.portlet.journalcontent.util.JournalContentUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleResource"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<%
String ctxPath = request.getContextPath();
%>

<!doctype html>
<html lang="en">

	<head>
		<meta charset="utf-8">

		<title>Liferay 6.2 for Developers</title>

		<meta name="description" content="A framework for easily creating beautiful presentations using HTML">
		<meta name="author" content="Hakim El Hattab">

		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />

		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<link rel="stylesheet" href="<%=ctxPath%>/presentation/css/reveal.min.css">
		<link rel="stylesheet" href="<%=ctxPath%>/presentation/css/theme/default.css" id="theme">

		<!-- For syntax highlighting -->
		<link rel="stylesheet" href="<%=ctxPath%>/lib/css/zenburn.css">

		<!-- If the query includes 'print-pdf', include the PDF print sheet -->
		<script>
			if( window.location.search.match( /print-pdf/gi ) ) {
				var link = document.createElement( 'link' );
				link.rel = 'stylesheet';
				link.type = 'text/css';
				link.href = '<%=ctxPath%>/presentation/css/print/pdf.css';
				document.getElementsByTagName( 'head' )[0].appendChild( link );
			}
		</script>

		<!--[if lt IE 9]>
		<script src="lib/js/html5shiv.js"></script>
		<![endif]-->
		<style type="text/css">

		.reveal .state-background .footer {
			width:100%;
			height: 100px;
			position: fixed;
			bottom:3px;
			background-color: transparent;
			/*background-image: url("img/footer.jpg");
			background-size: 200px;
			background-repeat: no-repeat;
			background-position-x: 15px;
			*/
		}

		.reveal .controls {
			bottom: 94px;
		}


		.reveal .state-background .footer .top {
			background-image: url("img/footer_top.png");
			position: relative;
			top: 0px;
			width: 100%;
			height: 11px;
		}

		.reveal .state-background .footer .logo {
			background-image: url("img/slides-logo.jpg");
			background-repeat: no-repeat;
			background-size: 199px;
			position: absolute;
			right: 37px;
			height: 90px;
			width: 206px;
			top: 34px;
			float: right;

		}
		.reveal .state-background .footer .add {
			width: 171px;
			position: absolute;
			top: 33px;
			left: 91px;
			font-family: "League Gothic", "Hiragino Sans GB W3", "Microsoft Yahei";
			color: #12436b;
		}

		</style>
	</head>

	<body onload="footer();">
		<div class="reveal">
			<!-- Any section element inside of this container is displayed as a slide -->
			<div class="slides">
				<jsp:include page="content.jsp" ></jsp:include>
			</div>
		</div>

		<script src="<%=ctxPath %>/presentation/lib/js/head.min.js"></script>
		<script src="<%=ctxPath %>/presentation/js/reveal.min.js"></script>

		<script>

			// Full list of configuration options available here:
			// https://github.com/hakimel/reveal.js#configuration
			Reveal.initialize({
				controls: true,
				progress: true,
				history: true,
				center: true,

				theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
				transition: Reveal.getQueryHash().transition || 'default', // default/cube/page/concave/zoom/linear/fade/none

				// Parallax scrolling
				// parallaxBackgroundImage: 'https://s3.amazonaws.com/hakim-static/reveal-js/reveal-parallax-1.jpg',
				// parallaxBackgroundSize: '2100px 900px',

				// Optional libraries used to extend on reveal.js
				dependencies: [
					{ src: '<%=ctxPath%>/presentation/lib/js/classList.js', condition: function() { return !document.body.classList; } },
					{ src: '<%=ctxPath%>/presentation/plugin/markdown/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
					{ src: '<%=ctxPath%>/presentation/plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
					{ src: '<%=ctxPath%>/presentation/plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } },
					{ src: '<%=ctxPath%>/presentation/plugin/zoom-js/zoom.js', async: true, condition: function() { return !!document.body.classList; } },
					{ src: '<%=ctxPath%>/presentation/plugin/notes/notes.js', async: true, condition: function() { return !!document.body.classList; } }
				]
			});

			function footer() {
				var stateBg = document.querySelector("body .reveal .state-background");
				var bginnerHtml = '';
				bginnerHtml = '<div class="topper"></div>';
				bginnerHtml += '<div class="footer">';
				bginnerHtml += '<div class="top"></div>';
				bginnerHtml += '<div class="add">www.liferay.com</div>';
				bginnerHtml += '<div class="logo"></div>';
				bginnerHtml += '</div>';
				stateBg.innerHTML = bginnerHtml;
			}
		</script>

	</body>
</html>
