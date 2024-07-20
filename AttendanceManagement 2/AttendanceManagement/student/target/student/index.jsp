<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Attendance Management System</title>
</head>
<body>
<h1>Mark Attendance</h1>
<form action="attendance" method="post">
    Student ID: <input type="text" name="studentId" required><br>
    Student Name: <input type="text" name="studentName" required><br>
    Present: <input type="checkbox" name="present" value="true"><br>
    <input type="submit" value="Mark Attendance">
</form>
</body>
</html>
