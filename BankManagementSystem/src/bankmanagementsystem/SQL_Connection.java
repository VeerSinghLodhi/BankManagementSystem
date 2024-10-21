
package bankmanagementsystem;
import java.sql.*;


public class SQL_Connection {
    
    Statement s1;
    SQL_Connection()
    {
        try
        {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection c1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","veer6264");
            s1=c1.createStatement();
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
}
