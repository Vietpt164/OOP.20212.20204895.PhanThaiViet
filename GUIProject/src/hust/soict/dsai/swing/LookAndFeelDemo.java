package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame{
	public LookAndFeelDemo() {
		
		addDemoComponent();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380,100);
		setVisible(true);
	}
	
	void addDemoComponent() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label: "));
		cp.add(new JTextField("TextField"));
		cp.add(new JRadioButton("Radio Button"));
		cp.add(new JButton("Button"));
	}
	
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel Here: "));
		
		//create the combo box
		LookAndFeelInfo[] ilafInfos = UIManager.getInstalledLookAndFeels();
		
		String[] lafNames = new String[ilafInfos.length + 2];
		lafNames[ilafInfos.length] = "Java";
		lafNames[ilafInfos.length + 1] = "System";
		for (int i = 0; i < ilafInfos.length; i++) {
			lafNames[i] = ilafInfos[i].getName();
		}
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		//handle change look and feel
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				int index = cbLookAndFeel.getSelectedIndex();
				try {
					if (index == ilafInfos.length) {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
						setTitle(lafNames[ilafInfos.length] + " Look And Feel");
					} else if (index == ilafInfos.length + 1) {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						setTitle(lafNames[ilafInfos.length + 1] + " Look And Feel");
					} else {
						UIManager.setLookAndFeel(ilafInfos[index].getClassName());
						setTitle(ilafInfos[index].getName() + " Look And Feel");
					}
				} catch (Exception e) {
					e.printStackTrace();	
				}
				SwingUtilities.updateComponentTreeUI(frame);
								
			}
		});
	}
	
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
	
}
