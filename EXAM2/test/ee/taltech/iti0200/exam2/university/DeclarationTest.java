package ee.taltech.iti0200.exam2.university;

import ee.taltech.iti0200.exam2.university.course.AssessmentType;
import ee.taltech.iti0200.exam2.university.course.Course;
import ee.taltech.iti0200.exam2.university.studyprogramme.ProgrammeType;
import ee.taltech.iti0200.exam2.university.studyprogramme.StudyProgramme;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ModuleType;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ProgrammeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DeclarationTest {
    Student kalvi;
    University TalTech;
    StudyProgramme systemsDevelopment;
    Course java;
    Teacher ago;
    ProgrammeModule module;

    @BeforeEach
    void setUp() {
        kalvi = new Student("Kalvi", "Kalle", 19);
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


        TalTech.addStudent(kalvi);
        kalvi.addNewDeclaration();
        kalvi.getActiveDeclaration().get().addCourseToDeclaration(java);
        kalvi.getActiveDeclaration().get().gradeCourse(java, "3");
    }

    @Test
    void getGradesSumForDeclaration() {
        assert kalvi.getActiveDeclaration().get().getGradesSumForDeclaration() == 3.0d;
    }
}
