package ee.taltech.iti0200.exam2.university;

import ee.taltech.iti0200.exam2.university.course.Course;
import ee.taltech.iti0200.exam2.university.studyprogramme.StudyProgramme;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class University {
    private String name;

    private Set<StudyProgramme> studyProgrammes = new HashSet<>();
    private Set<Student> students = new HashSet<>();
    private Set<Teacher> teachers = new HashSet<>();
    private Set<Course> courses = new HashSet<>();

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudyProgramme> getStudyProgrammes() {
        return studyProgrammes;
    }

    public void addStudyProgramme(StudyProgramme studyProgramme) {
        studyProgrammes.add(studyProgramme);
    }

    public Set<Student> getAllStudents() {
        return students;
    }

    public boolean addStudent(Student student) {
        if (student.getUniversity().isEmpty() && student.getAge() >= 18) {
            student.setUniversity(this);
            students.add(student);
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getCurrentlyStudyingStudents() {
        return students.stream()
                .filter(student -> !student.hasGraduated())
                .collect(Collectors.toList());
    }

    public List<Student> getGraduatedStudents() {
        return students.stream()
                .filter(Student::hasGraduated)
                .collect(Collectors.toList());
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public boolean addCourse(Course course) {
        if (teachers.contains(course.getTeacher())) {
            courses.add(course);
            return true;
        } else {
            return false;
        }
    }

    public void graduateStudent(Student student) {
        if (student.getDoneEcts() == student.getProgramme().getEctscredits()) {
            student.setHasGraduated(true);
        }
    }

    public List<Student> getStudentsByRank() {
        List<Student> currentlyStudying = this.getCurrentlyStudyingStudents();
        return currentlyStudying.stream()
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                //.thenComparing())
                .collect(Collectors.toList());
    }
}
