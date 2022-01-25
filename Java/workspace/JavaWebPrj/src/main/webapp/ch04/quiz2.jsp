<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
section {
	display: flex;
}
</style>
</head>
<body>
	<section>
		<jsp:include page="quiz2_1.jsp">
			<jsp:param name="heading"
				value="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/sample87.jpg" />
			<jsp:param name="profile"
				value="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/profile-sample4.jpg" />
			<jsp:param name="name" value="Hans Down" />
			<jsp:param name="major" value="Engineer" />
			<jsp:param name="desc"
				value="I'm looking for something that can deliver a 50-pound payload
				of snow on a small feminine target. Can you suggest something?
				Hello...?" />
		</jsp:include>
		<jsp:include page="quiz2_1.jsp">
			<jsp:param name="heading"
				value="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/sample74.jpg" />
			<jsp:param name="profile"
				value="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/profile-sample2.jpg" />
			<jsp:param name="name" value="Wisteria Widget" />
			<jsp:param name="major" value="Photographer" />
			<jsp:param name="desc"
				value="Calvin: I'm a genius, but I'm a misunderstood genius. Hobbes:
				What's misunderstood about you? Calvin: Nobody thinks I'm a genius...?" />
		</jsp:include>
		<jsp:include page="quiz2_1.jsp">
			<jsp:param name="heading"
				value="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/sample69.jpg" />
			<jsp:param name="profile"
				value="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/profile-sample5.jpg" />
			<jsp:param name="name" value="Desmond Eagle" />
			<jsp:param name="major" value="Accountant" />
			<jsp:param name="desc"
				value="If you want to stay dad you've got to polish your image. I
				think the image we need to create for you is 'repentant but
				learning'." />
		</jsp:include>
	</section>
</body>
</html>