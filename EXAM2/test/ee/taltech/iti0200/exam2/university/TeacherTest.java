package ee.taltech.iti0200.exam2.university;

import ee.taltech.iti0200.exam2.university.course.AssessmentType;
import ee.taltech.iti0200.exam2.university.course.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;


class TeacherTest {
    Course java;
    Course itspea;
    Teacher test;

    @BeforeEach
    void setUp() {
        test = new Teacher("Test", "Something");

        java = new Course("Java",
                "ITI0202",
                6.0d,
                AssessmentType.EXAM,
                test);

        itspea = new Course("ITSPEA",
                "ICD0001",
                6.0d,
                AssessmentType.GRADED_ASSESSMENT,
                test);
    }

    @Test
    void getFirstName() {
        assert test.getFirstName().equals("Test");
    }

    @Test
    void getLastName() {
        assert test.getLastName().equals("Something");
    }

    @Test
    void getCoursesTaught() {
        Set<Course> courses = Set.of(java, itspea);
        test.addCourse(java);
        test.addCourse(itspea);
        assert test.getCoursesTaught().equals(courses);
    }
}
