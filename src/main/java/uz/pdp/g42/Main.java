package uz.pdp.g42;

import uz.pdp.g42.dto.GroupDto;
import uz.pdp.g42.model.Group;
import uz.pdp.g42.service.FileService;
import uz.pdp.g42.service.GroupService;
import uz.pdp.g42.service.SchoolService;
import uz.pdp.g42.service.StudentService;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    FileService<Group> fileService = new FileService();
    static GroupDto groupDto = new GroupDto();
    static GroupService groupService = new GroupService(groupDto);
    static StudentService studentService = new StudentService();
    static TeacherService teacherService = new TeacherService();
    static SchoolService schoolService = new SchoolService();
    public static void main(String[] args) throws IOException {
        int option = 10;
        while(option != 0){
            System.out.println("1. Add Groups");
            System.out.println("2. Add Students");
            System.out.println("3. Add Teachers");
            System.out.println("0. Exit");
            option = scannerInt.nextInt();
            switch (option){
                case 1 -> {
                    Group group = new Group();
                    System.out.println("Enter group number: ");
                    group.setGroupNumber("Group " + scannerStr.nextLine());
                    System.out.println("Enter school id: ");
                    String schoolId = scannerStr.nextLine();
                    group.setSchoolId(schoolId.length()>1 ? UUID.fromString(schoolId) : null);
                    System.out.println("Enter group id: ");
                    String groupId = scannerStr.nextLine();
                    group.setId(groupId.length()>1 ? UUID.fromString(groupId) : null);
                    groupService.create(group);
                }

            }
         }
    }
}