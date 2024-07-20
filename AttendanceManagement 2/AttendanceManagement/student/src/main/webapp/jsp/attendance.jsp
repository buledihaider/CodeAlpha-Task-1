<%@ page contentType="text/html;charset=UTF-8" import="java.util.List, java.util.ArrayList"
import="model.Attendance" import="model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Attendance Report</title>
</head>
<body>
<h1>Attendance Report</h1>
<%
    List<model.Attendance> attendanceList = (List<model.Attendance>) request.getAttribute("attendanceList");
    if (attendanceList != null) {
        for (model.Attendance attendance : attendanceList) {
%>
            <p>
                Student ID: <%= attendance.getStudent().getId() %><br>
                Student Name: <%= attendance.getStudent().getName() %><br>
                Date: <%= attendance.getDate() %><br>
                Present: <%= attendance.isPresent() %>
            </p>
<%
        }
    } else {
%>
        <p>No attendance records found.</p>
<%
    }
%>
</body>
</html>
