package ch3.data; 
import java.sql.*;
import java.util.*;
public class RandomQueryWord extends ConnectDatabase{
   int count =0 ;//随机抽取的数目
   public void setCount(int n){
       count = n;
   }
   public int getCount(){
      return count;
   }
   public Word[] randomQueryWord() { 
      connectDatabase();
      Word [] word  = null;
      Statement sql; 
      ResultSet rs;
      try { 
        sql=con.createStatement                    (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs=sql.executeQuery("select * from word_table");
        rs.last(); 
        int recordAmount =rs.getRow();//结果集中的记录
        count = Math.min(count,recordAmount);
        word = new Word[count];
        for(int i=0;i<word.length;i++){
           word[i] = new Word();
        }
        //得到1至recordAmount之间count个不同随机整数（存放在index中）：
        int [] index = getRandomNumber(recordAmount,count);
        int m = 0;
        for(int randomNumer:index){ // randomNumer依次取数组index每个单元的值
             rs.absolute(randomNumer);//查询游标移动到第randomNumer行
             word[m].setEnglishWord(rs.getString(1));
             word[m].setMeaning(rs.getString(2));
             m++;
        }
        con.close();
      }
      catch(SQLException e) { 
         System.out.println(e);
      }
      return word;
   } 
   public int [] getRandomNumber(int max,int count) {
     // 得到1至max之间的amount个不同随机整数（包括1和max）：
     int [] randomNumber = new int[count];
     Set<Integer> set=new HashSet<Integer>(); //set不允许有相同的元素
     int index =set.size();
     Random random = new Random();
     while(index<count){
         int number = random.nextInt(max)+1;
         set.add(number); //number放入集合set中
         index =set.size();
     }
     Iterator<Integer> iter=set.iterator();
     index = 0;
     while(iter.hasNext()) {  //把集合中的随机数放入数组
         Integer te=iter.next();
         randomNumber[index] = te.intValue();
         index++;
     }
     return  randomNumber;
   }  
}
