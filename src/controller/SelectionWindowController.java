package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.CV;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dtsiounis on 27/03/2017.
 */
public class SelectionWindowController {

    @FXML
    private RadioButton functionalCVchoice, chronologicalCVchoice, combinedCVchoice;
    private static Boolean txtLoad = false, texLoad = false;
    private static File file;

    public void createNewButtonPressed(ActionEvent event) throws IOException {
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

    public void openExistedButtonPressed(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(((Node)event.getSource()).getScene().getWindow());

        if(file != null){
            if(file.getName().contains(".tex")){
                texLoad = true;
                Scanner reader = new Scanner(file);
                List<String> lines = new ArrayList<>();

                while (reader.hasNextLine()){
                    lines.add(reader.nextLine());
                }

                if(lines.contains("\\textbf{3.  SKILLS AND EXPERIENCE}") && lines.contains("\\textbf{4.  CAREER SUMMARY}")){
                    System.out.println("It's functional");
                    functionalCVchoice.setSelected(true);
                    createNewButtonPressed(event);
                }
                else if(lines.contains("\\textbf{3.  CORE STRENGTHS}\\\\") && lines.contains("\\textbf{4.  PROFESSIONAL EXPERIENCE}")){
                    System.out.println("It's a chronological");
                    chronologicalCVchoice.setSelected(true);
                    createNewButtonPressed(event);
                }
                else if(lines.contains("\\textbf{3.  SKILLS AND EXPERIENCE}") && lines.contains("\\textbf{4.  PROFESSIONAL EXPERIENCE}")){
                    System.out.println("It's a combined");
                    combinedCVchoice.setSelected(true);
                    createNewButtonPressed(event);
                }
                else {
                    Alert alert = new Alert((Alert.AlertType.ERROR));
                    alert.setHeaderText("It's not based on template");
                    alert.showAndWait();
                }
            }
            else if(file.getName().contains(".txt")){
                txtLoad = true;
                Scanner reader = new Scanner(file);
                List<String> lines = new ArrayList<>();

                while (reader.hasNextLine()){
                    lines.add(reader.nextLine());
                }

                if(lines.contains("3.  SKILLS AND EXPERIENCE") && lines.contains("4.  CAREER SUMMARY")){
                    System.out.println("It's functional");
                    functionalCVchoice.setSelected(true);
                    createNewButtonPressed(event);
                }
                else if(lines.contains("3.  CORE STRENGTHS") && lines.contains("4.  PROFESSIONAL EXPERIENCE")){
                    System.out.println("It's a chronological");
                    chronologicalCVchoice.setSelected(true);
                    createNewButtonPressed(event);
                }
                else if(lines.contains("3.  SKILLS AND EXPERIENCE") && lines.contains("4.  PROFESSIONAL EXPERIENCE")){
                    System.out.println("It's a combined");
                    combinedCVchoice.setSelected(true);
                    createNewButtonPressed(event);
                }
                else {
                    Alert alert = new Alert((Alert.AlertType.ERROR));
                    alert.setHeaderText("It's not based on template");
                    alert.showAndWait();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Wrong file type!");
                alert.setContentText("Please choose a .txt or a .tex file");
                alert.showAndWait();
            }
        }
    }

    public static File getFile() {
        return file;
    }

    public static Boolean getTxtLoad() {
        return txtLoad;
    }

    public static Boolean getTexLoad() {
        return texLoad;
    }
}
