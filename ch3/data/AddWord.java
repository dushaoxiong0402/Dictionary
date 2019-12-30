package ch3.data;
import java.sql.*;
public class AddWord extends ConnectDatabase{
    int isOK;
    public int insertWord(Word word) {
        connectDatabase();   //�������ݿ⣨�̳еķ�����
        try {
            String SQL ="insert into word_table values(?,?)";
            PreparedStatement sta = con.prepareStatement(SQL);
            //�������ҵ�1��ͨ�������ֵ��word.getEnglishWord()
            sta.setString(1,word.getEnglishWord());
            //�������ҵ�2��ͨ�������ֵ��word.getMeaning()
            sta.setString(2,word.getMeaning());
            isOK = sta.executeUpdate();
            con.close();
        }
        catch(SQLException e) {
            isOK = 0;   //word_table���е�word�ֶ����������������������ظ�
        }
        return isOK;
    }
}