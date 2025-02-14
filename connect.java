package cab_booking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    public static Connection connectdb()
    {
        Connection con=null;
        try {
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/cab","driver","1234");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
