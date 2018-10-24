<html>

<head>
<style>
input[type=text] {
	padding: 12px 20px;
	margin: 8px;
	color: green;
	size: 18;
	margin-left: 40px;
}

form {
	margin: 0 auto;
	width: 270;
	height: 200;
	border: 3px solid black;
	background-color: #66ffff;
}

h2 {
	margin-top: "45px" font-family: verdana;
}
</style>
</head>
<body>
	<h2 align="center">Welcome to AOS:</h2>

<!-- Pentru cazul in care vreau sa inserez utilizand al doilea mod
	trebuie sa inlocuiesc fisierul success.jsp cu numele portului
	la care i-am specificat in web.xml
 	<form name="f1" method="post" action="PostPerson"> -->
	<form name="f1" method="post" action="success.jsp">
		Name: <input type="text" name="name" /> <br>
		Email: <input type="text" name="email" /> <br> <br>
		<div align="center">
			<input type="submit" value="Submit" />
		</div>

	</form>
</body>
</html>
