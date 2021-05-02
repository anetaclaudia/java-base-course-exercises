package ee.taltech.iti0200.exam2.university;

import ee.taltech.iti0200.exam2.university.course.AssessmentType;
import ee.taltech.iti0200.exam2.university.course.Course;
import ee.taltech.iti0200.exam2.university.studyprogramme.ProgrammeType;
import ee.taltech.iti0200.exam2.university.studyprogramme.StudyProgramme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class UniversityTest {
    University TalTech;
    University fakeTalTech;
    Teacher ago;
    Teacher kikkas;
    Teacher tammet;
    StudyProgramme systemsDevelopment;
    Student kalvi;
    Student kalle;
    Course java;


    @BeforeEach
    void setUp() {
        kalvi = new Student("Kalvi", "Kalle", 19);
        kalle = new Student("Kalle", "Kalvi", 20);

        TalTech = new University("TalTech");
        fakeTalTech = new University("Fake TalTech");

        ago = new Teacher("Ago", "Luberg");
        kikkas = new Teacher("Kaido", "Kikkas");
        tammet = new Teacher("Tanel", "Tammet");

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
    }

    @Test
    void setName() {
        TalTech.setName("WRONG");
        assert TalTech.getName().equals("WRONG");
    }

    @Test
    void getStudyProgrammes() {
        assert TalTech.getStudyProgrammes().equals(new HashSet<>());
    }

    @Test
    void addStudyProgramme() {
        Set<StudyProgramme> programmeSet = new HashSet<>();
        programmeSet.add(systemsDevelopment);
        TalTech.addStudyProgramme(systemsDevelopment);
        assert TalTech.getStudyProgrammes().equals(programmeSet);
    }

    @Test
    void getAllStudents() {
        assert TalTech.getAllStudents().equals(new HashSet<>());
    }

    @Test
    void addStudent() {
        TalTech.addStudent(kalvi);
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(kalvi);
        assert TalTech.getAllStudents().equals(studentSet);
    }

    @Test
    void failToAddStudent() {
        kalvi.setUniversity(fakeTalTech);
        assert !TalTech.addStudent(kalvi);
        ;
    }

    @Test
    void getCurrentlyStudyingStudents() {
        TalTech.addStudent(kalvi);
        List<Student> studentList = new ArrayList<>();
        studentList.add(kalvi);
        assert TalTech.getCurrentlyStudyingStudents().equals(studentList);
    }

    @Test
    void getGraduatedStudents() {
        assert TalTech.getGraduatedStudents().equals(new ArrayList<>());
    }

    @Test
    void addTeacher() {
        TalTech.addTeacher(ago);
        Set<Teacher> teacherSet = new HashSet<>();
        teacherSet.add(ago);
        assert TalTech.getTeachers().equals(teacherSet);
    }

    @Test
    void addCourse() {
        TalTech.addTeacher(ago);
        TalTech.addCourse(java);
        Set<Course> courses = new HashSet<>();
        courses.add(java);
        assert TalTech.getCourses().equals(courses);
    }

    @Test
    void failToAddCourse() {
        assert !TalTech.addCourse(java);
    }

}
