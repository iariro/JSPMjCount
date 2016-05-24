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
		<li>
			<s:form action="detail" theme="simple">
				<s:submit value="当月分詳細" />
			</s:form>
		<li>
			<s:form action="digest" theme="simple">
				<s:submit value="半年分ダイジェスト" />
			</s:form>
		<li>
			<s:form action="digestall" theme="simple">
				<s:submit value="ダイジェストランキング" />
				<s:select name="sortKey" list="#{ 'gameCount':'ゲーム数', 'playTime':'プレイ時間', 'playNetTime':'正味プレイ時間', 'agarinashiCount':'和がりなしカウント', 'inputCredit':'投入クレジット', 'maxCredit':'最大クレジット', 'ratio':'出率'}" />
			</s:form>
		<li>
			<s:form action="joukenlist1" theme="simple">
				<s:submit value="条件指定リスト" />
			</s:form>
		<li>
			<s:form action="epoch" theme="simple">
				<s:submit value="記念すべきプレイ" />
			</s:form>
		</ul>

		<ul>
		<li>月指定
		<s:form action="month" theme="simple">
			<input type="text" size="4" name="year" value="<s:property value="todayYear" />">年
			<input type="text" size="2" name="month" value="<s:property value="todayMonth" />">月
			<s:submit value="表示" />
		</s:form>
		</ul>

		<ul>
		<li>
			<s:form action="oldlist" theme="simple">
				<s:submit value="戦績 2011/08-10" />
			</s:form>
		</ul>

	</body>
</html>
