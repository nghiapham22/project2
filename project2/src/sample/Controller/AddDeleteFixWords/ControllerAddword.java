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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sample.Model.AddData;
import sample.Model.TakeDataBase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerAddword implements Initializable {
    @FXML
    private TextField tfTuTiengAnh; // ô nhập từ/cụm từ
    @FXML
    private TextField tfTuTiengViet; // ô nhập dịch nghĩa của từ
    @FXML
    private TextField tfLoaiTu; //ô nhập loại từ
    @FXML
    private Button btnSave; //Nút để lưu dữ liệu mà người dùng nhập
    @FXML
    private Button btnBack; // Quay lại trang trước
    @FXML
    private Button btnChosePicture; //Nút này dùng để chọn ảnh mà người dùng muốn lưu
    @FXML
    private ImageView imv; //Hình ảnh
    @FXML
    private TextField tfPronounce; //ô này hiển thị đường dẫn tới file media mà người dùng lưu
    @FXML
    private TextField tfSpelling; //ô nhập Phiên âm
    @FXML
    private TextField tfSuggestedWords; // ô nhập Từ gợi ý
    @FXML
    private TextField tfHashtag; //ô nhập Hashtag
    @FXML
    private TextField tfChosePic; //ô này hiển thị đường dẫn tới ảnh mà người dùng lưu
    @FXML
    private Button btnPlay; //nút này để chạy phát âm của từ
    @FXML
    private Button btnCheck; // Nút này để kiểm tra thông tin từ đã đc nhập đủ chưa
    @FXML
    private Button btnChoseFile; //Nút này để chọn file media người dùng muốn
    @FXML
    private Button btnPause;// Để dừng khi mà phát âm đang chạy
    @FXML
    private DatePicker dp; //Chọn ngày tháng năm khi người dùng thêm từ
    @FXML
    private Label lbLoaiTu;
    @FXML
    private Label lbTime;

    private MediaPlayer mediaPlayer;
    private AddData addData = new AddData();
    private TakeDataBase takeDataBase = new TakeDataBase();

    //Bắt sự kiện khi ấn vào nút "Quay lại"
    @FXML
    public void onBack(ActionEvent event) {
        Parent root1 = null;
        try {
            //Lấy scene cũ
            root1 = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/Delete_AddWords/AddWords.fxml"));
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
        stage.setTitle("Add Words");
        stage.setScene(new Scene(root1, 600, 400));
        stage.setResizable(false);
    }

    //Bắt sự kiện khi ấn vào nút "lưu từ khóa"
    @FXML
    public void onSave(ActionEvent event) {
        if (!tfTuTiengViet.getText().trim().isEmpty() && !tfTuTiengAnh.getText().trim().isEmpty() && !tfSuggestedWords.getText().trim().isEmpty() && !tfPronounce.getText().trim().isEmpty() && !tfHashtag.getText().trim().isEmpty() && !tfLoaiTu.getText().trim().isEmpty() && !tfChosePic.getText().trim().isEmpty()) {
        /* ĐK1: ô tiếng Việt, tiếng Anh, từ gọi ý, hashtag, loại từ phải được điền đầy đủ và không để trống
           ĐK2: bắt buộc phải chọn file Media, chọn ảnh
           Đủ 2 đk trên thì hệ thống mới cho phép người dùng lưu thông tin từ/cụm từ
        */
            String linkPhatAm = tfPronounce.getText().trim();
            String linkAnh = tfChosePic.getText().trim();
            String check1 = "";
            String check2 = "";
            int dem3 = 0;

            for (int i = linkAnh.length() - 1; i >= 0; i--) {
                check1 = check1 + linkAnh.charAt(i);
                if (check1.equals("gpj.") || check1.equals("gnp.")) {
                    dem3++;
                    break;
                }
            }

            for (int i = linkPhatAm.length() - 1; i >= 0; i--) {
                check2 = check2 + linkPhatAm.charAt(i);
                if (check2.equals("3pm.") || check2.equals("a4m.")) {
                    dem3++;
                    break;
                }
            }

            if (dem3 == 2) {
                String tuTiengAnh = tfTuTiengAnh.getText().trim();
                String date = dp.getValue().toString();
                String cauLenhSQL = "INSERT INTO Words VALUES (" + "'" + tuTiengAnh + "',N'" + tfTuTiengViet.getText().trim() + "',N'" + tfSpelling.getText().trim() + "',N'" + tfPronounce.getText().trim() + "',N'" + tfSuggestedWords.getText().trim() + "',N'" + tfHashtag.getText().trim() + "',N'" + tfLoaiTu.getText().trim() + "',N'" + tfChosePic.getText().trim() + "','" + date + "')";
                addData.setSql(cauLenhSQL);
                addData.ketNoiDB();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Thông Báo");
                alert.setHeaderText("Bạn lưu từ thành công");
                alert.show();
                tfTuTiengAnh.setText("");
                tfTuTiengViet.setText("");
                tfPronounce.setText("");
                tfSpelling.setText("");
                tfHashtag.setText("");
                tfSuggestedWords.setText("");
                tfChosePic.setText("");
                tfLoaiTu.setText("");
                btnSave.setDisable(true);
                btnPlay.setDisable(true);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Cảnh báo");
                alert.setHeaderText("Bạn lưu từ không thành công !");
                alert.show();
                btnSave.setDisable(true);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Bạn lưu từ không thành công !");
            alert.show();
            btnSave.setDisable(true);
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

//        if(file != null){
//            Image image = new Image(file.toURI().toString());
//            imv.setImage(image);
//        }

//        String localUrl = null;
        try {
            tfChosePic.setText(file.getPath());
//            localUrl = file.toURI().toURL().toString();  2 dòng này thay cho 1 dòng dưới
//            Image image = new Image(localUrl);
            Image image = new Image(file.toURI().toString());
            imv.setImage(image);
        } catch (Exception e) {
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
            btnSave.setDisable(true);
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

    ////Bắt sự kiện khi ấn vào nút "Kiểm tra"
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
                //Kiểm tra xem từ sắp lưu có bị trùng với từ trong danh sách không
                String kiemTra = tfTuTiengAnh.getText().trim();  //Lấy từ trong ô Tiếng Anh mà người dùng nhập
                takeDataBase.setSql("SELECT * FROM Words WHERE TiengAnh = '" + kiemTra + "'"); //Dùng câu lệnh tìm kiếm từ mà người dùng đã nhập
                takeDataBase.connectDb();
                String kiemTra1 = ""; //Biến để lấy dữ liệu trong CSDL
                while (true) {
                    try {
                        if (!takeDataBase.resultSet.next()) break;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        kiemTra1 = takeDataBase.resultSet.getString("TiengAnh"); //Lấy dữ liệu Tiếng Anh trong câu lệnh SQL trên

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                //Kiểm tra xem từ người dùng điền có bị trùng không
                if (kiemTra.equalsIgnoreCase(kiemTra1)) {  //Nếu có thì báo cho người dùng biết
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Cảnh báo");
                    alert.setHeaderText("Từ/Cụm từ này đã có trong danh sách");
                    alert.show();
                    btnSave.setDisable(true);
                } else { //Nếu không thì họ có thể lưu
                    btnSave.setDisable(false);
                }
            } else { //nếu không thì hiện thông báo cho người dùng chọn file không đúng
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Cảnh báo");
                alert.setHeaderText("File bạn chọn không hợp lệ");
                alert.show();
                btnSave.setDisable(true);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText("Bạn chưa điền đủ thông tin của từ/cụm từ");
            alert.show();
            btnSave.setDisable(true);
        }

    }

    //Hàm khởi tạo giá trị ban đầu
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        String cauLenhSQL ="INSERT INTO Words VALUES (" + "'" + tfTuTiengAnh.getText() + "','" + tfTuTiengViet.getText() + "','" + tfSpelling.getText() + "','" + tfPronounce.getText() + "','" + tfSuggestedWords.getText() + "','" + tfHashtag.getText() + "','" + cbDacDiemCuaTu.getValue().toString() + "','" + tfChosePic.getText() + "','"+dp.getValue().toString()+"')" ;

        //Kết nối database và chạy câu lệnh "select * from Words"
        takeDataBase.setSql("select * from Words");
        takeDataBase.connectDb();


        //Set textfield
        tfTuTiengAnh.setPromptText("cat");
        tfTuTiengViet.setPromptText("con mèo");
        tfHashtag.setPromptText("#Animals");
        tfSuggestedWords.setPromptText("c*t");
        tfSpelling.setPromptText("kæt");
        tfLoaiTu.setPromptText("Danh Từ");
        tfChosePic.setPromptText("link ảnh");
        tfPronounce.setPromptText("link file media");

        //Set button
        btnPlay.setDisable(true);
        btnPause.setDisable(true);
        btnSave.setDisable(true);

        //Set datepicker
        dp.setValue(LocalDate.now()); //lấy ngày hiện tại

    }
}
