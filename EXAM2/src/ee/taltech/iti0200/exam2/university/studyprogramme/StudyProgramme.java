package ee.taltech.iti0200.exam2.university.studyprogramme;

import ee.taltech.iti0200.exam2.university.University;
import ee.taltech.iti0200.exam2.university.course.Course;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ProgrammeModule;
import ee.taltech.iti0200.exam2.university.studyprogramme.module.ModuleType;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StudyProgramme {
    private String name;
    private String id;
    private double ectscredits;
    private ProgrammeType programmeType;
    private University university;
    private Set<ProgrammeModule> programmeModules = new HashSet<>();

    public StudyProgramme(String name, String id, double ectscredits, ProgrammeType programmeType,
                          University university) {
        this.name = name;
        this.id = id;
        this.ectscredits = ectscredits;
        this.programmeType = programmeType;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getEctscredits() {
        return ectscredits;
    }

    public ProgrammeType getProgrammeType() {
        return programmeType;
    }

    public University getUniversity() {
        return university;
    }

    public boolean addModule(ProgrammeModule programmeModuleToAdd) {
        Set<ModuleType> moduleTypes = programmeModules
                .stream()
                .map(ProgrammeModule::getModuleType)
                .collect(Collectors.toSet());
        double currentProgrammeSize = programmeModules
                .stream()
                .mapToDouble(ProgrammeModule::getModuleSize)
                .sum();

        if (!moduleTypes.contains(programmeModuleToAdd.getModuleType())
                && currentProgrammeSize + programmeModuleToAdd.getModuleSize() <= this.ectscredits) {
            programmeModules.add(programmeModuleToAdd);
            return true;
        }
        return false;
    }

    public boolean addCourse(Course course, ProgrammeModule programmeModule) {
        if (university.getCourses().contains(course)
                && this.programmeModules.contains(programmeModule)) {
            programmeModule.addCourse(course);
            return true;
        }
        return false;
    }

    public Set<ProgrammeModule> getProgrammeModules() {
        return programmeModules;
    }
}
