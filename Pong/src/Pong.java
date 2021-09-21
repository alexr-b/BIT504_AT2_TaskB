import java.awt.Color;

/** Pong Game Main class
 * BIT 504 A2
 * Alex RB
 * 5038417
 */

import javax.swing.JFrame;

public class Pong extends JFrame{
	
	private final static String WINDOW_TITLE = "Pong"; // Window title set to Poing
    private final static int WINDOW_WIDTH = 800; //Window dimension
    private final static int WINDOW_HEIGHT = 600;
    private final static Color BACKGROUND_COLOUR = Color.BLACK; // Background colour of Panel set to black
	
	public Pong() {
		
		// Pong method defined using parameters above
		
    	setTitle(WINDOW_TITLE);
    	setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    	setBackground(BACKGROUND_COLOUR);
    	setResizable(false);
    	add(new PongPanel());
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		// Pong instance created
		
				new Pong();
			
		
			
		// TODO Auto-generated method stub

	}

}
