package ee.taltech.iti0200.exam2.university.course;

import ee.taltech.iti0200.exam2.university.Teacher;

public class Course {
    private String name;
    private String subjectCode;
    private double ectscredits;
    private AssessmentType assessmentType;
    private Teacher teacher;
    private boolean isMandatory = false;

    public Course(String name, String subjectCode, double ectscredits, AssessmentType assessmentType, Teacher teacher) {
        this.name = name;
        this.subjectCode = subjectCode;
        this.ectscredits = ectscredits;
        this.assessmentType = assessmentType;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public double getEctscredits() {
        return ectscredits;
    }

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

}
