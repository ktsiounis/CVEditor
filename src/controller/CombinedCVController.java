package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Course;
import model.Education;
import model.ProfessionalExperience;
import model.Skills;

import java.net.URL;
import java.util.Arrays;
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
    private TextField qualificationTxt, locationTxt, educationYearFromTxt, educationYearToTxt, establishmentTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseYearFromTxt, courseYearToTxt, courseEstablishmentTxt;
    @FXML
    private TextField skillTxt, experienceTxt, companyTxt;
    @FXML
    private TextField companyNameTxt, jobTitleTxt, dateFromTxt, dateToTxt, paragraphTxt, achievementsTxt;

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
        this.educationYearFromTxt = new TextField();
        this.educationYearToTxt = new TextField();
        this.establishmentTxt = new TextField();
        this.courseTxt = new TextField();
        this.courseLocationTxt = new TextField();
        this.courseYearFromTxt = new TextField();
        this.courseYearToTxt = new TextField();
        this.courseEstablishmentTxt = new TextField();
        this.companyNameTxt = new TextField();
        this.jobTitleTxt = new TextField();
        this.dateFromTxt = new TextField();
        this.dateToTxt = new TextField();
        this.paragraphTxt = new TextField();
        this.achievementsTxt = new TextField();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureSkillsTable(skillsTable, skillsList);
        configureEducationTable(educationTable, educationList);
        configureCourseTable(courseTable, courseList);
        configureProfessionalExperienceTable();
    }

    public void addToSkillsTable(){
        addSkill(skillTxt, experienceTxt, companyTxt, skillsList);
    }

    public void addToEducationTable(){
        addEducation(qualificationTxt, locationTxt, educationYearFromTxt, educationYearToTxt,establishmentTxt, educationList);
    }

    public void addToCourseTable(){
        addCourse(courseTxt, courseLocationTxt, courseYearFromTxt, courseYearToTxt, courseEstablishmentTxt, courseList);
    }

    public void addToProfessionalExpTable(){
        if(!companyNameTxt.getText().isEmpty() && !jobTitleTxt.getText().isEmpty() && !dateFromTxt.getText().isEmpty() && !achievementsTxt.getText().isEmpty()) {
            String[] achievements = achievementsTxt.getText().split(",");
            ProfessionalExperience exp = new ProfessionalExperience(companyNameTxt.getText(), jobTitleTxt.getText(),
                    dateFromTxt.getText(), "2018", "paragraph",
                    FXCollections.observableArrayList(Arrays.asList(achievements)));
            professionalExperiences.add(exp);
            companyNameTxt.clear();
            jobTitleTxt.clear();
            dateFromTxt.clear();
            achievementsTxt.clear();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the empty fields");
            alert.showAndWait();
        }
    }

    public void configureProfessionalExperienceTable(){
        TableColumn<ProfessionalExperience, String> companyNameCol = new TableColumn<>("Company Name");
        companyNameCol.setMinWidth(124);
        companyNameCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));

        TableColumn<ProfessionalExperience, String> jobTitleCol = new TableColumn<>("Job Title");
        jobTitleCol.setMinWidth(124);
        jobTitleCol.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));

        TableColumn<ProfessionalExperience, String> dateFromCol = new TableColumn<>("Date From");
        dateFromCol.setMinWidth(124);
        dateFromCol.setCellValueFactory(new PropertyValueFactory<>("dateFrom"));

        TableColumn<ProfessionalExperience, String> dateToCol = new TableColumn<>("Date To");
        dateToCol.setMinWidth(124);
        dateToCol.setCellValueFactory(new PropertyValueFactory<>("dateTo"));

        TableColumn<ProfessionalExperience, String> paragraphCol = new TableColumn<>("Responsibilities Paragraph");
        paragraphCol.setMinWidth(135);
        paragraphCol.setCellValueFactory(new PropertyValueFactory<>("paragraph"));

        TableColumn<ProfessionalExperience, String> achievementsCol = new TableColumn<>("Achievements");
        achievementsCol.setMinWidth(124);
        achievementsCol.setCellValueFactory(new PropertyValueFactory<>("achievements"));

        profExperienceTable.getColumns().addAll(companyNameCol, jobTitleCol, dateFromCol, dateToCol, paragraphCol, achievementsCol);
        profExperienceTable.setItems(professionalExperiences);
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

    public void setEducationYearFromTxt(String educationYearFromTxt) {
        this.educationYearFromTxt.setText(educationYearFromTxt);
    }

    public void setEducationYearToTxt(String educationYearToTxt) {
        this.educationYearToTxt.setText(educationYearToTxt);
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

    public void setCourseYearFromTxt(String courseYearFromTxt) {
        this.courseYearFromTxt.setText(courseYearFromTxt);
    }

    public void setCourseYearToTxt(String courseYearToTxt) {
        this.courseYearToTxt.setText(courseYearToTxt);
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

    public void setDateFromTxt(String dateFromTxt) {
        this.dateFromTxt.setText(dateFromTxt);
    }

    public void setDateToTxt(String dateToTxt) {
        this.dateToTxt.setText(dateToTxt);
    }

    public void setParagraphTxt(String paragraphTxt) {
        this.paragraphTxt.setText(paragraphTxt);
    }

    public void setAchievementsTxt(String achievementsTxt) {
        this.achievementsTxt.setText(achievementsTxt);
    }
}
