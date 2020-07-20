package sample.Model;

import java.sql.*;

public class AddData {

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    private String sql;
    public void  ketNoiDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Project2";// your db name
            String user = "sa"; // your db username
            String password = "sa"; // your db password
//            String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
//                    "databaseName=Project2;username=sa;password=sa;";
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connect success!");
            }

//            String sql = "INSERT INTO Words VALUES ('book','quyển sách','ˈbʊk','D:\dowloads\Phat_Am\book.mp3','b**k','#Items','Danh Từ','D:\dowloads\Phat_Am\picture\book.jpg','2020-03-24')";
            PreparedStatement statement = conn.prepareStatement(sql);
            int resultSet = statement.executeUpdate();


//            showResutl(resultSet);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
