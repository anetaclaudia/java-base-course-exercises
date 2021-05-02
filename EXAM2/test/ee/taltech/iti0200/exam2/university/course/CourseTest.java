package ee.taltech.iti0200.exam2.university.course;

import ee.taltech.iti0200.exam2.university.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CourseTest {
    Course java;
    Teacher evelin;

    @BeforeEach
    void setUp() {
        evelin = new Teacher("Evelin", "Halling");
        java = new Course("Java",
                "ITI0202",
                6.0d,
                AssessmentType.EXAM,
                evelin);
    }

    @Test
    void getName() {
        assert java.getName().equals("Java");
    }

    @Test
    void getSubjectCode() {
        assert java.getSubjectCode().equals("ITI0202");
    }

    @Test
    void getEctscredits() {
        assert java.getEctscredits() == 6.0d;
    }

    @Test
    void getAssessmentType() {
        assert java.getAssessmentType().equals(AssessmentType.EXAM);
    }

    @Test
    void getTeacher() {
        assert java.getTeacher().equals(evelin);
    }

    @Test
    void isMandatory() {
        assert !java.isMandatory();
    }

    @Test
    void setTeacher() {
        Teacher ago = new Teacher("Ago", "Luberg");
        java.setTeacher(ago);
        assert java.getTeacher().equals(ago);
    }
}
