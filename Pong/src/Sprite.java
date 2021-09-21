import java.awt.Color;
import java.awt.Rectangle;

/** Sprite class for Pong
 * BIT 504 A2
 * Alex RB
 * 5038417
 */
 


public class Sprite {
	
	 private int xPosition, yPosition;
	 private int xVelocity, yVelocity;
	 private int width, height;
	 private Color colour;
	 private int initialXPosition, initialYPosition;

	 /** Getters and setters defined below:
	  *  Set out to keep the sprite within the bounds of the screen
	  * 
	  */
	 
	 // Getters 

	 public int getxPosition() {
		 return xPosition;
	 }
	 
	 public int getyPosition() {
		 return yPosition;
	 }
	 
	 public int getxVelocity() {
		 return xVelocity;
	 }
	 
	 public int getyVelocity() {
		 return yVelocity;
	 }
	 
	 public int getWidth() {
		 return width;
	 }
	 
	 public int getHeight() {
		 return height;
	}
	 
	 public Color getColour() {
		 return colour;
	 }
	 
	 public Rectangle getRectangle() { // Creating rectangle
         return new Rectangle(getxPosition(), getyPosition(), getWidth(), getHeight());
     }
	 

	 // Setters
	 
	 public void setxPosition(int xPosition) {
         this.xPosition = xPosition;
     }
	 
	 public void setyPosition(int yPosition) {
         this.yPosition = yPosition;
     }

	 public void setxVelocity(int xVelocity) {
         this.xVelocity = xVelocity;
     }

	 public void setyVelocity(int yVelocity) {
         this.yVelocity = yVelocity;
     }

	 public void setWidth(int width) {
         this.width = width;
     }

	 public void setHeight(int height) {
         this.height = height;
     }
	 
	 public void setColour(Color colour) {
		 this.colour = colour;
	 }
	 
	 public void setXPosition(int newX, int panelWidth) {
	     xPosition = newX;
	     	if(xPosition < 0) {
	     		xPosition = 0;
	     	} else if(xPosition + width > panelWidth) {
	     		xPosition = panelWidth - width;
	     	}

	 }

	 public void setYPosition(int newY, int panelHeight) {
	     yPosition = newY;
	     	if(yPosition < 0) {
	     		yPosition = 0;
	     	} else if(yPosition + height > panelHeight) {
	     		yPosition = panelHeight - height;
	     	}
	 }
	 
	 public void setInitialPosition(int initialX, int initialY) { // Setting sprite to initial position on board
		 initialXPosition = initialX;
		 initialYPosition = initialY;
	 }
	 
	 public void resetToInitialPosition() { // Resetting the sprite
		 setxPosition(initialXPosition);
		 setyPosition(initialYPosition);
	 }

}
