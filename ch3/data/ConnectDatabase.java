package ch3.data;
import java.sql.Connection;
import java.sql.*;
public class ConnectDatabase{
	Connection con;
    public final void connectDatabase() {
    	try{
			String uri="jdbc:derby:MyEnglishBook;create=false";
			con=DriverManager.getConnection(uri);
		}
        catch(Exception e){}
		}     
}