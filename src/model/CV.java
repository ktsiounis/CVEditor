package model;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CV extends Application {

    private ObservableList<Skills> skills = FXCollections.observableArrayList();
    private ObservableList<CareerSummary> careerSummaries = FXCollections.observableArrayList();
    private ObservableList<Education> educations = FXCollections.observableArrayList();

    public ObservableList<Skills> getSkills() {
        return skills;
    }

    public ObservableList<CareerSummary> getCareerSummaries() {
        return careerSummaries;
    }

    public ObservableList<Education> getEducations() {
        return educations;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/view/SelectionWindow.fxml"));
        primaryStage.setTitle("CV Editor");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
