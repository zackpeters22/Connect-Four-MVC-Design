
/**
 * Zack Peters
 * ConnectFourModel.java
 * 
 * 
 * ConnectFourModel.java is where the majority of the game logic for the connectFour is hidden.
 * Here the game determines using a 2 dimensional array who wins or if the game ends up being a draw
 * This information is not told directly to the view but the view has the ability to ask for it
 * in numerous methods.  
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class ConnectFourModel implements ConnectFourModelInterface {

	//array list of observers (only the view is an observer)
	ArrayList<BoardObserver> boardObserver = new ArrayList<BoardObserver>();
	
	//game starts with player ones turn
	int playerTurn = 1;
	
	//create the gridList of two dimensions
	int[][] gridList =  new int[6][7];
	
	int a = 0;
	int b = 5;
	
	int c = 1;
	int d = 5;
	
	int e = 2;
	int f = 5;
	
	int g = 3;
	int h = 5;
	
	int i = 4;
	int j = 5;
	
	int k = 5;
	int l = 5;
	
	int m = 6;
	int n = 5;

	boolean win = false;

	/**
	 * startGame() method is called to reset the board as well as the two dimensional array
	 * when either a player has one OR the player decides to reset by pressing the reset button.
	 */
	public void startGame() {
		
		//for each row in the array it will fill it with 0, so later we can determine who wins/what spots are empty
		for (int[] row: gridList){
			Arrays.fill(row, 0);
		}
		//use these to reference where a coin is dropped originally...need to reset each time game it set up
		
		//index for the zero row fifth column
		a = 0;
		b = 5;
		
		//index for the first row fifth column
		c = 1;
		d = 5;
		
		//index for the second row fifth column
		e = 2;
		f = 5;
		
		//index for the third row fifth column
		g = 3;
		h = 5;
		
		//index for the fourth row fifth column
		i = 4;
		j = 5;
		
		//index for the fifth row fifth column
		k = 5;
		l = 5;
		
		//index for the sixth row fifth column
		m = 6;
		n = 5;
		

		playerTurn = 1;
		
		//notify observer
		notifyBoardObserver(10,10);
	}

	/**
	 * dropCoing() method is called to represent the insertion of the coin when the user
	 * presses a button. If it is in the represented column the notifyObservers() method
	 * is invoked in order to determine which section of the view to represent this in
	 */
	public void dropCoin(int buttonNum) {
		
		boolean inserted;
		
		inserted = false;
		
		//if button 1 is pressed 
		if (buttonNum == 1 && b != -1){
			
			while (inserted == false){	//assure has not already been inserted
				//check to see the section isn't already filled 
				if (gridList[b][a] == 0 && playerTurn == 1){	
					//set equal to corresponding players turn
					gridList[b][a] = playerTurn;
					inserted = true;
					//notify the view of changes
					notifyBoardObserver(b,a);
					b = b - 1;
					
					playerTurn = 2;	//change the players turn
				}
				//check to see the section isn't already filled 
				else if (gridList[b][a] == 0 && playerTurn ==2){
					gridList[b][a] = playerTurn;
					inserted = true;
					notifyBoardObserver(b,a);
					b = b -1;
					playerTurn = 1;

				}
			}
		}
		//if button 2 is pressed 
		else if (buttonNum == 2 && d != -1){
			inserted = false; //will reset each time game is played
				while (inserted == false){
					//check to see the section isn't already filled 
					if (gridList[d][c] == 0 && playerTurn == 1){
						//set equal to corresponding players turn
						gridList[d][c] = playerTurn;
						inserted = true;
						//notify the view of changes
						notifyBoardObserver(d,c);
						d = d - 1;
						playerTurn = 2;
					}
					//check to see the section isn't already filled 
					else if (gridList[d][c] == 0 && playerTurn ==2){
						gridList[d][c] = playerTurn;
						inserted = true;
						notifyBoardObserver(d,c);
						d = d -1;
						playerTurn = 1;
					}
				}
		}
		
		//if button 3 is pressed 
		else if (buttonNum == 3 && f != -1){
			inserted = false;
				while (inserted == false){
					//check to see the section isn't already filled 
					if (gridList[f][e] == 0 && playerTurn == 1){
						//set equal to corresponding players turn
						gridList[f][e] = playerTurn;
						inserted = true;
						//notify the view of changes
						notifyBoardObserver(f,e);
						f = f - 1;
						playerTurn = 2;
					}
					else if (gridList[f][e] == 0 && playerTurn ==2){
						//check to see the section isn't already filled 
						gridList[f][e] = playerTurn;
						inserted = true;
						notifyBoardObserver(f,e);
						f = f -1;
						playerTurn = 1;
					}
				}
		}
		
		//if button 4 is pressed 
		else if (buttonNum == 4  && h != -1){
			inserted = false;
				while (inserted == false){
					//check to see the section isn't already filled 
					if (gridList[h][g] == 0 && playerTurn == 1){
						//set equal to corresponding players turn
						gridList[h][g] = playerTurn;
						inserted = true;
						//notify the view of changes
						notifyBoardObserver(h,g);
						h = h - 1;
						playerTurn = 2;
					}
					else if (gridList[h][g] == 0 && playerTurn ==2){
						//check to see the section isn't already filled 
						gridList[h][g] = playerTurn;
						inserted = true;
						notifyBoardObserver(h,g);
						h = h -1;
						playerTurn = 1;
					}
				}
		}
		
		//if button 5 is pressed 
		else if (buttonNum == 5 && j != -1 ){
			inserted = false;
				while (inserted == false){
					//check to see the section isn't already filled 
					if (gridList[j][i] == 0 && playerTurn == 1){
						//set equal to corresponding players turn
						gridList[j][i] = playerTurn;
						inserted = true;
						//notify the view of changes
						notifyBoardObserver(j,i);
						j = j - 1;
						playerTurn = 2;
					}
					else if (gridList[j][i] == 0 && playerTurn ==2){
						gridList[j][i] = playerTurn;
						inserted = true;
						notifyBoardObserver(j,i);
						j = j -1;
						playerTurn = 1;
					}
				}
			}
		
		//if button 6 is pressed 
		else if (buttonNum == 6 && l != -1 ){
			inserted = false;
				while (inserted == false){
					//check to see the section isn't already filled 
					if (gridList[l][k] == 0 && playerTurn == 1){
						//set equal to corresponding players turn
						gridList[l][k] = playerTurn;
						inserted = true;
						//notify the view of changes
						notifyBoardObserver(l,k);
						l = l - 1;
						playerTurn = 2;
					}
					else if (gridList[l][k] == 0 && playerTurn ==2){
						gridList[l][k] = playerTurn;
						inserted = true;
						notifyBoardObserver(l,k);
						l = l -1;	
						playerTurn = 1;
					}
				}
			}
		
		//if button 7 is pressed 
		else if (buttonNum == 7 && n != -1 ){
			inserted = false;
				while (inserted == false){
					//check to see the section isn't already filled 
					if (gridList[n][m] == 0 && playerTurn == 1){
						//set equal to corresponding players turn
						gridList[n][m] = playerTurn;
						inserted = true;
						//notify the view of changes
						notifyBoardObserver(n,m);
						n = n - 1;
						playerTurn = 2;
					}
					else if (gridList[n][m] == 0 && playerTurn ==2){
						//check to see the section isn't already filled 
						gridList[n][m] = playerTurn;
						inserted = true;
						notifyBoardObserver(n,m);
						n = n - 1;
						playerTurn = 1;

					}
				}
	}

}
	/**
	 * registerObservers method will just add each observer to a list
	 */
	public void registerObserver(BoardObserver o) {
		boardObserver.add(o);
	}

	/**
	 * removeObservers method will just remove each observer from the list
	 */
	public void removeObserver(BoardObserver o) {
		int i = boardObserver.indexOf(o);
		if (i >= 0) {
			boardObserver.remove(i);
		}		
	}
	
	/**
	 * notifyBordObserver method will tell the observer to updateBoard() this calls the function each
	 * boardObserver must implement. 
	 */
	public void notifyBoardObserver(int a, int b) {
		for(int i = 0; i < boardObserver.size(); i++) {
			BoardObserver observer = (BoardObserver)boardObserver.get(i);
			//tells the view something has changed
			observer.updateBoard(a,b);
		}
	}

	
	/**
	 * getPlayerTurn() returns which player it is in int form
	 */
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	/**
	 * checkVerticalWin() function will go through the two dimensional list and
	 * determine which player has one. Since when each player drops a coin the number that
	 * is found at the four in a row shows which user one it is either 1 or 2.
	 */
	public int checkVerticalWin(){
		
		for (int row = 0; row < 3; row++){
			for (int column = 0; column <= 6; column ++){
				//vertical wins goes through the gridList vertically
			//increase the row by 1 and keep column the same in the inner for loop
				if (gridList[row][column] != 0 
					&& gridList[row][column] == gridList[row+1][column] 
					&& gridList[row][column] == gridList[row+2][column] 
					&& gridList[row][column] == gridList[row+3][column])
					{
						int playerNumber = gridList[row][column];
						return playerNumber;
					}
				}
		}
		return 0;
	}
		
	/**
	 * @return int
	 * checkHorizontalWin() function will go through the two dimensional list and
	 * determine if a player has one horizontally. Since when each player drops a coin the number that
	 * is found at the four in a row shows which user one it is either 1 or 2.
	 */
	public int checkHorizontalWin(){
		for (int row = 0; row < 6; row++){
			for (int column = 0; column < 4; column ++){
				//loop through the horizontal increasing the columns by 1
				if (gridList[row][column] != 0 
					&& gridList[row][column] == gridList[row][column+1] 
					&& gridList[row][column] == gridList[row][column+2] 
					&& gridList[row][column] == gridList[row][column+3])
					{
						int playerNumber = gridList[row][column];
						return playerNumber;
					}
				}
		}
		return 0;
		}
	
	/**
	 * @return int
	 * checkDiagnolWin() function will go through the two dimensional list and
	 * determine which player has won going from top left to right and then right to up
	 * 
	 * 
	 */
	public int checkDiagnolWin(){
		
		//starting from the left and going up one row/column at a time
		for (int row = 0; row < 3; row++){
			for (int column = 0; column < 4; column ++){
				if (gridList[row][column] != 0 
					//increase row and column by 1
					&& gridList[row][column] == gridList[row+1][column+1] 
					&& gridList[row][column] == gridList[row+2][column+2] 
					&& gridList[row][column] == gridList[row+3][column+3])
					{
						int playerNumber = gridList[row][column];
						return playerNumber;
					}
				}
		}
		//determine from right and up where the vertical is 
		for (int row = 3; row < 6; row++){
			for (int column = 0; column < 4; column ++){
				if (gridList[row][column] != 0 
					//subtract row by one and increase column by 1
					//moves right and up
					&& gridList[row][column] == gridList[row-1][column+1] 
					&& gridList[row][column] == gridList[row-2][column+2] 
					&& gridList[row][column] == gridList[row-3][column+3])
					{
						int playerNumber = gridList[row][column];
						return playerNumber;
					}
				}
		}
		return 0;
	}
	/**
	 * 
	 * @return int
	 * checkDraw() goes through the list and determines if the numbers are filled or not. If the number
	 * is not filled will not do anything. When it is filled adds to the count then if the count is at the highest possible
	 * will determine it is a draw and return -1. If no draw will continue playing.
	 */
	public int checkDraw(){
		int count = 0;
		//go through the entire list and add up if it is all filled
		for (int i = 0; i < 6; i++){
			for(int j = 0; j< 7 ; j++){
				if (gridList[i][j] != 0){
					count = count +1;
				}
			}
		}
		//return 42
		if (count == 42){
			return -1;
		}
		return 0;
	}
	
	/**
	 * 
	 * @return int determines which player has won
	 * checkWin() calls each of the three different styles of winnning and determines if anyone has one
	 * by checking the number. If neither has won then will return 0 and will continue the game.
	 * 1...return player one has won
	 * 2...return player two has won
	 * -1 return draw has occured
	 * this function is called by the view.
	 */
	public int checkWin() {
		int playerNum;
		//check for player that won vertically....tells view there is a win
		playerNum = checkVerticalWin();
		if (playerNum == 1){
			return 1;
		}
		else if (playerNum ==2){
			return 2;
		}
		
		//check for player that won horizontally....tells view there is a win
		playerNum = checkHorizontalWin();
		if (playerNum == 1){
			return 1;
		}
		else if (playerNum ==2){
			return 2;
		}
		//check for player that won diagnol....tells view there is a win
		playerNum = checkDiagnolWin();
		if (playerNum == 1){
			return 1;
		}
		else if (playerNum ==2){
			return 2;
		}
		//check draw if no draw return 0, if draw return -1....tells view there is a draw
		playerNum = checkDraw();
		if (playerNum == -1){
			return -1;
		}
		else{
			return 0;
		}	
	}
	
	/**
	 * 
	 * @return int which references the button number.
	 * check if the column is filled so it will disable the button
	 */
	public int checkButtonOneFilled() {
		int row = 0;
		int column = 0 ;
		//check if the secrion is filled disables button 1
		if (gridList[row][column] != 0){
			return 1;
		}
		return 0;
	}
	
	
	/**
	 * 
	 * @return int which references the button number.
	 * check if the column is filled so it will disable the button
	 */
	public int checkButtonTwoFilled() {
		int row = 0;
		int column = 0;
		//check if the secrion is filled disables button 2
		if (gridList[row][column+1] != 0){
			return 2;
		}
		return 0;
	}
	
	
	/**
	 * 
	 * @return int which references the button number.
	 * check if the column is filled so it will disable the button
	 */
	public int checkButtonThreeFilled() {
		int row = 0;
		int column = 0;
		//check if the secrion is filled disables button 3
		if (gridList[row][column+2] != 0){
			return 3;
		}
		return 0;
	}
	/**
	 * 
	 * @return int which references the button number.
	 * check if the column is filled so it will disable the button
	 */
	public int checkButtonFourFilled() {
		int row = 0;
		int column = 0 ;
		//check if the secrion is filled disables button 4
		if (gridList[row][column+3] != 0){
			return 4;
		}
		return 0;
	}
	/**
	 * 
	 * @return int which references the button number.
	 * check if the column is filled so it will disable the button
	 */
	public int checkButtonFiveFilled() {
		int row = 0;
		int column = 0 ;
		//check if the secrion is filled disables button 5
		if (gridList[row][column+4] != 0){
			return 5;
		}
		return 0;
	}
	/**
	 * 
	 * @return int which references the button number.
	 * check if the column is filled so it will disable the button
	 */
	public int checkButtonSixFilled() {
		int row = 0;
		int column = 0 ;
		//check if the secrion is filled disables button 6
		if (gridList[row][column+5] != 0){
			return 6;
		}
		return 0;
	}
	/**
	 * 
	 * @return int which references the button number.
	 * check if the column is filled so it will disable the button
	 */
	public int checkButtonSevenFilled() {
		int row = 0;
		int column = 0 ;
		//check if the secrion is filled disables button 7
		if (gridList[row][column+6] != 0){
			return 7;
		}
		return 0;
	}		
}
