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
import model.CV;
import model.CareerSummary;
import model.Education;
import model.Skills;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FunctionalCVController implements Initializable{

    @FXML
    private TableView<Skills> skillsTable = new TableView<>();
    @FXML
    private TableView<CareerSummary> careerSummaryTable = new TableView<>();
    @FXML
    private TableView<Education> educationTable = new TableView<>();
    @FXML
    private TableView<Education> courseTable = new TableView<>();

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
    private ObservableList<Education> courseList = FXCollections.observableArrayList();

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureSkillsTable();
        configureCareerSummaryTable();
        configureEducationTable();
        configureCourseTable();

    }

    public void configureSkillsTable(){
        TableColumn<Skills, String> skillColumn = new TableColumn<>("Skill");
        skillColumn.setMinWidth(124);
        skillColumn.setCellValueFactory(new PropertyValueFactory<>("skill"));

        TableColumn<Skills, String> experienceColumn = new TableColumn<>("Experience");
        experienceColumn.setMinWidth(124);
        experienceColumn.setCellValueFactory(new PropertyValueFactory<>("experience"));

        TableColumn<Skills, String> companyColumn = new TableColumn<>("Company");
        companyColumn.setMinWidth(124);
        companyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));

        skillsTable.getColumns().addAll(skillColumn, experienceColumn, companyColumn);
        skillsTable.setItems(skillsList);
    }

    public void configureCareerSummaryTable(){
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
        careerSummaryList.add(new CareerSummary("aaa", "vvv", 2016));
        careerSummaryTable.setItems(careerSummaryList);

    }

    public void configureEducationTable(){

    }

    public void configureCourseTable(){

    }
}
