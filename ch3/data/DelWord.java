package ch3.data;
import java.sql.*;

import ch3.data.ConnectDatabase;
public class DelWord extends ConnectDatabase{
    int isOK;
    public int delWord(Word word) {
        connectDatabase();   //�������ݿ⣨�̳еķ�����
        try {
            String SQL = "delete from word_table where word = ? ";
            PreparedStatement sta = con.prepareStatement(SQL);
            //�������ҵ�1��ͨ�������ֵ��word.getEnglishWord()
            sta.setString(1,word.getEnglishWord());
            isOK = sta.executeUpdate();
            con.close();
        }
        catch(SQLException e) {
            isOK = 0;   //word_table���е�word�ֶ����������������������ظ�
        }
        return isOK;
    }
}