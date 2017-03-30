package controller;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CareerSummary;
import model.Course;
import model.Education;
import model.Skills;

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

        TableColumn<CareerSummary, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(124);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        careerSummaryTable.getColumns().addAll(companyNameColumn, jobTitleColumn, dateColumn);
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

        TableColumn<Education, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(124);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        educationTable.getColumns().addAll(qualificationColumn, establishmentColumn, locationColumn, dateColumn);
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

        TableColumn<Course, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(124);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        courseTable.getColumns().addAll(courseColumn, establishmentColumn, locationColumn, dateColumn);
        courseTable.setItems(courseList);

    }
}
