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
import sample.Model.ComparingTwoStrings;
import sample.Model.LayKiTuDauVaCuoi;
import sample.Model.QueryStatement;
import sample.Model.TakeDataBase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerLevel2 implements Initializable {
    @FXML
    private Button btnPhiemAm;
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

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Kí tự @ đại diện cho những chữ cái đúng" + "\nNhững từ bạn sai là: " + a);
            alert.show();

        }
        String tiengViet = "";
        String phiemAm = "";
        String loaiTu = "";
        String hashTag = "";
        String tuGoiY = "";
        String thoiGian = "";
        String list = "";
        String tiengAnh = "";
        tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
        layKiTuDauVaCuoi.setResoult(tiengAnh);
        String tiengAnh1 = layKiTuDauVaCuoi.getString();
        tiengViet = takeDataBase.resultSet.getString("TiengViet");
        phiemAm = takeDataBase.resultSet.getString("PhienAm");
        loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
        hashTag = takeDataBase.resultSet.getString("Hashtag");
        tuGoiY = takeDataBase.resultSet.getString("TuGoiY");
        thoiGian = takeDataBase.resultSet.getString("ThoiGian");
        list = list + "Từ khóa: " + tiengAnh1 + "\n\nTiếng Việt: " + tiengViet + "\n\nPhiên âm: " + phiemAm + "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nTừ gợi ý: " + tuGoiY + "\n\nThời gian thêm: " + thoiGian;
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

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Kí tự @ đại diện cho những chữ cái đúng" + "\nNhững từ bạn sai là: " + a);
            alert.show();

        }
        String tiengViet = "";
        String phiemAm = "";
        String loaiTu = "";
        String hashTag = "";
        String tuGoiY = "";
        String thoiGian = "";
        String list = "";
        String tiengAnh = "";
        tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
        layKiTuDauVaCuoi.setResoult(tiengAnh);
        String tiengAnh1 = layKiTuDauVaCuoi.getString();
        tiengViet = takeDataBase.resultSet.getString("TiengViet");
        phiemAm = takeDataBase.resultSet.getString("PhienAm");
        loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
        hashTag = takeDataBase.resultSet.getString("Hashtag");
        tuGoiY = takeDataBase.resultSet.getString("TuGoiY");
        thoiGian = takeDataBase.resultSet.getString("ThoiGian");
        list = list + "Từ khóa: " + tiengAnh1 + "\n\nTiếng Việt: " + tiengViet + "\n\nPhiên âm: " + phiemAm + "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nTừ gợi ý: " + tuGoiY + "\n\nThời gian thêm: " + thoiGian;
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
            btnPhiemAm.setDisable(false);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Kí tự @ đại diện cho những chữ cái đúng" + "\nNhững từ bạn sai là: " + a);
            alert.show();
            btnPhiemAm.setDisable(false);
        }
        btnGoiY3.setDisable(true);
    }

    @FXML
    public void on4(ActionEvent event) throws SQLException {
        String tiengViet = "";
        String phiemAm = "";
        String loaiTu = "";
        String hashTag = "";
        String tuGoiY = "";
        String thoiGian = "";
        String list = "";
        String tiengAnh = "";
        tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
        layKiTuDauVaCuoi.setResoult(tiengAnh);
        String tiengAnh1 = layKiTuDauVaCuoi.getString();
        tiengViet = takeDataBase.resultSet.getString("TiengViet");
        phiemAm = takeDataBase.resultSet.getString("PhienAm");
        loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
        hashTag = takeDataBase.resultSet.getString("Hashtag");
        tuGoiY = takeDataBase.resultSet.getString("TuGoiY");
        thoiGian = takeDataBase.resultSet.getString("ThoiGian");
        list = list + "Từ khóa: " + tiengAnh1 + "\n\nTiếng Việt: " + tiengViet + "\n\nPhiên âm: " + phiemAm + "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nTừ gợi ý: " + tuGoiY + "\n\nThời gian thêm: " + thoiGian;
        ta.setText(list);
        btnPhiemAm.setDisable(false);
        btnGoiY4.setDisable(true);
    }


    @FXML
    public void onCheck(ActionEvent event) {
        try {
            String kiemTra = tfCheck.getText().trim();
            String tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
            if (kiemTra.equalsIgnoreCase(tiengAnh)) { //Nếu điền đúng
                System.out.println("chính xác");
                String tiengAnh1 = "";
                String tiengViet = "";
                String phiemAm = "";
                String loaiTu = "";
                String hashTag = "";
                String tuGoiY = "";
                String thoiGian = "";
                String list = "";

                try {
                    takeDataBase.resultSet.next();
                    tiengAnh1 = takeDataBase.resultSet.getString("TiengAnh");
                    layKiTuDauVaCuoi.setResoult(tiengAnh1);
                    String tiengAnh2 = layKiTuDauVaCuoi.getString();
                    tiengViet = takeDataBase.resultSet.getString("TiengViet");
//                    phiemAm = takeDataBase.resultSet.getString("PhienAm");
                    loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
                    hashTag = takeDataBase.resultSet.getString("Hashtag");
                    tuGoiY = takeDataBase.resultSet.getString("TuGoiY");
                    thoiGian = takeDataBase.resultSet.getString("ThoiGian");
                    list = list + "Từ khóa: " + tiengAnh2 + "\n\nTiếng Việt: " + tiengViet + "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nTừ gợi ý: " + tuGoiY + "\n\nThời gian thêm: " + thoiGian;

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
                btnPhiemAm.setDisable(false);

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
        btnPhiemAm.setDisable(true);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String cauTruyVan = queryStatement.cauTruyVan();
        takeDataBase.setSql(cauTruyVan);
        takeDataBase.connectDb();


        String tiengViet = "";
        String phiemAm = "";
        String loaiTu = "";
        String hashTag = "";
        String tuGoiY = "";
        String thoiGian = "";
        String list = "";
        String tiengAnh = "";

        try {
            takeDataBase.resultSet.next();
            tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
            layKiTuDauVaCuoi.setResoult(tiengAnh);
            String tiengAnh1 = layKiTuDauVaCuoi.getString();
            tiengViet = takeDataBase.resultSet.getString("TiengViet");
//            phiemAm = takeDataBase.resultSet.getString("PhienAm");
            loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
            hashTag = takeDataBase.resultSet.getString("Hashtag");
            tuGoiY = takeDataBase.resultSet.getString("TuGoiY");
            thoiGian = takeDataBase.resultSet.getString("ThoiGian");
            list = list + "Từ khóa: " + tiengAnh1 + "\n\nTiếng Việt: " + tiengViet + "\n\nLoại từ: " + loaiTu + "\n\nHashtag: " + hashTag + "\n\nTừ gợi ý: " + tuGoiY + "\n\nThời gian thêm: " + thoiGian;

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

        //Set Imageview
        Image image = new Image(localUrl);
        imageView.setImage(image);

        //Set button
        btnGoiY1.setDisable(true);
        btnGoiY2.setDisable(true);
        btnGoiY3.setDisable(true);
        btnGoiY4.setDisable(true);

        //Set TextArea
        ta.setStyle(
                "-fx-control-inner-background: paleturquoise;" //Xét màu background của textArea
        );
    }

}

