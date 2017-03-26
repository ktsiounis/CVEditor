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
import model.Skills;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FunctionalCVController implements Initializable{

    @FXML
    private TableView<Skills> skillsTable = new TableView<>();

    @FXML
    private TextField skillTxt, experienceTxt, companyTxt;

    private ObservableList<Skills> skillsList = FXCollections.observableArrayList();

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureSkillsTable();

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
}
