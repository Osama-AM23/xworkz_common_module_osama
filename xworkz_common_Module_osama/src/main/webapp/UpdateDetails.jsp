<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update_Users</title>

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

        #dropdown {
            width: 200px;
            padding: 8px;
            font-size: 16px;
            border: 2px solid #4CAF50;
            border-radius: 5px;
            background-color: #f9f9f9;
            color: #333;
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
        }

        #dropdown::after {
            content: '▼';
            font-size: 16px;
            color: #000;
            position: absolute;
            right: 10px;
            top: calc(50% - 9px);
            pointer-events: none;
        }

        #dropdown option {
            padding: 10px;
            background-color: #fffcc2;
            color: #000;
            font-size: 14px;
        }

        #dropdown option:hover {
            background-color: #000;
        }

        #dropdown:focus {
            outline: none;
            border-color: #000;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
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
        </div>
    </header>

    <div class="form-container">

        <form action="updateDetails" method="post">
            <h2>Update your Details</h2>
            <input type="text" name="userName" placeholder="Enter your User Name" value="${dto.userName}">
            <input type="hidden" name="loginId" value="${dto.loginId}" readonly>
            <input type="text" name="email" placeholder="Enter your Email" readonly value="${dto.email}">
            <input type="hidden" name="gender" value="${dto.gender}" readonly>
            <input type="text" name="phoneNo" placeholder="Enter your Phone Number" value="${dto.phoneNo}">
            <input type="hidden" name="dob" value="${dto.dob}" readonly>
            <input type="text" name="age" placeholder="Enter your Age" value="${dto.age}">
            <select id="dropdown" name="location" value="${dto.location}">
                            <c:forEach items="${list}" var="location">
                                <option value= "${location}">${location}</option>
                            </c:forEach>
            </select>
            <input type="password" name="password" placeholder="Enter your Password" >
            <input type="password" name="confirmPassword" placeholder="Enter Your Confirm Password">
            <input type="submit" value="Update">
        </form>
    </div>

</body>

</html>