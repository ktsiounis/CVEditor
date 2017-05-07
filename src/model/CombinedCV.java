package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by dtsiounis on 06/05/2017.
 */
public class CombinedCV {

    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<Skills> skillsList;
    private ObservableList<ProfessionalExperience> professionalExperiences;
    private String name, address, telehome, telemob, email, professionalProfile, additionalInfo, interests;

    public CombinedCV() {
        this.skillsList = FXCollections.observableArrayList();
        this.professionalExperiences = FXCollections.observableArrayList();
        this.educationList = FXCollections.observableArrayList();
        this.courseList = FXCollections.observableArrayList();
        this.name = "";
        this.address = "";
        this.telehome = "";
        this.telemob = "";
        this.email = "";
        this.professionalProfile = "";
        this.additionalInfo = "";
        this.interests = "";
    }

    public ObservableList<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(ObservableList<Education> educationList) {
        this.educationList = educationList;
    }

    public ObservableList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ObservableList<Course> courseList) {
        this.courseList = courseList;
    }

    public ObservableList<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(ObservableList<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public ObservableList<ProfessionalExperience> getProfessionalExperiences() {
        return professionalExperiences;
    }

    public void setProfessionalExperiences(ObservableList<ProfessionalExperience> professionalExperiences) {
        this.professionalExperiences = professionalExperiences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelehome() {
        return telehome;
    }

    public void setTelehome(String telehome) {
        this.telehome = telehome;
    }

    public String getTelemob() {
        return telemob;
    }

    public void setTelemob(String telemob) {
        this.telemob = telemob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfessionalProfile() {
        return professionalProfile;
    }

    public void setProfessionalProfile(String professionalProfile) {
        this.professionalProfile = professionalProfile;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
