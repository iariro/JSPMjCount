<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
	<head>
		<title>戦績 2011/08 - 2011/10</title>
		<meta http-equiv=Content-Style-Type content=text/css>
		<link rel="stylesheet" type="text/css" href="hatena.css">
	</head>

	<body>
		<div class=hatena-body>
		<div class=main>

		<h3>戦績 2011/08 - 2011/10</h3>

		<s:iterator value="playDataCollections">
			<h4><s:property value="month" /></h4>

			<div class=day>

			<table>
				<tr>
					<th>開始日時</th>
					<th>プレイ<br>時間</th>
					<th>ゲームセンター</th>
					<th>ゲーム</th>
					<th>ゲーム数</th>
					<th>和了率</th>
					<th>聴牌率</th>
					<th>ラストチャンス率</th>
					<th>和がり<br>なし</th>
					<th>出率</th>
				</tr>

				<s:iterator>
					<tr>
					<td bgcolor="<s:property value="bgcolor1" />">
						<s:property value="datetime" />
					</td>
					<td bgcolor="<s:property value="bgcolor1" />" align="right">
						<s:property value="playtime" />
					</td>
					<td bgcolor="<s:property value="bgcolor1" />">
						<s:property value="gamecenter" />
					</td>
					<td bgcolor="<s:property value="bgcolor1" />">
						<s:property value="gameKind" />
					</td>
					<td bgcolor="<s:property value="bgcolor1" />" align="right">
						<s:property value="totalCount" />
					</td>
					<td bgcolor="<s:property value="bgcolor2" />" align="right">
						<s:property value="agariRatio" />
					</td>
					<td bgcolor="<s:property value="bgcolor1" />" align="right">
						<s:property value="tenpaiRatio" />
					</td>
					<td bgcolor="<s:property value="bgcolor3" />" align="right">
						<s:property value="lastchange" />
					</td>
					<td bgcolor="<s:property value="bgcolor1" />" align="right">
						<s:property value="和がりなしカウント" />
					</td>
					<td bgcolor="<s:property value="bgcolor1" />" align="right">
						<s:property value="ratio" />
					</td>
					</tr>
				</s:iterator>
			</table>

			</div>

		</s:iterator>

		</div>
		</div>

	</body>
</html>
