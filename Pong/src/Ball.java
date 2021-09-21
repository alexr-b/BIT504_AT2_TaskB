import java.awt.Color;

/** Sprite class for Pong
 * BIT 504 A2
 * Alex RB
 * 5038417
 */
   

   public class Ball extends Sprite {
	   
	   // Public ball class that inherits the attributes from the sprite class
	   
       private static final int BALL_WIDTH = 25;
       private static final int BALL_HEIGHT = 25;
       private static final Color BALL_COLOUR = Color.WHITE;

       public Ball(int panelWidth, int panelHeight) {

    	   setWidth(BALL_WIDTH);
           setHeight(BALL_HEIGHT);
           setColour(BALL_COLOUR);
           
           // Set initial position created by placing ball directly in middle of screen
           
           setInitialPosition((panelWidth / 2) - (getWidth() / 2), (panelHeight / 2) - (getHeight() / 2));
           resetToInitialPosition();

      }

 }
