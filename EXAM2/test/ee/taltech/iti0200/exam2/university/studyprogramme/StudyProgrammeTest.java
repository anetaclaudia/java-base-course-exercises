package ee.taltech.iti0200.exam2.university.studyprogramme;

import ee.taltech.iti0200.exam2.university.Teacher;
import ee.taltech.iti0200.exam2.university.University;
import ee.taltech.iti0200.exam2.university.course.AssessmentType;
import ee.taltech.iti0200.exam2.university.course.Course;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ModuleType;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ProgrammeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StudyProgrammeTest {
    University TalTech;
    Teacher ago;
    StudyProgramme systemsDevelopment;
    Course java;
    ProgrammeModule module;

    @BeforeEach
    void setUp() {
        TalTech = new University("TalTech");

        ago = new Teacher("Ago", "Luberg");

        systemsDevelopment = new StudyProgramme("IT Systems Development",
                "IADB",
                30.0d,
                ProgrammeType.BACHELORS,
                TalTech);

        java = new Course("Java",
                "ITI0202",
                15.0d,
                AssessmentType.EXAM,
                ago);

        module = new ProgrammeModule(30.0d, ModuleType.GENERAL_STUDIES);
        module.addCourse(java);

        systemsDevelopment.addModule(module);
    }

    @Test
    void getName() {
        assert systemsDevelopment.getName().equals("IT Systems Development");
    }

    @Test
    void getId() {
        assert systemsDevelopment.getId().equals("IADB");
    }

    @Test
    void getEctscredits() {
        assert systemsDevelopment.getEctscredits() == 30.0d;
    }

    @Test
    void getProgrammeType() {
        assert systemsDevelopment.getProgrammeType().equals(ProgrammeType.BACHELORS);
    }

    @Test
    void getUniversity() {
        assert systemsDevelopment.getUniversity().equals(TalTech);
    }

    @Test
    void addCourse() {
        TalTech.addTeacher(ago);
        TalTech.addCourse(java);
        assert systemsDevelopment.addCourse(java, module);
    }

    @Test
    void failAddCourse() {
        TalTech.addTeacher(ago);
        assert !systemsDevelopment.addCourse(java, module);
    }
}
