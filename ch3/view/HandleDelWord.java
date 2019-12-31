package ch3.view;
import java.awt.event.*;
import ch3.data.*;
public class HandleDelWord implements ActionListener {
   DelWordView view ;
   public void actionPerformed(ActionEvent e) {
      String englishWord = view.inputWord.getText();
      if(englishWord.length()==0) 
         return;
      Word word = new Word();
      DelWord del = new DelWord();
      word.setEnglishWord(englishWord);
      int isOK = del.delWord(word);
      if(isOK!=0)
         view.hintMess.setText("删除单词成功");
      else
         view.hintMess.setText("删除失败，单词不在表里");
   }
   public void setView(DelWordView view) {
      this.view = view;
   }
}