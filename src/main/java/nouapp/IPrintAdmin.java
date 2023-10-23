package nouapp;

import static nouapp.Admin.admins;
import static nouapp.Student.students;

public interface IPrintAdmin {

    default void printAdminsList() {
        System.out.println(admins);
    }

    default void printStudentsList() {
        System.out.println(students);
    }
}
