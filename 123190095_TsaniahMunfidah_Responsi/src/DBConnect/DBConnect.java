
package DBConnect;
import java.sql.*;

public class DBConnect {
    String url = "jdbc:mysql://localhost:3306/barang?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String username = "root";
    String password = "";
    Connection connection;
    Statement statement;

    public DBConnect() {
        String forName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(forName);
            connection = (Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Koneksi gagal");
        }
    }
    
    public Connection getConnection(){
        return  connection;
    }  
}
