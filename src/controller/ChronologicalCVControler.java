package controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Course;
import model.Education;
import model.ProfessionalExperience;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Created by dtsiounis on 27/03/2017.
 */
public class ChronologicalCVControler extends CommonFunctions implements Initializable{

    @FXML
    private TableView<Education> educationTable = new TableView<>();
    @FXML
    private TableView<Course> courseTable = new TableView<>();
    @FXML
    private TableView<ProfessionalExperience> profExperienceTable = new TableView<>();
    @FXML
    private TextField qualificationTxt, locationTxt, educationDateTxt, establishmentTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt;
    @FXML
    private TextField companyNameTxt, jobTitleTxt, dateFromTxt, dateToTxt, paragraphTxt, achievementsTxt;

    private ObservableList<Education> educationList = FXCollections.observableArrayList();
    private ObservableList<Course> courseList = FXCollections.observableArrayList();
    private ObservableList<ProfessionalExperience> professionalExperiences = FXCollections.observableArrayList();

    public void addToEducationTable(){

        if(!(qualificationTxt.getText().isEmpty()) && !(locationTxt.getText().isEmpty()) && !(educationDateTxt.getText().isEmpty()) && !(establishmentTxt.getText().isEmpty())) {
            Education education = new Education(qualificationTxt.getText(), establishmentTxt.getText(), locationTxt.getText(), educationDateTxt.getText());
            educationList.add(education);
            qualificationTxt.clear();
            establishmentTxt.clear();
            locationTxt.clear();
            educationDateTxt.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the empty fields");
            alert.showAndWait();
        }

    }

    public void addToCourseTable(){

        if(!(courseTxt.getText().isEmpty()) && !(courseLocationTxt.getText().isEmpty()) && !(courseDateTxt.getText().isEmpty()) && !(courseEstablishmentTxt.getText().isEmpty())) {
            Course course = new Course(courseTxt.getText(), courseEstablishmentTxt.getText(), courseLocationTxt.getText(), courseDateTxt.getText());
            courseList.add(course);
            courseTxt.clear();
            courseEstablishmentTxt.clear();
            courseLocationTxt.clear();
            courseDateTxt.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the empty fields");
            alert.showAndWait();
        }

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
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the empty fields");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureEducationTable(educationTable, educationList);
        configureCourseTable(courseTable, courseList);
        configureProfessionalExperienceTable();
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

    public void deleteEducation(){
        int selectedIndex = educationTable.getSelectionModel().getSelectedIndex();
        educationTable.getItems().remove(selectedIndex);
    }

    public void deleteCourse(){
        int selectedIndex = courseTable.getSelectionModel().getSelectedIndex();
        courseTable.getItems().remove(selectedIndex);
    }
}
