package uz.pdp.g42;

import uz.pdp.g42.dto.ManagerDto;
import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.Manager;
import uz.pdp.g42.service.FileService;
import uz.pdp.g42.service.ManagerService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);

    static FileService<Manager> fileService = new FileService<>();
    static ManagerDto managerDto = new ManagerDto();
    static ManagerService managerService = new ManagerService();

    public static void main(String[] args) throws IOException {
        int n;
        while (true) {
            System.out.println("""
                    1 -> Register as manager
                    2 -> Login
                    3 -> Login as teacher
                    4 -> Exit
                    """);
            System.out.print("Choose: ");
            n = scannerInt.nextInt();

            if (n == 1) {
                Manager manager = new Manager();
                System.out.print("Enter the fullName as manager: ");
                String name = scannerStr.nextLine();
                System.out.print("Enter the username as manager: ");
                String username = scannerStr.nextLine();
                System.out.print("Enter the password as manager: ");
                String password = scannerStr.nextLine();
                manager.setName(name);
                manager.setUsername(username);
                manager.setPassword(password);
                if (check(username, password)) {
                    System.out.println("Already exist!!!");
                } else {
                    fileService.write(manager,FilePath.MANAGERS_PATH,Manager[].class);
                    System.out.println("Successful!!!");
                    System.out.println("\n");
                }

            } else if (n == 2) {

                System.out.print("Enter username");
                String us = scannerStr.nextLine();
                System.out.print("Enter password: ");
                String pass = scannerInt.nextLine();
                if (check(us,pass)){

                }else {
                    System.out.println("manager not found!!! \n");
                    System.out.println("choose again: ");
                }
            } else if (n == 3) {

            } else if (n == 4) {
                System.out.println("Thank you !!!");
                System.out.println();
                break;
            } else {
                System.out.println("Invalid option. Please choose again.");
                System.out.println();
            }
        }
    }

    private static boolean check(String username, String password) throws IOException {
        boolean test = false;
        List<Manager> read = fileService.read(FilePath.MANAGERS_PATH, Manager[].class);
        for (Manager manager : read) {
            if (username.equalsIgnoreCase(manager.getUsername()) && password.equalsIgnoreCase(manager.getPassword())) {
                test = true;
                break;
            }
        }
        return test;
    }
}

