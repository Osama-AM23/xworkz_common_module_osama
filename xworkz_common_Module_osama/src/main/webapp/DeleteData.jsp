<%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Delete_User</title>
            <style>
                body {
                    background-color: #fff;
                    font-family: Arial, sans-serif;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 100vh;
                    margin: 0;
                    flex-direction: column;
                }

                body img {
                    max-width: 100%;
                    height: auto;
                    width: 300px;
                    margin-bottom: 20px;
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

                body img {
                    animation: fadeIn 1s ease-in-out;
                }


                body h2 {
                    font-size: 24px;
                    font-weight: bold;
                    color: #45aae8;
                    text-align: center;
                    margin-top: 20px;
                    padding: 10px 20px;
                }

                .buttons {
                    display: flex;
                    justify-content: center;
                    margin-top: 20px;

                }

                .buttons a {
                    text-decoration: none;
                    padding: 4px 10px;
                    margin: 0 15px;
                    border-radius: 5px;
                    font-size: 10px;
                    font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                    color: black;
                    background-color: #fff;
                }

                .buttons a:hover {
                    background-color: #45aae8;
                }
            </style>
        </head>



        <body>

            <img src="https://img.freepik.com/free-vector/inbox-cleanup-concept-illustration_114360-27345.jpg?ga=GA1.1.964938970.1741070753&semt=ais_hybrid"
                alt="logo">

            <h2>Your Account is Deleted Successfull</h2>

            <div class="buttons">
                <a href="index">Home</a>
                <a href="signup">Sign Up</a>
            </div>
        </body>

        </html>