package ch3.data; 
import java.sql.*;
public class DelWord extends ConnectDatabase{
   int isOK ; 
   public int delWord(Word word) {
      connectDatabase();
      try { 
          String SQL ="delete from word_table where word = ? ";
          PreparedStatement sta  = con.prepareStatement(SQL);
          //������������1��ͨ���?��ֵ��word.getEnglishWord():
          sta.setString(1,word.getEnglishWord());
          isOK = sta.executeUpdate();
          con.close();
      }
      catch(SQLException e) {
          isOK = 0; 
      }
      return isOK;
   }
}
