package ee.taltech.iti0200.exam2.university;

import ee.taltech.iti0200.exam2.university.course.Course;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Declaration {
    private boolean status = true; // if declaration is active, then its true
    private Map<Course, String> declarationsCoursesResults = new HashMap<>();
    private double doneEcts;
    private double gradesSumForDeclaration;

    public Declaration() {
    }


    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        if (!declarationsCoursesResults.containsValue("")) {
            this.status = status;
        }
    }

    public Map<Course, String> getDeclarationsCoursesResults() {
        return declarationsCoursesResults;
    }

    public void addCourseToDeclaration(Course course) {
        if (!declarationsCoursesResults.containsKey(course)) {
            declarationsCoursesResults.put(course, "");
        }
    }

    public void gradeCourse(Course course, String grade) {
        if (declarationsCoursesResults.containsKey(course)) {
            declarationsCoursesResults.replace(course, grade);
        }
    }

    public double getDoneEcts() {
        double result = 0.0d;
        for (Map.Entry<Course, String> entry : declarationsCoursesResults.entrySet()) {
            if (!(entry.getValue().equals("0")
                    || entry.getValue().equals("F")
                    || entry.getValue().equals("MI"))) {
                result += entry.getKey().getEctscredits();
            }
        }
        return result;
    }

    public double getGradesSumForDeclaration() {
        double result = 0.0d;
        for (Map.Entry<Course, String> entry : declarationsCoursesResults.entrySet()) {
            if (!(entry.getValue().equals("F")
                    || entry.getValue().equals("P")
                    || entry.getValue().equals("MI"))) {
                double number = Double.parseDouble(entry.getValue());
                result += number;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declaration that = (Declaration) o;
        return status == that.status
                && Double.compare(that.doneEcts, doneEcts) == 0
                && Double.compare(that.gradesSumForDeclaration, gradesSumForDeclaration) == 0
                && declarationsCoursesResults.equals(that.declarationsCoursesResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, declarationsCoursesResults, doneEcts, gradesSumForDeclaration);
    }
}
