package sample.Controller.AddDeleteFixWords;

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.Model.AddData;
import sample.Model.TakeDataBase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerFixWords implements Initializable {
    @FXML
    private TextField tfTuTiengAnh;  //ô trống để hiện thị từ tiếng Anh
    @FXML
    private TextField tfTuTiengViet; //ô trống để hiện thị từ tiếng Việt
    @FXML
    private TextField tfLoaiTu; //ô trống để hiện thị loại từ
    @FXML
    private Button btnFix1; //Nút để lưa lại thông tin của từ khi người dùng đã thay đổi
    @FXML
    private Button btnBack;  //Nút này dùng để quay lại giao diện trước
    @FXML
    private Button btnChosePicture; //Nút này để chọn ảnh
    @FXML
    private ImageView imv; // Hình ảnh
    @FXML
    private TextField tfPronounce; //ô hiện thị đường dẫn tới file Media mà người dùng đã chọn
    @FXML
    private TextField tfSpelling; // ô hiện thị Phiên âm
    @FXML
    private TextField tfSuggestedWords; // ô hiện thị Từ gợi ý
    @FXML
    private TextField tfHashtag; //ô để hiện thị Hashtag
    @FXML
    private TextField tfChosePic; //ô trống hiện thị đường dẫn tới ảnh mà người dùng đã chọn
    @FXML
    private Button btnPlay; //nút dùng để chạy file Media
    @FXML
    private Button btnCheck; //Nút dùng để  kiểm tra xem người dùng có điền đủ thông tin của từ không
    @FXML
    private Button btnChoseFile; //Nút dùng để chọn file media
    @FXML
    private Button btnPause; //Nút để dừng phát âm
    @FXML
    private TextField tfSearch; //ô hiện thị từ cần tìm kiếm để sửa
    @FXML
    private Button btnSearch; //Nút dùng để tìm kiếm từ để sửa

    private MediaPlayer mediaPlayer;
    private AddData addData = new AddData();
    private TakeDataBase takeDataBase = new TakeDataBase();

    //Bắt sự kiện khi ấn vào nút "Sửa từ"
    @FXML
    public void onFix1(ActionEvent event) {
        if (!tfTuTiengViet.getText().trim().isEmpty() && !tfTuTiengAnh.getText().trim().isEmpty() && !tfSuggestedWords.getText().trim().isEmpty() && !tfPronounce.getText().trim().isEmpty() && !tfHashtag.getText().trim().isEmpty() && !tfLoaiTu.getText().trim().isEmpty() && !tfChosePic.getText().trim().isEmpty()) {
            String linkPhatAm = tfPronounce.getText().trim();
            String linkAnh = tfChosePic.getText().trim();
            String check1 = "";
            String check2 = "";
            int dem3 = 0; //Biến này dùng để kiểm tra 2 đk là file ảnh và file media

            //Kiểm tra xem người dùng có chọn đúng file Media hay không
            for (int i = linkAnh.length() - 1; i >= 0; i--) {
                check1 = check1 + linkAnh.charAt(i);
                if (check1.equals("gpj.") || check1.equals("gnp.")) {
                    dem3++;
                    break;
                }
            }

            //Kiểm tra xem người dùng có chọn đúng file ảnh hay không
            for (int i = linkPhatAm.length() - 1; i >= 0; i--) {
                check2 = check2 + linkPhatAm.charAt(i);
                if (check2.equals("3pm.") || check2.equals("a4m.")) {
                    dem3++;
                    break;
                }
            }

            //Nếu đúng thì người dùng có thể lưu từ
            if (dem3 == 2) {
                String tiengAnh = tfTuTiengAnh.getText();
                String tiengViet = tfTuTiengViet.getText();
                String phiemAm = tfSpelling.getText();
                String phatAm = tfPronounce.getText();
                String loaiTu = tfLoaiTu.getText();
                String hashTag = tfHashtag.getText();
                String tuGoiY = tfSuggestedWords.getText();
                String anh = tfChosePic.getText();
                String dieuKien = tfSearch.getText();


                String cauLenhSQL = "UPDATE Words SET TiengAnh = '" + tiengAnh + "', TiengViet =N'" + tiengViet + "', PhienAm = N'" + phiemAm + "', PhatAm = N'" + phatAm + "', TuGoiY = N'" + tuGoiY + "', Hashtag = N'" + hashTag + "', DacDiemTu = N'" + loaiTu + "', Anh = N'" + anh + "' WHERE TiengAnh = '" + dieuKien + "'";
                addData.setSql(cauLenhSQL);
                addData.ketNoiDB();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Thông Báo");
                alert.setHeaderText("Bạn sửa từ thành công");
                alert.show();
                btnFix1.setDisable(true);
                btnPlay.setDisable(true);
            } else { //nếu không thì hiện thông báo cho người dùng chọn file không đúng
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Cảnh báo");
                alert.setHeaderText("File bạn chọn không hợp lệ");
                alert.show();
                btnFix1.setDisable(true);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Bạn sửa từ không thành công !!!");
            alert.show();
            btnFix1.setDisable(true);
        }


    }

    //Bắt sự kiện khi ấn vào nút "Tìm kiếm"
    @FXML
    public void onSearch(ActionEvent event) {
        String values = tfSearch.getText().trim();
        takeDataBase.setSql("SELECT * FROM Words WHERE TiengAnh = '" + values + "'");
        takeDataBase.connectDb();
        String tiengAnh = "";
        String tiengViet = "";
        String phienAm = "";
        String phatAm = "";
        String tuGoiY = "";
        String hashtag = "";
        String loaiTu = "";
        String pic = "";


        while (true) {
            try {
                if (!takeDataBase.resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
                tiengViet = takeDataBase.resultSet.getString("TiengViet");
                phienAm = takeDataBase.resultSet.getString("PhienAm");
                loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
                hashtag = takeDataBase.resultSet.getString("Hashtag");
                tuGoiY = takeDataBase.resultSet.getString("TuGoiY");
                pic = takeDataBase.resultSet.getString("Anh");
                phatAm = takeDataBase.resultSet.getString("PhatAm");


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(tiengAnh + phatAm);
        tfTuTiengAnh.setText(tiengAnh);
        tfTuTiengViet.setText(tiengViet);
        tfSpelling.setText(phienAm);
        tfPronounce.setText(phatAm);
        tfSuggestedWords.setText(tuGoiY);
        tfHashtag.setText(hashtag);
        tfLoaiTu.setText(loaiTu);
        tfChosePic.setText(pic);
        File file = new File(tfChosePic.getText());
        String localUrl = null;
        try {
            localUrl = file.toURI().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Image image = new Image(localUrl);
        imv.setImage(image);

        if (tfTuTiengAnh.getText().isEmpty()) {  // Bắt sự kiện khi người dùng nhập từ không có trong danh sách
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Từ/Cụm từ này không có trong danh sách !!!");
            alert.show();
        }
    }

    //Bắt sự kiện khi ấn vào nút "Chọn ảnh"
    @FXML
    public void onChosePicture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage stage = new Stage();
        FileChooser.ExtensionFilter imgameFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"); //chỉ cho người dùng chọn file ảnh không cho chọn file khác
        fileChooser.getExtensionFilters().add(imgameFilter);
        File file = fileChooser.showOpenDialog(stage);
        String localUrl = null;
        try {
            tfChosePic.setText(file.getPath());
            localUrl = file.toURI().toURL().toString();
            Image image = new Image(localUrl);
            imv.setImage(image);
        } catch (Exception e) {
//            e.printStackTrace();
            //Hiện thị thông báo khi người dùng chưa chọn file
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText("Bạn chưa chọn ảnh");
            alert.show();
        }

    }

    //Bắt sự kiện khi ấn vào nút "Chạy"
    @FXML
    public void onPlay(ActionEvent event) {
        String linkPhatAm = tfPronounce.getText().trim();
        String check2 = "";
        int dem3 = 0; //Biến này dùng để kiểm tra đk là file media

        //Kiểm tra xem người dùng có chọn đúng file ảnh hay không
        for (int i = linkPhatAm.length() - 1; i >= 0; i--) {
            check2 = check2 + linkPhatAm.charAt(i);
            if (check2.equals("3pm.") || check2.equals("a4m.")) {
                dem3++;
                break;
            }
        }

        //Nếu đúng thì người dùng có thể nghe đoạn âm thanh vừa mới chọn
        if (dem3 == 1) {
            String uriString = new File(tfPronounce.getText()).toURI().toString();
            mediaPlayer = new MediaPlayer(new Media(uriString));
            mediaPlayer.play();
            btnPause.setDisable(false);
        } else { //nếu không thì hiện thông báo cho người dùng chọn file không đúng
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText("File bạn chọn không hợp lệ");
            alert.show();
            btnFix1.setDisable(true);
        }
    }

    //Bắt sự kiện khi ấn vào nút "Dừng"
    @FXML
    public void onPause(ActionEvent event) {
        mediaPlayer.pause();
    }

    //Bắt sự kiện khi ấn vào nút "Chọn file"
    @FXML
    public void onChoseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage stage = new Stage();
        FileChooser.ExtensionFilter imgameFilter = new FileChooser.ExtensionFilter("Media Files", "*.mp3", "*.m4a"); //Chỉ cho người dùng chọn file âm thanh không cho chọn file khác
        fileChooser.getExtensionFilters().add(imgameFilter);
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            tfPronounce.setText(file.getPath());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText("Bạn chưa chọn tệp");
            alert.show();
        }
        if (!tfPronounce.getText().trim().isEmpty()) {
            btnPlay.setDisable(false);
        }
    }

    //Bắt sự kiện khi ấn vào nút "Quay lại"
    @FXML
    public void onBack(ActionEvent event) {
        Parent root1 = null;
        try {
            //Lấy scene cũ
            root1 = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/Delete_AddWords/ListWords.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //Lấy stage cũ để set scene cũ

        //Set lại background cho scene cũ
        String image = getClass().getClassLoader().getResource("sample/Source/backgroundAddWords.jpg").toExternalForm();
        root1.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        //Lấy stage cũ để set scene cũ: quay trở lại màn hình chính
        stage.setTitle("List Words");
        stage.setScene(new Scene(root1, 600, 400));
        stage.setResizable(false);
    }

    //Bắt sự kiện khi ấn vào nút "Kiểm tra"
    @FXML
    public void onCheck(ActionEvent event) {
        if (!tfTuTiengViet.getText().trim().isEmpty() && !tfTuTiengAnh.getText().trim().isEmpty() && !tfSuggestedWords.getText().trim().isEmpty() && !tfPronounce.getText().trim().isEmpty() && !tfHashtag.getText().trim().isEmpty() && !tfLoaiTu.getText().trim().isEmpty() && !tfChosePic.getText().trim().isEmpty()) {
            String linkPhatAm = tfPronounce.getText().trim();
            String linkAnh = tfChosePic.getText().trim();
            String check1 = "";
            String check2 = "";
            int dem3 = 0; //Biến này dùng để kiểm tra 2 đk là file ảnh và file media

            //Kiểm tra xem người dùng có chọn đúng file Media hay không
            for (int i = linkAnh.length() - 1; i >= 0; i--) {
                check1 = check1 + linkAnh.charAt(i);
                if (check1.equals("gpj.") || check1.equals("gnp.")) {
                    dem3++;
                    break;
                }
            }

            //Kiểm tra xem người dùng có chọn đúng file ảnh hay không
            for (int i = linkPhatAm.length() - 1; i >= 0; i--) {
                check2 = check2 + linkPhatAm.charAt(i);
                if (check2.equals("3pm.") || check2.equals("a4m.")) {
                    dem3++;
                    break;
                }
            }

            //Nếu đúng thì người dùng có thể lưu từ
            if (dem3 == 2) {
                btnFix1.setDisable(false);
            } else { //nếu không thì hiện thông báo cho người dùng chọn file không đúng
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Cảnh báo");
                alert.setHeaderText("File bạn chọn không hợp lệ");
                alert.show();
                btnFix1.setDisable(true);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText("Bạn chưa điền đủ thông tin của từ/cụm từ");
            alert.show();
        }
    }

    //Hàm khởi tạo một số giá trị ban đầu
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        takeDataBase.setSql("select * from dbo.Words");
        takeDataBase.connectDb();

        //Set Button
        btnFix1.setDisable(true);
        btnPause.setDisable(true);


    }


}




