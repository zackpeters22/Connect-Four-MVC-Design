/**
 * Zack Peters
 * ConnectFourDriverjava
 *
 * ConnectFourDriver.java will create instances of the connectFourModelInterface and ConnectFourControllerInterface
 * doing so will create a new GUI.
 * 
 * Allows for the ability to test the code. 
 */


public class ConnectFourDriver {

	public static void main(String[] args) {	
		
		ConnectFourModelInterface model = new ConnectFourModel();
		ConnectFourControllerInterface controller = new ConnectFourController(model);
	}
}
