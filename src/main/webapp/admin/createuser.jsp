<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<html>
<body>

<form action="/createUser" method="post">
<div class="container my-4">
    <div class="mb-3">
      <label for="formGroupExampleInput" class="form-label">Enter Your Name</label>
      <input type="text" class="form-control" id="formGroupExampleInput" name="name" placeholder="Enter your name">
    </div>
    <div class="mb-3">
      <label for="formGroupExampleInput2" class="form-label">Username</label>
      <input type="text" class="form-control" id="formGroupExampleInput2" name="username" placeholder="Enter Username">
    </div>
    <div class="mb-3">
          <label for="formGroupExampleInput2" class="form-label">Password</label>
          <input type="text" name="password" class="form-control" id="formGroupExampleInput2" placeholder="Enter Your password">
        </div>
    <div class="mb-3">
              <label for="formGroupExampleInput2" class="form-label">Email</label>
              <input type="email" class="form-control" name="email" placeholder="Enter your Email">
    </div>
    <div class="mb-3">
          <label for="formGroupExampleInput2" class="form-label">Phone</label>
          <input type="text" class="form-control" name="phone"  placeholder="Enter Phone Number">
    </div>
    <label>Is active?</label>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="active" value="true" >
      <label class="form-check-label" for="flexRadioDefault1">
        Yes
      </label>
    </div>
    <div class="form-check">
      <input class="form-check-input" type="radio" name="active" value="false" checked>
      <label class="form-check-label" for="flexRadioDefault2">
        No
      </label>
    </div>
      <div class="my-2">
     <input type="submit" value="Submit" class="btn btn-warning">
     </div>
</div>
<form>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>