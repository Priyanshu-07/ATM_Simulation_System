
package atm.simulator.system;

import java.sql.*;

public class conn 
{
    Connection c;
    Statement s1;
    public conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///project","root","");
            s1 = c.createStatement();
        }catch(Exception e)
        {
        System.out.println(e);
        }
    }
}
