package com.example.studenmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice = -1;

        do {
            System.out.println("\n1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Tim sinh vien");
            System.out.println("4. Hien thi tat ca");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");

            int input = sc.nextInt();
            choice = input; 

            switch (choice) {
                case 1:
                    service.addStudent(null);
                    break;
                case 2:
                    service.deleteStudent(sc);
                    break;
                case 3:
                    service.searchStudent(sc);
                    break;
                case 4:
                    service.displayAll();
                    break;
                case 5:
                    System.out.println("bye!");
                    break;
                default:
                    System.out.println("Lua chon sai!");
            }

        } while (choice != 5);
        sc.close();
    
    }
}