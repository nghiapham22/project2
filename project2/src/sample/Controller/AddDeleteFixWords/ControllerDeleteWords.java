package sample.Controller.AddDeleteFixWords;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Model.AddData;
import sample.Model.TakeDataBase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDeleteWords implements Initializable {
    @FXML
    private Button btnDelete; //Nút này dùng để xóa từ mà người dùng muốn xóa
    @FXML
    private Button btnBack;  // Nút này dùng để quay trở lại giao diện trước
    @FXML
    private TextField tfTiengAnh; // Ô này để nhập Tiếng Anh của từ/cụm từ mà người muốn xóa
    @FXML
    private TextField tfTiengViet;// Ô này để nhập Tiếng Việt của từ/cụm từ mà người muốn xóa
    @FXML
    private TextField tfLoaiTu;// Ô này để nhập loại của từ/cụm từ mà người muốn xóa
    @FXML
    private TextField tfTuGoiY;// Ô này để nhập từ gợi ý của từ/cụm từ mà người muốn xóa
    @FXML
    private TextField tfHashtag;// Ô này để nhập hashtag của từ/cụm từ mà người muốn xóa


    private TakeDataBase takeDataBase = new TakeDataBase();
    private AddData deleteData = new AddData();

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

    //Bắt sự kiện khi ấn vào nút "Xóa"
    @FXML
    public void onDelete(ActionEvent event) {
        //Kiểm tra điều kiện khi người dùng chưa nhập đủ thông tin của từ/cụm từ cần xóa
        if (!tfTiengViet.getText().isEmpty() && !tfLoaiTu.getText().isEmpty() && !tfHashtag.getText().isEmpty() && !tfTiengViet.getText().isEmpty() && !tfTuGoiY.getText().isEmpty()) {  //Nếu người dùng nhập đủ sẽ thực hiện xóa từ theo câu lệnh SQL
            String cauLenhSQL = "DELETE FROM Words WHERE TiengAnh ='" + tfTiengAnh.getText().trim() + "' AND TiengViet = N'" + tfTiengViet.getText().trim() + "' AND DacDiemTu = N'" + tfLoaiTu.getText().trim() + "' AND TuGoiY = N'" + tfTuGoiY.getText().trim() + "' AND Hashtag =N'" + tfHashtag.getText().trim() + "' ";
            deleteData.setSql(cauLenhSQL);
            deleteData.ketNoiDB();

            //Hiện thị thông báo để báo cho người dùng biết là họ đã xóa từ thành công
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Bạn xóa từ thành công");
            alert.show();

            //Set lại các ô điền thông tin từ
            tfHashtag.setText("");
            tfTuGoiY.setText("");
            tfLoaiTu.setText("");
            tfTiengViet.setText("");
            tfTiengAnh.setText("");

        } else {
            //Nếu người dùng chưa nhập đủ thông tin từ cần xóa thì hiện thị cho người dùng thông báo
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Thông Báo");
            alert.setHeaderText("Bạn xóa từ không thành công\n" + "Bạn chưa điền đủ thông tin từ cần xóa!!");
            alert.show();

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {  //Khởi tạo một vài giá trị ban đầu
        takeDataBase.setSql("select * from Words");
        takeDataBase.connectDb();

        //Set TextField
        tfTiengAnh.setPromptText("swim");
        tfTiengViet.setPromptText("bơi");
        tfLoaiTu.setPromptText("Động Từ");
        tfTuGoiY.setPromptText("s**m");
        tfHashtag.setPromptText("#Activity");
    }
}
