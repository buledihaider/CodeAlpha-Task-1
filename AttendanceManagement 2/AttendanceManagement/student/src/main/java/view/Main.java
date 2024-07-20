package view;

import controller.AttendanceController;
import model.Student;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AttendanceView view = new AttendanceView();
        AttendanceController controller = new AttendanceController(view);

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
        	System.out.println("ATTENDANCE MANAGEMENT SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Attendance Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        Student student = new Student(id, name);
                        controller.markAttendance(student, new Date(), false); // Adding student without marking attendance
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter student ID: ");
                        String studentId = scanner.nextLine();
                        System.out.print("Is the student present? (true/false): ");
                        boolean present = scanner.nextBoolean();
                        scanner.nextLine(); // consume newline
                        Student studentForAttendance = new Student(studentId, ""); // Empty name as it's just for marking attendance
                        controller.markAttendance(studentForAttendance, new Date(), present);
                        System.out.println("Attendance marked successfully.");
                        break;
                    case 3:
                        controller.updateView();
                        break;
                    case 4:
                        scanner.close();
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
}
