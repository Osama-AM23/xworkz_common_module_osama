<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signin Module</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
        }

        body {
            background: linear-gradient(120deg, #ffe476, #ffeca1);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
            position: relative;
        }

        header {
            position: absolute;
            top: 0;
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: rgba(0, 0, 0, 0.8);
            padding: 20px 10%;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            animation: slideDown 1s ease-in-out;
        }

        header img {
            max-height: 50px;
        }

        header .nav-buttons a {
            text-decoration: none;
            color: white;
            font-size: 16px;
            padding: 10px 15px;
            border-radius: 5px;
            background: #d2b647;
            transition: 0.3s;
        }

        header .nav-buttons a:hover {
            background: #ffe75d;
            transform: scale(1.1);
        }

        .form-container {
            width: 30%;
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.2);
            text-align: center;
            animation: fadeIn 1.5s ease-in-out;
        }

        .form-container h2 {
            margin-bottom: 20px;
            font-size: 24px;
        }

        .form-container input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: none;
            border-bottom: 2px solid #ddd;
            font-size: 16px;
            outline: none;
            transition: 0.3s;
        }

        .form-container input:focus {
            border-bottom: 2px solid #ffcc00;
            transform: scale(1.02);
        }

        .form-container a {
            display: block;
            text-decoration: none;
            color: #000000;
            margin-bottom: 15px;
            transition: 0.3s;
        }

        .form-container a:hover {
            color: #ffaa00;
        }

        .form-container input[type="submit"] {
            background: #fff134;
            color: black;
            font-size: 18px;
            font-weight: bold;
            border: none;
            cursor: pointer;
            transition: 0.4s;
        }

        .form-container input[type="submit"]:hover {
            background: #ffe32c;
            transform: scale(1.05);
            box-shadow: 0px 5px 10px rgba(255, 253, 138, 0.6);
        }

        @keyframes slideDown {
            from {
                transform: translateY(-100%);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        @media (max-width: 768px) {
            .form-container {
                width: 80%;
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
            <p style="color:red">${error}</p>
            <c:if test="${not empty errorMessage}">
                <div class="error-message">
                    <p>${errorMessage}</p>
                </div>
            </c:if>
            <input type="text" name="email" placeholder="Enter your email">
            <input type="password" name="password" placeholder="Enter your password">
            <a href="forgetPassword">Forgot password?</a>
            <input type="submit" value="SIGN IN">
        </form>
    </div>
</body>

</html>
