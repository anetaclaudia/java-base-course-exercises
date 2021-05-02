package ee.taltech.iti0200.personstatistics;

public class PersonBuilder {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private double heightInMeters;
    private String occupation;
    private String nationality;

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setGender(String gender) {
        if (gender.equals("MALE")) {
            this.gender = Gender.MALE;
        } else if (gender.equals("FEMALE")) {
            this.gender = Gender.FEMALE;
        }
        return this;
    }

    public PersonBuilder setHeight(double height) {
        this.heightInMeters = height;
        return this;
    }

    public PersonBuilder setOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public PersonBuilder setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public Person build() {
        return new Person(firstName, lastName, age, gender, heightInMeters, occupation, nationality);
    }
}
