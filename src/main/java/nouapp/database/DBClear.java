package nouapp.database;

import nouapp.Admin;
import nouapp.Person;

import java.util.Arrays;
import java.util.List;

public class DBClear {
    public static void main(String[] args) {
        DBUtils.dropTableAdmin();
        DBUtils.dropTablePerson();

        List<Admin> dbAdmins = DBUtils.getTblAdminData();
        List<Person> dbUsers = DBUtils.getTablePersonData();

        System.out.println("Person:");
        System.out.println(Arrays.toString(dbUsers.toArray()));
        System.out.println("Admin:");
        System.out.println(Arrays.toString(dbAdmins.toArray()));
    }
}
