package view;

import model.Attendance;
import model.Student;

import java.util.List;

public class AttendanceView {

    public void printStudentDetails(Student student) {
        System.out.println("Student: ");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
    }

    public void printAttendanceReport(List<Attendance> attendanceList) {
        System.out.println("Attendance Report: ");
        for (Attendance attendance : attendanceList) {
            printStudentDetails(attendance.getStudent());
            System.out.println("Date: " + attendance.getDate());
            System.out.println("Present: " + attendance.isPresent());
            System.out.println("-----");
        }
    }
}
