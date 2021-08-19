package textEditor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class MenuCreator extends JFrame implements ActionListener{

	//Lists needed to save references to created items
	private ArrayList<JMenu> list = new ArrayList<>();
	private ArrayList<JMenuItem> itemList = new ArrayList<>();
	private ArrayList<JComponent> componentsList = new ArrayList<>();
	
	public ArrayList<JMenu> getList() {
		return list;
	}
	
	public ArrayList<JMenuItem> getItemList() {
		return itemList;
	}
	
	public ArrayList<JComponent> getComponentList() {
		return componentsList;
	}
	//End of Lists
	
	//Items and tabs generators
	public ArrayList<JMenu> createMenu(JMenuBar parent, String[] args){ 
		for(String txt : args) {
			JMenu menu = new JMenu(txt);
			menu.setBorderPainted(true);
			parent.add(menu);
			list.add(menu);
		}
		return list;
	}
	
	
	public ArrayList<JMenu> createMenu(JMenu parent, String[] args) {
		for(String txt : args) {
			JMenu menu = new JMenu(txt);
			menu.setBorder(BorderFactory.createRaisedBevelBorder());
			menu.setBorderPainted(true);
			parent.add(menu);
			list.add(menu);
		}
		return list;
	}
	
	
	
	public ArrayList<JMenuItem> createMenuItem(JMenu parent, String[] args) {
		for (String txt : args) {
			JMenuItem item = new JMenuItem(txt);
		      item.addActionListener(this);
		      item.setBorder(BorderFactory.createRaisedBevelBorder());
		      parent.add(item);
		      itemList.add(item);
		      
		      String parentName = parent.getText();
		      item.setActionCommand(parentName + " " + txt);
		    }
		return itemList;
	  }
	
	
	
	//Special generator for Items with Icon
	public ArrayList<JMenuItem> createMenuItemWithIcon(JMenu parent, String[] args) {
		 Icons[] icons = {new Icons(Color.BLUE, false),
				  new Icons(Color.YELLOW, false),
				  new Icons(Color.ORANGE, false),
				  new Icons(Color.RED, false),
				  new Icons(Color.WHITE, false),
				  new Icons(Color.BLACK, false),
				  new Icons(Color.GREEN, false)
		};
		int i =0;
		for (String txt : args) {
			JMenuItem item = new JMenuItem(txt, icons[i++]);
		      item.addActionListener(this);
		      item.setBorder(BorderFactory.createRaisedBevelBorder());
		      parent.add(item);
		      itemList.add(item);
		     
		      
		      String parentName = parent.getText();
		      item.setActionCommand(parentName + " " + txt);
		    }
		return itemList;
	  }
	
	
	//Special generator for JMenu List with line at n index
	public ArrayList<JComponent> createMenuItemWithLine(JMenu parent, String[] args, Color lineColor, int index){ 
		ArrayList<JComponent> components = new ArrayList<>();
		for(String txt : args) {
			JMenuItem item = new JMenuItem(txt);
			item.addActionListener(this);
			item.setBorder(BorderFactory.createRaisedBevelBorder());
		
			components.add(item);
	
			String parentName = parent.getText();
		    item.setActionCommand(parentName + " " + txt);
		}
		JSeparator separator = new JSeparator();
		separator.setForeground(lineColor);
		separator.setVisible(true);
		components.add(index,separator);
		
		for(JComponent component : components) {
			parent.add(component);
			componentsList.add(component);
		}

		return componentsList;
	}
	//End of special generator
	//End generators generators
	
	
	
	//KeyStrokes
	String[] keys = {"CtrlO", "CtrlS", "CtrlA", "CtrlX", "CtrlShiftP", "CtrlShiftS", "CtrlShiftD"};
	String[] actions = {"openFile", "saveFile", "saveFileAs", "Exit", "adresPraca", "adresSzkoła", "adresDom"};
	
	//Actions assigned to commands --> for example JMenuItem "Open" in JMenu "File" 
	//has Action Command = "File Open"
	//methods for Actions in class Actions.
	
	
	Actions action = new Actions();
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		//System.out.println(cmd);
		if (cmd.equals("File Open")) {
			action.openFile();
		}
		if (cmd.equals("File Save")) {
			action.saveFile();
		}
		if (cmd.equals("File Save As...")) {
			action.saveAs();
		}
		if (cmd.equals("File Exit")) {
			action.exit();
		}
		if (cmd.equals("Adresy Praca")) {
			action.adresyPraca();
		}
		if (cmd.equals("Adresy Szkoła")) {
			action.adresySzkola();
		}
		if (cmd.equals("Adresy Dom")) {
			action.adresyDom();
		}
		
		if (cmd.split(" ")[0].equals("Foreground")||cmd.split(" ")[0].equals("Background")) {
			action.color(cmd.split(" ")[0], cmd.split(" ")[1]);
			
		}
		if (cmd.split(" ")[0].equals("FontSize")) {
			action.fontSize(cmd.split(" ")[1]);
		}
	}
}
