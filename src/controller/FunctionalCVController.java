package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FunctionalCVController extends CommonFunctions implements Initializable{

    @FXML
    private TableView<Skills> skillsTable;
    @FXML
    private TableView<CareerSummary> careerSummaryTable;
    @FXML
    private TableView<Education> educationTable;
    @FXML
    private TableView<Course> courseTable;

    @FXML
    private TextField qualificationTxt, locationTxt, educationYearFromTxt, educationYearToTxt, establishmentTxt;
    @FXML
    private TextField companyNameTxt, jobTitleTxt, careerYearFromTxt, careerYearToTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseYearFromTxt, courseYearToTxt, courseEstablishmentTxt;
    @FXML
    private TextField skillTxt, experienceTxt, companyTxt;

    private ObservableList<Skills> skillsList;
    private ObservableList<CareerSummary> careerSummaryList;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;

    public FunctionalCVController() {
        this.educationYearFromTxt = new TextField();
        this.educationYearToTxt = new TextField();
        this.careerYearFromTxt = new TextField();
        this.careerYearToTxt = new TextField();
        this.courseYearFromTxt = new TextField();
        this.courseYearToTxt = new TextField();
        this.qualificationTxt = new TextField();
        this.locationTxt = new TextField();
        this.establishmentTxt = new TextField();
        this.companyTxt = new TextField();
        this.jobTitleTxt = new TextField();
        this.courseTxt = new TextField();
        this.courseLocationTxt = new TextField();
        this.courseEstablishmentTxt = new TextField();
        this.skillTxt = new TextField();
        this.experienceTxt = new TextField();
        this.companyTxt = new TextField();
        this.skillsList = FXCollections.observableArrayList();
        this.careerSummaryList = FXCollections.observableArrayList();
        this.educationList = FXCollections.observableArrayList();
        this.courseList = FXCollections.observableArrayList();
        this.skillsTable = new TableView<>();
        this.careerSummaryTable = new TableView<>();
        this.educationTable = new TableView<>();
        this.courseTable = new TableView<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureSkillsTable(skillsTable, skillsList);
        configureCareerSummaryTable(careerSummaryTable, careerSummaryList);
        configureEducationTable(educationTable, educationList);
        configureCourseTable(courseTable, courseList);

    }

    public void addToSkillsTable(){
        addSkill(skillTxt, experienceTxt, companyTxt, skillsList);
    }

    public void addToCareerSummaryTable(){
        if(!(companyNameTxt.getText().isEmpty()) && !(jobTitleTxt.getText().isEmpty()) && !(careerYearFromTxt.getText().isEmpty()) && !(careerYearToTxt.getText().isEmpty())) {
            CareerSummary careerSummary = new CareerSummary(companyNameTxt.getText(), jobTitleTxt.getText(), Integer.parseInt(careerYearFromTxt.getText()), Integer.parseInt(careerYearToTxt.getText()));
            careerSummaryList.add(careerSummary);
            companyNameTxt.clear();
            jobTitleTxt.clear();
            careerYearFromTxt.clear();
            careerYearToTxt.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the empty fields");
            alert.showAndWait();
        }
    }

    public void addToEducationTable(){
        addEducation(qualificationTxt, locationTxt, educationYearFromTxt, educationYearToTxt,establishmentTxt, educationList);
    }

    public void addToCourseTable(){
        addCourse(courseTxt, courseLocationTxt, courseYearFromTxt, courseYearToTxt, courseEstablishmentTxt, courseList);
    }

    public void deleteSkill(){
        int selectedIndex = skillsTable.getSelectionModel().getSelectedIndex();
        skillsTable.getItems().remove(selectedIndex);
    }

    public void deleteCareerSummary(){
        int selectedIndex = careerSummaryTable.getSelectionModel().getSelectedIndex();
        careerSummaryTable.getItems().remove(selectedIndex);
    }

    public void deleteEducation(){
        int selectedIndex = educationTable.getSelectionModel().getSelectedIndex();
        educationTable.getItems().remove(selectedIndex);
    }

    public void deleteCourse(){
        int selectedIndex = courseTable.getSelectionModel().getSelectedIndex();
        courseTable.getItems().remove(selectedIndex);
    }

    public ObservableList<Skills> getSkillsList() {
        return skillsList;
    }

    public ObservableList<CareerSummary> getCareerSummaryList() {
        return careerSummaryList;
    }

    public ObservableList<Education> getEducationList() {
        return educationList;
    }

    public ObservableList<Course> getCourseList() {
        return courseList;
    }

    public void setQualificationTxt(String qualificationTxt) {
        this.qualificationTxt.setText(qualificationTxt);
    }

    public void setLocationTxt(String locationTxt) {
        this.locationTxt.setText(locationTxt);
    }

    public void setEducationYearFromTxt(String educationYearFromTxt) {
        this.educationYearFromTxt.setText(educationYearFromTxt);
    }

    public void setEducationYearToTxt(String educationYearToTxt) {
        this.educationYearToTxt.setText(educationYearToTxt);
    }

    public void setEstablishmentTxt(String establishmentTxt) {
        this.establishmentTxt.setText(establishmentTxt);
    }

    public void setCompanyNameTxt(String companyNameTxt) {
        this.companyNameTxt.setText(companyNameTxt);
    }

    public void setJobTitleTxt(String jobTitleTxt) {
        this.jobTitleTxt.setText(jobTitleTxt);
    }

    public void setCareerYearFromTxt(String careerYearFromTxt) {
        this.careerYearFromTxt.setText(careerYearFromTxt);
    }

    public void setCareerYearToTxt(String careerYearToTxt) {
        this.careerYearToTxt.setText(careerYearToTxt);
    }

    public void setCourseTxt(String courseTxt) {
        this.courseTxt.setText(courseTxt);
    }

    public void setCourseLocationTxt(String courseLocationTxt) {
        this.courseLocationTxt.setText(courseLocationTxt);
    }

    public void setCourseYearFromTxt(String courseYearFromTxt) {
        this.courseYearFromTxt.setText(courseYearFromTxt);
    }

    public void setCourseYearToTxt(String courseYearToTxt) {
        this.courseYearToTxt.setText(courseYearToTxt);
    }

    public void setCourseEstablishmentTxt(String courseEstablishmentTxt) {
        this.courseEstablishmentTxt.setText(courseEstablishmentTxt);
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
}
