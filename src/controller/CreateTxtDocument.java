package controller;

import javafx.collections.ObservableList;
import model.*;

import java.io.File;

/**
 * Created by Ntinos on 30/4/2017.
 */
public class CreateTxtDocument {

    private ObservableList<Skills> skillsList;
    private ObservableList<CareerSummary> careerSummaryList;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<ProfessionalExperience> professionalExperiences;
    private String name, address, homeTel, mobileTel, email, professionalProfile, additionalInfo, interests, coreStrength;

    public CreateTxtDocument(ObservableList<Skills> skillsList, ObservableList<CareerSummary> careerSummaryList, ObservableList<Education> educationList, ObservableList<Course> courseList, ObservableList<ProfessionalExperience> professionalExperiences, String name, String address, String homeTel, String mobileTel, String email, String professionalProfile, String additionalInfo, String interests, String coreStrength) {
        this.skillsList = skillsList;
        this.careerSummaryList = careerSummaryList;
        this.educationList = educationList;
        this.courseList = courseList;
        this.professionalExperiences = professionalExperiences;
        this.name = name;
        this.address = address;
        this.homeTel = homeTel;
        this.mobileTel = mobileTel;
        this.email = email;
        this.professionalProfile = professionalProfile;
        this.additionalInfo = additionalInfo;
        this.interests = interests;
        this.coreStrength = coreStrength;
    }

    public void produceTxtFile(File file, String type){

    }
}
