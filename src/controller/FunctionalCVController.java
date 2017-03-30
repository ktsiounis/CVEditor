package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FunctionalCVController extends CommonFunctions implements Initializable{

    @FXML
    private TableView<Skills> skillsTable = new TableView<>();
    @FXML
    private TableView<CareerSummary> careerSummaryTable = new TableView<>();
    @FXML
    private TableView<Education> educationTable = new TableView<>();
    @FXML
    private TableView<Course> courseTable = new TableView<>();

    @FXML
    private TextField qualificationTxt, locationTxt, educationDateTxt, establishmentTxt;
    @FXML
    private TextField companyNameTxt, jobTitleTxt, careerDateTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt;
    @FXML
    private TextField skillTxt, experienceTxt, companyTxt;

    private ObservableList<Skills> skillsList = FXCollections.observableArrayList();
    private ObservableList<CareerSummary> careerSummaryList = FXCollections.observableArrayList();
    private ObservableList<Education> educationList = FXCollections.observableArrayList();
    private ObservableList<Course> courseList = FXCollections.observableArrayList();

    public void addToSkillsTable(){
        if(!(skillTxt.getText().isEmpty()) && !(experienceTxt.getText().isEmpty()) && !(companyTxt.getText().isEmpty())) {
            Skills skills = new Skills(skillTxt.getText(), experienceTxt.getText(), companyTxt.getText());
            skillsList.add(skills);
            skillTxt.clear();
            experienceTxt.clear();
            companyTxt.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the empty fields");
            alert.showAndWait();
        }
    }

    public void addToCareerSummaryTable(){
        if(!(companyNameTxt.getText().isEmpty()) && !(jobTitleTxt.getText().isEmpty()) && !(careerDateTxt.getText().isEmpty())) {
            CareerSummary careerSummary = new CareerSummary(companyNameTxt.getText(), jobTitleTxt.getText(), Integer.parseInt(careerDateTxt.getText()));
            careerSummaryList.add(careerSummary);
            companyNameTxt.clear();
            jobTitleTxt.clear();
            careerDateTxt.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the empty fields");
            alert.showAndWait();
        }
    }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureSkillsTable(skillsTable, skillsList);
        configureCareerSummaryTable(careerSummaryTable, careerSummaryList);
        configureEducationTable(educationTable, educationList);
        configureCourseTable(courseTable, courseList);

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
}
