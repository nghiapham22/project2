package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Model.TakeDataBase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
    @FXML
    private Button btnAddWords;
    @FXML
    private Button btnGuide;
    @FXML
    private Button btnStartLearning;
    @FXML
    private Button btnExit;


    @FXML
    public void onGuide(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/Guide.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String image = getClass().getClassLoader().getResource("sample/Source/backgroundGuide.jpg").toExternalForm();
//        root.setStyle("-fx-background-image: url('" + image + "'); " +
//                "-fx-background-position: center center; " +
//                "-fx-background-repeat: stretch;" +
//                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Guide");
        stage.setScene(scene);
    }

    @FXML
    public void onAddWords(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/Delete_AddWords/AddWords.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/background.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Add Words");
        stage.setScene(scene);
    }

    @FXML
    public void onStartLearning(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/StartLearning/StartLearning.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/background.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Start Learning");
        stage.setScene(scene);

    }

    @FXML
    public void onExit(ActionEvent event){
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }


}
