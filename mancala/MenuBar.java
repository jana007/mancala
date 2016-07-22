package mancala;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	private JMenu file;
	private JMenu options;
	private JMenu quit;
	
	public MenuBar() {
		super();
		file = new JMenu("File");
		options = new JMenu("Options");
		quit = new JMenu("quit");
		
		add(file);
		add(options);
		add(quit);
	}
}
