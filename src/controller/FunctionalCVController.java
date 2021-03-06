package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import model.*;
import javafx.event.ActionEvent;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
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
    @FXML
    private TextField nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt;

    private ObservableList<Skills> skillsList;
    private ObservableList<CareerSummary> careerSummaryList;
    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private FunctionalCV functionalCV = new FunctionalCV();

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
        this.skillsList = functionalCV.getSkillsList();
        this.careerSummaryList = functionalCV.getCareerSummaryList();
        this.educationList = functionalCV.getEducationList();
        this.courseList = functionalCV.getCourseList();
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
        if(SelectionWindowController.getTxtLoad()){
            TxtCVParser txtParser = new TxtCVParser(nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt, educationList, courseList);
            txtParser.loadTxtInfo(SelectionWindowController.getFile());
            loadFunctionalTxtInfo(SelectionWindowController.getFile());
        }
        else if(SelectionWindowController.getTexLoad()){
            LaTexCVParser texParser = new LaTexCVParser(nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt, educationList, courseList);
            texParser.loadTexInfo(SelectionWindowController.getFile());
            loadTexInfo(SelectionWindowController.getFile());
        }
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
        if (!(companyNameTxt.getText().isEmpty()) && !(jobTitleTxt.getText().isEmpty()) && !(careerDateTxt.getText().isEmpty())) {
            if(Integer.parseInt(lastItemsDate[1]) > Integer.parseInt(currentItemsDate[0])){
                showDateOrderError();
            }
            else {
                CareerSummary careerSummary = new CareerSummary(companyNameTxt.getText(), jobTitleTxt.getText(), careerDateTxt.getText());
                careerSummaryList.add(careerSummary);
                companyNameTxt.clear();
                jobTitleTxt.clear();
                careerDateTxt.clear();
            }
        } else {
            showEmptyFieldsError();
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
        if(selectedIndex != -1) {
            skillsTable.getItems().remove(selectedIndex);
        }
        else {
            showDeleteError();
        }
    }

    public void deleteCareerSummary(){
        int selectedIndex = careerSummaryTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            careerSummaryTable.getItems().remove(selectedIndex);
        }
        else {
            showDeleteError();
        }
    }

    public void deleteEducation(){
        int selectedIndex = educationTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex != -1) {
            educationTable.getItems().remove(selectedIndex);
        }
        else {
            showDeleteError();
        }
    }

    public void deleteCourse(){
        int selectedIndex = courseTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex != -1) {
            courseTable.getItems().remove(selectedIndex);
        }
        else {
            showDeleteError();
        }
    }

    public ObservableList<Education> getEducationList() {
        return educationList;
    }

    public ObservableList<Course> getCourseList() {
        return courseList;
    }

    public ObservableList<Skills> getSkillsList() {
        return skillsList;
    }

    public ObservableList<CareerSummary> getCareerSummaryList() {
        return careerSummaryList;
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

    public void saveBtnPressed(ActionEvent event){
        functionalCV.setName(nameTxt.getText());
        functionalCV.setAddress(addressTxt.getText());
        functionalCV.setTelehome(telehomeTxt.getText());
        functionalCV.setTelemob(telemobTxt.getText());
        functionalCV.setEmail(emailTxt.getText());
        functionalCV.setAdditionalInfo(additionalInfoTxt.getText());
        functionalCV.setProfessionalProfile(professionalProfile.getText());
        functionalCV.setInterests(interestsTxt.getText());

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("LaTex File (*.tex)", "*.tex"), new FileChooser.ExtensionFilter("Plain Text File (*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
        Alert completion = new Alert(Alert.AlertType.INFORMATION);

        if(file!=null) {
            if (file.getName().contains(".tex")) {
                LaTexCVDocumentCreator laTexDocument = new LaTexCVDocumentCreator(skillsList, careerSummaryList, educationList, courseList, null,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), null);
                laTexDocument.produceLaTex(file, "functional");
            }
            else{
                TxtCVDocumentCreator txtDocument = new TxtCVDocumentCreator(skillsList, careerSummaryList, educationList, courseList, null,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), null);
                txtDocument.produceTxtFile(file, "functional");
            }
            completion.setHeaderText("The CV created successfully");
            completion.showAndWait();
        }
    }

    public void loadFunctionalTxtInfo(File file){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0; i<lines.size(); i++) {
            if(lines.get(i).contains("3.")){
                i++;
                while (!lines.get(i).contains("4.")) {
                    String[] skillItem = lines.get(i).split(" and ");
                    if(skillItem.length>0) {
                        skillItem[0] = skillItem[0].replace("\t• ", "");
                        skillsList.add(new Skills(skillItem[0], skillItem[1].split(" on ")[0], skillItem[1].split(" on ")[1]));
                    }
                    i++;
                }
            }
            if(lines.get(i).contains("4.")){
                i++;
                while (!lines.get(i).contains("5.")) {
                    String[] careeItem = lines.get(i).split(", ");
                    if(careeItem.length>0){
                        careeItem[0] = careeItem[0].replace("\t• ", "");
                        careerSummaryList.add(new CareerSummary(careeItem[0], careeItem[1], careeItem[2]));
                    }
                    i++;
                }
            }
        }
    }

    public void loadTexInfo(File file){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0; i<lines.size(); i++) {
            if(lines.get(i).contains("3.")){
                i++;
                while (!lines.get(i).contains("4.")) {
                    if(lines.get(i).contains("\\item")){
                        String[] items = lines.get(i).split(" and ");
                        skillsList.add(new Skills(items[0].replace("\\item ",""), items[1].split(" on ")[0], items[1].split(" on ")[1]));
                    }
                    i++;
                }
            }

            if(lines.get(i).contains("4. ")){
                i++;
                while (!lines.get(i).contains("5. ")) {
                    if(lines.get(i).contains("\\item")){
                        String[] items = lines.get(i).split(", ");
                        careerSummaryList.add(new CareerSummary(items[0].replace("\\item ",""), items[1], items[2]));
                    }
                    i++;
                }
            }
        }
    }
}
