package com.example.studenmanager;


import java.util.ArrayList;
import java.util.Scanner;


public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();
    private final int MAX = 100;

    public void addStudent(Scanner sc) {
        if (students.size() >= MAX) {
            System.out.println("Danh sach đa đay.");
            return;
        }

        System.out.print("Nhap ID: ");
        int id = sc.nextInt(); sc.nextLine();

        if (getStudentById(id) != null) {
            System.out.println("ID đa ton tai.");
            return;
        }

        System.out.print("Nhap ho ten: ");
        String name = sc.nextLine();
        if (name.length() > 50) {
            System.out.println("Ten khong đuoc vuot qua 50 ky tu.");
            return;
        }

        System.out.print("Nhap GPA: ");
        double gpa = sc.nextDouble();
        if (gpa < 0.0 || gpa > 4.0) {
            System.out.println("GPA khong hop le.");
            return;
        }

        students.add(new Student(id, name, gpa));
        System.out.println("Them thanh cong.");
    }

    public void deleteStudent(Scanner sc) {
        System.out.print("Nhap ID can xoa: ");
        int id = sc.nextInt();
        Student s = getStudentById(id);
        if (s != null) {
            students.remove(s);
            System.out.println("Da xoa.");
        } else {
            System.out.println("Khong tim thay.");
        }
    }

    public void searchStudent(Scanner sc) {
        System.out.print("Nhap ten (mot phan hoac toan bo): ");
        String keyword = sc.nextLine().toLowerCase();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(keyword)) {
                System.out.println(s);
            }
        }
    }

    public void displayAll() {
        System.out.println("Danh sach sinh vien:");
        System.out.printf("%-10s %-30s %s\n", "ID", "Name", "GPA");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
