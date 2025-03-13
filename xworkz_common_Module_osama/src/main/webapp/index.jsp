<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz_Module</title>
    <style>
        body {
            margin: 0;
            font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
            background-color: #fff;
            animation: fadeIn 1.5s ease-in-out;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #000000f3;
            box-shadow: 5px 5px 5px 0px rgba(78, 78, 78, 0.45);
            padding: 10px 20px;
            transition: all 0.5s ease-in-out;
        }

        .logo img {
            height: 50px;
            transition: transform 0.3s ease-in-out;
        }

        .logo img:hover {
            transform: scale(1.1);
        }

        .buttons {
            display: flex;
            justify-content: center;
        }

        .buttons a {
            text-decoration: none;
            padding: 10px 20px;
            margin: 0 10px;
            border-radius: 5px;
            font-size: 15px;
            color: black;
            background-color: #fff764;
            transition: background-color 0.3s ease-in-out, transform 0.3s ease-in-out;
        }

        .buttons a:hover {
            background-color: #ffffff;
            transform: translateY(-3px);
        }

        .image {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
        }

        .image img {
            width: 100%;
            max-width: 300px;
            height: auto;
            display: flex;
            animation: bounce 2s infinite;
        }

        @keyframes bounce {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-10px);
            }
        }

        .text {
            text-align: center;
            margin-top: 20px;
            color: #333;
            animation: slideIn 1.5s ease-in-out;
        }

        @keyframes slideIn {
            from {
                transform: translateY(30px);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        .text h3 {
            font-size: 28px;
            font-weight: bold;
            color: #8f8c45;
        }

        .text h2 {
            font-size: 18px;
            line-height: 1.5;
            color: #b2b091;
        }
    </style>
</head>

<body>
    <header class="header">
        <div class="logo">
            <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Logo">
        </div>
        <div class="buttons">
            <a href="signup">SignUp</a>
            <a href="signin">SignIn</a>
        </div>
    </header>

    <div class="image">
        <div>
            <img src="https://img.freepik.com/premium-vector/web-development-programming-languages-css-html-it-ui-programmer-cartoon-character-developing-website-coding-flat-illustration-banner_128772-898.jpg?ga=GA1.1.964938970.1741070753&semt=ais_hybrid" alt="logo">
        </div>
    </div>

    <div class="text">
        <h3>Welcome</h3>
        <h2>FREE 1 months class for any Graduates<br><br>
            Contact :<br><br>
            9886971480 / 9886971483<br><br>
            Upcoming batches
        </h2>
    </div>
</body>

</html>
