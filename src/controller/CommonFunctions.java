package controller;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

/**
 * Created by Ntinos on 30/3/2017.
 */
public class CommonFunctions {

    public void configureSkillsTable(TableView<Skills> skillsTable, ObservableList<Skills> skillsList){
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

    public void configureCareerSummaryTable(TableView<CareerSummary> careerSummaryTable, ObservableList<CareerSummary> careerSummaryList){
        TableColumn<CareerSummary, String> companyNameColumn = new TableColumn<>("Company name");
        companyNameColumn.setMinWidth(124);
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("company"));

        TableColumn<CareerSummary, String> jobTitleColumn = new TableColumn<>("Job Title");
        jobTitleColumn.setMinWidth(124);
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));

        TableColumn<CareerSummary, String> yearFromColumn = new TableColumn<>("Year From");
        yearFromColumn.setMinWidth(124);
        yearFromColumn.setCellValueFactory(new PropertyValueFactory<>("yearFrom"));

        TableColumn<CareerSummary, String> yearToColumn = new TableColumn<>("Year To");
        yearToColumn.setMinWidth(124);
        yearToColumn.setCellValueFactory(new PropertyValueFactory<>("yearTo"));

        careerSummaryTable.getColumns().addAll(companyNameColumn, jobTitleColumn, yearFromColumn, yearToColumn);
        careerSummaryTable.setItems(careerSummaryList);

    }

    public void configureEducationTable(TableView<Education> educationTable, ObservableList<Education> educationList){
        TableColumn<Education, String> qualificationColumn = new TableColumn<>("Qualification");
        qualificationColumn.setMinWidth(124);
        qualificationColumn.setCellValueFactory(new PropertyValueFactory<>("qualification"));

        TableColumn<Education, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setMinWidth(124);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Education, String> establishmentColumn = new TableColumn<>("Establishment");
        establishmentColumn.setMinWidth(124);
        establishmentColumn.setCellValueFactory(new PropertyValueFactory<>("establishment"));

        TableColumn<Education, String> yearFromColumn = new TableColumn<>("Year From");
        yearFromColumn.setMinWidth(124);
        yearFromColumn.setCellValueFactory(new PropertyValueFactory<>("yearFrom"));

        TableColumn<Education, String> yearToColumn = new TableColumn<>("Year To");
        yearToColumn.setMinWidth(124);
        yearToColumn.setCellValueFactory(new PropertyValueFactory<>("yearTo"));

        educationTable.getColumns().addAll(qualificationColumn, establishmentColumn, locationColumn, yearFromColumn, yearToColumn);
        educationTable.setItems(educationList);

    }

    public void configureCourseTable(TableView<Course> courseTable, ObservableList<Course> courseList){
        TableColumn<Course, String> courseColumn = new TableColumn<>("Course");
        courseColumn.setMinWidth(124);
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));

        TableColumn<Course, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setMinWidth(124);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Course, String> establishmentColumn = new TableColumn<>("Establishment");
        establishmentColumn.setMinWidth(124);
        establishmentColumn.setCellValueFactory(new PropertyValueFactory<>("establishment"));

        TableColumn<Course, String> yearFromColumn = new TableColumn<>("Year From");
        yearFromColumn.setMinWidth(124);
        yearFromColumn.setCellValueFactory(new PropertyValueFactory<>("yearFrom"));

        TableColumn<Course, String> yearToColumn = new TableColumn<>("Year To");
        yearToColumn.setMinWidth(124);
        yearToColumn.setCellValueFactory(new PropertyValueFactory<>("yearTo"));

        courseTable.getColumns().addAll(courseColumn, establishmentColumn, locationColumn, yearFromColumn, yearToColumn);
        courseTable.setItems(courseList);

    }

    public void addSkill(TextField skillTxt, TextField experienceTxt, TextField companyTxt, ObservableList skillsList){
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

    public void addEducation(TextField qualificationTxt, TextField locationTxt, TextField educationYearFromTxt, TextField educationYearToTxt, TextField establishmentTxt, ObservableList educationList){
        if(!(qualificationTxt.getText().isEmpty()) && !(locationTxt.getText().isEmpty()) && !(educationYearFromTxt.getText().isEmpty()) && !(educationYearToTxt.getText().isEmpty()) && !(establishmentTxt.getText().isEmpty())) {
            Education education = new Education(qualificationTxt.getText(), establishmentTxt.getText(), locationTxt.getText(), educationYearFromTxt.getText(), educationYearToTxt.getText());
            educationList.add(education);
            qualificationTxt.clear();
            establishmentTxt.clear();
            locationTxt.clear();
            educationYearFromTxt.clear();
            educationYearToTxt.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the empty fields");
            alert.showAndWait();
        }
    }

    public void addCourse(TextField courseTxt, TextField courseLocationTxt, TextField courseYearFromTxt, TextField courseYearToTxt, TextField courseEstablishmentTxt, ObservableList courseList){
        if(!(courseTxt.getText().isEmpty()) && !(courseLocationTxt.getText().isEmpty()) && !(courseYearFromTxt.getText().isEmpty()) && !(courseYearToTxt.getText().isEmpty()) && !(courseEstablishmentTxt.getText().isEmpty())) {
            Course course = new Course(courseTxt.getText(), courseEstablishmentTxt.getText(), courseLocationTxt.getText(), courseYearFromTxt.getText(), courseYearToTxt.getText());
            courseList.add(course);
            courseTxt.clear();
            courseEstablishmentTxt.clear();
            courseLocationTxt.clear();
            courseYearFromTxt.clear();
            courseYearToTxt.clear();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill the empty fields");
            alert.showAndWait();
        }
    }
}
