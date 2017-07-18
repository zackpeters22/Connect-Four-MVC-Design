/**
 * Zack Peters
 * ConnectFourController.java
 
 * ConnectFourController.java is a java class that has an instance of model and view along with
 * its own constructor. In the constructor it will create an instance of view, and model then call create 
 * view which is the GUI.
 *
 * the controller has the startGame() method which will invoke the models call of start game
 * the controller also has the dropCoin which will be invoked onto the model so it will show a 
 * graphical represnetaiton of the board 
 */

public class ConnectFourController implements ConnectFourControllerInterface {
	
	ConnectFourModelInterface model;
	ConnectFourView view;
	
	/**
	 * 
	 * @param model
	 * create the model,
	 * create instance of view and call create view
	 */
	public ConnectFourController(ConnectFourModelInterface model ){
		this.model = model;
		view = new ConnectFourView(this, model);
		view.createView();
	}
	
	/**
	 * startGame method calls startGame() on the model to invoke the sequence of starting/reseting
	 * the game
	 */
	public void startGame() {
		model.startGame();
	}

	/**
	 * dropCoin method calls startGame() on the model to invoke the sequence of entering a coin into the game
	 */	
	public void dropCoin(int buttonNum) {
		model.dropCoin(buttonNum);
		
	}


}
