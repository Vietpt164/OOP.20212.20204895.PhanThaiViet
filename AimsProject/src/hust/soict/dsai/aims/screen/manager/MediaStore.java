package hust.soict.dsai.aims.screen.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.Playable;
import hust.soict.dsai.aims.media.Media;

public class MediaStore extends JPanel { 
	private Media media; 
	
	public MediaStore(Media media) { 
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 

		JLabel title = new JLabel(media.getTitle()); 
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15)); 
		title.setAlignmentX(CENTER_ALIGNMENT); 
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT); 
		
		JPanel container = new JPanel(); 
		container.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		
		if(media instanceof Playable) { 
			JButton playButton = new JButton("Play");
			container.add(playButton); 
			playButton.addActionListener(new ButtonListener());
			
		}
		
		this.add(Box.createVerticalGlue()); 
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container); 
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 

	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
	    {
	        String button = e.getActionCommand();
	        if (button.equals("Play")) {
	            // create a dialog Box
	            JDialog play = new JDialog();
	            play.setTitle("Playing " + media.getClass().getSimpleName());
	 
	            // create a label
	            JLabel l = new JLabel("Title: " + media.getTitle());
	 
	            play.add(l);
	 
	            // setsize of dialog
	            play.setSize(200, 100);
	 
	            // set visibility of dialog
	            play.setVisible(true);
	        }
	    }
	}
	
}