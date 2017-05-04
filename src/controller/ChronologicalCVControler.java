package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by dtsiounis on 27/03/2017.
 */
public class ChronologicalCVControler extends CommonFunctions implements Initializable{

    @FXML
    private TableView<Education> educationTable;
    @FXML
    private TableView<Course> courseTable;
    @FXML
    private TableView<ProfessionalExperience> profExperienceTable;

    @FXML
    private TextField qualificationTxt, locationTxt, educationDateTxt, establishmentTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt;
    @FXML
    private TextField companyNameTxt, jobTitleTxt, dateTxt, paragraphTxt, achievementsTxt;
    @FXML
    private TextField nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt, coreStrengthTxt;

    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<ProfessionalExperience> professionalExperiences;

    public ChronologicalCVControler() {
        this.educationDateTxt = new TextField();
        this.courseDateTxt = new TextField();
        this.paragraphTxt = new TextField();
        this.qualificationTxt = new TextField();
        this.locationTxt = new TextField();
        this.establishmentTxt = new TextField();
        this.courseTxt = new TextField();
        this.courseLocationTxt = new TextField();
        this.courseEstablishmentTxt = new TextField();
        this.dateTxt = new TextField();
        this.jobTitleTxt = new TextField();
        this.achievementsTxt = new TextField();
        this.companyNameTxt = new TextField();
        this.educationList = FXCollections.observableArrayList();
        this.courseList = FXCollections.observableArrayList();
        this.professionalExperiences = FXCollections.observableArrayList();
        this.educationTable = new TableView<>();
        this.courseTable = new TableView<>();
        this.profExperienceTable = new TableView<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureEducationTable(educationTable, educationList);
        configureCourseTable(courseTable, courseList);
        configureProfessionalExperienceTable(profExperienceTable, professionalExperiences);
        if(SelectionWindowController.getTxtLoad()){
            TxtParser txtParser = new TxtParser(nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt, educationList, courseList);
            txtParser.loadTxtInfo(SelectionWindowController.getFile());
            loadChronologicalTxtInfo(SelectionWindowController.getFile());
        }
        else if(SelectionWindowController.getTexLoad()){
            LaTexParser texParser = new LaTexParser(nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt, educationList, courseList);
            texParser.loadTexInfo(SelectionWindowController.getFile());
            loadTexInfo(SelectionWindowController.getFile());
        }
    }

    public void addToEducationTable(){
        addEducation(qualificationTxt, locationTxt, educationDateTxt, establishmentTxt, educationList);
    }

    public void addToCourseTable(){
        addCourse(courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt, courseList);
    }

    public void addToProfessionalExpTable(){
        addProfessionalExperience(companyNameTxt, jobTitleTxt, dateTxt, achievementsTxt, paragraphTxt, professionalExperiences);
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

    public void deleteProfessionalExperience(){
        int selectedIndex = profExperienceTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex != -1) {
            profExperienceTable.getItems().remove(selectedIndex);
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

    public ObservableList<ProfessionalExperience> getProfessionalExperiences() {
        return professionalExperiences;
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

    public void setCompanyNameTxt(String companyNameTxt) {
        this.companyNameTxt.setText(companyNameTxt);
    }

    public void setJobTitleTxt(String jobTitleTxt) {
        this.jobTitleTxt.setText(jobTitleTxt);
    }

    public void setDateTxt(String dateTxt) {
        this.dateTxt.setText(dateTxt);
    }

    public void setParagraphTxt(String paragraphTxt) {
        this.paragraphTxt.setText(paragraphTxt);
    }

    public void setAchievementsTxt(String achievementsTxt) {
        this.achievementsTxt.setText(achievementsTxt);
    }

    public void saveBtnPressed(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("LaTex File (*.tex)", "*.tex"), new FileChooser.ExtensionFilter("Plain Text File (*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
        Alert completion = new Alert(Alert.AlertType.INFORMATION);

        if(file!=null) {
            if (file.getName().contains(".tex")) {
                LaTexDocumentCreator laTexDocument = new LaTexDocumentCreator(null, null, educationList, courseList, professionalExperiences,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), coreStrengthTxt.getText());
                laTexDocument.produceLaTex(file, "chronological");
            }
            else {
                TxtDocumentCreator txtDocument = new TxtDocumentCreator(null, null, educationList, courseList, professionalExperiences,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), coreStrengthTxt.getText());
                txtDocument.produceTxtFile(file, "chronological");
            }
            completion.setHeaderText("The LaTex CV created successfully");
            completion.showAndWait();
        }
    }

    public void loadChronologicalTxtInfo(File file){
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
                    coreStrengthTxt.setText(coreStrengthTxt.getText() + lines.get(i));
                    i++;
                }
            }
            if(lines.get(i).contains("4.")){
                i++;
                while (!lines.get(i).contains("5.")) {
                    String[] firstLine = lines.get(i).split(", ");
                    if(firstLine.length>1) {
                        firstLine[0] = firstLine[0].replace("\t• ", "");
                        String companyName = firstLine[0], jobTitle = firstLine[1], date = firstLine[2], paragraph = "";
                        i++;
                        while (!lines.get(i).contains("List of")) {
                            paragraph = paragraph + lines.get(i);
                            i++;
                        }
                        paragraph = paragraph.replace("\t\t• Paragraph of responsibilities: ", "");
                        i++;
                        List<String> achievements = new ArrayList<>();
                        while (lines.get(i).contains("\t\t\t")) {
                            achievements.add(lines.get(i).replace("\t\t\t• ", ""));
                            i++;
                        }
                        professionalExperiences.add(new ProfessionalExperience(companyName, jobTitle, date, paragraph, FXCollections.observableArrayList(achievements)));
                    }
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
                while (!lines.get(i).contains("4. ")) {
                    coreStrengthTxt.setText(coreStrengthTxt.getText() + lines.get(i));
                    coreStrengthTxt.setText(coreStrengthTxt.getText().replace("//",""));
                    i++;
                }
            }

            if(lines.get(i).contains("4. ")){
                i++;
                while (!lines.get(i).contains("5. ")) {
                    if(lines.get(i).contains("\\item")){
                        String[] items = lines.get(i).split(", ");
                        String company = items[0].replace("\\item ",""), job = items[1], date = items[2], paragraph = "";
                        List<String> achievements = new ArrayList<>();
                        i+=2;
                        while (!lines.get(i).contains("List of")){
                            paragraph = paragraph + lines.get(i);
                            i++;
                        }
                        paragraph = paragraph.replace("\\item ","").replace("Paragraph of responsibilities:","");
                        i+=2;
                        while (lines.get(i).contains("\\item")){
                            achievements.add(lines.get(i).replace("\\item ",""));
                            i++;
                        }
                        professionalExperiences.add(new ProfessionalExperience(company, job, date, paragraph, FXCollections.observableArrayList(achievements)));
                    }
                    i++;
                }
            }
        }
    }
}
