package infraestrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

private static Connection con;

public Connection getConnection() { 

try { 
Class.forName("net.sourceforge.jtds.jdbc.Driver");
con = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.10:1433;DatabaseName=UsersCameraPress","camerapress","rainbow");
System.out.println("Conexao ok");
} catch (ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
} catch (Exception e) { 
e.printStackTrace();
}
return con; 
}


public static void fechaConexao(){
try {
if(con!=null) con.close();
con =null;
} catch(Exception e) {
e.printStackTrace();
}
}
}
