<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
	<head>
		<title>戦績</title>
		<meta http-equiv=Content-Style-Type content=text/css>
		<link rel="stylesheet" type="text/css" href="hatena.css">
	</head>

	<body>
		<div class=hatena-body>
		<div class=main>

		<h3>戦績</h3>

			<h5>
			<s:property value="playDataCollection.fullDate" />
			<s:property value="playDataCollection.gameCenter" /> - <s:property value="playDataCollection.gameKind" />
			</h5>

			<div class=day>
			<table>
				<tr>
					<th>カウント</th>
					<th>経過</th>
					<th>時刻</th>
					<th>間隔</th>
					<th>結果</th>
					<th>連続</th>
					<th>投入</th>
					<th>獲得</th>
					<th>クレジット</th>
				</tr>

				<s:iterator value="playDataListCollection">
					<tr bgcolor="<s:property value="bgcolor" />">
						<td align="right"><s:property value="count" /></td>
						<td><s:property value="progress" /></td>
						<td><s:property value="time" /></td>
						<td align="right"><s:property value="diff" /></td>
						<td><s:property value="result" /></td>
						<td ralign="right"><s:property value="count2" /></td>
						<td align="right"><s:property value="inCredit" /></td>
						<td align="right"><s:property value="outCredit" /></td>
						<td align="right"><s:property value="credit" /></td>
					</tr>
				</s:iterator>

			</table>

			<table>
				<tr>
					<th>開始日時</th>
					<td><s:property value="statistics.date" /></td>
				</tr>
				<tr>
					<th>プレイ時間</th>
					<td><s:property value="playDataCollection.playTime" /></td>
				</tr>
				<tr>
					<th>ゲームセンター</th>
					<td><s:property value="playDataCollection.gameCenter" /></td>
				</tr>
				<tr>
					<th>ゲーム</th>
					<td><s:property value="playDataCollection.gameKind" /></td>
				</tr>
				<tr>
					<th>ゲーム数</th>
					<td align="right"><s:property value="playDataCollection.gameCount" /></td>
				</tr>
				<tr>
					<th>連続和がりなし</th>
					<td align="right"><s:property value="playDataCollection.agarinashiCount" /></td>
				</tr>
				<tr>
					<th>投入クレジット</th>
					<td align="right"><s:property value="statistics.inCredit" /></td>
				</tr>
				<tr>
					<th>獲得クレジット</th>
					<td align="right"><s:property value="statistics.outCredit" /></td>
				</tr>
				<tr>
					<th>最大クレジット</th>
					<td align="right"><s:property value="playDataCollection.maxCredit" /></td>
				</tr>
			</table>

			<table>

				<tr>
					<th>和了率</th>
					<td align="right">
					<s:property value="statistics.agariritsu1" />
					</td>
					<td>= <s:property value="statistics.agariritsu2" /></td>
				</tr>

				<tr>
					<th>聴牌率</th>
					<td align="right">
					<s:property value="statistics.tenpairitsu1" />
					</td>
					<td>= <s:property value="statistics.tenpairitsu2" /></td>
				</tr>

				<tr>
					<th>ラストチャンス率</th><td align="right">
						<s:property value="statistics.lastChance1" />
					</td>
					<td>= <s:property value="statistics.lastChance2" /></td>
				</tr>

				<tr>
					<th>出率</th>
					<td align="right"><s:property value="statistics.deritsu1" /></td>
					<td>= <s:property value="statistics.deritsu2" /></td>
				</tr>

				<tr>
					<th>平均獲得クレジット</th>
					<td align="right"><s:property value="statistics.heikinKakutokuCredit1" /></td>
					<td>= <s:property value="statistics.heikinKakutokuCredit2" /></td>
				</tr>

			</table>
			</div>

		</div>
		</div>

	</body>
</html>
