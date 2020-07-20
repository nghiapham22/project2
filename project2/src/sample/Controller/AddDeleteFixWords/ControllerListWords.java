package sample.Controller.AddDeleteFixWords;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.TakeDataBase;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerListWords implements Initializable {

    @FXML
    private TextArea taList;  //Đoạn văn bản hiện thị danh sách các từ/cụm từ mà người dùng đã thêm
    @FXML
    private Button btnSearch; //Nút này dùng để tìm kiếm từ/cụm từ theo người dùng chọn tìm kiếm theo đặc điểm nào của từ
    @FXML
    private Button btnDelete; //Nút này dùng để đưa người dùng đến dao giện để xóa từ
    @FXML
    private Button btnFix; //Nút này dùng để đưa người dùng đến dao giện để sửa từ
    @FXML
    private Button btnBack; //Nút này dùng để đưa người dùng quay lại dao giện trước đấy
    @FXML
    private Button btnReset; //Nút này dùng để đặt lại danh sách khi mà người dùng đang tìm kiếm mà muốn trở lại danh sách như lúc đầu
    @FXML
    private Label labelSearch;
    @FXML
    private TextField tfListSearch; //Ô nhập thông tin từ cần tìm kiếm
    @FXML
    private ComboBox<String> comboBox;
    ObservableList<String> listSearch = FXCollections.observableArrayList("Tiếng Anh", "Tiếng Việt", "Hashtag", "Từ gợi ý", "Thời gian", "Loại từ"); //người dùng có thể tìm kiếm theo những đặc điểm của từ


    private TakeDataBase takeDataBase = new TakeDataBase();


    //Bắt sự kiện khi ấn vào nút "Đặt lại"
    @FXML
    public void onReset(ActionEvent event) {
        takeDataBase.setSql("select * from Words ORDER BY TiengAnh");
        takeDataBase.connectDb();
        String tiengAnh = "";
        String tiengViet = "";
        String phiemAm = "";
        String loaiTu = "";
        String hashTag = "";
        String tuGoiY = "";
        String thoiGian = "";
        String list = "";
        int i = 1;
        while (true) {
            try {
                if (!takeDataBase.resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
                tiengViet = takeDataBase.resultSet.getString("TiengViet");
                phiemAm = takeDataBase.resultSet.getString("PhienAm");
                loaiTu = takeDataBase.resultSet.getString("DacDiemTu");
                hashTag = takeDataBase.resultSet.getString("Hashtag");
                tuGoiY = takeDataBase.resultSet.getString("TuGoiY");
                thoiGian = takeDataBase.resultSet.getString("ThoiGian");
                list = list + i + "." + "Tiếng Anh: " + tiengAnh + "        " + "Tiếng Việt: " + tiengViet + "        " + "Phiên âm: " + phiemAm + "        " + "Loại từ: " + loaiTu + "        " + "Hashtag: " + hashTag + "        " + "Từ gợi ý: " + tuGoiY + "         " + "Thời gian thêm: " + thoiGian + "         " + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                i++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        taList.setText(list);
    }

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

    //Bắt sự kiện khi ấn vào nút "Xóa từ"
    @FXML
    public void onDelete(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/Delete_AddWords/DeleteWords.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/backgroundDeleteUpdate.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Delete Words");
        stage.setScene(scene);

    }

    //Bắt sự kiện khi ấn vào nút "Sửa từ"
    @FXML
    public void onFix(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("sample/View/Delete_AddWords/FixWords.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String image = getClass().getClassLoader().getResource("sample/Source/backgroundDeleteUpdate.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;" +
                "-fx-background-size: 600 400;");

        Scene scene = new Scene(root, 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Fix Words");
        stage.setScene(scene);


    }

    //Bắt sự kiện khi ấn vào nút "Tìm kiếm"
    @FXML
    public void onSearch(ActionEvent event) {
        if (labelSearch.getText() == "Tiếng Anh") {
            String result = tfListSearch.getText().trim();
            takeDataBase.setSql("SELECT * FROM Words WHERE TiengAnh like '%" + result + "%'");
            takeDataBase.connectDb();
            String tiengAnh1 = "";
            String tiengViet1 = "";
            String phiemAm1 = "";
            String loaiTu1 = "";
            String hashTag1 = "";
            String tuGoiY1 = "";
            String thoiGian1 = "";
            String list1 = "";
            int i = 1;
            while (true) {
                try {
                    if (!takeDataBase.resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    tiengAnh1 = takeDataBase.resultSet.getString("TiengAnh");
                    tiengViet1 = takeDataBase.resultSet.getString("TiengViet");
                    phiemAm1 = takeDataBase.resultSet.getString("PhienAm");
                    loaiTu1 = takeDataBase.resultSet.getString("DacDiemTu");
                    hashTag1 = takeDataBase.resultSet.getString("Hashtag");
                    tuGoiY1 = takeDataBase.resultSet.getString("TuGoiY");
                    thoiGian1 = takeDataBase.resultSet.getString("ThoiGian");
                    list1 = list1 + i + "." + "Tiếng Anh: " + tiengAnh1 + "        " + "Tiếng Việt: " + tiengViet1 + "        " + "Phiên âm: " + phiemAm1 + "        " + "Loại từ: " + loaiTu1 + "        " + "Hashtag: " + hashTag1 + "        " + "Từ gợi ý: " + tuGoiY1 + "         " + "Thời gian thêm: " + thoiGian1 + "         " + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    i++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            taList.setText(list1);
        } else if (labelSearch.getText() == "Tiếng Việt") {
            String result = tfListSearch.getText().trim();
            takeDataBase.setSql("SELECT * FROM Words WHERE TiengViet like N'%" + result + "%'");
            takeDataBase.connectDb();
            String tiengAnh1 = "";
            String tiengViet1 = "";
            String phiemAm1 = "";
            String loaiTu1 = "";
            String hashTag1 = "";
            String tuGoiY1 = "";
            String thoiGian1 = "";
            String list1 = "";
            int i = 1;
            while (true) {
                try {
                    if (!takeDataBase.resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    tiengAnh1 = takeDataBase.resultSet.getString("TiengAnh");
                    tiengViet1 = takeDataBase.resultSet.getString("TiengViet");
                    phiemAm1 = takeDataBase.resultSet.getString("PhienAm");
                    loaiTu1 = takeDataBase.resultSet.getString("DacDiemTu");
                    hashTag1 = takeDataBase.resultSet.getString("Hashtag");
                    tuGoiY1 = takeDataBase.resultSet.getString("TuGoiY");
                    thoiGian1 = takeDataBase.resultSet.getString("ThoiGian");
                    list1 = list1 + i + "." + "Tiếng Anh: " + tiengAnh1 + "        " + "Tiếng Việt: " + tiengViet1 + "        " + "Phiên âm: " + phiemAm1 + "        " + "Loại từ: " + loaiTu1 + "        " + "Hashtag: " + hashTag1 + "        " + "Từ gợi ý: " + tuGoiY1 + "         " + "Thời gian thêm: " + thoiGian1 + "         " + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    i++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            taList.setText(list1);
        } else if (labelSearch.getText() == "Từ gợi ý") {
            String result = tfListSearch.getText().trim();
            takeDataBase.setSql("SELECT * FROM Words WHERE TuGoiY like N'%" + result + "%'");
            takeDataBase.connectDb();
            String tiengAnh1 = "";
            String tiengViet1 = "";
            String phiemAm1 = "";
            String loaiTu1 = "";
            String hashTag1 = "";
            String tuGoiY1 = "";
            String thoiGian1 = "";
            String list1 = "";
            int i = 1;
            while (true) {
                try {
                    if (!takeDataBase.resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    tiengAnh1 = takeDataBase.resultSet.getString("TiengAnh");
                    tiengViet1 = takeDataBase.resultSet.getString("TiengViet");
                    phiemAm1 = takeDataBase.resultSet.getString("PhienAm");
                    loaiTu1 = takeDataBase.resultSet.getString("DacDiemTu");
                    hashTag1 = takeDataBase.resultSet.getString("Hashtag");
                    tuGoiY1 = takeDataBase.resultSet.getString("TuGoiY");
                    thoiGian1 = takeDataBase.resultSet.getString("ThoiGian");
                    list1 = list1 + i + "." + "Tiếng Anh: " + tiengAnh1 + "        " + "Tiếng Việt: " + tiengViet1 + "        " + "Phiên âm: " + phiemAm1 + "        " + "Loại từ: " + loaiTu1 + "        " + "Hashtag: " + hashTag1 + "        " + "Từ gợi ý: " + tuGoiY1 + "         " + "Thời gian thêm: " + thoiGian1 + "         " + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    i++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            taList.setText(list1);
        } else if (labelSearch.getText() == "Hashtag") {
            String result = tfListSearch.getText().trim();
            takeDataBase.setSql("SELECT * FROM Words WHERE Hashtag like N'%" + result + "%'");
            takeDataBase.connectDb();
            String tiengAnh1 = "";
            String tiengViet1 = "";
            String phiemAm1 = "";
            String loaiTu1 = "";
            String hashTag1 = "";
            String tuGoiY1 = "";
            String thoiGian1 = "";
            String list1 = "";
            int i = 1;
            while (true) {
                try {
                    if (!takeDataBase.resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    tiengAnh1 = takeDataBase.resultSet.getString("TiengAnh");
                    tiengViet1 = takeDataBase.resultSet.getString("TiengViet");
                    phiemAm1 = takeDataBase.resultSet.getString("PhienAm");
                    loaiTu1 = takeDataBase.resultSet.getString("DacDiemTu");
                    hashTag1 = takeDataBase.resultSet.getString("Hashtag");
                    tuGoiY1 = takeDataBase.resultSet.getString("TuGoiY");
                    thoiGian1 = takeDataBase.resultSet.getString("ThoiGian");
                    list1 = list1 + i + "." + "Tiếng Anh: " + tiengAnh1 + "        " + "Tiếng Việt: " + tiengViet1 + "        " + "Phiên âm: " + phiemAm1 + "        " + "Loại từ: " + loaiTu1 + "        " + "Hashtag: " + hashTag1 + "        " + "Từ gợi ý: " + tuGoiY1 + "         " + "Thời gian thêm: " + thoiGian1 + "         " + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    i++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            taList.setText(list1);
        } else if (labelSearch.getText() == "Loại từ") {
            String result = tfListSearch.getText().trim();
            takeDataBase.setSql("SELECT * FROM Words WHERE DacDiemTu like N'%" + result + "%'");
            takeDataBase.connectDb();
            String tiengAnh1 = "";
            String tiengViet1 = "";
            String phiemAm1 = "";
            String loaiTu1 = "";
            String hashTag1 = "";
            String tuGoiY1 = "";
            String thoiGian1 = "";
            String list1 = "";
            int i = 1;
            while (true) {
                try {
                    if (!takeDataBase.resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    tiengAnh1 = takeDataBase.resultSet.getString("TiengAnh");
                    tiengViet1 = takeDataBase.resultSet.getString("TiengViet");
                    phiemAm1 = takeDataBase.resultSet.getString("PhienAm");
                    loaiTu1 = takeDataBase.resultSet.getString("DacDiemTu");
                    hashTag1 = takeDataBase.resultSet.getString("Hashtag");
                    tuGoiY1 = takeDataBase.resultSet.getString("TuGoiY");
                    thoiGian1 = takeDataBase.resultSet.getString("ThoiGian");
                    list1 = list1 + i + "." + "Tiếng Anh: " + tiengAnh1 + "        " + "Tiếng Việt: " + tiengViet1 + "        " + "Phiên âm: " + phiemAm1 + "        " + "Loại từ: " + loaiTu1 + "        " + "Hashtag: " + hashTag1 + "        " + "Từ gợi ý: " + tuGoiY1 + "         " + "Thời gian thêm: " + thoiGian1 + "         " + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    i++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            taList.setText(list1);
        } else if (labelSearch.getText() == "Thời gian") {
            String result = tfListSearch.getText().trim();
            takeDataBase.setSql("SELECT * FROM Words WHERE ThoiGian like N'%" + result + "%'");
            takeDataBase.connectDb();
            String tiengAnh1 = "";
            String tiengViet1 = "";
            String phiemAm1 = "";
            String loaiTu1 = "";
            String hashTag1 = "";
            String tuGoiY1 = "";
            String thoiGian1 = "";
            String list1 = "";
            int i = 1;
            while (true) {
                try {
                    if (!takeDataBase.resultSet.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    tiengAnh1 = takeDataBase.resultSet.getString("TiengAnh");
                    tiengViet1 = takeDataBase.resultSet.getString("TiengViet");
                    phiemAm1 = takeDataBase.resultSet.getString("PhienAm");
                    loaiTu1 = takeDataBase.resultSet.getString("DacDiemTu");
                    hashTag1 = takeDataBase.resultSet.getString("Hashtag");
                    tuGoiY1 = takeDataBase.resultSet.getString("TuGoiY");
                    thoiGian1 = takeDataBase.resultSet.getString("ThoiGian");
                    list1 = list1 + i + "." + "Tiếng Anh: " + tiengAnh1 + "        " + "Tiếng Việt: " + tiengViet1 + "        " + "Phiên âm: " + phiemAm1 + "        " + "Loại từ: " + loaiTu1 + "        " + "Hashtag: " + hashTag1 + "        " + "Từ gợi ý: " + tuGoiY1 + "         " + "Thời gian thêm: " + thoiGian1 + "         " + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                    i++;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            taList.setText(list1);
        }

    }

    //Bắt sự kiện khi combobox thay đổi
    @FXML
    public void comboboxChange(ActionEvent event) {
        labelSearch.setText(comboBox.getValue()); //Nếu combobox thay đổi thì thay đổi nhãn labelSearch
    }


    //Hàm khởi tạo ban đầu
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Kết nối Database và chạy câu lệnh "select * from Words ORDER BY TiengAnh"
        takeDataBase.setSql("select * from Words ORDER BY TiengAnh");
        takeDataBase.connectDb();

        String tiengAnh = "";
        String tiengViet = "";
        String phiemAm = "";
        String loaiTu = "";
        String hashTag = "";
        String tuGoiY = "";
        String thoiGian = "";
        String list = "";
        int i = 1; // Biến này dùng để đánh stt trong danh sách
        while (true) { //Bước nhảy sang từ tiếp sau nó
            try {
                if (!takeDataBase.resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                //Lấy thông tin của từ/cụm từ
                tiengAnh = takeDataBase.resultSet.getString("TiengAnh");
                tiengViet = takeDataBase.resultSet.getString("TiengViet");
                phiemAm = takeDataBase.resultSet.getString("PhienAm");
                loaiTu = takeDataBase.resultSet.getString("DacDiemTu"); //Chính là loại từ
                hashTag = takeDataBase.resultSet.getString("Hashtag");
                tuGoiY = takeDataBase.resultSet.getString("TuGoiY");
                thoiGian = takeDataBase.resultSet.getString("ThoiGian");
                list = list + i + "." + "Tiếng Anh: " + tiengAnh + "        " + "Tiếng Việt: " + tiengViet + "        " + "Phiên âm: " + phiemAm + "        " + "Loại từ: " + loaiTu + "        " + "Hashtag: " + hashTag + "        " + "Từ gợi ý: " + tuGoiY + "         " + "Thời gian thêm: " + thoiGian + "         " + "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
                i++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //SetTexkArea
        taList.setText(list);

        //Set Combobox
        comboBox.setItems(listSearch);

    }


}
