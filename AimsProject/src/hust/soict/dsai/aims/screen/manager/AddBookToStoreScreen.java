package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
private JTextField title,category,cost,author;

	
	public JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		
		center.add(new JLabel("Enter the Book's details"));
		
		//create DVDInput Panel
		JPanel DVDInput = new JPanel();
		DVDInput.setLayout(new GridLayout(4,2,3,3));
		
		DVDInput.add(new JLabel("Title"));
		title = new JTextField(10);
		DVDInput.add(title);
		
		DVDInput.add(new JLabel("Category"));
		category = new JTextField(10);
		DVDInput.add(category);
		
		DVDInput.add(new JLabel("Cost"));
		cost = new JTextField(10);
		DVDInput.add(cost);	
		
		DVDInput.add(new JLabel("Author"));
		author = new JTextField(10);
		DVDInput.add(author);
		
		center.add(DVDInput);
		
		
		JButton okButton = new JButton("OK");
		center.add(okButton);
		okButton.addActionListener(new OKButtonListener());
		
		return center;
	}	

	private class OKButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String button = evt.getActionCommand();
	        if (button.equals("OK")) {
	        	Book book = new Book(title.getText(), category.getText(), 
	        								Float.parseFloat(cost.getText()), author.getText());
	        	store.addMedia(book);
	        	//System.out.println(book);
	        	
	        	//reset all text field
	        	title.setText(""); category.setText(""); cost.setText(""); author.setText("");
	        }
		}	
	}
	
	public AddBookToStoreScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Add Book to store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
