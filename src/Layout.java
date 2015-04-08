import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Layout extends JPanel
{
	

public static void main(String[] args)
{
	 //name and close your frame
    JFrame frame = new JFrame( "Duck Hunt" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    Layout theSky = new Layout();				//JPanel
    frame.add(theSky);			
    frame.setSize(801, 501);			 // initialize the Jframe's height and width
    frame.setVisible(true);			 // show the triangle
}
}

/*
public class Sky extends JPanel {
// Declarations 
	private JPanel  ;			// sky is in ground
	
	
	sky = new JPanel();
	
	
	 public static void main(String[] args)
	 {
		 //name and close your frame
	     JFrame frame = new JFrame( "Duck Hunt" );
	     frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	     Sky theSky = new Sky();				//JPanel
	     frame.add(theSky);			
	     frame.setSize(801, 501);			 // initialize the Jframe's height and width
	     frame.setVisible(true);			 // show the triangle
	 }
	
	
	

}*/
