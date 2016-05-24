<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv=Content-Style-Type content=text/css>
		<link rel="stylesheet" type="text/css" href="hatena.css">
		<title>麻雀ゲーム戦績</title>
	</head>

	<body>
		<h1>麻雀ゲーム戦績</h1>
		<br>
		<ul>
		<s:form action="joukenlist2" theme="simple">
			ゲームセンター：
			<s:select name="gameCenter" list="gameCenterCollection" />
			<br>
			ゲーム機種：
			<s:select name="gameKind" list="gameKindCollection" />
			<br>
			<s:submit value="表示" />
		</s:form>

	</body>
</html>
