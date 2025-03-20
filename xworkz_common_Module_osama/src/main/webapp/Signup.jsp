<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup_module</title>
    <style>
                    body {
                        background: linear-gradient(120deg, #fffcc2, #fff478);
                        font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
                        margin: 0;
                        padding: 0;
                    }

                    header {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        background-color: #000;
                        padding: 20px 10%;
                        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                        animation: slideDown 1s ease-in-out;
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

                    header img {
                        max-height: 50px;
                    }

                    .nav-buttons a {
                        text-decoration: none;
                        color: white;
                        font-size: 16px;
                        padding: 10px 15px;
                        border-radius: 5px;
                        background: #ffeb14;
                        transition: 0.3s ease-in-out;
                    }

                    .nav-buttons a:hover {
                        background: #fefefd;
                        color: #000;
                        transform: scale(1.1);
                    }

                    .form-container {
                        width: 40%;
                        margin: 40px auto;
                        padding: 30px;
                        background-color: white;
                        border-radius: 8px;
                        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
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

                    .form-container h2 {
                        text-align: center;
                        margin-bottom: 20px;
                    }

                    .form-container h4 {
                        text-align: center;
                        margin-bottom: 15px;
                    }

                    .form-container input[type="text"],
                    .form-container input[type="email"],
                    .form-container input[type="number"],
                    .form-container input[type="date"],
                    .form-container input[type="tel"],
                    .form-container input[type="password"],
                    .form-container select {
                        width: 100%;
                        padding: 12px;
                        margin: 8px 0 18px 0;
                        border: 1px solid #ddd;
                        border-radius: 5px;
                        font-size: 14px;
                        transition: 0.3s;
                    }

                    .form-container input:focus,
                    .form-container select:focus {
                        outline: none;
                        border-color: #ffeb14;
                        box-shadow: 0 0 5px rgba(255, 235, 20, 0.7);
                        transform: scale(1.02);
                    }

                    .form-container input[type="submit"] {
                        background-color: #ffcc00;
                        color: black;
                        padding: 12px 25px;
                        border: none;
                        cursor: pointer;
                        border-radius: 5px;
                        font-size: 16px;
                        width: 100%;
                        transition: 0.4s;
                    }

                    .form-container input[type="submit"]:hover {
                        background-color: #ffd900;
                        transform: scale(1.05);
                        box-shadow: 0px 5px 10px rgba(255, 204, 0, 0.6);
                    }

                    .form-container input[name="captcha"] {
                        width: calc(100% - 100px);
                        padding: 10px;
                        margin: 8px 0;
                        border: 1px solid #ddd;
                        border-radius: 5px;
                        font-size: 10px;
                        transition: 0.3s;
                        display: inline-block;
                    }

                    .form-container img {
                        display: inline-block;
                        vertical-align: middle;
                        margin-left: 5px;
                        border-radius: 5px;
                    }

                    .form-container a {
                        display: inline-block;
                        text-decoration: none;
                        color: white;
                        background: #ffcc00;
                        padding: 8px 15px;
                        font-size: 8px;
                        border-radius: 2px;
                        margin-left: 10px;
                        transition: 0.3s ease-in-out;
                    }

                    .form-container a:hover {
                        background: #ffd900;
                        color: black;
                        transform: scale(1.1);
                        box-shadow: 0px 5px 10px rgba(255, 204, 0, 0.6);
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
             <a href="signin">Sign In</a>
        </div>
     </header>

    <div class="form-container">
        <h2>SignUp</h2>
        <h4>Enter your Details</h4>
    <form action="signup" method="post">

                        <input type="text" id="userName" onChange="onUserName()" onblur= "onUserName()" name="userName"
                            placeholder="Enter your user name" value="${dto.userName}">
                        <span id="displayUserName" style="color: red;"></span>
                        <c:if test="${not empty userNameError}">
                            <div style="color: red;">
                                <c:out value="${userNameError}" />
                            </div>
                        </c:if>

                        <input type="text" id="loginId" onChange="onLoginId()" name="loginId" placeholder="Enter your login Id"
                            value="${dto.loginId}">
                        <span id="displayLoginId" style="color: red;"></span>
                        <c:if test="${not empty loginIdError}">
                            <div style="color: red;">
                                <c:out value="${loginIdError}" />
                            </div>
                        </c:if>

                        <input type="text" id="email" onChange="onEmail()" name="email" placeholder="Enter your email"
                            value="${dto.email}">

                        <span id="displayEmail" style="color: red;"></span>
                        <c:if test="${not empty emailError}">
                            <div style="color: red;">
                                <c:out value="${emailError}" />
                            </div>
                        </c:if> </br>

                        <label>Gender:</label>
                        <input type="radio" name="gender" value="male">
                        <label for="male">Male</label>
                        <input type="radio" name="gender" value="female">
                        <label for="female">Female</label>
                        <input type="radio" name="gender" value="others">
                        <label for="female">Others</label> <br>

                        <input type="text" id="age" onChange="onAge()" name="age"  placeholder="Enter your age" value="${dto.age}">
                        <span id="displayAge" style="color: red;"></span>
                        <c:if test="${not empty ageError}">
                            <div style="color: red;">
                                <c:out value="${ageError}" />
                            </div>
                        </c:if>


                        <input type="text" id="dob" name="dob" placeholder="Enter your DOB" value="${dto.dob}">


                        <input type="text" id="phoneNo" onChange="onPhoneNo()" name="phoneNo"
                            placeholder="Enter your Phone Number" value="${dto.phoneNo}">

                        <span id="displayPhoneNo" style="color: red;"></span>
                        <c:if test="${not empty phoneNoError}">
                            <div style="color: red;">
                                <c:out value="${phoneNoError}" />
                            </div>
                        </c:if> </br>

                        <select id="dropdown" name="location">
                            <c:forEach items="${list}" var="location">
                                <option value="${location.name()}">
                                    ${location.name()}
                                </option>
                            </c:forEach>
                        </select>

                        <input type="text" name="captcha" placeholder="Enter Captcha" /><br>

                            <p style="font-weight: bold; font-size: 18px;">
                               <span style="color: yellow;">${captchaText}</span>
                            </p>

                        <a href="signup">Refresh CAPTCHA</a><br>
                        <span style="color: red;">${captchaError}</span> <br>
                        <br>
                        <input type="submit" value="Submit">
    </form>
    </div>
<script>
    function onUserName() {
        console.log('user Name from Ajax & Js');
        var nameElement = document.getElementById('userName');
        var nameValue = nameElement.value.trim();
        var displayError = document.getElementById("displayUserName");
        var submitButton = document.getElementById("submitButton");

        var usernamePattern = /^[A-Z][a-z]{2,24}$/;


        if (nameValue === "") {
            displayError.innerHTML = "User Name cannot be empty.";
            submitButton.disabled = true;
            return;
        }


        if (!usernamePattern.test(nameValue)) {
            displayError.innerHTML = "Invalid User Name! It must contain only letters 3-25 characters";
            submitButton.disabled = true;
            return;
        }

        var xhttp = new XMLHttpRequest();
        if (nameValue !== "") {
            xhttp.open("GET", "http://localhost:2004/xworkz_common_Module_osama/userName/" + nameValue);
            xhttp.send();

            xhttp.onload = function () {
                console.log(this.responseText)
                document.getElementById("displayUserName").innerHTML = this.responseText;
            }
        }
    }

    function onLoginId() {
        console.log('LoginId from Ajax & Js');
        var nameElement = document.getElementById('loginId');
        var nameValue = nameElement.value.trim();
        var displayError = document.getElementById("displayLoginId");
        var submitButton = document.getElementById("submitButton");

        var loginIdPattern = /^\d+$/;


        if (loginIdPattern === "") {
            displayError.innerHTML = "LoginId cannot be empty.";
            submitButton.disabled = true;
            return;
        }


        if (!loginIdPattern.test(nameValue)) {
            displayError.innerHTML = "Invalid LoginId! Only numbers are allowed";
            submitButton.disabled = true;
            return;
        }

        var xhttp = new XMLHttpRequest();
        if (nameValue !== "") {
            xhttp.open("GET", "http://localhost:2004/xworkz_common_Module_osama/loginId/" + nameValue);
            xhttp.send();

            xhttp.onload = function () {
                console.log(this.responseText)
                document.getElementById("displayLoginId").innerHTML = this.responseText;
            }
        }
    }

    function onAge() {
        console.log('Age from Ajax & Js');
        var nameElement = document.getElementById('age');
        var nameValue = nameElement.value.trim();
        var displayError = document.getElementById("displayAge");
        var submitButton = document.getElementById("submitButton");

        var agePattern = /^\d+$/;


        if (agePattern === "") {
            displayError.innerHTML = "Age cannot be empty.";
            submitButton.disabled = true;
            return;
        }


        if (!agePattern.test(nameValue)) {
            displayError.innerHTML = "Invalid Age! Only numbers are allowed";
            submitButton.disabled = true;
            return;
        }
        var ageNumber = parseInt(nameValue, 10);
            if (ageNumber <= 18 || ageNumber >= 100) {
                displayError.innerHTML = "Age must be 18";
                submitButton.disabled = true;
                return;
            }
            submitButton.disabled = false;
            displayError.innerHTML = "";

        var xhttp = new XMLHttpRequest();
        if (nameValue !== "") {
            xhttp.open("GET", "http://localhost:2004/xworkz_common_Module_osama/age/" + nameValue);
            xhttp.send();

            xhttp.onload = function () {
                console.log(this.responseText)
                document.getElementById("displayAge").innerHTML = this.responseText;
            }
        }
    }

    function onEmail() {
        console.log('user Email from Ajax & Js');
        var name = document.getElementById('email');
        var nameValue = email.value;
        var displayError = document.getElementById("displayEmail");

        var emailPattern = /^[a-z0-9._]+@gmail\.com$/;

        if (emailPattern === "") {
            displayError.innerHTML = "Email cannot be empty.";
            return;
        }

        if (!emailPattern.test(nameValue)) {
            displayError.innerHTML = "Invalid Email! and it must end with @gmail.com.";
            return;
        }
        var xhttp = new XMLHttpRequest();
        if (nameValue !== "") {
            xhttp.open("GET", "http://localhost:2004/xworkz_common_Module_osama/email/" + nameValue);
            xhttp.send();

            xhttp.onload = function () {
                console.log(this.responseText)
                document.getElementById("displayEmail").innerHTML = this.responseText;
            }
        }
    }

    function onPhoneNo() {
        console.log('Phone from Ajax & Js');
        var name = document.getElementById('phoneNo');
        var nameValue = phoneNo.value.trim();
        var displayError = document.getElementById("displayPhoneNo");
        var submitButton = document.getElementById("submitButton");
        var phonePattern = /^[967]\d{9}$/;

        if (phoneValue === "") {
            displayError.innerHTML = "Phone Number cannot be empty.";
            submitButton.disable = true;
            return;
        }

        if (!phonePattern.test(phoneValue)) {
            displayError.innerHTML = "Invalid Phone Number! It must start with 9, 7, or 6 and be exactly 10 digits";
            submitButton.disable = true;
            return;
        }

        var xhttp = new XMLHttpRequest();
        if (nameValue !== "") {
            xhttp.open("GET", "http://localhost:2004/xworkz_common_Module_osama/phoneNo/" + nameValue);
            xhttp.send();

            xhttp.onload = function () {
                console.log(this.responseText)
                document.getElementById("displayPhoneNo").innerHTML = this.responseText;
            }
        }
    }

</script>
</body>

</html>