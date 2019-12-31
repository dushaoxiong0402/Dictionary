package ch3.data; 
import java.sql.*;
public class QueryOneWord extends ConnectDatabase{
   public Word queryOneWord(Word word) { 
      connectDatabase();
      Word  result  = null;
      Statement sql; 
      ResultSet rs;
      String str =
      "select * from word_table where word ='"+word.getEnglishWord()+"'";
      try { 
        sql=con.createStatement();
        rs=sql.executeQuery(str);
        if(rs.next()){ 
          result = new Word();
          result.setEnglishWord(rs.getString(1));
          result.setMeaning(rs.getString(2));
        }
        con.close();
      }
      catch(SQLException e) {}
      return result;
   }   
}
