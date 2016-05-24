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

		<div class=day>
		<table>

			<tr>
				<th>順位</th>
				<th>開始日時</th>
				<th>プレイ<br>時間</th>
				<th>正味<br>プレイ</th>
				<th>ゲームセンター</th>
				<th>ゲーム</th>
				<th>ゲーム数</th>
				<th>和了率</th>
				<th>聴牌率</th>
				<th>和がり<br>なし</th>
				<th>クレ<br>ジット</th>
				<th>出率</th>
				<th>最大</th>
				<th>詳細</th>
			</tr>

			<s:iterator value="itemsCollection">

				<tr>
					<td align="right"><s:property value="num" /></td>
					<td><a href="../diary/oneday1.action?date=<s:property value='datetime' />&usetag=true&category=麻雀"><s:property value="datetime" /></a></td>
						<s:property value="rentalDate" /></a>
					<td align="right"><s:property value="playTime" /></td>
					<td align="right"><s:property value="playNetTime" /></td>
					<td><s:property value="gameCenter" /></td>
					<td><s:property value="gameKind" /></td>
					<td align="right"><s:property value="gameCount" /></td>
					<td align="right" bgcolor="<s:property value="color2" />">
						<s:property value="agariRatio" />
					</td>
					<td align="right">
						<s:property value="tenpaiRatio" />
					</td>
					<td align="right"><s:property value="agarinashiCount" /></td>
					<td align="right"><s:property value="inCredit" /></td>
					<td align="right"><s:property value="ratioAsString" /></td>
					<td align="right"><s:property value="maxCredit" /></td>
					<td>
						<table style='MARGIN: 0px'><tr>
						<td style='border:0px; padding:0px;'>
						<s:form action="detailone" theme="simple">
							<input type="hidden" name="filename" value="<s:property value="filename" />">
							<input type="hidden" name="index" value="<s:property value="index" />">
							<s:submit value="詳細" />
						</s:form>
						</td>
						<td style='border:0px; padding:0px;'>
						<s:form action="creditgraph" theme="simple">
							<input type="hidden" name="filename" value="<s:property value="filename" />">
							<input type="hidden" name="currentYear" value="<s:property value="currentYear" />">
							<input type="hidden" name="index" value="<s:property value="index" />">
							<input type="hidden" name="style" value="0">
							<s:submit value="グラフ" />
						</s:form>
						</td>
						</tr></table>
					</td>
				</tr>

			</s:iterator>

		</table>
		</div>

		</div>
		</div>

	</body>
</html>
