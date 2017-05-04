package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.util.Arrays;

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

    public void configureProfessionalExperienceTable(TableView<ProfessionalExperience> profExperienceTable, ObservableList<ProfessionalExperience> professionalExperiences){
        TableColumn<ProfessionalExperience, String> companyNameCol = new TableColumn<>("Company Name");
        companyNameCol.setMinWidth(124);
        companyNameCol.setCellValueFactory(new PropertyValueFactory<>("companyName"));

        TableColumn<ProfessionalExperience, String> jobTitleCol = new TableColumn<>("Job Title");
        jobTitleCol.setMinWidth(124);
        jobTitleCol.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));

        TableColumn<ProfessionalExperience, String> dateCol = new TableColumn<>("Date");
        dateCol.setMinWidth(124);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<ProfessionalExperience, String> paragraphCol = new TableColumn<>("Responsibilities Paragraph");
        paragraphCol.setMinWidth(135);
        paragraphCol.setCellValueFactory(new PropertyValueFactory<>("paragraph"));

        TableColumn<ProfessionalExperience, String> achievementsCol = new TableColumn<>("Achievements");
        achievementsCol.setMinWidth(124);
        achievementsCol.setCellValueFactory(new PropertyValueFactory<>("achievements"));

        profExperienceTable.getColumns().addAll(companyNameCol, jobTitleCol, dateCol, paragraphCol, achievementsCol);
        profExperienceTable.setItems(professionalExperiences);
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
            showEmptyFieldsError();
        }
    }

    public void addEducation(TextField qualificationTxt, TextField locationTxt, TextField educationDateTxt, TextField establishmentTxt, ObservableList<Education> educationList){
        String[] lastItemsDate = {"0","0"};
        if(educationList.size()>0) lastItemsDate = educationList.get(educationList.size()-1).getDate().split("-");
        String[] currentItemsDate = educationDateTxt.getText().split("-");

        if (!(qualificationTxt.getText().isEmpty()) && !(locationTxt.getText().isEmpty()) && !(educationDateTxt.getText().isEmpty()) && !(establishmentTxt.getText().isEmpty())) {
            if(Integer.parseInt(lastItemsDate[1]) > Integer.parseInt(currentItemsDate[0])){
                showDateOrderError();
            }
            else {
                Education education = new Education(qualificationTxt.getText(), establishmentTxt.getText(), locationTxt.getText(), educationDateTxt.getText());
                educationList.add(education);
                qualificationTxt.clear();
                establishmentTxt.clear();
                locationTxt.clear();
                educationDateTxt.clear();
            }
        } else {
            showEmptyFieldsError();
        }
    }

    public void addCourse(TextField courseTxt, TextField courseLocationTxt, TextField courseDateTxt, TextField courseEstablishmentTxt, ObservableList<Course> courseList){
        String[] lastItemsDate = {"0","0"};
        if(courseList.size()>0) lastItemsDate = courseList.get(courseList.size()-1).getDate().split("-");
        String[] currentItemsDate = courseDateTxt.getText().split("-");

        if (!(courseTxt.getText().isEmpty()) && !(courseLocationTxt.getText().isEmpty()) && !(courseDateTxt.getText().isEmpty()) && !(courseEstablishmentTxt.getText().isEmpty())) {
            if(Integer.parseInt(lastItemsDate[1]) > Integer.parseInt(currentItemsDate[0])){
                showDateOrderError();
            }
            else {
                Course course = new Course(courseTxt.getText(), courseEstablishmentTxt.getText(), courseLocationTxt.getText(), courseDateTxt.getText());
                courseList.add(course);
                courseTxt.clear();
                courseEstablishmentTxt.clear();
                courseLocationTxt.clear();
                courseDateTxt.clear();
            }
        } else {
            showEmptyFieldsError();
        }
    }

    public void addProfessionalExperience(TextField companyNameTxt, TextField jobTitleTxt, TextField dateTxt, TextField achievementsTxt, TextField paragraphTxt, ObservableList<ProfessionalExperience> professionalExperiences){
        String[] lastItemsDate = {"0","0"};
        if(professionalExperiences.size()>0) lastItemsDate = professionalExperiences.get(professionalExperiences.size()-1).getDate().split("-");
        String[] currentItemsDate = dateTxt.getText().split("-");

        if (!companyNameTxt.getText().isEmpty() && !jobTitleTxt.getText().isEmpty() && !dateTxt.getText().isEmpty() && !achievementsTxt.getText().isEmpty() && !paragraphTxt.getText().isEmpty()) {
            if(Integer.parseInt(lastItemsDate[1]) > Integer.parseInt(currentItemsDate[0])){
                showDateOrderError();
            }
            else {
                String[] achievements = achievementsTxt.getText().split(",");
                ProfessionalExperience exp = new ProfessionalExperience(companyNameTxt.getText(), jobTitleTxt.getText(),
                        dateTxt.getText(), paragraphTxt.getText(), FXCollections.observableArrayList(Arrays.asList(achievements)));
                professionalExperiences.add(exp);
                companyNameTxt.clear();
                jobTitleTxt.clear();
                dateTxt.clear();
                achievementsTxt.clear();
                paragraphTxt.clear();
            }
        } else {
            showEmptyFieldsError();
        }
    }

    public void showDeleteError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Please choose a list item");
        alert.showAndWait();
    }

    public void showEmptyFieldsError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Please fill the empty fields");
        alert.showAndWait();
    }

    public void showDateOrderError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Please add a recent date item");
        alert.showAndWait();
    }
}
