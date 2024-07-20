package model;

import java.util.Date;

public class Attendance {
    private Student student;
    private Date date;
    private boolean present;

    public Attendance(Student student, Date date, boolean present) {
        this.student = student;
        this.date = date;
        this.present = present;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}

