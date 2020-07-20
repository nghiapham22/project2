package sample.Model;

public class LayKiTuDauVaCuoi {
    public String getResoult() {
        return resoult;
    }

    public void setResoult(String resoult) {
        this.resoult = resoult;
    }

    private String resoult;

    public String getString() {  //Lấy kí tự đầu và cuối
        String a = "";
        for (int i = 0; i < resoult.length(); i++) {
            char checkSpace = resoult.charAt(i);
            if (i == 0 || i == resoult.length() - 1 || Character.toString(checkSpace).equals(" ")) {
                a = a + resoult.charAt(i);
            } else {
                a = a + "*";
            }
        }
        return a;
    }

    public  String layKiTuDau(){
        char a =a = resoult.charAt(0);
        String s = Character.toString(a);
        return s;
    }

    public  String layKiTuCuoi(){
        char a =a = resoult.charAt(resoult.length()-1);
        String s = Character.toString(a);
        return s;
    }

    public int getLengthString() {
        int doDaiChuoi = resoult.length();
        return doDaiChuoi;
    }

    public int getWordCountOfWords() { //Dùng để xác định người dùng nhập từ hay cụm từ
        int dem = 1;
        for (int i = 0; i < resoult.length(); i++) {
            char check = resoult.charAt(i);
            if (Character.toString(check).equals(" ")) {
                dem++;
            }
        }
        return dem;
    }
}
