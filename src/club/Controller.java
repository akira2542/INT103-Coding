package club;
import java.util.Scanner;

public class Controller {

    Student student;
    Club testClub;
   
    
    public Controller() {
       this.student = new Student(6213077, "Ruri Kiku","IT");
       this.testClub = new Club("Swimming Club","Swim Team",10);
       mainMenu();
    }
//    public Controller(int num) {
//
//    } 
//    public static void main(String[] args) {
//        Controller debug = new Controller(0);
//        debug.listMember();
//    }

    private void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        Scanner con = new Scanner(System.in);
        deployTestObj();
        do {
            printMenu();
            int input = scanner.nextInt();
            scanner.reset();
            if (input == 6) break;
            optionController(input);
            System.out.println("Press Enter to Continue");
            con.nextLine();
        } while (true);
        con.close();
        scanner.close();
    }

    private void deployTestObj() {
        Student s1 = new Student(001, "test_student_1","IT");
        Student s2 = new Student(002, "test_student_2","IT");
        Student s3 = new Student(003, "test_student_3","IT");
        s1.subscribeToClub(this.testClub);
        s2.subscribeToClub(this.testClub);
        s3.subscribeToClub(this.testClub);
    }

    private void optionController(int input) {
        switch (input) {
            case 1:
                newClub();
                break;
            case 2:
                memberSub();
                break;
            case 3:
                editInfo();
                break;
            case 4:
                memberUnSub();
                break;
            case 5:
                listMember();
                break;
            default:
                System.out.println("Something Wrong");
                break;
        }
    }

    private void printMenu() {
        System.out.println(" <<Main Menu>> \n"
        + "1. New Club \n"
        + "2. Membership Subscribe \n"
        + "3. Edit Membership Information \n"
        + "4. Membership Unsubscribe \n"
        + "5. List Members \n"
        + "6. (Exit)");
        System.out.print("Enter Your Menu [1‐6]: ");
    } 

    
    private void newClub() {
        Scanner temp = new Scanner(System.in);
        System.out.println("Enter Club's Full Name :");
        String fullName = temp.nextLine();
        System.out.println("Enter Club's Nick Name :");
        String nickName = temp.nextLine();
        System.out.println("Enter Club's size");
        int size =temp.nextInt();
        this.testClub = new Club(fullName, nickName, size);
        temp.close();
    }

    private void memberSub() {
        this.student.subscribeToClub(this.testClub);
        System.out.println("Student no."+this.student.getStudentId()+" has been registered to "+this.testClub.getFullName());
    }
    private void editInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your new name:");
        String newName = scanner.nextLine();
        System.out.println("Type your new department:");
        // String newDepartment = scanner.nextLine();
        String newDepartment = scanner.nextLine();
        if (this.student.setClubInfo(this.testClub,newName,newDepartment)) {
            System.out.println("you have successfully changed your name and department");
        }else{
            System.out.println("No Such Student in this club");
        }
        ;
    }
    private void memberUnSub() {
        if (this.student.unSubToClub(this.testClub)) {
        System.out.println("Student no."+this.student.getStudentId()+" has resighned from "+this.testClub.getFullName());
        }else{
            System.out.println("No Such Student in this club");
        }
    }
    private void listMember() {
        System.out.println(this.testClub.getStudentList());
    }
}