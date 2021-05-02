package ee.taltech.iti0200.exam2.documents;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private boolean isLicenceActive = true;

    public Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public boolean isLicenceActive() {
        return isLicenceActive;
    }

    public void setLicenceIsActive(boolean licenceActive) {
        isLicenceActive = licenceActive;
    }
}
