package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import model.Course;
import model.Education;
import model.ProfessionalExperience;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

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
        if(SelectionWindowController.getTxtLoad()){
            try {
                Scanner scanner = new Scanner(SelectionWindowController.getFile());
                loadTxtInfo(scanner);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if(SelectionWindowController.getTexLoad()){
            try {
                Scanner scanner = new Scanner(SelectionWindowController.getFile());
                loadTexInfo(scanner);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
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

    public void saveBtnPressed(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("LaTex File (*.tex)", "*.tex"), new FileChooser.ExtensionFilter("Plain Text File (*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
        Alert completion = new Alert(Alert.AlertType.INFORMATION);

        if(file!=null) {
            if (file.getName().contains(".tex")) {
                CreateLaTexDocument laTexDocument = new CreateLaTexDocument(null, null, educationList, courseList, professionalExperiences,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), coreStrengthTxt.getText());
                laTexDocument.produceLaTex(file, "chronological");
            }
            else {
                CreateTxtDocument txtDocument = new CreateTxtDocument(null, null, educationList, courseList, professionalExperiences,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), coreStrengthTxt.getText());
                txtDocument.produceTxtFile(file, "chronological");
            }
            completion.setHeaderText("The LaTex CV created successfully");
            completion.showAndWait();
        }
    }

    public void loadTxtInfo(Scanner scanner){

        nameTxt.setText(scanner.nextLine());
        addressTxt.setText(scanner.nextLine());
    }

    public void loadTexInfo(Scanner scanner){

    }
}
