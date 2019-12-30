package ch3.data;
import java.sql.*;
public class CreateDatabaseAndTable{
	Connection con;
	public CreateDatabaseAndTable(){
		try{Class.forName("org.apache.derby.jdbc.EmbeddDriver");
	}
	catch(Exception e){}
	try{
		String uri="jdbc:derby:MyEnglishBook;create=true";
		con=DriverManager.getConnection(uri);
	}
	catch(Exception e){}
	try{
		Statement sta=con.createStatement();
		String SQL="Create table word_table"+"(word varchar(50) primary key,meaning varchar(200))";
		sta.executeUpdate(SQL);
		con.close();
	}
	catch(SQLException e){}
	}
}