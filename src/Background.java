/*
 * Jonathan Reynes & Nicolas Feraud
 * DUCK HUNT
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.Timer;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends JPanel implements ActionListener{
	
	public enum GameState {
	      INTRO, PLAY, END
	}
	private GameState currentState;  // the current GameState
	
	private static final int MIN_X = 38, MAX_X = 770, MIN_Y = 35, MAX_Y = 345, INC_AMOUNT = 35;
	private static int DELAY =300;
	private static int dx = INC_AMOUNT;
	private static int dy = INC_AMOUNT;
	
	protected Timer timer;
	private Random random= new Random();
	private int x1 = random.nextInt(MAX_X), y1 = random.nextInt(MAX_Y),
				x2 = random.nextInt(MAX_X),	y2 = random.nextInt(MAX_Y),
				x3 = random.nextInt(MAX_X), y3 = random.nextInt(MAX_Y);
	
	private BufferedImage background;
	private BufferedImage inflight,duck1, duck2;
	private BufferedImage bar10,bar9,bar8,bar7,bar6,bar5,bar4,bar3,bar2,bar1;		//full bar
	private BufferedImage ammo3,ammo2,ammo1,ammo0;
	private boolean wingsdown = true;
	public void actionPerformed(ActionEvent e)
	{	
		wingsdown = !wingsdown;
		inflight = wingsdown ? duck1: duck2;
		repaint();	
	}
	
	public Background(){
		try{
			background = ImageIO.read(getClass().getResource("/res/img/background.jpg"));	//800x500
			duck1 =ImageIO.read(getClass().getResource("/res/img/flyingduck.png")); 		//71x52
			duck2 =ImageIO.read(getClass().getResource("/res/img/flyingduck2.png")); 
			bar10 = ImageIO.read(getClass().getResource("/res/img/bar10.png"));
			ammo3 = ImageIO.read(getClass().getResource("/res/img/Ammo1.png"));
		
		}catch (IOException ex ){}
		
		timer = new Timer(DELAY,this);	//(delay,this);  timer is what will redraw
										//the images by time, 300 is intermediate
		timer.start();
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		
		//JButton[] bduck = new JButton[4];		//for 3 ducks
		
		super.paintComponent(g);
		
		//check boundaries
		if (x1 <  MIN_X)			dx = Math.abs(dx);
		if (x1 > MAX_X - MIN_X)		dx = -Math.abs(dx);
		if (y1 < MIN_Y )			dy = Math.abs(dy);
		if (y1 > MAX_Y - MIN_Y)		dy = -Math.abs(dy);
		
		//adjust bird position
		x1 += dx;
		y1 += dy;
		//check boundaries
		if (x2 <  MIN_X)			dx = Math.abs(dx);
		if (x2 > MAX_X - MIN_X)		dx = -Math.abs(dx);
		if (y2 < MIN_Y )			dy = Math.abs(dy);
		if (y2 > MAX_Y - MIN_Y)		dy = -Math.abs(dy);
		
		//adjust bird position
		x2 += dx;
		y2 += dy;
		//check boundaries
		if (x3 <  MIN_X)			dx = Math.abs(dx);
		if (x3 > MAX_X - MIN_X)		dx = -Math.abs(dx);
		if (y3 < MIN_Y )			dy = Math.abs(dy);
		if (y3 > MAX_Y - MIN_Y)		dy = -Math.abs(dy);
		
		//adjust bird position
		x3 += dx;
		y3 += dy;
		g.drawImage(background,0,0,null);
		g.drawImage(bar10, 305, 426, null);
		g.drawImage(ammo3, 25, 426, null);
		
		/*
		JButton bduck = new JButton((Icon) inflight);
		bduck.setOpaque(false);
		bduck.setContentAreaFilled(false);				//make the button invisible
		bduck.setBorderPainted(false);
		bduck.setFocusPainted(false);
		
        bduck.setBounds(x1-MIN_X, y1-MIN_Y,71,52);*/   //make moving jbuttons
		
		g.drawImage(inflight, x1-MIN_X, y1-MIN_Y, null);
		g.drawImage(inflight, x2-MIN_X, y2-MIN_Y, null);
		g.drawImage(inflight, x3-MIN_X, y3-MIN_Y, null);
	}
//___________________________________________________________________________
//							main											 |
//___________________________________________________________________________'

//variables used in main
public static JFrame frame;
public static BufferedImage intro;
public static void main (String [] args)
{
		frame = new JFrame( "Duck Hunt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
        final JPanel introPanel = new JPanel() {
        	@Override
            public void paintComponent(Graphics g){
        		super.paintComponent(g);
        		try{
        			intro = ImageIO.read(getClass().getResource("/res/img/Intro.png"));	//800x500
        		}catch (IOException ex ){}	
        		g.drawImage(intro,0,0,null);
            }
        };

		
		final MouseListener enterGame = new MouseListener() {	//extends mouseAdapter
			@Override
			public void mouseClicked(MouseEvent e){
				frame.remove(introPanel);
				Background bpanel = new Background();
			    frame.add(bpanel);
				frame.setSize(806, 529);
				frame.setVisible(true);
				frame.setResizable(false);		//doesn't allow user to resize frame
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			};
	        introPanel.addMouseListener(enterGame);
			frame.add(introPanel);
			frame.setSize(806, 529);
			frame.setVisible(true);
			frame.setResizable(false);		//doesn't allow user to resize frame

}

	
	
}


/*IMPLEMENT AS an anonymous class
 * public void mouseEntered(MouseEvent e)
{

java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
Image image = toolkit.getImage("D:/images/mousepoint.jpg");
Cursor a = toolkit.createCustomCursor(image , new Point(this.getX(),this.getY()), "");
this.setCursor (a);
}
*/


