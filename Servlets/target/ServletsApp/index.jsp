<html>
<head>
    <title>Web</title>
    <link rel="stylesheet" href="style/bootstrap.css" type="text/css">
</head>
<body>
<div class="page-header">
    <h1>Login Form</h1>
    <a href="locationList.jsp">Location List</a>
    <a href="login.jsp">Login</a>
</div>
<div>
    <form class="navbar-form navbar-left" name="zerotohero" method="post" action="hello">
        <div class="form-group">
            <p>
                <label for="firstname">First Name:</label>
                <input class="form-control" type="text" id="firstname" name="firstname"/>
                <span id="firstname_error" class="error-span"></span>
            </p>

            <p>
                <label for="lastname">Last Name:</label>
                <input class="form-control" type="text" id="lastname" name="lastname"/>
                <span id="password_error" class="error-span"></span>
            </p>
        </div>
        <p>
            <input type="submit" class="btn btn-default navbar-btn" value="Submit">
        </p>
    </form>
</div>
</body>
</html>
