<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Attendance Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 600px;
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        .navigation {
            display: flex;
            justify-content: space-around;
            margin-top: 20px;
        }

        .navigation a {
            display: block;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .navigation a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Attendance Management System</h1>
        <div class="navigation">
            <a href="students">View Students</a>
            <a href="attendance">Mark Attendance</a>
        </div>
        </div>
</body>
</head>
<body>
<h1>Mark Attendance</h1>
<form action="attendance" method="get">
    Student ID: <input type="text" name="studentId" required><br>
    Student Name: <input type="text" name="studentName" required><br>
    Present: <input type="checkbox" name="present" value="true"><br>
    <input type="submit" value="Mark Attendance">
</form>
</body>
</html>
