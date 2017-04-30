package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import model.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by dtsiounis on 27/03/2017.
 */
public class CombinedCVController extends CommonFunctions implements Initializable{

    @FXML
    private TableView<Education> educationTable;
    @FXML
    private TableView<Course> courseTable;
    @FXML
    private TableView<Skills> skillsTable;
    @FXML
    private TableView<ProfessionalExperience> profExperienceTable;

    @FXML
    private TextField qualificationTxt, locationTxt, educationDateTxt, establishmentTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt;
    @FXML
    private TextField skillTxt, experienceTxt, companyTxt;
    @FXML
    private TextField companyNameTxt, jobTitleTxt, dateTxt, paragraphTxt, achievementsTxt;
    @FXML
    private TextField nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt;

    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<Skills> skillsList;
    private ObservableList<ProfessionalExperience> professionalExperiences;

    public CombinedCVController() {
        this.educationTable = new TableView<>();
        this.courseTable = new TableView<>();
        this.skillsTable = new TableView<>();
        this.profExperienceTable = new TableView<>();
        this.educationList = FXCollections.observableArrayList();
        this.courseList = FXCollections.observableArrayList();
        this.skillsList = FXCollections.observableArrayList();
        this.professionalExperiences =  FXCollections.observableArrayList();
        this.skillTxt = new TextField();
        this.experienceTxt = new TextField();
        this.companyTxt = new TextField();
        this.qualificationTxt = new TextField();
        this.locationTxt = new TextField();
        this.educationDateTxt = new TextField();
        this.establishmentTxt = new TextField();
        this.courseTxt = new TextField();
        this.courseLocationTxt = new TextField();
        this.courseDateTxt = new TextField();
        this.courseEstablishmentTxt = new TextField();
        this.companyNameTxt = new TextField();
        this.jobTitleTxt = new TextField();
        this.dateTxt = new TextField();
        this.paragraphTxt = new TextField();
        this.achievementsTxt = new TextField();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureSkillsTable(skillsTable, skillsList);
        configureEducationTable(educationTable, educationList);
        configureCourseTable(courseTable, courseList);
        configureProfessionalExperienceTable(profExperienceTable, professionalExperiences);
    }

    public void addToSkillsTable(){
        addSkill(skillTxt, experienceTxt, companyTxt, skillsList);
    }

    public void addToEducationTable(){
        addEducation(qualificationTxt, locationTxt, educationDateTxt ,establishmentTxt, educationList);
    }

    public void addToCourseTable(){
        addCourse(courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt, courseList);
    }

    public void addToProfessionalExpTable(){
        addProfessionalExperience(companyNameTxt, jobTitleTxt, dateTxt, achievementsTxt, paragraphTxt, professionalExperiences);
    }

    public void deleteSkill(){
        int selectedIndex = skillsTable.getSelectionModel().getSelectedIndex();
        skillsTable.getItems().remove(selectedIndex);
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

    public ObservableList<Skills> getSkillsList() {
        return skillsList;
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

    public void setSkillTxt(String skillTxt) {
        this.skillTxt.setText(skillTxt);
    }

    public void setExperienceTxt(String experienceTxt) {
        this.experienceTxt.setText(experienceTxt);
    }

    public void setCompanyTxt(String companyTxt) {
        this.companyTxt.setText(companyTxt);
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

    public void saveBtnPressed(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("LaTex File (*.tex)", "*.tex"), new FileChooser.ExtensionFilter("Plain Text File (*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
        Alert completion = new Alert(Alert.AlertType.INFORMATION);

        if(file!=null) {
            if (file.getName().contains(".tex")) {
                CreateLaTexDocument laTexDocument = new CreateLaTexDocument(skillsList, null, educationList, courseList, professionalExperiences,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), null);
                laTexDocument.produceLaTex(file, "combined");
            }
            else{
                CreateTxtDocument txtDocument = new CreateTxtDocument(skillsList, null, educationList, courseList, professionalExperiences,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), null);
                txtDocument.produceTxtFile(file, "combined");
            }
            completion.setHeaderText("The LaTex CV created successfully");
            completion.showAndWait();
        }
    }
}
