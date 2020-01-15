package club;
import java.util.Scanner;

public class Controller {

    Scanner scanner = new Scanner(System.in);

    public Controller() {
       // mainMenu();
    }

    private void mainMenu() {
        
        printMenu();
        int input = scanner.nextInt();
        optionController(input);
    
    }

    private void optionController(int input) {
        switch (input) {
            case 1:
                newClub();
                break;
        
            default:
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
        + "6. Exit)");
        System.out.print("Enter Your Menu [1‐6]: ");
    } 

    public static void main(String[] args) {
        Controller n = new Controller();
    }
    
    private void newClub() {
        System.out.println("Enter Club's Full Name :");
        String fullName = (scanner.nextLine() == null)? "none" : scanner.nextLine();
        System.out.println("Enter Club's Nick Name :");
        String nickName = (scanner.nextLine() == null)? "none" : scanner.nextLine();
        System.out.println("Enter Club's size");
        int size = (scanner.nextInt() <= 0)? 5 : scanner.nextInt();

    }
}