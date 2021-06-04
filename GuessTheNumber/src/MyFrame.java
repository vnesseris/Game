import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class MyFrame extends JFrame {
	
	private JTextField playersNumber;
	private JLabel resultLabel;
	private JButton guessButton;
	private JTextArea welcomeMessage;
	private GridLayout gridLayout;
	private JPanel firstPanel;
	private JPanel secondPanel;
	private JPanel thirdPanel;
	private JPanel fifthPanel;
	private JPanel fourthPanel;
	private JPanel sixthPanel;
	private JLabel newGame;
	private JButton yes;
	private JButton no;
	
	Play play = new Play();
	
	public MyFrame() {
		
	
		playersNumber = new JTextField(10);
		guessButton = new JButton("Guess");
		welcomeMessage = new JTextArea("Welcome to the Game.\nChoose a number between\n1 and 100");
		resultLabel = new JLabel();
		gridLayout = new GridLayout(6,1,0,0);
		
		newGame = new JLabel("Do you want to play new game?");
		yes = new JButton("Yes");
		no = new JButton("No");
		
		firstPanel = new JPanel();
		secondPanel = new JPanel();
		thirdPanel = new JPanel();
		fourthPanel = new JPanel();
		fifthPanel = new JPanel();
		sixthPanel = new JPanel();
		
		welcomeMessage.setEditable(false);
		welcomeMessage.setFont(welcomeMessage.getFont().deriveFont(Font.BOLD));
		
		this.setLayout(gridLayout);	
		this.add(firstPanel);
		this.add(secondPanel);
		this.add(thirdPanel);
		this.add(fourthPanel);
		this.add(fifthPanel);
		this.add(sixthPanel);
		
		firstPanel.add(welcomeMessage);
		firstPanel.setBackground(Color.WHITE);
		secondPanel.add(playersNumber);
		secondPanel.setBackground(Color.WHITE);
		thirdPanel.add(guessButton);
		thirdPanel.setBackground(Color.WHITE);
		fourthPanel.add(resultLabel);
		fourthPanel.setBackground(Color.WHITE);
		fifthPanel.add(newGame);
		fifthPanel.setBackground(Color.WHITE);
		sixthPanel.add(yes);
		sixthPanel.add(no);
		sixthPanel.setBackground(Color.WHITE);
		welcomeMessage.setPreferredSize(new Dimension(160,150));
		
		this.setVisible(true);
		this.setSize(300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Guess The Number");
		this.setResizable(false);
		
		PlayersChoiceListener playersChoiceListener = new PlayersChoiceListener();
		guessButton.addActionListener(playersChoiceListener);
		RestartGameListener restartListener = new RestartGameListener();
		yes.addActionListener(restartListener);
		no.addActionListener(restartListener);
	}
	
	public class PlayersChoiceListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			resultLabel.setText(play.guessTheNumber(Integer.parseInt(playersNumber.getText())));
			playersNumber.setText("");
		}
		
	}
	
	public class RestartGameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == yes) {
				play.restart();
				resultLabel.setText("");
				playersNumber.setText("");
			}
			else {
				System.exit(0);
			}
		}
	}
	

}
