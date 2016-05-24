<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
	<head>
		<title>戦績</title>
		<meta http-equiv=Content-Style-Type content=text/css>
		<link rel="stylesheet" type="text/css" href="hatena.css">
	</head>

	<body>
		<h3>戦績</h3>

		<div class=hatena-body>
		<div class=main>

		<s:iterator value="epochListItemCollection">
			<h4><s:property value="month" /></h4>

			<s:if test="%{size>0}">

			<div class=day>

			<table>
				<tr>
				<th>開始日時</th>
				<th>ゲームセンター</th>
				<th>ゲーム</th>
				<th>コメント</th>
				<th>リンク</th>

				<s:iterator>
					<tr bgcolor="<s:property value="color1" />">
						<td><s:property value="dateTime" /></td>
						<td><s:property value="gameCenter" /></td>
						<td><s:property value="gameKind" /></td>
						<td><s:property value="comment" /></td>
						<td>

							<s:form action="creditgraph" theme="simple">
							    <input type="hidden" name="filename" value="<s:property value="filename" />">
							    <input type="hidden" name="currentYear" value="<s:property value="currentYear" />">
							    <input type="hidden" name="index" value="<s:property value="index" />">

								<s:submit value="表示" />

								<s:select name="style" list="#{ '0':'1G', '1':'1G収支',  '2':'GC',  '3':'GC収支' }" />

							</s:form>

						</td>
					</tr>
				</s:iterator>
			</table>

			</div>

			</s:if>

		</s:iterator>
		<br>

		</div>
		</div>

	</body>
</html>
