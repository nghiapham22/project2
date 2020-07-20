package sample.Controller;

import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGuide implements Initializable {
    @FXML
    private Button btnBack;
    @FXML
    private WebView webview;
    @FXML
    private TextField tfLinkGuide;
    private WebEngine engine;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = webview.getEngine();
        tfLinkGuide.setText("https://drive.google.com/open?id=1Jav_K6BdmAQyj57yq5o71SuzVXeSDe20");
        String address = "https://drive.google.com/open?id=1Jav_K6BdmAQyj57yq5o71SuzVXeSDe20";
        engine.load(address);
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
