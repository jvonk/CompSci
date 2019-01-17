import java.util.*;
public class Contact implements Comparable<Contact> {
    private String firstName, lastName, email;
    public Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return firstName;
    }
    public String getUserName() {
        return email.substring(email.indexOf("@"));
    }
    public String getDomainName() {
        return email.substring(email.indexOf("@")+1, email.lastIndexOf("."));
    }
    public String getDomainExtension() {
        return email.substring(email.lastIndexOf(".")+1, email.length());
    }
    public String toString() {
        return firstName + " " + lastName + ":   \t" + email;
    }
    @Override
    public int compareTo(Contact o) {
        return Comparators.FIRSTNAME.compare(this, o);
    }
    public static class Comparators {
        public static final Comparator<Contact> FIRSTNAME = (Contact o1, Contact o2) -> o1.firstName.compareToIgnoreCase(o2.firstName);
        public static final Comparator<Contact> LASTNAME = (Contact o1, Contact o2) -> o1.lastName.compareToIgnoreCase(o2.lastName);
        public static final Comparator<Contact> EMAIL = (Contact o1, Contact o2) -> o1.email.compareToIgnoreCase(o2.email);
    }
}
