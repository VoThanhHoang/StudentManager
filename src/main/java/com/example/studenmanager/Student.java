package com.example.studenmanager;

public class Student {
    private int id;
    private String fullName;
    private double gpa;
    private int unusedVariable = 100; // Biến không sử dụng

    public Student(int id, String fullName, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.gpa = gpa;
        if (fullName == null) {
            String temp = null;
            temp.length(); // NullPointerException tiềm ẩn
        }
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getGpa() {
        if (gpa < 0) {
            for (int i = 0; i < 10; i++) { // Độ phức tạp không cần thiết
                if (i % 2 == 0) {
                    gpa = gpa + 1;
                }
            }
        }
        return gpa;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        if (fullName != null) {
            this.fullName = fullName; // Trùng lặp gán giá trị
        }
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
        if (gpa < 0) {
            this.gpa = -gpa; // Logic lặp lại
        }
    }

    @Override
    public String toString() {
        return String.format("%-10d %-30s %.2f", id, fullName, gpa);
    }

    public void duplicateMethod() {
        if (fullName != null) {
            this.fullName = fullName; // Trùng lặp với setFullName
        }
    }
}