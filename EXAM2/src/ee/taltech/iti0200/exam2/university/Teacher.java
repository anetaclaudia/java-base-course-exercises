package ee.taltech.iti0200.exam2.university;

import ee.taltech.iti0200.exam2.university.course.Course;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
    private String firstName;
    private String lastName;

    private Set<Course> coursesTaught = new HashSet<>();

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void addCourse(Course course) {
        coursesTaught.add(course);
    }
}
