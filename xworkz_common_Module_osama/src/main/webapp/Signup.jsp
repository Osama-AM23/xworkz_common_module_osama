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

                        <input type="text" id="userName" onChange="onUserName()" onblur="validate(event)" name="userName"
                            placeholder="Enter your user name" value="${dto.userName}">
                        <span id="displayUserName" style="color: red;"></span>
                        <span id="userNameError" style="color: red;"></span>
                        <c:if test="${not empty userNameError}">
                            <div style="color: red;">
                                <c:out value="${userNameError}" />
                            </div>
                        </c:if>

                        <input type="text" id="loginId" onblur="validate(event)" name="loginId" placeholder="Enter your login Id"
                            value="${dto.loginId}">
                        <span id="loginIdError" style="color: red;"></span>
                        <c:if test="${not empty loginIdError}">
                            <div style="color: red;">
                                <c:out value="${loginIdError}" />
                            </div>
                        </c:if>

                        <input type="text" id="email" onChange="onEmail()" onblur="validate(event)" name="email" placeholder="Enter your email"
                            value="${dto.email}">
                        <span id="emailError" style="color: red;"></span>
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

                        <input type="text" id="age" name="age" onblur="validate(event)" placeholder="Enter your age" value="${dto.age}">
                        <span id="userAgeError" style="color: red;"></span>
                        <c:if test="${not empty ageError}">
                            <div style="color: red;">
                                <c:out value="${ageError}" />
                            </div>
                        </c:if>


                        <input type="text" id="dob" name="dob" placeholder="Enter your DOB" value="${dto.dob}">


                        <input type="text" id="phoneNo" onChange="onPhoneNo()" onblur="validate(event)" name="phoneNo"
                            placeholder="Enter your Phone Number" value="${dto.phoneNo}">
                        <span id="phoneError" style="color: red;"></span>
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

                        <input type="text" name="captcha" placeholder="Enter CAPTCHA">
                        <img src="captcha" alt="CAPTCHA Image"> <br> <br>
                        <a href="signup">Refresh</a> <br>
                        <span style="color: red;">${captchaError}</span> <br>
                        <br>
                        <input type="submit" value="Submit">
    </form>
    </div>
    // Js Validation
    <script>
                    const checkBox = () => {
                        const userNameError = document.getElementById("userName").innerHTML = "";
                        const loginIdError = document.getElementsById("loginId").innerHTML = "";
                        const emailError = document.getElementById("email").innerHTML = "";
                        const userAgeError = document.getElementById("age").innerHTML = "";
                        const phoneError = document.getElementById("phoneNo").innerHTML = "";

                        const validation = userNameError && loginIdError && emailError && userAgeError && phoneError

                        document.getElementById("submitButton") != validation;
                    }

                    const validate = (event) => {
                        const { name, value } = event.target;

                        let ischeck = true;

                        if (name === "userName" && value.length < 3 && value.trim()) {
                            let check = document.getElementById("userNameError");
                            check.innerHTML = "User Name is Invalid, give Proper Username";
                            ischeck = false;
                        }

                        if (name === "loginId") {
                            let check = document.getElementById("loginIdError");

                            if (check) {

                               if (!/^\d+$/.test(value)) {
                                   check.innerHTML = "Login Id must contain only numbers";
                                   ischeck = false;
                               }
                               else {
                                  let loginIdValue = parseInt(value, 10);
                                  if (loginIdValue < 10 || loginIdValue > 9999) {
                                     check.innerHTML = "Login Id should be between 10 and 9999";
                                     ischeck = false;
                                  } else {
                                     check.innerHTML = "";
                                  }
                               }
                               }
                            }

                        if (name === "email" && value.trim() && !(value.includes("@gmail.com"))) {
                            let check = document.getElementById("emailError");
                            check.innerHTML = "Email Id is Invalid, it should be @gamil.com";
                            ischeck = false;
                        }

                        if (name === "age") {
                            let ageValue = parseInt(value, 18);
                            let check = document.getElementById("userAgeError");
                            if (ageValue >= 18 || ageValue <= 100) {
                                check.innerHTML = "Age should be above 18";
                                ischeck = false;
                            } else {
                                check.innerHTML = "";
                            }
                        }

                        if (name === "phoneNo") {
                            let phoneValue = parseInt(value, 10);
                            let check = document.getElementById("phoneError");
                            if (phoneValue < 1000000000 || phoneValue > 9999999999) {
                                check.innerHTML = "Phone Number should be 10 Digits";
                                ischeck = false;
                            } else {
                                check.innerHTML = "";
                            }
                        }


                    }

    </script>

    //AjAX Validation
    <script>
                    function onUserName() {
                        console.log('user Name from jsp');
                        var name = document.getElementById('userName');
                        var nameValue = userName.value;

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

                    function onEmail() {
                        console.log('user Email from jsp');
                        var name = document.getElementById('email');
                        var nameValue = email.value;

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
                        console.log('Phone from jsp');
                        var name = document.getElementById('phoneNo');
                        var nameValue = phoneNo.value;

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