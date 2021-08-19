/**
 *
 *  @author Kalinowski Michał PD3431

 *
 */

package textEditor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class Main {

	public static ContainerCreator Window = new ContainerCreator();
	
	public static String sdresPraca = "województwo: mazowieckie" + "\n" 
									 +"miejscowość: Warszawa" + "\n"
									 +"ulica: pracownicza 34" + "\n"
									 +"nr mieszkania: 31" + "\n"
									 +"kod pocztowy: 00-001";
	public static String sdresSzkola = "województwo: mazowieckie" + "\n" 
									 +"miejscowość: Warszawa" + "\n"
									 +"ulica: szkolna 123" + "\n"
									 +"nr mieszkania: -" + "\n"
									 +"kod pocztowy: 00-002";
	public static String sdresDom = "województwo: mazowieckie" + "\n" 
									 +"miejscowość: Warszawa" + "\n"
									 +"ulica: domowa 1" + "\n"
									 +"nr mieszkania: 1" + "\n"
									 +"kod pocztowy: 00-003";
	
  public static void main(String[] args) throws IOException {
	  
	  
	  //Containers
	  Window.mainFrameProperties("bez tytułu", 400, 400);
	  Window.menuBarProperties();
	  Window.scrollPaneProperties();
	  //End of Containers
	  
	  
	  
	  
	  //Menu Options
	  // create File, Edit and Option in MenuBar
	  String[] menuOptions = {"File", "Edit", "Options"};
	  MenuCreator MainMenu = new MenuCreator();
	  MainMenu.createMenu(Window.getMenuBar(),menuOptions);
	  
	  // creates Open, Save, Save as.. and Exit options in File
	  String[] fileOptions = {"Open", "Save", "Save As...", "Exit"};
	  MenuCreator fileMenu = new MenuCreator();
	  fileMenu.createMenuItemWithLine(MainMenu.getList().get(0),fileOptions, Color.red, 3);
	  
	  // creates Adresy option in Edit
	  String[] editOptions = {"Adresy"};
	  MenuCreator editMenu = new MenuCreator();
	  editMenu.createMenu(MainMenu.getList().get(1),editOptions);
	  
	  // creates Praca, Szkoła, Dom option in Adresy
	  String[] adressOptions = {"Praca", "Szkoła", "Dom"};
	  MenuCreator adressMenu = new MenuCreator();
	  adressMenu.createMenuItem(editMenu.getList().get(0),adressOptions);
	  
	  // creates Foreground, Background, Fontsize tabs in Options
	  String[] optionsOptions = {"Foreground", "Background", "FontSize"};		 
	  MenuCreator optionsMenu = new MenuCreator();
	  optionsMenu.createMenu(MainMenu.getList().get(2),optionsOptions);	  
	  
	  // creates colors options in foreground
	  String[] colors = {"Blue", "Yellow", "Orange", "Red", "White", "Black", "Green"};
	  MenuCreator foregroundMenu = new MenuCreator();
 	  foregroundMenu.createMenuItemWithIcon(optionsMenu.getList().get(0),colors);
 	  
 	  // creates colors options in background
 	  MenuCreator backgroundMenu = new MenuCreator();
 	  backgroundMenu.createMenuItemWithIcon(optionsMenu.getList().get(1),colors);
 	 	  
 	  // creates fontsizes list options in font size
 	  String[] fontSizes = {"8","10","12","14","16","18","20","22","24"};
 	  MenuCreator fontSizeMenu = new MenuCreator();
 	  fontSizeMenu.createMenuItem(optionsMenu.getList().get(2),fontSizes);
	  
	  
 	  //Mnemonics
 	  //File Menu
 	  ((JMenuItem) fileMenu.getComponentList().get(0)).setMnemonic(KeyEvent.VK_O);
 	  ((JMenuItem) fileMenu.getComponentList().get(1)).setMnemonic(KeyEvent.VK_S);
 	  ((JMenuItem) fileMenu.getComponentList().get(2)).setMnemonic(KeyEvent.VK_A);
 	  ((JMenuItem) fileMenu.getComponentList().get(4)).setMnemonic(KeyEvent.VK_X);

 	  adressMenu.getItemList().get(0).setMnemonic(KeyEvent.VK_P);
 	  adressMenu.getItemList().get(1).setMnemonic(KeyEvent.VK_S);
 	  adressMenu.getItemList().get(2).setMnemonic(KeyEvent.VK_D);
 	  
 	  //Accelerators
 	  KeyStroke keyStrokeToOpen= KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
 	  ((JMenuItem) fileMenu.getComponentList().get(0)).setAccelerator(keyStrokeToOpen);
 	  KeyStroke keyStrokeToSave= KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
	  ((JMenuItem) fileMenu.getComponentList().get(1)).setAccelerator(keyStrokeToSave);
	  KeyStroke keyStrokeToSaveAs= KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
 	  ((JMenuItem) fileMenu.getComponentList().get(2)).setAccelerator(keyStrokeToSaveAs);
 	  KeyStroke keyStrokeToExit= KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
	  ((JMenuItem) fileMenu.getComponentList().get(4)).setAccelerator(keyStrokeToExit);
	  
	  KeyStroke keyStrokeToAdresPraca= KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK);
	  adressMenu.getItemList().get(0).setAccelerator(keyStrokeToAdresPraca);
	  KeyStroke keyStrokeToAdresSzkola= KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK);
	  adressMenu.getItemList().get(1).setAccelerator(keyStrokeToAdresSzkola);
	  KeyStroke keyStrokeToAdresDom= KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK);
	  adressMenu.getItemList().get(2).setAccelerator(keyStrokeToAdresDom);
 	  
 	  
	  //Last command to show prepared frame
	  Window.showMainFrame();
  }
}