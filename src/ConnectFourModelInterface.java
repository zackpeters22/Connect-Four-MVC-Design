/**
 * Zack Peters
 * ConnectFourModelInterface.java

 * ConnectFourModelInterface.java lays out what must be implemented for all of the classes that implement
 * this interface.
 */
public interface ConnectFourModelInterface {
	
	//reset or start the game
	void startGame();
	void dropCoin(int buttonNum);
	
	//determine player turn
	int getPlayerTurn();
	
	//vertical and horizontal wins
	int checkVerticalWin();
	int checkHorizontalWin();
	
	//check if the columns are filled and if it needs to disabled
	int checkButtonOneFilled();
	int checkButtonTwoFilled();
	int checkButtonThreeFilled();
	int checkButtonFourFilled();
	int checkButtonFiveFilled();
	int checkButtonSixFilled();
	int checkButtonSevenFilled();
	
	//checkWin in the model
	int checkWin();

	//register all observers
	void registerObserver(BoardObserver o);
	void removeObserver(BoardObserver o);


}
