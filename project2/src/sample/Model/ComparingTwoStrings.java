package sample.Model;

public class ComparingTwoStrings {
    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    private String s1; // chuỗi trong CSDL
    private String s2;// chuỗi nhập

    public String compare(){
        String resoult = "";
        int dem=0;
        if(s2.length()>s1.length()) {  // nếu chuỗi nhập vào dài hơn chuỗi trong CSDl
            for (int i = 0; i < s1.length(); i++) {
                dem++;
                if (Character.toString(s1.charAt(i)).equalsIgnoreCase(Character.toString(s2.charAt(i)))) {
                    resoult = resoult + "@";
                } else {
                    resoult = resoult + s2.charAt(i);
                }
            }
            for (int i = dem; i < s2.length(); i++) {
                resoult = resoult + s2.charAt(i);
            }
        } else if(s2.length() <= s1.length()){  //CHuỗi nhập ngắn hon chuỗi trong CSDL
            for (int i = 0; i < s2.length(); i++) {
//                dem++;
                if (Character.toString(s1.charAt(i)).equalsIgnoreCase(Character.toString(s2.charAt(i)))) {
                    resoult = resoult + "@"; //Những từ đúng sẽ thay = kí tự "@"
                } else {
                    resoult = resoult + s2.charAt(i); //Những từ sai sẽ được hiện đầy đủ cho người dùng biết đc họ sai ở đâu
                }
            }
        }
        return  resoult;
    }
}
