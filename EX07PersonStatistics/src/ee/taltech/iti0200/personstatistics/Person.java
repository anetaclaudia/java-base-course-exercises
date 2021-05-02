package ee.taltech.iti0200.personstatistics;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private double heightInMeters;
    private String occupation;
    private String nationality;

    public Person(String firstName, String lastName, int age, Gender gender, double heightInMeters, String occupation,
                  String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.heightInMeters = heightInMeters;
        this.occupation = occupation;
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public double getHeightInMeters() {
        return heightInMeters;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age
                && Double.compare(person.heightInMeters, heightInMeters) == 0
                && firstName.equals(person.firstName)
                && lastName.equals(person.lastName)
                && gender == person.gender
                && occupation.equals(person.occupation)
                && nationality.equals(person.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender, heightInMeters, occupation, nationality);
    }
}
