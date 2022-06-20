package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField title,category,director,length,cost;

	
	public JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		
		center.add(new JLabel("Enter the DVD's details"));
		
		//create DVDInput Panel
		JPanel DVDInput = new JPanel();
		DVDInput.setLayout(new GridLayout(5,2,3,3));
		
		DVDInput.add(new JLabel("Title"));
		title = new JTextField(10);
		DVDInput.add(title);
		
		DVDInput.add(new JLabel("Category"));
		category = new JTextField(10);
		DVDInput.add(category);
		
		DVDInput.add(new JLabel("Director"));
		director = new JTextField(10);
		DVDInput.add(director);
	
		DVDInput.add(new JLabel("Length"));
		length = new JTextField(10);
		DVDInput.add(length);
		
		DVDInput.add(new JLabel("Cost"));
		cost = new JTextField(10);
		DVDInput.add(cost);
		center.add(DVDInput);
		
		
		JButton okButton = new JButton("OK");
		center.add(okButton);
		okButton.addActionListener(new ButtonListener());
		
		return center;
	}	

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String button = evt.getActionCommand();
	        if (button.equals("OK")) {
	        	store.addMedia(new DigitalVideoDisc(title.getText(), category.getText(), director.getText(), 
	        								Integer.parseInt(length.getText()), Float.parseFloat(cost.getText())));

	        	title.setText(""); category.setText(""); director.setText(""); length.setText(""); cost.setText("");
	        }
		}	
	}
	
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Update Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	
		
	
}
