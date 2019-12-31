package ch3.data; 
import java.sql.*;
public class UpdateWord extends ConnectDatabase{
   int isOK  ; 
   public int updateWord(Word word) {
      connectDatabase();
      try { 
          String SQL ="update word_table set meaning = ? where word = ? ";
          PreparedStatement sta  = con.prepareStatement(SQL);
          //从左向右数第1个通配符?的值是word.getMeaning():
          sta.setString(1,word.getMeaning());
          //从左向右数第2个通配符?的值是word.getEnglishWord():
          sta.setString(2,word.getEnglishWord());
          isOK = sta.executeUpdate();
          con.close();
      }
      catch(SQLException e) {
          isOK = 0; 
      }
       return isOK;
   }
}
