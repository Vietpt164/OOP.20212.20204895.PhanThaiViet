package hust.soict.dsai.aims.screen.manager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.screen.manager.StoreManagerScreen.MenuListener;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
	protected Store store = new Store();
	
	public JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		
		return north;
	}
	
	public JMenuBar createMenuBar() { 
		JMenu menu = new JMenu("Options"); 
		
		JMenuItem viewStore = new JMenuItem("View store");
		menu.add(viewStore); 
		viewStore.addActionListener(new ViewStoreListener());
		
		JMenu smUpdateStore = new JMenu("Update Store"); 
		
		JMenuItem addBook = new JMenuItem("Add Book");
		smUpdateStore.add(addBook);
		addBook.addActionListener(new MenuListener()); 
		
		JMenuItem addCD = new JMenuItem("Add CD");
		smUpdateStore.add(addCD);
		addCD.addActionListener(new MenuListener()); 
		
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addDVD);
		addDVD.addActionListener(new MenuListener());
		
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar(); 
		menuBar.setLayout(new FlowLayout(FlowLayout .LEFT)); 
		menuBar.add(menu); 
		
		return menuBar; 
	}
	
	public JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	private class ViewStoreListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String option = e.getActionCommand();
			if (option.equals("View store")) {
				new StoreManagerScreen(store);
				dispose();
			} 
		}
		
	}
	
	public class MenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String menuItem = e.getActionCommand();
			if (menuItem.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen(store);
				dispose();
			} else if (menuItem.equals("Add CD")) {
				new AddCompactDiscToStoreScreen(store);
				dispose();
			} else if (menuItem.equals("Add Book")) {
				new AddBookToStoreScreen(store);
				dispose();
			}
			
		}
		
	}
	
}
