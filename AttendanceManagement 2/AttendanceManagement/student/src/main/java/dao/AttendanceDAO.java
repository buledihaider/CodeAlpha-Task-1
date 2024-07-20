package dao;

import model.Attendance;
import model.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public void addAttendance(Attendance attendance) throws SQLException {
        String sql = "INSERT INTO attendance (student_id, date, present) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, attendance.getStudent().getId());
            stmt.setDate(2, new Date(attendance.getDate().getTime()));
            stmt.setBoolean(3, attendance.isPresent());
            stmt.executeUpdate();
        }
    }

    public List<Attendance> getAttendance() throws SQLException {
        String sql = "SELECT * FROM attendance";
        List<Attendance> attendanceList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String studentId = rs.getString("student_id");
                Date date = rs.getDate("date");
                boolean present = rs.getBoolean("present");
                Student student = new StudentDAO().getStudent(studentId);
                attendanceList.add(new Attendance(student, date, present));
            }
        }
        return attendanceList;
    }
}
