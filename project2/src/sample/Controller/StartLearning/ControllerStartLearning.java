package sample.Controller.StartLearning;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class ControllerStartLearning {
    @FXML
    private Button btnLevel7;
    @FXML
    private Button btnLevel6;
    @FXML
    private Button btnLevel5;
    @FXML
    private Button btnLevel4;
    @FXML
    private Button btnLevel3;
    @FXML
    private Button btnLevel2;
    @FXML
    private Button btnLevel1;
    @FXML
    private Button btnBack;


    @FXML
    public void onLV1(ActionEvent event) {  //Bắt sự kiện khi ấn vào nút mức 1
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/StartLearning/Level1.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/lv1.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Level 1");
        stage.setScene(scene);

    }

    @FXML
    public void onLV2(ActionEvent event) { //Bắt sự kiện khi ấn vào nút mức 2
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/StartLearning/Level2.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/lv2.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Level 2");
        stage.setScene(scene);

    }

    @FXML
    public void onLV3(ActionEvent event) { //Bắt sự kiện khi ấn vào nút mức 2
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/StartLearning/Level3.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/lv3.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Level 3");
        stage.setScene(scene);


    }

    @FXML
    public void onLV4(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/StartLearning/Level4.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/lv4.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Level 4");
        stage.setScene(scene);


    }

    @FXML
    public void onLV5(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/StartLearning/Level5.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/lv5.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Level 5");
        stage.setScene(scene);


    }

    @FXML
    public void onLV6(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/StartLearning/Level6.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/lv6.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Level 6");
        stage.setScene(scene);


    }

    @FXML
    public void onLV7(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/StartLearning/Level7.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/lv7.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Level 7");
        stage.setScene(scene);


    }

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

}

