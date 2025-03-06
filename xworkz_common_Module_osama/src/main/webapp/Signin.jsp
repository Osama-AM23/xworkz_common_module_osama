<%@ page isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin_module</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
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
        .error-message {
            color: red;
            font-weight: bold;
            text-align: center;
            margin-top: 10px;
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
        <form action="signin" method="post">
            <h2>Enter your Details</h2>
            <c:if test="${not empty errorMessage}">
                    <div class="error-message">
                        <p>${errorMessage}</p>
                    </div>
                </c:if>
                
            <h4><i class="bi bi-envelope"></i>   Email:</h4>
            <input type="text" name="email" placeholder="Enter your email">
            <h4><i class="bi bi-key-fill"></i>    Password:</h4>
            <input type="password" name="password" placeholder="Enter your password">
            <input type="submit" value="SIGNIN">
        </form>
    </div>
</body>

</html>