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

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dtsiounis on 27/03/2017.
 */
public class ChronologicalCVControler implements Initializable{

    @FXML
    private TableView<Education> educationTable = new TableView<>();
    @FXML
    private TableView<Course> courseTable = new TableView<>();
    @FXML
    private TextField qualificationTxt, locationTxt, educationDateTxt, establishmentTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt;

    private ObservableList<Education> educationList = FXCollections.observableArrayList();
    private ObservableList<Course> courseList = FXCollections.observableArrayList();

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
        configureCourseTable();
        configureEducationTable();
    }

    public void configureEducationTable(){
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

    public void configureCourseTable(){
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

    public void deleteEducation(){
        int selectedIndex = educationTable.getSelectionModel().getSelectedIndex();
        educationTable.getItems().remove(selectedIndex);
    }

    public void deleteCourse(){
        int selectedIndex = courseTable.getSelectionModel().getSelectedIndex();
        courseTable.getItems().remove(selectedIndex);
    }
}
