package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TextField qualificationTxt, locationTxt, educationDateTxt, establishmentTxt;
    @FXML
    private TextField companyNameTxt, jobTitleTxt, careerDateTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt;
    @FXML
    private TextField skillTxt, experienceTxt, companyTxt;

    private ObservableList<Skills> skillsList;
    private ObservableList<CareerSummary> careerSummaryList;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;

    public FunctionalCVController() {
        this.educationDateTxt = new TextField();
        this.careerDateTxt = new TextField();
        this.careerDateTxt = new TextField();
        this.qualificationTxt = new TextField();
        this.locationTxt = new TextField();
        this.establishmentTxt = new TextField();
        this.companyTxt = new TextField();
        this.jobTitleTxt = new TextField();
        this.courseTxt = new TextField();
        this.courseLocationTxt = new TextField();
        this.courseEstablishmentTxt = new TextField();
        this.courseDateTxt = new TextField();
        this.skillTxt = new TextField();
        this.experienceTxt = new TextField();
        this.companyNameTxt = new TextField();
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

    public void configureCareerSummaryTable(TableView<CareerSummary> careerSummaryTable, ObservableList<CareerSummary> careerSummaryList){
        TableColumn<CareerSummary, String> companyNameColumn = new TableColumn<>("Company name");
        companyNameColumn.setMinWidth(124);
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("company"));

        TableColumn<CareerSummary, String> jobTitleColumn = new TableColumn<>("Job Title");
        jobTitleColumn.setMinWidth(124);
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));

        TableColumn<CareerSummary, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(124);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        careerSummaryTable.getColumns().addAll(companyNameColumn, jobTitleColumn, dateColumn);
        careerSummaryTable.setItems(careerSummaryList);

    }

    public void addToSkillsTable(){
        addSkill(skillTxt, experienceTxt, companyTxt, skillsList);
    }

    public void addToCareerSummaryTable(){
        String[] lastItemsDate = {"0","0"};
        if(careerSummaryList.size()>0) lastItemsDate = careerSummaryList.get(careerSummaryList.size()-1).getDate().split("-");
        String[] currentItemsDate = careerDateTxt.getText().split("-");
        if(Integer.parseInt(lastItemsDate[1]) > Integer.parseInt(currentItemsDate[0])){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please add a recent date item");
            alert.showAndWait();
        }
        else {
            if (!(companyNameTxt.getText().isEmpty()) && !(jobTitleTxt.getText().isEmpty()) && !(careerDateTxt.getText().isEmpty())) {
                CareerSummary careerSummary = new CareerSummary(companyNameTxt.getText(), jobTitleTxt.getText(), careerDateTxt.getText());
                careerSummaryList.add(careerSummary);
                companyNameTxt.clear();
                jobTitleTxt.clear();
                careerDateTxt.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Please fill the empty fields");
                alert.showAndWait();
            }
        }
    }

    public void addToEducationTable(){
        addEducation(qualificationTxt, locationTxt, educationDateTxt,establishmentTxt, educationList);
    }

    public void addToCourseTable(){
        addCourse(courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt, courseList);
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

    public void setEducationDateTxt(String educationDateTxt) {
        this.educationDateTxt.setText(educationDateTxt);
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

    public void setCareerDateTxt(String careerYearFromTxt) {
        this.careerDateTxt.setText(careerYearFromTxt);
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
