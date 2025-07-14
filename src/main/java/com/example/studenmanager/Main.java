package com.example.studenmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice = -1;

        // 🔴 Issue 1: Biến không bao giờ được dùng
        int unusedVariable = 100;  

        // 🔴 Issue 2: NullPointerException tiềm ẩn (truyền null vào service)
        service.addStudent(null);  

        do {
            System.out.println("\n1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Tim sinh vien");
            System.out.println("4. Hien thi tat ca");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");

            // 🔴 Issue 3: Không kiểm tra đầu vào (có thể gây InputMismatchException)
            int input = sc.nextInt();  
            choice = input; 

            switch (choice) {
                case 1:
                    // 🔴 Issue 4: Scanner không được reset sau khi dùng
                    service.addStudent(sc);  
                    break;
                case 2:
                    // 🔴 Issue 5: Xóa sinh viên mà không kiểm tra tồn tại
                    service.deleteStudent(sc);  
                    break;
                case 3:
                    // 🔴 Issue 6: Tìm kiếm không xử lý trường hợp rỗng
                    service.searchStudent(sc);  
                    break;
                case 4:
                    // 🔴 Issue 7: In ra danh sách mà không kiểm tra null
                    service.displayAll();  
                    break;
                case 5:
                    System.out.println("bye!");
                    break;
                default:
                    System.out.println("Lua chon sai!");
            }

        } while (choice != 5);

        // 🔴 Issue 8: Đóng Scanner quá sớm (có thể gây IllegalStateException)
        sc.close();  
    }
}