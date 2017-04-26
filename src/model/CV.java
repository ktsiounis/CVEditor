package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CV extends Application {
    public Stage getStage() {
        return stage;
    }

    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/view/SelectionWindow.fxml"));
        primaryStage.setTitle("CV Editor");
        primaryStage.setScene(new Scene(root, 500, 275));
        stage = primaryStage;
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
