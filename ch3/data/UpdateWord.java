package ch3.data; 
import java.sql.*;
public class UpdateWord extends ConnectDatabase{
   int isOK  ; 
   public int updateWord(Word word) {
      connectDatabase();
      try { 
          String SQL ="update word_table set meaning = ? where word = ? ";
          PreparedStatement sta  = con.prepareStatement(SQL);
          //������������1��ͨ���?��ֵ��word.getMeaning():
          sta.setString(1,word.getMeaning());
          //������������2��ͨ���?��ֵ��word.getEnglishWord():
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
