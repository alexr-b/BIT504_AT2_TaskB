import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class PongPanel extends JPanel implements ActionListener, KeyListener{
	
	 private final static Color BACKGROUND_COLOUR = Color.BLACK;
	 private final static int TIMER_DELAY = 5;
	
	  public PongPanel() {
          setBackground(BACKGROUND_COLOUR);
          Timer timer = new Timer(TIMER_DELAY, this);
          timer.start();

      }
	  
	  private void update() {
	  }


	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
		// TODO Auto-generated method stub
		
	}

}