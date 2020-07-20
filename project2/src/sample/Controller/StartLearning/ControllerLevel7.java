package sample.Controller.StartLearning;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import sample.Model.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerLevel7 implements Initializable {
    @FXML
    private Button btnPhatAm;
    @FXML
    private Button btnCheck;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField tfCheck;
    @FXML
    private TextArea ta;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnGoiY1;
    @FXML
    private Button btnGoiY2;
    @FXML
    private Button btnGoiY3;
    @FXML
    private Button btnGoiY4;
    @FXML
    private Label lbGoiY;

    private TakeDataBase takeDataBase = new TakeDataBase();
    private MediaPlayer mediaPlayer;
    private LayKiTuDauVaCuoi layKiTuDauVaCuoi = new LayKiTuDauVaCuoi();
    private ComparingTwoStrings comparingTwoStrings = new ComparingTwoStrings();
    private FindTheLargestSubstring findTheLargestSubstring = new FindTheLargestSubstring();
    private QueryStatement queryStatement = new QueryStatement();


    @FXML
    public void on1(ActionEvent event) throws SQLException {
        comparingTwoStrings.setS1(takeDataBase.resultSet.getString("TiengAnh"));
        comparingTwoStrings.setS2(tfCheck.getText().trim());
        String a = comparingTwoStrings.compare();
        if (tfCheck.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Bạn chưa điền chữ cái !!!");
            alert.show();
            btnPhatAm.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Kí tự @ đại diện cho những chữ cái đúng" + "\nNhững từ bạn sai là: " + a);
            alert.show();
            btnPhatAm.setDisable(false);
        }

        String loaiTu = "";
        String hashTag = "";
        String thoiGian = "";
        String list = "";
        String tiengAnh = "";
        String phiemAm = "";

        phiemAm = takeDataBase.resultSet.getString("PhienAm");
        tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
        layKiTuDauVaCuoi.setResoult(tiengAnh);
        loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
        hashTag = takeDataBase.resultSet.getString("Hashtag");
        thoiGian = takeDataBase.resultSet.getString("ThoiGian");

        if(loaiTu.equalsIgnoreCase("Cụm Từ")){
//            int soTu = layKiTuDauVaCuoi.getWordCountOfWords();
            list = list + "Phiên âm: " + phiemAm + "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nThời gian thêm: " + thoiGian;
        } else {
//            int soChuCai = layKiTuDauVaCuoi.getLengthString();
            list = list + "Phiên âm: " + phiemAm +  "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nThời gian thêm: " + thoiGian;
        }
        ta.setText(list);

        btnGoiY1.setDisable(true);
    }

    @FXML
    public void on2(ActionEvent event) throws SQLException {
        comparingTwoStrings.setS1(takeDataBase.resultSet.getString("TiengAnh"));
        comparingTwoStrings.setS2(tfCheck.getText().trim());
        String a = comparingTwoStrings.compare();
        if (tfCheck.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Bạn chưa điền chữ cái !!!");
            alert.show();
            btnPhatAm.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            findTheLargestSubstring.setStringInput(tfCheck.getText().trim());
            findTheLargestSubstring.setStringInDataBase(takeDataBase.resultSet.getString("TiengAnh"));
            String xauChungDaiNhat = findTheLargestSubstring.largestSubstring();
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Xâu chung giữa từ bạn nhập và từ khóa là: " + xauChungDaiNhat);
            alert.show();
            btnPhatAm.setDisable(false);
        }

        String loaiTu = "";
        String hashTag = "";
        String thoiGian = "";
        String list = "";
        String tiengAnh = "";
        String phiemAm = "";

        phiemAm = takeDataBase.resultSet.getString("PhienAm");
        tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
        layKiTuDauVaCuoi.setResoult(tiengAnh);
        loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
        hashTag = takeDataBase.resultSet.getString("Hashtag");
        thoiGian = takeDataBase.resultSet.getString("ThoiGian");

        if(loaiTu.equalsIgnoreCase("Cụm Từ")){
//            int soTu = layKiTuDauVaCuoi.getWordCountOfWords();
            list = list  + "Phiên âm: " + phiemAm + "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nThời gian thêm: " + thoiGian;
        } else {
//            int soChuCai = layKiTuDauVaCuoi.getLengthString();
            list = list + "Phiên âm: " + phiemAm +  "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nThời gian thêm: " + thoiGian;
        }
        ta.setText(list);

        btnGoiY2.setDisable(true);

    }

    @FXML
    public void on3(ActionEvent event) throws SQLException {
        comparingTwoStrings.setS1(takeDataBase.resultSet.getString("TiengAnh"));
        comparingTwoStrings.setS2(tfCheck.getText().trim());
        String a = comparingTwoStrings.compare();
        if (tfCheck.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Bạn chưa điền chữ cái !!!");
            alert.show();
            btnPhatAm.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            findTheLargestSubstring.setStringInput(tfCheck.getText().trim());
            findTheLargestSubstring.setStringInDataBase(takeDataBase.resultSet.getString("TiengAnh"));
            String xauChungDaiNhat = findTheLargestSubstring.largestSubstring();
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Xâu chung giữa từ bạn nhập và từ khóa là: " + xauChungDaiNhat);
            alert.show();
            btnPhatAm.setDisable(false);
        }

        btnGoiY3.setDisable(true);

    }

    @FXML
    public void on4(ActionEvent event) throws SQLException {

        String loaiTu = "";
        String hashTag = "";
        String thoiGian = "";
        String list = "";
        String tiengAnh = "";
        String phiemAm = "";

        phiemAm = takeDataBase.resultSet.getString("PhienAm");
        tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
        layKiTuDauVaCuoi.setResoult(tiengAnh);
        loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
        hashTag = takeDataBase.resultSet.getString("Hashtag");
        thoiGian = takeDataBase.resultSet.getString("ThoiGian");

        if(loaiTu.equalsIgnoreCase("Cụm Từ")){
//            int soTu = layKiTuDauVaCuoi.getWordCountOfWords();
            list = list + "Phiên âm: " + phiemAm + "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nThời gian thêm: " + thoiGian;
        } else {
//            int soChuCai = layKiTuDauVaCuoi.getLengthString();
            list = list + "Phiên âm: " + phiemAm +  "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nThời gian thêm: " + thoiGian;
        }
        ta.setText(list);
        btnPhatAm.setDisable(false);
        btnGoiY4.setDisable(true);

    }

    @FXML
    public void onCheck(ActionEvent event) {
        try {
            String kiemTra = tfCheck.getText().trim();
            String tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
            if (kiemTra.equalsIgnoreCase(tiengAnh)) {
                System.out.println("chính xác");
                String tiengAnh1 = "";
                String loaiTu = "";
                String hashTag = "";
                String thoiGian = "";
                String list = "";

                try {
                    takeDataBase.resultSet.next();
                    tiengAnh1 = takeDataBase.resultSet.getString("TiengAnh");
                    layKiTuDauVaCuoi.setResoult(tiengAnh1);
                    loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
                    hashTag = takeDataBase.resultSet.getString("Hashtag");
                    thoiGian = takeDataBase.resultSet.getString("ThoiGian");
                    list = list + "Loại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nThời gian thêm: " + thoiGian;


                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ta.setText(list);
                File file = null;
                try {
                    file = new File(takeDataBase.resultSet.getString("Anh"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                String localUrl = null;
                try {
                    localUrl = file.toURI().toURL().toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                Image image = new Image(localUrl);
                imageView.setImage(image);

                //Set button
                btnGoiY1.setDisable(true);
                btnGoiY4.setDisable(true);
                btnGoiY3.setDisable(true);
                btnGoiY2.setDisable(true);
                btnPhatAm.setDisable(false);
                btnPhatAm.setDisable(true);

                //Set textfield
                tfCheck.setText("");

                //Set label
                lbGoiY.setText("");
            } else {
                System.out.println("Sai rồi");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Thông Báo");
                alert.setHeaderText("Sai rồi !!!!" + "\nBạn có thể sử dụng những sự gợi ý bên dưới");
                alert.show();
                btnGoiY1.setDisable(false);
                btnGoiY2.setDisable(false);
                btnGoiY3.setDisable(false);
                btnGoiY4.setDisable(false);
                lbGoiY.setText("Gợi ý");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void onBack(ActionEvent event) {
        Parent root1 = null;
        try {
            //Lấy scene cũ
            root1 = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/StartLearning/StartLearning.fxml"));
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
        stage.setTitle("Start Learning");
        stage.setScene(new Scene(root1, 600, 400));
        stage.setResizable(false);

    }

    @FXML
    public void onPhatAm(ActionEvent event) throws SQLException {
        String pathMedia = takeDataBase.resultSet.getString("PhatAm");
        String uriString = new File(pathMedia).toURI().toString();
        mediaPlayer = new MediaPlayer(new Media(uriString));
        mediaPlayer.play();
        btnPhatAm.setDisable(true);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String cauTruyVan = queryStatement.cauTruyVan();
        takeDataBase.setSql(cauTruyVan);
        takeDataBase.connectDb();


        String loaiTu = "";
        String hashTag = "";
        String thoiGian = "";
        String list = "";
        String tiengAnh = "";

        try {
            takeDataBase.resultSet.next();
            tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
            layKiTuDauVaCuoi.setResoult(tiengAnh);

            loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
            hashTag = takeDataBase.resultSet.getString("Hashtag");
            thoiGian = takeDataBase.resultSet.getString("ThoiGian");
            list = list + "Loại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nThời gian thêm: " + thoiGian;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        ta.setText(list);
        File file = null;
        try {
            file = new File(takeDataBase.resultSet.getString("Anh"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String localUrl = null;
        try {
            localUrl = file.toURI().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Image image = new Image(localUrl);
        imageView.setImage(image);

        //Set button
        btnPhatAm.setDisable(true);
        btnPhatAm.setDisable(true);
        btnPhatAm.setDisable(true);
        btnGoiY1.setDisable(true);
        btnGoiY2.setDisable(true);
        btnGoiY3.setDisable(true);
        btnGoiY4.setDisable(true);
    }


}
