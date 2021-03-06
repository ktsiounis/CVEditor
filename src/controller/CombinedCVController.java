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
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
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
    private TextField qualificationTxt, locationTxt, educationDateTxt, establishmentTxt;
    @FXML
    private TextField courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt;
    @FXML
    private TextField skillTxt, experienceTxt, companyTxt;
    @FXML
    private TextField companyNameTxt, jobTitleTxt, dateTxt, paragraphTxt, achievementsTxt;
    @FXML
    private TextField nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt;

    private ObservableList<Education> educationList;
    private ObservableList<Course> courseList;
    private ObservableList<Skills> skillsList;
    private ObservableList<ProfessionalExperience> professionalExperiences;
    private CombinedCV combinedCV = new CombinedCV();

    public CombinedCVController() {
        this.educationTable = new TableView<>();
        this.courseTable = new TableView<>();
        this.skillsTable = new TableView<>();
        this.profExperienceTable = new TableView<>();
        this.educationList = combinedCV.getEducationList();
        this.courseList = combinedCV.getCourseList();
        this.skillsList = combinedCV.getSkillsList();
        this.professionalExperiences =  combinedCV.getProfessionalExperiences();
        this.skillTxt = new TextField();
        this.experienceTxt = new TextField();
        this.companyTxt = new TextField();
        this.qualificationTxt = new TextField();
        this.locationTxt = new TextField();
        this.educationDateTxt = new TextField();
        this.establishmentTxt = new TextField();
        this.courseTxt = new TextField();
        this.courseLocationTxt = new TextField();
        this.courseDateTxt = new TextField();
        this.courseEstablishmentTxt = new TextField();
        this.companyNameTxt = new TextField();
        this.jobTitleTxt = new TextField();
        this.dateTxt = new TextField();
        this.paragraphTxt = new TextField();
        this.achievementsTxt = new TextField();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureSkillsTable(skillsTable, skillsList);
        configureEducationTable(educationTable, educationList);
        configureCourseTable(courseTable, courseList);
        configureProfessionalExperienceTable(profExperienceTable, professionalExperiences);
        if(SelectionWindowController.getTxtLoad()){
            TxtCVParser txtParser = new TxtCVParser(nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt, educationList, courseList);
            txtParser.loadTxtInfo(SelectionWindowController.getFile());
            loadCombinedTxtInfo(SelectionWindowController.getFile());
        }
        else if(SelectionWindowController.getTexLoad()) {
            LaTexCVParser texParser = new LaTexCVParser(nameTxt, addressTxt, telehomeTxt, telemobTxt, emailTxt, professionalProfile, additionalInfoTxt, interestsTxt, educationList, courseList);
            texParser.loadTexInfo(SelectionWindowController.getFile());
            loadTexInfo(SelectionWindowController.getFile());
        }
    }

    public void addToSkillsTable(){
        addSkill(skillTxt, experienceTxt, companyTxt, skillsList);
    }

    public void addToEducationTable(){
        addEducation(qualificationTxt, locationTxt, educationDateTxt ,establishmentTxt, educationList);
    }

    public void addToCourseTable(){
        addCourse(courseTxt, courseLocationTxt, courseDateTxt, courseEstablishmentTxt, courseList);
    }

    public void addToProfessionalExpTable(){
        addProfessionalExperience(companyNameTxt, jobTitleTxt, dateTxt, achievementsTxt, paragraphTxt, professionalExperiences);
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
        combinedCV.setName(nameTxt.getText());
        combinedCV.setAddress(addressTxt.getText());
        combinedCV.setTelehome(telehomeTxt.getText());
        combinedCV.setTelemob(telemobTxt.getText());
        combinedCV.setEmail(emailTxt.getText());
        combinedCV.setAdditionalInfo(additionalInfoTxt.getText());
        combinedCV.setProfessionalProfile(professionalProfile.getText());
        combinedCV.setInterests(interestsTxt.getText());

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("LaTex File (*.tex)", "*.tex"), new FileChooser.ExtensionFilter("Plain Text File (*.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(((Node)event.getSource()).getScene().getWindow());
        Alert completion = new Alert(Alert.AlertType.INFORMATION);

        if(file!=null) {
            if (file.getName().contains(".tex")) {
                LaTexCVDocumentCreator laTexDocument = new LaTexCVDocumentCreator(skillsList, null, educationList, courseList, professionalExperiences,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), null);
                laTexDocument.produceLaTex(file, "combined");
            }
            else{
                TxtCVDocumentCreator txtDocument = new TxtCVDocumentCreator(skillsList, null, educationList, courseList, professionalExperiences,
                        nameTxt.getText(), addressTxt.getText(), telehomeTxt.getText(), telemobTxt.getText(),
                        emailTxt.getText(), professionalProfile.getText(), additionalInfoTxt.getText(), interestsTxt.getText(), null);
                txtDocument.produceTxtFile(file, "combined");
            }
            completion.setHeaderText("The CV created successfully");
            completion.showAndWait();
        }
    }

    public void loadCombinedTxtInfo(File file){
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
                    String[] skillItem = lines.get(i).split(" and ");
                    if(skillItem.length>0) {
                        skillItem[0] = skillItem[0].replace("\t• ", "");
                        skillsList.add(new Skills(skillItem[0], skillItem[1].split(" on ")[0], skillItem[1].split(" on ")[1]));
                    }
                    i++;
                }
            }

            if(lines.get(i).contains("4. ")){
                i++;
                while (!lines.get(i).contains("5. ")) {
                    String[] firstLine = lines.get(i).split(", ");
                    if(firstLine.length>1) {
                        firstLine[0] = firstLine[0].replace("\t• ", "");
                        String companyName = firstLine[0], jobTitle = firstLine[1], date = firstLine[2], paragraph = "";
                        i++;
                        while (!lines.get(i).contains("List of ")) {
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
                        String company = items[0].replace("\\item ",""), job = items[1], date = items[2], paragraph = "";
                        List<String> achievements = new ArrayList<>();
                        i+=2;
                        while (!lines.get(i).contains("List")){
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
