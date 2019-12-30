package ch3.data;
import java.sql.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomQueryWord extends ConnectDatabase{
    int count =0;   
    public void setCount(int n){
        count = n;
    }
    public int getCount() {
        return count;
    }
    public Word[] randomQueryWord() {
        connectDatabase();   //�������ݿ⣨�̳еķ�����
        Word [] word = null;
        Statement sql;
        ResultSet rs;
        try {
            sql=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs=sql.executeQuery("select * from word_table");
            rs.last();
            int recordAmount =rs.getRow();   
            count = Math.min(count, recordAmount);
            word = new Word[count];
            for(int i=0;i<word.length;i++) {
                word[i] =new Word();
            }
            //�õ�1��recordAmount֮���count��������ͬ����������������index�У�
            int [] index = getRandomNumber(recordAmount,count);
            int m = 0;
            for(int randomNumber:index) {   //randomNumber����ȡ����index��ÿ����Ԫ��ֵ
                rs.absolute(randomNumber);   //��ѯ�α��ƶ�����randomNumber��
                word[m].setEnglishWord(rs.getString(1));
                word[m].setMeaning(rs.getString(2));
                m++;
            }
            con.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return word;
    }
    public int [] getRandomNumber(int max,int count) {
        int [] randomNumber = new int[count];
        Set<Integer> set=new HashSet<Integer>();
        int index =set.size();
        Random random = new Random();
        while(index<count){
            int number = random.nextInt(max)+1;
            set.add(number);   //��number���뼯��set��
            index =set.size();
        }
        Iterator<Integer> iter=set.iterator();
        index=0;
        while(iter.hasNext()) {   
            Integer te=iter.next();
            randomNumber[index] = te.intValue();
            index++;
        }
        return randomNumber;
    }
}