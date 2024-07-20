package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.sql.SQLException;

import dao.StudentDAO;


@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");

        Student student = new Student(studentId, studentName);

        try {
            studentDAO.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("students.jsp");
    }
}

