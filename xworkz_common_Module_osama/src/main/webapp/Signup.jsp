<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Page</title>
    <style>
        body {
            background-color: #fffcc2;
            font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #000000f3;
            padding: 20px 10%;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        header img {
            max-height: 50px;

        }

        header .nav-buttons {
            display: flex;
            gap: 20px;
        }

        header .nav-buttons a {
            text-decoration: none;
            color: #000;
            font-size: 16px;
            font-weight: bold;
            padding: 10px 15px;
            border-radius: 5px;
            background-color: #fffcc2;
            transition: background-color 0.3s;
        }

        header .nav-buttons a:hover {
            background-color: #ffd900;

        }

        .form-container {
            width: 40%;
            margin: 40px auto;
            padding: 30px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }


        .form-container label {
            display: inline-flex;
            margin-bottom: 5px;
            font-size: 16px;
            font-weight: bold;
            color: #333;
        }

        .form-container input[type="text"],
        .form-container input[type="email"],
        .form-container input[type="number"],
        .form-container input[type="date"],
        .form-container input[type="tel"],
        .form-container input[type="password"],
        .form-container input[type="radio"],
        .form-container select {
            width: 100%;
            padding: 12px;
            margin: 8px 0 18px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
        }

        .form-container input[type="radio"] {
            width: auto;
            display: inline-block;
            margin-right: 8px;
        }

        .form-container input[type="submit"] {
            background-color: #ffe476f3;
            color: white;
            padding: 12px 25px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 16px;
            width: 100%;
            margin-top: 20px;
        }

        .form-container input[type="submit"]:hover {
            background-color: #ffeb14;
        }

        @media (max-width: 768px) {
            .form-container {
                width: 80%;
            }

            header {
                padding: 20px 5%;
            }
        }
    </style>
</head>

<body>

    <header>
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="logo">
        <div class="nav-buttons">
            <a href="index">Home</a>
            <a href="signin">Sign In</a>
        </div>
    </header>

    <div class="form-container">
        <h2>SignUp</h2>
        <form action="#" method="post">

            <input type="text" id="username" name="userName" placeholder="Enter your user name" value="${dto.userName}">
            <c:if test="${not empty userNameError}">
                    <div style="color: red;">
                        <c:out value="${userNameError}" />
                    </div>
                </c:if>

            <input type="text" id="loginId" name="loginId" placeholder="Enter your login Id" value="${dto.loginId}">


            <input type="text" id="email" name="email" placeholder="Enter your email" value="${dto.email}">

            <label>Gender:</label>
            <input type="radio" id="male" name="gender" value="male">
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="female">
            <label for="female">Female</label>


            <input type="text" id="age" name="age" placeholder="Enter your age" value="${dto.age}">


            <input type="text" id="dob" name="dob" placeholder="Enter your DOB" value="${dto.dob}">


            <input type="text" id="phoneNo" name="phoneNo" placeholder="Enter your Phone No" value="${dto.phoneNo}">
            <c:if test="${not empty phoneNoError}">
                    <div style="color: red;">
                        <c:out value="${phoneNoError}" />
                    </div>
                </c:if>

            <input type="text" id="location" name="location" placeholder="Enter your location" value="${dto.location}">


            <input type="password" id="password" name="password" placeholder="Enter your password" value="${dto.password}">
            <c:if test="${not empty passwordError}">
                    <div style="color: red;">
                        <c:out value="${passwordError}" />
                    </div>
                </c:if>

            <input type="password" id="confirmPassword" name="confirmPassword"
                placeholder="Enter your Confirm Password" value="${dto.confirmPassword}">

            <input type="submit" value="Submit">
        </form>
    </div>

</body>

</html>