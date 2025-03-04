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
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #000000f3;
            box-shadow: 5px 5px 5px 0px rgba(78, 78, 78, 0.45);
            padding: 10px 20px;
        }

        .logo img {
            height: 50px;
        }
        .buttons {
            display: flex;
            justify-content: center;
            margin-top: 20px;

        }
        .buttons a {
            text-decoration: none;
            padding: 10px 20px;
            margin: 0 10px;
            border-radius: 5px;
            font-size: 15px;
            font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
            color: black;
            background-color: #fff764 ;
        }
        .buttons a:hover {
            background-color: #ffffff ;
        }

        .image {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 10px;
        }

        .image img {
            width: 100%;
            max-width: 300px;
            height: auto;
            display: flex;
        }
        .text {
            text-align: center;
            margin-top: 20px;
            font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
            color: #333;
        }
        .text h3 {
            font-size: 28px;
            font-weight: bold;
            margin-top: 0;
            color: #8f8c45;
        }
        .text h2 {
            font-size: 18px;
            font-weight: 200px;
            line-height: 1.0;
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
            <a href="login">SignIn</a>
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