<%@ page isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update_user</title>
    <style>

        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
        }

        header {
            background-color: #000;
            width: 100%;
            height: auto;
            position: absolute;
            top: 0px;
            left: 0;
        }


        header img {
            width: 100px;
            height: auto;
        }


        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            background-color: #ecff5a;
            width: 300px;
            margin-top: 80px;
        }

        .container img {
            width: 100px;
            height: auto;
            margin-bottom: 10px;
        }

        .button {
            margin-top: 20px;
        }

        .button a {
            text-decoration: none;
            background-color: #ffec1d;
            color: rgb(50, 50, 50);
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            display: inline-block;
            transition: background 0.3s ease;
        }

        .button a:hover {
            background-color: #f9ffbf;
        }
    </style>
</head>

<body>

    <header>
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="logo">
    </header>
    <div class="container">
        <img src="https://cdn-icons-png.freepik.com/256/1362/1362983.png?ga=GA1.1.964938970.1741070753&semt=ais_hybrid"
            alt="logo">
        <h2>${email}</h2>
    </div>
    <div class="button">
        <a href="updateDetails?email=${email}">Profile Update</a>
    </div>

</body>

</html>