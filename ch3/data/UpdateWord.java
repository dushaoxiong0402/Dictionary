package ch3.data;
import java.sql.*;

import ch3.data.ConnectDatabase;
public class UpdateWord extends ConnectDatabase{
    int isOK;
    public int UpdateWord(Word word) {
        connectDatabase();   //�������ݿ⣨�̳еķ�����
        try {
            String SQL = "update word_table set meaning = ? where word = ? ";
            PreparedStatement sta = con.prepareStatement(SQL);
            //������������1��ͨ�������ֵ��word.getMeaning()
            sta.setString(1,word.getMeaning());
            //�������ҵ�2��ͨ�������ֵ��word.getEnglishWord()
            sta.setString(2,word.getEnglishWord());
            isOK = sta.executeUpdate();
            con.close();
        }
        catch(SQLException e) {
            isOK = 0;   //word_table���е�word�ֶ����������������������ظ�
        }
        return isOK;
    }
}