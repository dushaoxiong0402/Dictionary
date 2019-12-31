package ch3.gui;
import ch3.view.IntegrationView;
import ch3.data.CreateDatabaseAndTable;
public class AppWindow {
   public static void main(String [] args) {
      new CreateDatabaseAndTable();
      IntegrationView win = new IntegrationView(); 
   }
}