package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by dtsiounis on 27/03/2017.
 */
public class SelectionWindowController {

    @FXML
    private RadioButton functionalCVchoice, chronologicalCVchoice, combinedCVchoice;

    public void nextButtonPressed(ActionEvent event) throws IOException {
        if(functionalCVchoice.isSelected()){
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Parent newScene = FXMLLoader.load(getClass().getResource("/view/FunctionalCV.fxml"));
            primaryStage.setScene(new Scene(newScene, 600, 375));
            primaryStage.show();

        }
        else if (chronologicalCVchoice.isSelected()) {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Parent newScene = FXMLLoader.load(getClass().getResource("/view/ChronologicalCV.fxml"));
            primaryStage.setScene(new Scene(newScene, 600, 375));
            primaryStage.show();
        }
        else if(combinedCVchoice.isSelected()){
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Parent newScene = FXMLLoader.load(getClass().getResource("/view/CombinedCV.fxml"));
            primaryStage.setScene(new Scene(newScene, 600, 375));
            primaryStage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please choose a template");
            alert.showAndWait();
        }
    }
}
