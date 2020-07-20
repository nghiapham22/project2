package sample.Controller.AddDeleteFixWords;

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

public class ControllerAddDeleteFixWords implements Initializable {
    @FXML
    private Button btnAddWord;
    @FXML
    private Button btnListWords;
    @FXML
    private Button btnBack;

    private TakeDataBase takeDataBase = new TakeDataBase();

    @FXML
    public void onBack(ActionEvent event) {
        Parent root1 = null;
        try {
            //Lấy scene cũ
            root1 = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Lấy stage cũ để set scene cũ

        //Set lại background cho scene cũ
        String image = getClass().getClassLoader().getResource("sample/Source/background.jpg").toExternalForm();
        root1.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        //Lấy stage cũ để set scene cũ: quay trở lại màn hình chính
        stage.setTitle("English Learning Software");
        stage.setScene(new Scene(root1, 600, 400));
        stage.setResizable(false);
    }

    @FXML
    public void onAddWord(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/Delete_AddWords/ThemTu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/backgroundAddWords.jpg").toExternalForm();
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
    public void onListWords(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/Delete_AddWords/ListWords.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/backgroundAddWords.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("List Words");
        stage.setScene(scene);


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        takeDataBase.setSql("select * from dbo.Words");
//        takeDataBase.ketnNoiDB();


    }

}

