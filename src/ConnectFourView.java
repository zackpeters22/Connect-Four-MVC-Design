/**
 * Zack Peters
 * ConnectFourView.java
 * 
 * ConnectFourView.java creates the GUI representation of the connect four by using JFrame and numerous JPanels.
 * The view is used to represent visually the processes of the game and who may be winning or losing. 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ConnectFourView implements ActionListener, BoardObserver {
	
	//create instances 
	ConnectFourModelInterface model;
	ConnectFourControllerInterface controller;
	
	//game panel
	JPanel gamePanel;
	JPanel resetPanel;
	
	JLabel playerLabel;
	
	//game Frame
	JFrame gameFrame;
	
	//JLabel
	JLabel stringLabel;
		
	//buttons
	JButton columnButton1;
	JButton columnButton2;
	JButton columnButton3;
	JButton columnButton4;
	JButton columnButton5;
	JButton columnButton6;
	JButton columnButton7;
	JButton resetButton;
	
	//need the panel list for the two-d array
	public JPanel[][] panelList =  new JPanel[6][7];
	
	/**
	 * 
	 * @param controller
	 * @param model
	 * constructor for the VIEW and this creates an instance of model, and the controller.
	 * Lastly will register as an observer to be able to asks for updates.
	 */
	public ConnectFourView(ConnectFourControllerInterface controller, ConnectFourModelInterface model){
		this.model = model;
		this.controller = controller;
		model.registerObserver((BoardObserver) this);	
	}
	
	/**
	 * createView method will create a layout of the Graphic Interface that
	 * uses buttons for where to send a coin, and panels to determine where a coin has been dropped.
	 */
	public void createView(){
		
		//game view JPanel
		gamePanel = new JPanel(new GridLayout(7,7,1,1));
		resetPanel = new JPanel(new BorderLayout());

		stringLabel = new JLabel("String");
		
		//determines whose turn it is
		playerLabel = new JLabel("Players One's Turn");
		
		
		//create JFrame with the title of connect four
		gameFrame = new JFrame("Connect Four Game");
		playerLabel.setForeground(Color.BLACK);

		
		//exit on close and dimensions are large
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(new Dimension(700,260));
		
		//create column button
		columnButton1 = new JButton("insert");
		columnButton2 = new JButton("insert");
		columnButton3 = new JButton("insert");
		columnButton4 = new JButton("insert");
		columnButton5 = new JButton("insert");
		columnButton6 = new JButton("insert");
		columnButton7 = new JButton("insert");
		resetButton = new JButton("Reset");
		
		//add to the game panel
		gamePanel.add(columnButton1);
		gamePanel.add(columnButton2);
		gamePanel.add(columnButton3);
		gamePanel.add(columnButton4);
		gamePanel.add(columnButton5);
		gamePanel.add(columnButton6);
		gamePanel.add(columnButton7);
		
		
		//reset pannel so the button and the label are on opposite sides
		resetPanel.add(playerLabel, BorderLayout.WEST);
		resetPanel.add(resetButton, BorderLayout.EAST);

		//for loop that is used to add all of the panels to the gamePanel in order
		for (int i = 0; i < 6; i++){
			for(int j = 0; j< 7 ; j++){
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				panelList[i][j] = panel;
				gamePanel.add(panel);
			}
		}
		
		
		//adds the panels to the frame and then seperates them
		gameFrame.add(gamePanel, BorderLayout.NORTH);
		gameFrame.add(resetPanel, BorderLayout.CENTER);
		
		//action listeners for the buttons
		columnButton1.addActionListener(this);
		columnButton2.addActionListener(this);
		columnButton3.addActionListener(this);
		columnButton4.addActionListener(this);
		columnButton5.addActionListener(this);
		columnButton6.addActionListener(this);
		columnButton7.addActionListener(this);
		
		resetButton.addActionListener(this);
		
		//set everything to be visible in the gameFrame
		gameFrame.setVisible(true);
	}
	
	
		/**
		 * actionPerformed is the acitonListener for each button and determines what occurs when each button is pressed.
		 */
		public void actionPerformed(ActionEvent e) {
			
			//check source and if it is corresponding column drop the coin
			if (e.getSource() == columnButton1){
				int buttonNum1 = 1;
				controller.dropCoin(buttonNum1);
			}
			//check source and if it is corresponding column drop the coin
			else if (e.getSource() == columnButton2){
				int buttonNum2 = 2;
				controller.dropCoin(buttonNum2);
			}
			//check source and if it is corresponding column drop the coin
			else if (e.getSource() == columnButton3){
				int buttonNum3 = 3;
				controller.dropCoin(buttonNum3);
			}
			//check source and if it is corresponding column drop the coin
			else if (e.getSource() == columnButton4){
				int buttonNum4 = 4;
				controller.dropCoin(buttonNum4);
			}
			//check source and if it is corresponding column drop the coin
			else if (e.getSource() == columnButton5){
				int buttonNum5 = 5;
				controller.dropCoin(buttonNum5);
			}
			//check source and if it is corresponding column drop the coin
			else if (e.getSource() == columnButton6){
				int buttonNum6 = 6;
				controller.dropCoin(buttonNum6);
			}
			
			//check source and if it is corresponding column drop the coin
			else if (e.getSource() == columnButton7){
				int buttonNum7 = 7;
				controller.dropCoin(buttonNum7);
			}
			//check source and if it is corresponding column drop the coin
			else if (e.getSource() == resetButton){
				controller.startGame();
			}
		}

		/**
		 * @param int a...updateBoard takes two integers from the model when it is notified that it
		 * will need to update. The controller takes responsibility of telling the View it must update.
		 * When the controller tells the view it needs to update it will call update board which
		 * determine where the coin is dropped, if someone has won and if there a draw.
		 * @param int b...
		 */
		public void updateBoard(int a, int b) {
			
			int playerTurn = model.getPlayerTurn();
			
			
			//when it is reset will change all of the panels in the panel list to white so game
			//is reset
			if (a == 10 && b == 10){
				for (int i = 0; i < 6; i++){
					for(int j = 0; j< 7 ; j++){
						panelList[i][j].setBackground(Color.WHITE);
					}
				}
			
				playerLabel.setText("Player One's Turn");	//set to player two turn
				playerLabel.setForeground(Color.BLACK);	//get black
				
				//all buttons are enabled
				columnButton1.setEnabled(true);
				columnButton2.setEnabled(true);
				columnButton3.setEnabled(true);
				columnButton4.setEnabled(true);
				columnButton5.setEnabled(true);
				columnButton6.setEnabled(true);
				columnButton7.setEnabled(true);
			}
			
			//player one is black
			else if (playerTurn == 1){
				//if player ones turn then change color accordingly
				playerLabel.setText("Player's Two Turn");
				playerLabel.setForeground(Color.RED);
				panelList[a][b].setBackground(Color.BLACK);
			}
			//player two is red then change the text color, and the foreground color of panel 
			else if (playerTurn == 2){
				playerLabel.setText("Player's One Turn");
				playerLabel.setForeground(Color.BLACK);
				panelList[a][b].setBackground(Color.RED);
			}
		
			//following will check win and determine who has one
			int playerWin = model.checkWin();
			
			if (playerWin == 1){
				//tell who has won the game
				JOptionPane.showMessageDialog(null, "Player One has Won! Congrats. Play again by hitting Reset");
				columnButton1.setEnabled(false);
				columnButton2.setEnabled(false);
				columnButton3.setEnabled(false);
				columnButton4.setEnabled(false);
				columnButton5.setEnabled(false);
				columnButton6.setEnabled(false);
				columnButton7.setEnabled(false);
			}
			else if (playerWin ==2){
				//tell who has one the game and disable all of the buttons
				JOptionPane.showMessageDialog(null, "Player Two has Won! Congrats. Play again by hitting Reset");
				columnButton1.setEnabled(false);
				columnButton2.setEnabled(false);
				columnButton3.setEnabled(false);
				columnButton4.setEnabled(false);
				columnButton5.setEnabled(false);
				columnButton6.setEnabled(false);
				columnButton7.setEnabled(false);
			}
			else if (playerWin == -1){
				//tell there is a tie and then disable all buttons
				JOptionPane.showMessageDialog(null, "It appears there is a draw. Please hit the Reset Button to play again!");
				System.out.println("Hello world.");
				columnButton1.setEnabled(false);
				columnButton2.setEnabled(false);
				columnButton3.setEnabled(false);
				columnButton4.setEnabled(false);
				columnButton5.setEnabled(false);
				columnButton6.setEnabled(false);
				columnButton7.setEnabled(false);
			}
			
			int disabledButton = 0;
			
			//check if section is filled
			disabledButton = model.checkButtonOneFilled();
			if (disabledButton == 1){
				columnButton1.setEnabled(false);
			}
			
			//check if section is filled
			disabledButton = model.checkButtonTwoFilled();
			if (disabledButton == 2){
				columnButton2.setEnabled(false);
			}
			
			//check if section is filled
			disabledButton = model.checkButtonThreeFilled();
			if (disabledButton == 3){
				columnButton3.setEnabled(false);
			}
			
			//check if section is filled
			disabledButton = model.checkButtonFourFilled();
			if (disabledButton == 4){
				columnButton4.setEnabled(false);
			}
			//check if section is filled
			disabledButton = model.checkButtonFiveFilled();
			if (disabledButton == 5){
				columnButton5.setEnabled(false);
			}
			
			//check if section is filled
			disabledButton = model.checkButtonSixFilled();
			if (disabledButton == 6){
				columnButton6.setEnabled(false);
			}
			//check if section is filled
			disabledButton = model.checkButtonSevenFilled();
			if (disabledButton == 7){
				columnButton7.setEnabled(false);
			}
				
		}
}
