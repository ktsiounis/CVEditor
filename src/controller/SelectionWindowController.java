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
    public void setFunctionalCVchoice(Boolean choice) {
        this.functionalCVchoice.setSelected(choice);
    }

    public void setChronologicalCVchoice(Boolean choice) {
        this.chronologicalCVchoice.setSelected(choice);
    }

    public void setCombinedCVchoice(Boolean choice) {
        this.combinedCVchoice.setSelected(choice);
    }

    public RadioButton getFunctionalCVchoice() {

        return functionalCVchoice;
    }

    public RadioButton getChronologicalCVchoice() {
        return chronologicalCVchoice;
    }

    public RadioButton getCombinedCVchoice() {
        return combinedCVchoice;
    }

    @FXML
    private RadioButton functionalCVchoice, chronologicalCVchoice, combinedCVchoice;

    public void nextButtonPressed(ActionEvent event) throws IOException {
        if(functionalCVchoice.isSelected()){
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Parent newScene = FXMLLoader.load(getClass().getResource("/view/FunctionalCV.fxml"));
            primaryStage.setTitle("CVEditor - FunctionalCV");
            primaryStage.setScene(new Scene(newScene, 700, 475));
            primaryStage.show();

        }
        else if (chronologicalCVchoice.isSelected()) {
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Parent newScene = FXMLLoader.load(getClass().getResource("/view/ChronologicalCV.fxml"));
            primaryStage.setTitle("CVEditor - ChronologicalCV");
            primaryStage.setScene(new Scene(newScene, 700, 475));
            primaryStage.show();
        }
        else if(combinedCVchoice.isSelected()){
            Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Parent newScene = FXMLLoader.load(getClass().getResource("/view/CombinedCV.fxml"));
            primaryStage.setTitle("CVEditor - CombinedCV");
            primaryStage.setScene(new Scene(newScene, 700, 475));
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
