<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up </title>
    <!-- Main css -->
<link rel="stylesheet" href="http://localhost:8080/Registration/css/style.css">
</head>
<body>

    <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
				                        <form method="POST" class="register-form" id="register-form" action="/Registration/RegistrationCtl">
				                            <div class="form-group">
				                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
				                                <input type="text" name="fname" id="name" placeholder="First Name"/>
				                            </div>
				                            <div class="form-group">
				                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
				                                <input type="text" name="lname" id="name" placeholder="Last Name"/>
				                            </div>
				                            <div class="form-group">
				                                <label for="email"><i class="zmdi zmdi-email"></i></label>
				                                <input type="email" name="email" id="email" placeholder="Your Email"/>
				                            </div>
				                            <div class="form-group">
				                                <label for="mobile"><i class="zmdi zmdi-email"></i></label>
				                                <input type="text" name="mobile" id="email" placeholder="Your Number"/>
				                            </div>
				                    
				                            <div class="form-group">
				                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
				                                <input type="password" name="pass" id="pass" placeholder="Password"/>
				                            </div>
				                            <div class="form-group">
				                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
				                                <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password"/>
				                            </div>
				                            <div class="form-group">
				                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
				                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
				                            </div>
				                            <div class="form-group form-button">
				                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
				                           <input type="Reset" id="signup" class="form-submit">
				                            </div>
				                            
				                                            
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="http://localhost:8080/Registration/images/signup-image.jpg" alt="Signup image"></figure>
                         
                        <a href="#" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>

        
</body></html>