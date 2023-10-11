package nouapp;

import nouapp.database.DBUtils;

import java.util.List;
import java.util.Scanner;

public class SignUp {

    private void printWelcomeMessage() {
        System.out.println("     Welcome to NOU!");
        System.out.println();
    }

    private void signUp() {
        Admin admin = new Admin("Ivan", "Sidorov");
        Admin.addAdmin(admin);

        System.out.println();
        System.out.println("____________________________________");
        System.out.println("Local Admins list");
        Admin.printAdmins();

        System.out.println();
        System.out.println("____________________________________");
        System.out.println("DB Users list");
        List<Person> dbPerson = DBUtils.getTablePersonData();
        System.out.println(dbPerson);

        System.out.println();
        System.out.println("____________________________________");
        System.out.println("DB Admins list");
        List<Admin> dbAdmins = DBUtils.getTblAdminData();
        System.out.println(dbAdmins);

        System.out.println();
        System.out.println("Enter 'q' for quit OR");
        System.out.println();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter username: ");
        String input = in.nextLine();
        if (input.equals("Q") || input.equals("q")) {
            System.out.println("Goodbye");
            System.exit(0);
        }
        String username = input;

        System.out.print("Enter password: ");
        input = in.nextLine();
        if (input.equals("Q") || input.equals("q")) {
            System.out.println("Goodbye");
            System.exit(0);
        }
        String password = input;

        checkCredentials(username, password);
    }

    private void checkCredentials(String userName, String password) {
        List<Admin> adminsList = Admin.getAdmins();
        for (Admin admin : adminsList) {
            if (admin.getUserName().equals(userName) && admin.getPassword().equals(password)) {
                System.out.println("Welcome, " + admin.getFirstName() + " " + admin.getLastName() + "!");
                admin.runAdmin();
            } else {
                System.out.println("Sorry, we can't recognize you. Check your credentials and try again later.");
                System.out.println("Goodbye");
                System.exit(0);
            }
        }
    }

    public void runNOUApp() {
        printWelcomeMessage();
        signUp();
    }
}
