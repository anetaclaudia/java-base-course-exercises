package ee.taltech.iti0200.exam2.university.studyprogramme.module;


import ee.taltech.iti0200.exam2.university.course.Course;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeModule {
    private double moduleSize;
    private ModuleType moduleType;
    private List<Course> courses = new ArrayList<>();

    public ProgrammeModule(double moduleSize, ModuleType moduleType) {
        this.moduleSize = moduleSize;
        this.moduleType = moduleType;
    }

    public double getModuleSize() {
        return moduleSize;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public double getCurrentlyAddedCoursesSize() {
        return courses.stream().mapToDouble(Course::getEctscredits).sum();
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)
                && (getCurrentlyAddedCoursesSize() + course.getEctscredits()) <= moduleSize) {
            if (moduleType.equals(ModuleType.CORE_STUDIES)
                    || moduleType.equals(ModuleType.GENERAL_STUDIES)
                    || moduleType.equals(ModuleType.GRADUATION_THESIS)) {
                course.setMandatory(true);
            }
            courses.add(course);
        }
    }
}
