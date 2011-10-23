package tao.xiao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemo2 {

	JFrame jtfMainFrame;
	JButton jbnButton1, jbnButton2;
	JTextField jtfInput;
	JPanel jplPanel;
	public JButtonDemo2() {
		jtfMainFrame = new JFrame("Which Button Demo");
		jtfMainFrame.setSize(50, 50);
		jbnButton1 = new JButton("Button 1");
		jbnButton2 = new JButton("Button 2");
		jtfInput = new JTextField(20);
		jplPanel = new JPanel();
		jbnButton1.setMnemonic(KeyEvent.VK_I); //Set ShortCut Keys
		jbnButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtfInput.setText("Button 1!");
			}
		});
		jbnButton2.setMnemonic(KeyEvent.VK_I);
		jbnButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtfInput.setText("Button 2!");
			}
		});
		jplPanel.setLayout(new FlowLayout());
		jplPanel.add(jtfInput);
		jplPanel.add(jbnButton1);
		jplPanel.add(jbnButton2);
		jtfMainFrame.getContentPane().add(jplPanel, BorderLayout.CENTER);
		jtfMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jtfMainFrame.pack();
		jtfMainFrame.setVisible(true);
	}
	public static void main(String[] args) {
		// Set the look and feel to Java Swing Look
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		JButtonDemo2 application = new JButtonDemo2();
	}
}