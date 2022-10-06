package objects_class_and_null_check;

import java.util.Objects;

public class RequireNull {
    public static void main(String[] args) {
        Person p = null;
        requireNullExample(p);
    }

    public static void requireNullExample(Person p) {
        Objects.requireNonNull(p, "Person object can't be null");
        System.out.println("Full name: " + p.getFirstName() + " " + p.getLastName());
    }
}

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

