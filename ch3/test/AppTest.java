package ch3.test;
import javax.swing.JFrame;
import java.sql.*;
import ch3.data.*;
public class AppTest {
    public static void main(String []args) {
        new CreateDatabaseAndTable();
        Word word = new Word();
        String [][] a = { {"boy","nanhai"},{"girl","nvhai"},
                       {"sun","taiyang"},{"moon","yueliang"},
                       {"book","shu"},{"water","shui"}
        };
    AddWord addWord = new AddWord();
    for(int i=0;i<a.length;i++){
        word.setEnglishWord(a[i][0]);
        word.setMeaning(a[i][1]);
        addWord.insertWord(word);
    }
    QueryOneWord q = new QueryOneWord();
    word.setEnglishWord("boy");
    Word re =q.queryOneWord(word);
    System.out.println("chaxundaoyigedanci:");
    System.out.printf("%-10s",re.getEnglishWord());
    System.out.printf("%-10s\n",re.getMeaning());
    QueryAllWord query = new QueryAllWord();
    Word [] result =query.queryAllWord();
    System.out.println("quanbudanci:");
    input(result);
    RandomQueryWord random = new RandomQueryWord();
    random.setCount(3);         
    result = random.randomQueryWord();
    System.out.println("suijichouqu"+random.getCount()+"gedanci");
    input(result);
    UpdateWord update = new UpdateWord();
    word.setEnglishWord("book");
    word.setMeaning("n.shuji,juan,zhangbu,mingce,gongzuobu");
    update.UpdateWord(word);
    DelWord del = new DelWord();
    word.setEnglishWord("boy");
    del.delWord(word);
    word.setEnglishWord("girl");
    del.delWord(word);
    System.out.println("gengxin,shangchuhopuqunbudnaci");
    query = new QueryAllWord();
    result =query.queryAllWord();
    input(result);
    }
    static void input(Word [] result){
        for(int i=0;i<result.length;i++){
           System.out.printf("-10%s",result[i].getEnglishWord());
           System.out.printf("-10%s",result[i].getMeaning());
           System.out.println();
    }
  }
}