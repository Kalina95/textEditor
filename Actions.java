package textEditor;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

import javax.swing.JFileChooser;


public class Actions {
	
	private static File file;

	
	
	public static void changefileName() {
		if (file==null) {
			Main.Window.updateMainFrameTitle("");
		}
		else Main.Window.updateMainFrameTitle(file.getName());
	}
	
	public void openFile() {
		final JFileChooser chooseFile = new JFileChooser();
		chooseFile.setDialogTitle("Open file");
		chooseFile.setCurrentDirectory(file);
		int returnVal = chooseFile.showOpenDialog(Main.Window.getMainFrame());
		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			file = chooseFile.getSelectedFile();
			
			
			try {
				BufferedReader bReader = new BufferedReader(new FileReader(file));
				Main.Window.getTextArea().setText(null);
				String readedLine=bReader.readLine();
				
				while(readedLine!=null) {
				Main.Window.getTextArea().append(readedLine+"\n");
				readedLine=bReader.readLine();
				}
				bReader.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Actions.changefileName();
        } else {
        	System.out.println("Dialog cancelled");
        }
		
	}
	
	
	public void saveFile() {
		String text = Main.Window.getTextArea().getText();
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(text);
			writer.close();
		} catch (IOException e) {
			System.out.println("IOEception");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
			Actions action = new Actions();
			action.saveAs();
		}
	}
	
	public void saveAs() {
		String text = Main.Window.getTextArea().getText();
		final JFileChooser chooseFile = new JFileChooser();
		chooseFile.setDialogTitle("Save file as...");
		int returnVal = chooseFile.showSaveDialog(Main.Window.getMainFrame());
		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			file = chooseFile.getSelectedFile();
			
			try {
				FileWriter writer = new FileWriter(file);
				writer.write(text);
				writer.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Actions.changefileName();
        } else {
        	System.out.println("Dialog cancelled");
        }
		
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void adresyPraca() {
		Main.Window.getTextArea().insert(Main.sdresPraca, Main.Window.getTextArea().getCaretPosition());
	}
	
	public void adresySzkola() {
		Main.Window.getTextArea().insert(Main.sdresSzkola, Main.Window.getTextArea().getCaretPosition());
	}
	
	public void adresyDom() {
		Main.Window.getTextArea().insert(Main.sdresDom, Main.Window.getTextArea().getCaretPosition());
	}
	
	public void color(String identifier, String string) {
		
		Hashtable<String, Color> colors = new Hashtable<>();
		colors.put("Blue", Color.blue);
		colors.put("Yellow", Color.yellow);
		colors.put("Orange", Color.orange);
		colors.put("Red", Color.red);
		colors.put("White", Color.white);
		colors.put("Black", Color.black);
		colors.put("Green", Color.green);
		
		if(identifier.equals("Foreground")) {
			Main.Window.updateTextAreaForegroundColor(colors.get(string));
		}
		if(identifier.equals("Background")) {
			Main.Window.updateTextAreaBackgroundColor(colors.get(string));
		}
		
	}
	
	public void fontSize(String string) {
		int textSizeInt = Integer.parseInt(string);
		Main.Window.updateTextAreaFontSize(textSizeInt);
	}
	
	
	
}
