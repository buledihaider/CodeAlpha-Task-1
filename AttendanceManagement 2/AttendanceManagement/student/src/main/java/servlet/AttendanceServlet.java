package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import view.AttendanceView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import controller.AttendanceController;

@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {
    private AttendanceController controller;

    @Override
    public void init() throws ServletException {
        super.init();
        AttendanceView view = new AttendanceView();
        controller = new AttendanceController(view);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        boolean present = Boolean.parseBoolean(req.getParameter("present"));

        Student student = new Student(studentId, studentName);

        try {
            controller.markAttendance(student, new Date(), present);
            controller.updateView();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("index.jsp");
    }
}


