package textEditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JComponent;

public class Icons implements Icon {
	
	private Color color;
	private int w = 0;
	private boolean frame;
	
	 Icons(Color c, boolean frame) {
		 	
		    color = c;
		    this.frame = frame;
		  }
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
	    Color old = g.getColor();
	    g.setColor(color);
	    w = ((JComponent) c).getHeight();
	    g.fillOval(w/2, w/4, w/2, w/2);
	    if (frame) g.drawRect(x, y, w - 1, w - 1);
	    g.setColor(old);
	  }

	@Override
	public int getIconWidth() {
		return 0;
	}

	@Override
	public int getIconHeight() {
		return 0;
	}



}
