package ch3.view;
import java.awt.event.*;
import ch3.data.*;
public class HandleRandomQueryWord implements ActionListener {
   RandomQueryView view ;
   public void actionPerformed(ActionEvent e) {
      view.showWord.setText("");
      String n =view.inputQueryNumber.getText().trim();
      if(n.length()==0)
        return;
      int count = 0;
      try{
         count = Integer.parseInt(n);
      }
      catch(NumberFormatException exp){
         view.showWord.setText("请输入正整数");
      }
      RandomQueryWord random = new RandomQueryWord();
      random.setCount(count); //随机抽取count个单词
      Word [] result = random.randomQueryWord();
      for(int i=0;i<result.length;i++){
         int m = i+1;
         view.showWord.append(m+"."+result[i].getEnglishWord());
         view.showWord.append("   "+result[i].getMeaning());
         view.showWord.append("\n");   
      }
   }
   public void setView(RandomQueryView view) {
      this.view = view;
   }
}