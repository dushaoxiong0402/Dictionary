package ch3.data; 
import java.sql.*;
public class ConnectDatabase{
   Connection con;
   public final void connectDatabase() {
      try{  
        String uri ="jdbc:derby:MyEnglishBook;create=false";
        con=DriverManager.getConnection(uri);//连接数据库代码
      }
      catch(Exception e){}
   }
}