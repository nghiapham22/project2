package sample.Model;

public class FindTheLargestSubstring {
    public String getStringInDataBase() {
        return stringInDataBase;
    }

    public void setStringInDataBase(String stringInDataBase) {
        this.stringInDataBase = stringInDataBase;
    }

    public String getStringInput() {
        return stringInput;
    }

    public void setStringInput(String stringInput) {
        this.stringInput = stringInput;
    }

    private String stringInDataBase;
    private String stringInput;

    public String largestSubstring() {
        int dem = 0; // biến này dùng để bỏ qua những từ không trùng vs từ trong database. Nó là một bước nhảy bỏ qua các ký tự k trùng vs ký trự trong database
        String resoult = ""; // Dùng để lấy xâu chung LSC
        if (stringInDataBase.length() < stringInput.length()) {
            for (int i = 0; i < stringInDataBase.length(); i++) {
                int check = 0; // Dùng để dừng vòng lặp khi tìm thấy ký tự trùng
                for (int j = dem; j < stringInput.length(); j++) {
                    if (Character.toString(stringInDataBase.charAt(i)).equalsIgnoreCase(Character.toString(stringInput.charAt(j)))) {
                        check++;
                        dem = j + 1;
                        if (i == 0) {
                            resoult = resoult + stringInDataBase.charAt(i);
                            break;
                        } else {
                            for (int t = j - 1; t >= 0; t--) {
                                if (Character.toString(stringInput.charAt(t)).equalsIgnoreCase(Character.toString(stringInDataBase.charAt(i - 1)))) {
                                    resoult = resoult + stringInDataBase.charAt(i);
                                    break;
                                }
                            }
                        }

                    }
                    if (check > 0) {
                        break;
                    }
                }
            }
        } else if (stringInDataBase.length() > stringInput.length()) {
            for (int i = 0; i < stringInput.length(); i++) {
                if (Character.toString(stringInDataBase.charAt(i)).equalsIgnoreCase(Character.toString(stringInput.charAt(i)))){
                    resoult = resoult + stringInDataBase.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < stringInput.length(); i++) {
                if (Character.toString(stringInDataBase.charAt(i)).equalsIgnoreCase(Character.toString(stringInput.charAt(i)))) {
                    resoult = resoult + stringInDataBase.charAt(i);
                }

            }
        }

        return resoult;
    }


}
