package ee.taltech.iti0200.exam2.university;

import ee.taltech.iti0200.exam2.university.course.Course;
import ee.taltech.iti0200.exam2.university.exceptions.CannotAddNewDeclarationException;
import ee.taltech.iti0200.exam2.university.exceptions.ProgrammeDoesNotExistException;
import ee.taltech.iti0200.exam2.university.studyprogramme.StudyProgramme;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ModuleType;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ProgrammeModule;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private University university = null;
    private StudyProgramme programme;
    private double doneEcts;
    private boolean hasGraduated = false;
    private List<Declaration> declarations = new LinkedList<>();

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Optional<University> getUniversity() {
        if (university == null) {
            return Optional.empty();
        }
        return Optional.of(university);
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public StudyProgramme getProgramme() {
        return programme;
    }

    public void setProgramme(StudyProgramme programme) {
        if (university.getStudyProgrammes().contains(programme)) {
            this.programme = programme;
        } else {
            throw new ProgrammeDoesNotExistException();
        }
    }

    public double getAverageGrade() {
        double declarationsSum = declarations
                .stream()
                .mapToDouble(Declaration::getGradesSumForDeclaration)
                .sum();
        return declarationsSum / getDoneEcts();
    }

    public double getDoneEcts() {
        doneEcts = declarations.stream().mapToDouble(Declaration::getDoneEcts).sum();
        return doneEcts;
    }

    public List<Declaration> getAllDeclarations() {
        return declarations;
    }

    public Optional<Declaration> getActiveDeclaration() {
        return declarations.stream()
                .filter(Declaration::getStatus)
                .findFirst();
    }

    public void addNewDeclaration() {
        Declaration declarationToAdd = new Declaration();
        for (Declaration declaration : declarations) {
            if (declaration.getStatus()) {
                throw new CannotAddNewDeclarationException();
            }
        }
        declarations.add(declarationToAdd);
    }

    public boolean hasGraduated() {
        return hasGraduated;
    }

    public void setHasGraduated(boolean hasGraduated) {
        this.hasGraduated = hasGraduated;
    }

    public double getProgrammeCompletionPercentage() {
        Set<Course> studentAllCompulsoryCompletedCourses = new HashSet<>();
        Set<Course> programmesMandatoryCourses = new HashSet<>();

        Map<Course, String> studentAllCompletedCourses = declarations
                .subList(0, declarations.size() - 1)
                .stream()
                .map(Declaration::getDeclarationsCoursesResults)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        // get all courses student has declared to

        for (Map.Entry<Course, String> entry : studentAllCompletedCourses.entrySet()) {
            if (entry.getKey().isMandatory()) {
                if (!(entry.getValue().equals("0")
                        || entry.getValue().equals("F")
                        || entry.getValue().equals("MI"))) {
                    studentAllCompulsoryCompletedCourses.add(entry.getKey());
                }
            }
        }

        for (ProgrammeModule module : programme.getProgrammeModules()) {
            if (module.getModuleType().equals(ModuleType.GRADUATION_THESIS)
                    || module.getModuleType().equals(ModuleType.GENERAL_STUDIES)
                    || module.getModuleType().equals(ModuleType.CORE_STUDIES)) {
                programmesMandatoryCourses.addAll(module.getCourses());
            }
        }

        double finalStudentCourseEcts = studentAllCompulsoryCompletedCourses
                .stream()
                .mapToDouble(Course::getEctscredits).sum();

        double programmeMandatoryEcts = programmesMandatoryCourses
                .stream()
                .mapToDouble(Course::getEctscredits)
                .sum();

        return finalStudentCourseEcts / programmeMandatoryEcts * 100;
    }
}
