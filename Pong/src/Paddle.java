import java.awt.Color;

/** Paddle class for Pong
 * BIT 504 A2
 * Alex RB
 * 5038417
 */
   
 
public class Paddle extends Sprite {

       private static final int PADDLE_WIDTH = 10;
       private static final int PADDLE_HEIGHT = 100;
       private static final Color PADDLE_COLOUR = Color.WHITE;
       private static final int DISTANCE_FROM_EDGE = 40;
       
       
       public Paddle(Player player, int panelWidth, int panelHeight) {
    	   
    	   // Creating the paddle parameters of width, height, colour
           setWidth(PADDLE_WIDTH);
           setHeight(PADDLE_HEIGHT);
           setColour(PADDLE_COLOUR);
           int xPos;
           if(player == Player.One) {
               xPos = DISTANCE_FROM_EDGE;
           } else {
               xPos = panelWidth - DISTANCE_FROM_EDGE - getWidth();
           }
           setInitialPosition(xPos, (panelHeight / 2) - (getHeight() / 2));
           resetToInitialPosition();

       }

  }