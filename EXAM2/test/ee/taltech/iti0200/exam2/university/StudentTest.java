package ee.taltech.iti0200.exam2.university;

import ee.taltech.iti0200.exam2.university.course.AssessmentType;
import ee.taltech.iti0200.exam2.university.course.Course;
import ee.taltech.iti0200.exam2.university.exceptions.ProgrammeDoesNotExistException;
import ee.taltech.iti0200.exam2.university.studyprogramme.ProgrammeType;
import ee.taltech.iti0200.exam2.university.studyprogramme.StudyProgramme;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ModuleType;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ProgrammeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;


class StudentTest {
    Student kalvi;
    University TalTech;
    StudyProgramme systemsDevelopment;
    Declaration declaration;
    Course java;
    Course python;
    Teacher ago;
    ProgrammeModule module;

    @BeforeEach
    void setUp() {
        kalvi = new Student("Kalvi", "Kalle", 19);

        TalTech = new University("TalTech");

        systemsDevelopment = new StudyProgramme("IT Systems Development",
                "IADB",
                30.0d,
                ProgrammeType.BACHELORS,
                TalTech);

        declaration = new Declaration();

        java = new Course("Java",
                "ITI0202",
                15.0d,
                AssessmentType.EXAM,
                ago);

        python = new Course("Python",
                "MAAUSALTENAMEIJAKSA",
                15.0d,
                AssessmentType.EXAM,
                ago);

        module = new ProgrammeModule(30.0d, ModuleType.GENERAL_STUDIES);
        module.addCourse(java);
        module.addCourse(python);

        systemsDevelopment.addModule(module);

        kalvi.addNewDeclaration();
        kalvi.getActiveDeclaration().get().addCourseToDeclaration(java);
        kalvi.getActiveDeclaration().get().addCourseToDeclaration(python);
        kalvi.getActiveDeclaration().get().gradeCourse(java, "3");
        kalvi.getActiveDeclaration().get().gradeCourse(python, "1");

    }

    @Test
    void getFirstName() {
        assert kalvi.getFirstName().equals("Kalvi");
    }

    @Test
    void getLastName() {
        assert kalvi.getLastName().equals("Kalle");
    }

    @Test
    void getAge() {
        assert kalvi.getAge() == 19;
    }

    @Test
    void getUniversityWhenNoUniversity() {
        assert kalvi.getUniversity().equals(Optional.empty());
    }

    @Test
    void getUniversity() {
        kalvi.setUniversity(TalTech);
        assert kalvi.getUniversity().get().equals(TalTech);
    }

    @Test
    void getProgrammeException() {
        kalvi.setUniversity(TalTech);
        assertThrows(ProgrammeDoesNotExistException.class, () -> {
            kalvi.setProgramme(systemsDevelopment);
        });
    }

    @Test
    void getProgramme() {
        kalvi.setUniversity(TalTech);
        TalTech.addStudyProgramme(systemsDevelopment);
        kalvi.setProgramme(systemsDevelopment);
        assert kalvi.getProgramme().equals(systemsDevelopment);

    }

    @Test
    void getDoneEcts() {
        assert kalvi.getDoneEcts() == 30.0d;
    }

    @Test
    void getAllDeclarations() {
        List<Declaration> test = new ArrayList<>();
        Declaration declaration = new Declaration();
        declaration.addCourseToDeclaration(java);
        declaration.addCourseToDeclaration(python);
        declaration.gradeCourse(java, "3");
        declaration.gradeCourse(python, "1");
        test.add(declaration);
        assert kalvi.getAllDeclarations().equals(test);
    }

    @Test
    void getActiveDeclaration() {
        Declaration declaration = new Declaration();
        declaration.addCourseToDeclaration(java);
        declaration.addCourseToDeclaration(python);
        declaration.gradeCourse(java, "3");
        declaration.gradeCourse(python, "1");
        Optional<Declaration> optionalDeclaration = Optional.of(declaration);
        assert kalvi.getActiveDeclaration().equals(optionalDeclaration);
    }

    @Test
    void hasGraduated() {
        assert !kalvi.hasGraduated();
    }

    @Test
    void setGraduated() {
        kalvi.setHasGraduated(true);
        assert kalvi.hasGraduated();
    }

    @Test
    void getProgrammeCompletionPercentage() {
        kalvi.setUniversity(TalTech);
        TalTech.addStudyProgramme(systemsDevelopment);
        kalvi.setProgramme(systemsDevelopment);
        kalvi.getActiveDeclaration().get().setStatus(false);
        kalvi.addNewDeclaration();
        // two courses in module, 1 module in program, kalvi has completed both
        assert kalvi.getProgrammeCompletionPercentage() == 100.0d;
    }

    @Test
    void getAverageGrade() {
        assert kalvi.getAverageGrade() == 0.13333333333333333;
    }
}
