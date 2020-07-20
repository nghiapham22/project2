package sample.Model;

import java.util.Random;

public class QueryStatement {
    public String cauTruyVan() {
        String resoult = "";
        Random random = new Random();
        int check = random.nextInt(15);
        if (check == 0) {
            resoult = "select * from dbo.Words";
        } else if (check == 1) {
            resoult = "select * from Words ORDER BY TiengAnh";
        } else if (check == 2) {
            resoult = "select * from Words ORDER BY TiengAnh DESC";
        } else if (check == 3) {
            resoult = "select * from Words ORDER BY TiengViet";
        } else if (check == 4) {
            resoult = "select * from Words ORDER BY TiengViet DESC";
        } else if (check == 5) {
            resoult = "select * from Words ORDER BY PhienAm";
        } else if (check == 6) {
            resoult = "select * from Words ORDER BY PhienAm DESC";
        } else if (check == 7) {
            resoult = "select * from Words ORDER BY TuGoiY";
        } else if (check == 8) {
            resoult = "select * from Words ORDER BY TuGoiY DESC";
        } else if (check == 9) {
            resoult = "select * from Words ORDER BY Hashtag";
        } else if (check == 10) {
            resoult = "select * from Words ORDER BY Hashtag DESC";
        } else if (check == 11) {
            resoult = "select * from Words ORDER BY DacDiemTu";
        } else if (check == 12) {
            resoult = "select * from Words ORDER BY DacDiemTu DESC";
        } else if (check == 13) {
            resoult = "select * from Words ORDER BY ThoiGian ";
        } else {
            resoult = "select * from Words ORDER BY ThoiGian DESC";
        }
        return resoult;
    }
}
