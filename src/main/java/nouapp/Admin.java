package nouapp;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends Person {
    private String id = "A";
    private static int adminID = 1000001;
    private static List<Admin> admins = new ArrayList<>();

    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
        this.id = id + adminID;
        adminID++;
    }

    public static void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public static void printAdmins() {
        for (Admin admin : admins) {
            System.out.println(admin.getFirstName());
            System.out.println(admin.getLastName());
            System.out.println(admin.getPassword());
            System.out.println(admin.getUserName());
            System.out.println(admin.id);
        }
    }

    public static List<Admin> getAdmins() {
        return admins;
    }

    public void runAdmin() {
        Utils.printExitMessage();

        Scanner in = new Scanner(System.in);

        System.out.println("Would you like:");
        System.out.println("1 - Register new user");
        System.out.println("2 - Print existing data");

        String input = in.nextLine();

        switch (input) {
            case "Q", "q" -> {
                System.out.println("Goodbye");
                System.exit(0);
            }
            case "1" -> runRegistration();
            case "2" -> runPrintInformation();
        }
    }

    private void runRegistration() {
        System.out.println("Running Registration");
        Utils.printExitMessage();

        Scanner in = new Scanner(System.in);

        System.out.println("Would you like:");
        System.out.println("1 - Register new Student");
        System.out.println("2 - Register new Professor");
        System.out.println("3 - Register new Admin");

        String input = in.nextLine();

        switch (input) {
            case "Q", "q" -> {
                System.out.println("Goodbye");
                System.exit(0);
            }
            case "1" -> runRegisterNewStudent();
            case "2" -> runRegisterNewProfessor();
            case "3" -> runRegisterNewAdmin();
        }
    }

    private void runPrintInformation() {
        System.out.println("Running Print Information");
        Utils.printExitMessage();
    }

    private void runRegisterNewStudent() {
        System.out.println("Register New Student");
        Utils.printExitMessage();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String input = in.nextLine();
        String firstName = input;

        System.out.print("Enter last name: ");
        input = in.nextLine();
        String lastName = input;

        System.out.println("Would you like to register student for courses?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        System.out.println("q - for exit");
        input = in.nextLine();

        switch (input) {
            case "Q", "q" -> {
                System.out.println("Goodbye");
                System.exit(0);
            }
            case "1" -> runCourseRegistration();
            case "2" -> {
                Student student = new Student(firstName, lastName, new ArrayList<>());
                student.addStudent(student);
                runRegistration();
            }
        }
    }

    private void runRegisterNewProfessor() {
        System.out.println("Register New Professor");
        Utils.printExitMessage();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String input = in.nextLine();
        String firstName = input;

        System.out.print("Enter last name: ");
        input = in.nextLine();
        String lastName = input;

        System.out.println("Would you like to register courses for the professor?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        System.out.println("q - for exit");
        input = in.nextLine();

        switch (input) {
            case "Q", "q" -> {
                System.out.println("Goodbye");
                System.exit(0);
            }
            case "1" -> runCourseRegistration();
            case "2" -> {
                Professor professor = new Professor(firstName, lastName, new ArrayList<>());
                professor.addProfessor(professor);
                runRegistration();
            }
        }

    }

    private void runRegisterNewAdmin() {
        System.out.println("Register New Admin");
        Utils.printExitMessage();
    }

    private void runCourseRegistration() {
        System.out.println("Register Student for Courses");
        Utils.printExitMessage();

        List<String> courses = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.print("Enter course name or 'Q' to quit: ");
            String input = in.nextLine();
            switch (input) {
                case "Q", "q" -> {
                    Utils.printList(courses);
                    flag = false;
                    runRegistration();
                }
                default -> {
                    courses.add(input);
                    Utils.printList(courses);
                }
            }
        }
        while (flag);
    }
}
