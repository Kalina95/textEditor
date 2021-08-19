package textEditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ContainerCreator{
	
	private JFrame mainFrame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JMenuBar menu;
	private Font font;
	
	
	
	//Constructor
	public ContainerCreator() {
		this.mainFrame = new JFrame();
		this.textArea = new JTextArea(25,80);
		this.scrollPane = new JScrollPane(this.textArea);
		this.menu = new JMenuBar();
		this.font = new Font("Dialog",Font.PLAIN,14);
	}
	
	
	//mainFrame methods:
	public void mainFrameProperties(String fileName, int width, int height) {
		this.mainFrame.setSize(width,height);
		this.mainFrame.setResizable(true);
		this.mainFrame.setLayout(new BorderLayout());
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setTitle(fileName);

	}
	public void showMainFrame() {
		this.mainFrame.setVisible(true);
	}
	
	
	//menuBar methods:
	public void menuBarProperties() {
		this.mainFrame.add(menu, BorderLayout.NORTH);
		this.mainFrame.setJMenuBar(menu);
	}
		
	//menuBar methods:
	public void scrollPaneProperties() {
		this.scrollPane.setPreferredSize(new Dimension(200,200));
		this.mainFrame.getContentPane().add(scrollPane);
	}
	
	public void updateMainFrameTitle(String title) {
		this.mainFrame.setTitle(title);
	}
	
	public void updateTextAreaForegroundColor(Color color) {
		this.textArea.setForeground(color);
	}
	public void updateTextAreaBackgroundColor(Color color) {
		this.textArea.setBackground(color);
	}
	public void updateTextAreaFontSize(int textSize) {
		this.textArea.setFont(new Font(this.font.getName(), this.font.getStyle(), textSize));
	}
	
	public JMenuBar getMenuBar() {
		return this.menu;
	}
	
	public JFrame getMainFrame() {
		return this.mainFrame;
	}
	
	public JTextArea getTextArea() {
		return this.textArea;
	}
}
