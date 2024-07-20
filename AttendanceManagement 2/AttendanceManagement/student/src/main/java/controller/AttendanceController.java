package controller;

import dao.AttendanceDAO;

import dao.StudentDAO;
import model.Attendance;
import model.Student;
import view.AttendanceView;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class AttendanceController {
    private AttendanceDAO attendanceDAO;
    private StudentDAO studentDAO;
    private AttendanceView view;

    public AttendanceController(AttendanceView view) {
        this.attendanceDAO = new AttendanceDAO();
        this.studentDAO = new StudentDAO();
        this.view = view;
    }

    public void markAttendance(Student student, Date date, boolean present) throws SQLException {
        Student existingStudent = studentDAO.getStudent(student.getId());
        if (existingStudent == null) {
            studentDAO.addStudent(student);
        }
        if (date != null) {
            attendanceDAO.addAttendance(new Attendance(student, date, present));
        }
    }

    public List<Attendance> getAttendanceReport() throws SQLException {
        return attendanceDAO.getAttendance();
    }

    public void updateView() throws SQLException {
        List<Attendance> attendanceList = getAttendanceReport();
        view.printAttendanceReport(attendanceList);
    }
}
