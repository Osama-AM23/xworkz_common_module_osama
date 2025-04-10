<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>signIn-success</title>
    <style>
        body {
            background-color: #fff;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }

        .container img {
            max-width: 100%;
            height: auto;
            width: 300px;
            margin-bottom: 20px;
            animation: fadeIn 1s ease-in-out;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h2 {
            font-size: 24px;
            font-weight: bold;
            color: #ffc067;
            text-align: center;
            margin-top: 20px;
            padding: 10px 20px;
        }

        h3 {
            font-size: 20px;
            color: #333;
        }

        h4 {
            color: #ffd24adf;
            font-size: 14px;
        }

        .buttons {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .buttons a {
            text-decoration: none;
            padding: 8px 16px;
            margin: 0 10px;
            border-radius: 5px;
            font-size: 14px;
            font-family: Arial, sans-serif;
            color: black;
            background-color: #fff;
            border: 1px solid #ffca3a;
        }

        .buttons a:hover {
            background-color: #ffca3a;
        }
    </style>
</head>
<body>
    <div class="container">
        <img src="https://img.freepik.com/free-vector/tiny-people-standing-near-big-checkmark-team-male-female-characters-finishing-work-with-list-good-job-sign-flat-vector-illustration-done-job-checklist-time-management-concept_74855-21019.jpg?ga=GA1.1.964938970.1741070753&semt=ais_hybrid" alt="logo">
        <h3>Thank you!</h3>
        <h4>${email}</h4>
        <img src="download?fileName=${img}" alt="profile-image" width="auto" height="200">
        <h2>Your profile Updated Successfully</h2>
        <div class="buttons">
            <a href="index">Home</a>
        </div>
    </div>
</body>
</html>
