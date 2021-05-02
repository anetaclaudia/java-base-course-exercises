package ee.taltech.iti0200.exam2.university;

import ee.taltech.iti0200.exam2.university.course.AssessmentType;
import ee.taltech.iti0200.exam2.university.course.Course;
import ee.taltech.iti0200.exam2.university.studyprogramme.ProgrammeType;
import ee.taltech.iti0200.exam2.university.studyprogramme.StudyProgramme;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ModuleType;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ProgrammeModule;

import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        University TalTech = new University("TalTech");
        University fakeTalTech = new University("Fake TalTech");

        Teacher ago = new Teacher("Ago", "Luberg");
        Teacher kikkas = new Teacher("Kaido", "Kikkas");
        Teacher tammet = new Teacher("Tanel", "Tammet");
        Teacher evelin = new Teacher("Evelin", "Halling");
        Teacher hakk = new Teacher("Kristiina", "Hakk");

        TalTech.addTeacher(ago);
        TalTech.addTeacher(kikkas);
        TalTech.addTeacher(tammet);
        TalTech.addTeacher(evelin);
        TalTech.addTeacher(hakk);

        Student kalvi = new Student("Kalvi", "Kalle", 19);
        Student kalle = new Student("Kalle", "Kalvi", 20);
        Student laps = new Student("Nimeta", "Laps", 5);

        System.out.println(TalTech.addStudent(kalvi)); // true

        System.out.println(fakeTalTech.addStudent(kalle)); // lets just add the student to that school, should be true
        System.out.println(TalTech.addStudent(kalle)); // this should be now false

        System.out.println(TalTech.addStudent(laps)); // this also should be false

        StudyProgramme systemsDevelopment = new StudyProgramme("IT Systems Development",
                "IADB",
                30.0d,
                ProgrammeType.BACHELORS,
                TalTech);

        StudyProgramme informatics = new StudyProgramme("Informatics",
                "IAIM",
                15.0d,
                ProgrammeType.MASTERS,
                TalTech);

        Course java = new Course("Java",
                "ITI0202",
                6.0d,
                AssessmentType.EXAM,
                evelin);

        Course itspea = new Course("ITSPEA",
                "ICD0001",
                6.0d,
                AssessmentType.GRADED_ASSESSMENT,
                kikkas);

        Course matemaatika = new Course("Kõrgem matemaatika",
                "ICD0002",
                6.0d,
                AssessmentType.EXAM,
                hakk);

        Course sissejuhatus = new Course("Sissejuhatus ITsse",
                "ICD0123",
                6.0d,
                AssessmentType.PASSED_FAILED_ASSESSMENT,
                tammet);

        Course python = new Course("Python",
                "ITI0101",
                6.0d,
                AssessmentType.EXAM,
                ago);

        ProgrammeModule general = new ProgrammeModule(30.0d, ModuleType.GENERAL_STUDIES);

        general.addCourse(java);
        general.addCourse(itspea);
        general.addCourse(sissejuhatus);
        general.addCourse(matemaatika);
        general.addCourse(python);

        systemsDevelopment.addModule(general);

        kalle.addNewDeclaration();

        Optional<Declaration> kalleDeclaration = kalle.getActiveDeclaration();
        kalleDeclaration.ifPresent(declaration -> {
            declaration.addCourseToDeclaration(java);
            declaration.addCourseToDeclaration(itspea);
            declaration.addCourseToDeclaration(sissejuhatus);
            declaration.addCourseToDeclaration(matemaatika);
            declaration.addCourseToDeclaration(python);
        });

        kalleDeclaration.ifPresent(System.out::println);
        kalle.getActiveDeclaration().get().gradeCourse(java, "2");
        kalle.getActiveDeclaration().get().gradeCourse(itspea, "2");
        kalle.getActiveDeclaration().get().gradeCourse(sissejuhatus, "2");
        kalle.getActiveDeclaration().get().gradeCourse(matemaatika, "2");
        kalle.getActiveDeclaration().get().gradeCourse(python, "2");
        kalle.getActiveDeclaration().get().setStatus(false);
        kalle.addNewDeclaration();
        kalle.getProgrammeCompletionPercentage();

    }
}
