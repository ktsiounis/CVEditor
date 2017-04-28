package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Course;
import model.Education;
import model.CreateLaTexDocument;
import model.ProfessionalExperience;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dtsiounis on 27/03/2017.
 */
public class ChronologicalCVControler extends CommonFunctions implements Initializable{

    @FXML
    private TableView<Education> educationTable;
    @FXML
    private TableView<Course> courseTable;
    @FXML
    private TableView<ProfessionalExperience> profExperienceTable;

    @FXML
    private TextField qualificationTxt, locationTxt, educationDateTxt, establishmentTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt;
    @FXML
    private TextField companyNameTxt, jobTitleTxt, dateTxt, paragraphTxt, achievementsTxt;
    @FXML
    private TextField nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt, coreStrengthTxt;

    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<ProfessionalExperience> professionalExperiences;

    public ChronologicalCVControler() {
        this.educationDateTxt = new TextField();
        this.courseDateTxt = new TextField();
        this.paragraphTxt = new TextField();
        this.qualificationTxt = new TextField();
        this.locationTxt = new TextField();
        this.establishmentTxt = new TextField();
        this.courseTxt = new TextField();
        this.courseLocationTxt = new TextField();
        this.courseEstablishmentTxt = new TextField();
        this.dateTxt = new TextField();
        this.jobTitleTxt = new TextField();
        this.achievementsTxt = new TextField();
        this.companyNameTxt = new TextField();
        this.educationList = FXCollections.observableArrayList();
        this.courseList = FXCollections.observableArrayList();
        this.professionalExperiences = FXCollections.observableArrayList();
        this.educationTable = new TableView<>();
        this.courseTable = new TableView<>();
        this.profExperienceTable = new TableView<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureEducationTable(educationTable, educationList);
        configureCourseTable(courseTable, courseList);
        configureProfessionalExperienceTable(profExperienceTable, professionalExperiences);
    }

    public void addToEducationTable(){
        addEducation(qualificationTxt, locationTxt, educationDateTxt, establishmentTxt, educationList);
    }

    public void addToCourseTable(){
        addCourse(courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt, courseList);
    }

    public void addToProfessionalExpTable(){
        addProfessionalExperience(companyNameTxt, jobTitleTxt, dateTxt, achievementsTxt, paragraphTxt, professionalExperiences);
    }

    public void deleteEducation(){
        int selectedIndex = educationTable.getSelectionModel().getSelectedIndex();
        educationTable.getItems().remove(selectedIndex);
    }

    public void deleteCourse(){
        int selectedIndex = courseTable.getSelectionModel().getSelectedIndex();
        courseTable.getItems().remove(selectedIndex);
    }

    public void deleteProfessionalExperience(){
        int selectedIndex = profExperienceTable.getSelectionModel().getSelectedIndex();
        profExperienceTable.getItems().remove(selectedIndex);
    }

    public ObservableList<Education> getEducationList() {
        return educationList;
    }

    public ObservableList<Course> getCourseList() {
        return courseList;
    }

    public ObservableList<ProfessionalExperience> getProfessionalExperiences() {
        return professionalExperiences;
    }

    public void setQualificationTxt(String qualificationTxt) {
        this.qualificationTxt.setText(qualificationTxt);
    }

    public void setLocationTxt(String locationTxt) {
        this.locationTxt.setText(locationTxt);
    }

    public void setEducationDateTxt(String educationDateTxt) {
        this.educationDateTxt.setText(educationDateTxt);
    }

    public void setEstablishmentTxt(String establishmentTxt) {
        this.establishmentTxt.setText(establishmentTxt);
    }

    public void setCourseTxt(String courseTxt) {
        this.courseTxt.setText(courseTxt);
    }

    public void setCourseLocationTxt(String courseLocationTxt) {
        this.courseLocationTxt.setText(courseLocationTxt);
    }

    public void setCourseDateTxt(String courseDateTxt) {
        this.courseDateTxt.setText(courseDateTxt);
    }

    public void setCourseEstablishmentTxt(String courseEstablishmentTxt) {
        this.courseEstablishmentTxt.setText(courseEstablishmentTxt);
    }

    public void setCompanyNameTxt(String companyNameTxt) {
        this.companyNameTxt.setText(companyNameTxt);
    }

    public void setJobTitleTxt(String jobTitleTxt) {
        this.jobTitleTxt.setText(jobTitleTxt);
    }

    public void setDateTxt(String dateTxt) {
        this.dateTxt.setText(dateTxt);
    }

    public void setParagraphTxt(String paragraphTxt) {
        this.paragraphTxt.setText(paragraphTxt);
    }

    public void setAchievementsTxt(String achievementsTxt) {
        this.achievementsTxt.setText(achievementsTxt);
    }

    public void saveBtnPressed(){
        CreateLaTexDocument laTexDocument = new CreateLaTexDocument(null, null, educationList, courseList, professionalExperiences,
                nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), coreStrengthTxt.getText());
        laTexDocument.produceLaTex("testFile", "chronological");
        Alert completion = new Alert(Alert.AlertType.INFORMATION);
        completion.setHeaderText("The LaTex CV created successfully");
        completion.showAndWait();
    }
}
