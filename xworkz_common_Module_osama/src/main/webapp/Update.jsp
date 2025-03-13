<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update_user</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        background: linear-gradient(to right, #fff4a2, #e8f4ff);
        text-align: center;
    }

    header {
        background-color: #000;
        width: 100%;
        padding: 10px 0;
        text-align: center;
    }

    header img {
        width: 120px;
        height: auto;
        transition: transform 0.3s ease-in-out;
    }

    header img:hover {
        transform: scale(1.1);
    }

    .container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        padding: 20px;
        border-radius: 15px;
        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
        background: rgba(255, 255, 255, 0.1);
        backdrop-filter: blur(10px);
        width: 350px;
        height: 55vh;
        margin-top: 80px;
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

    .container img {
        width: 80px;
        height: auto;
        margin-bottom: 15px;
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

    .button {
        position: absolute;
        top: 10px;
        left: 10px;
    }

    .menu-icon {
        font-size: 26px;
        cursor: pointer;
        color: rgb(65, 65, 65);
        background: none;
        border: none;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #fff;
        min-width: 120px;
        box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.3);
        border-radius: 5px;
        left: 0;
        z-index: 1;
        animation: slideDown 0.3s ease-in-out;
    }

    @keyframes slideDown {
        from {
            transform: translateY(-10px);
            opacity: 0;
        }
        to {
            transform: translateY(0);
            opacity: 1;
        }
    }

    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        background-color: #f8f9fa;
        border-bottom: 1px solid #ddd;
        transition: background 0.3s ease-in-out;
    }

    .dropdown-content a:last-child {
        border-bottom: none;
    }

    .dropdown-content a:hover {
        background-color: #ffdf60;
    }

    .button.active .dropdown-content {
        display: block;
    }

    h2 {
        color: rgb(126, 126, 126);
        font-size: 20px;
        margin-top: 10px;
    }
</style>
</head>

<body>
<header>
    <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="logo">
</header>

<div class="container">
     <div class="button">
       <button class="menu-icon" onclick="toggleDropdown()">
           <i class="bi bi-three-dots"></i>
       </button>
       <div class="dropdown-content">
           <a href="updateDetails?email=${email}">Update Profile</a>
           <a href="deleteData?email=${email}">Delete Account</a>
           <a href="index">Log out</a>
       </div>
     </div>
     <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png" alt="User">
     <h2>${email}</h2>
</div>

<script>
    function toggleDropdown() {
        document.querySelector(".button").classList.toggle("active");
    }

    window.onclick = function(event) {
        if (!event.target.closest('.button')) {
            let dropdown = document.querySelector(".button");
            if (dropdown.classList.contains("active")) {
                dropdown.classList.remove("active");
            }
        }
    };
</script>
</body>
</html>