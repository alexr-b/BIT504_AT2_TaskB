import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import javax.swing.Timer;
import javax.swing.JPanel;

/** Pong Panel class
 * BIT504 A2
 * Alex RB
 * 5038417
 *
 */

public class PongPanel extends JPanel implements ActionListener, KeyListener{
	
	 private final static Color BACKGROUND_COLOUR = Color.BLACK;
	 private final static int TIMER_DELAY = 5;
	 private final static int BALL_MOVEMENT_SPEED = 2;
	 
	 GameState gameState = GameState.Initialising;
	 
	 boolean gameInitialised = false;
	 Ball ball;
	 Paddle paddleOne, paddleTwo;
	
	  private final static int POINTS_TO_WIN = 3;
	  int playerOneScore = 0, playerTwoScore = 0;
	  Player gameWinner;
	  
	  private final static int SCORE_TEXT_X = 100;
      private final static int SCORE_TEXT_Y = 100;
      private final static int SCORE_FONT_SIZE = 50;
      private final static String SCORE_FONT_FAMILY = "Forte";
      
      private final static int WINNER_TEXT_X = 200;
      private final static int WINNER_TEXT_Y = 200;
      private final static int WINNER_FONT_SIZE = 40;
      private final static String WINNER_FONT_FAMILY = "Arial";
      private final static String WINNER_TEXT = "YOU WIN!";
      
	 
	 
	  public PongPanel() {
          setBackground(BACKGROUND_COLOUR); // CLass parameter for colour
          Timer timer = new Timer(TIMER_DELAY, this); // New instance of timer object
          timer.start();
          addKeyListener(this);
          setFocusable(true);
      

      }
	  
	  private void checkPaddleBounce() {
		// TODO Auto-generated method stub
		   if(ball.getxVelocity() < 0 && ball.getRectangle().intersects(paddleOne.getRectangle())) {
		          ball.setxVelocity(BALL_MOVEMENT_SPEED);
		      }

		      if(ball.getxVelocity() > 0 && ball.getRectangle().intersects(paddleTwo.getRectangle())) {
		          ball.setxVelocity(-BALL_MOVEMENT_SPEED);

		      }
	}
	  
	  
	  

	  public void createObjects() { // Creating the ball when game starts
		  ball = new Ball(getWidth(), getHeight());
		  paddleOne = new Paddle(Player.One, getWidth(), getHeight());
	      paddleTwo = new Paddle(Player.Two, getWidth(), getHeight());
	  }
	  
	  private void update() { // Set up of game
		 switch(gameState) {
		 	case Initialising: {
			 	createObjects();
			 	gameState = GameState.Playing;
			 	ball.setxVelocity(BALL_MOVEMENT_SPEED);
			 	ball.setyVelocity(BALL_MOVEMENT_SPEED);
			 	break;
		 	}
		 	case Playing: {
		 		moveObject(paddleOne);
		 		moveObject(paddleTwo);
		 		moveObject(ball);
		 		checkWallBounce();
		 		checkPaddleBounce();
		 		checkWin();
		 		break;
		 }
		 	case GameOver: {
		 		break;
		 }
		  }
	  }
	  
	  private void moveObject(Sprite obj) {

	      obj.setXPosition(obj.getxPosition() + obj.getxVelocity(),getWidth());
	      obj.setYPosition(obj.getyPosition() + obj.getyVelocity(),getHeight());
	  }
	  
	  private void checkWin() {
          if(playerOneScore >= POINTS_TO_WIN) {
              gameWinner = Player.One;
              gameState = GameState.GameOver;
          } else if(playerTwoScore >= POINTS_TO_WIN) {
              gameWinner = Player.Two;
              gameState = GameState.GameOver;
          }
      }

      private void addScore(Player player) {
          if(player == Player.One) {
              playerOneScore++;
          } else if(player == Player.Two) {
              playerTwoScore++;
          }
      }
	  
	  private void checkWallBounce() {

	       if(ball.getxPosition() <= 0) {
	           // Hit left side of screen
	           ball.setxVelocity(-ball.getxVelocity());
	           addScore(Player.Two);
	           resetBall();
	       } else if(ball.getxPosition() >= getWidth() - ball.getWidth()) {
	           // Hit right side of screen
	           ball.setxVelocity(-ball.getxVelocity());
	           addScore(Player.One);
	           resetBall();
	       }
	       if(ball.getyPosition() <= 0 || ball.getyPosition() >= getHeight() - ball.getHeight()) {
	           // Hit top or bottom of screen
	           ball.setyVelocity(-ball.getyVelocity());
	       }
	       
	  }
	  
	  private void resetBall() {
		  ball.resetToInitialPosition();
	  }
	  
	  private void paintSprite(Graphics g, Sprite sprite) {
	      g.setColor(sprite.getColour());
	      g.fillRect(sprite.getxPosition(), sprite.getyPosition(), sprite.getWidth(), sprite.getHeight());
	  }
	  
	  
	  private void paintScores(Graphics g) {
          Font scoreFont = new Font(SCORE_FONT_FAMILY, Font.BOLD, SCORE_FONT_SIZE);
          String leftScore = Integer.toString(playerOneScore);
          String rightScore = Integer.toString(playerTwoScore);
          g.setFont(scoreFont);
          g.drawString(leftScore, SCORE_TEXT_X, SCORE_TEXT_Y);
          g.drawString(rightScore, getWidth()-SCORE_TEXT_X, SCORE_TEXT_Y);
 
     }

 
	  
	  // Method to paint dotted line on panel
	  
	  private void paintDottedLine(Graphics g) {
	      Graphics2D g2d = (Graphics2D) g.create();
	         Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
	         g2d.setStroke(dashed);
	         g2d.setPaint(Color.WHITE);
	         g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
	         g2d.dispose();

	 }
	  
	  private void paintWinner(Graphics g) {
          if(gameWinner != null) {
              Font winnerFont = new Font(WINNER_FONT_FAMILY, Font.BOLD, WINNER_FONT_SIZE);
             g.setFont(winnerFont);
             int xPosition = getWidth() / 2;
             if(gameWinner == Player.One) {
                 xPosition -= WINNER_TEXT_X;
             } else if(gameWinner == Player.Two) {
                 xPosition += WINNER_TEXT_X;
             }
             g.drawString(WINNER_TEXT, xPosition, WINNER_TEXT_Y);

         }

     }
	  
	  @Override
	  public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      paintDottedLine(g);
	      if(gameState != GameState.Initialising) {
	    	  paintSprite(g, ball);
	    	  paintSprite(g, paddleOne);
	    	  paintSprite(g, paddleTwo);
	    	  paintScores(g);
	    	  paintWinner(g);
	      }

	  }


	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_W) {
            paddleOne.setyVelocity(-1);
       } else if(event.getKeyCode() == KeyEvent.VK_S) {
            paddleOne.setyVelocity(1);
       }
		if(event.getKeyCode() == KeyEvent.VK_UP) {
            paddleTwo.setyVelocity(-1);
        } else if(event.getKeyCode() == KeyEvent.VK_DOWN) {
            paddleTwo.setyVelocity(1);
        }
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_W || event.getKeyCode() == KeyEvent.VK_S) {
            paddleOne.setyVelocity(0);
		}
		 if(event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_DOWN) {

             paddleTwo.setyVelocity(0);
		 }
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
		repaint(); // Call repaint to update graphics
		// TODO Auto-generated method stub
		
	}

}