import java.sql.*;

public class ConnectDatabase {

    private static final String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
    private static final String username = "root";
    private static final String password = "";
    Connection c;
    Statement s;
    public ConnectDatabase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, username, password);
            s = c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);;
        }
    }

    public static void main(String[] args) {
        new ConnectDatabase();
    }
}
