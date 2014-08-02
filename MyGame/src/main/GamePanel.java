package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 6644375181764124582L;
	
	int xpos = 304;
	int ypos = 224;
	int size1 = 16;
	
	int xppos = 320;
	int yppos = 224;
	int size2 = 16;
	
	private Image player1;
	private Image player2;
	
	 @Override
     public Dimension getPreferredSize() {
         return new Dimension(640, 480);
     }
	
	public GamePanel() {
		
		setFocusable(true);
		requestFocus();
		
		loadImages();
		
		repaint();
		
	}
	
	public void loadImages() {
		
		try {
			player1 = ImageIO.read(getClass().getResource("/player1.jpg"));
			player2 = ImageIO.read(getClass().getResource("/player2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				int code = e.getKeyCode();
				
				int speed = 16;
				
				if (code == KeyEvent.VK_ESCAPE) {
					
					System.exit(0);
					
				}
				
				if (code == KeyEvent.VK_RIGHT) {
					
					xpos += speed;
					repaint();
					
				}
				
				if (code == KeyEvent.VK_D) {
					
					xppos += speed;
					repaint();
					
				}
				
				if (code == KeyEvent.VK_LEFT) {
					
					xpos -= speed;
					repaint();
					
				}
				
				if (code == KeyEvent.VK_A) {
					
					xppos -= speed;
					repaint();
					
				}
				
				if (code == KeyEvent.VK_UP) {
					
					ypos -= speed;
					repaint();
					
				}
				
				if (code == KeyEvent.VK_W) {
					
					yppos -= speed;
					repaint();
					
				}
				
				if (code == KeyEvent.VK_DOWN) {
					
					ypos += speed;
					repaint();
				}
				
				if (code == KeyEvent.VK_S) {
					
					yppos += speed;
					repaint();
					
				}
				
				if (code == KeyEvent.VK_PERIOD) {
					
					if (size1 <= 0) {
						
						size1 = 16;
						repaint();
					}
					else {
						
						size1 *= 3;
						
					}
					
				}
				
				if (code == KeyEvent.VK_COMMA) {
					
					if (size1 <= 0) {
						
						size1 = 0;
						repaint();
						
					}
					else if (size1 == 16) {
						
						size1 = size1 - 16;	
						
					}
					else {
						
						size1 /= 3;
						
					}
					
				}
				
				if (code == KeyEvent.VK_E) {
					
					if (size2 <= 0) {
						
						size2 = 16;
						repaint();
					}
					else {
						
						size2 *= 3;
						
					}
					
				}
				
				if (code == KeyEvent.VK_Q) {
					
					if (size2 <= 0) {
						
						size2 = 0;
						repaint();
						
					}
					else if (size2 == 16) {
						
						size2 = size2 - 16;	
						
					}
					else {
						
						size2 /= 3;
						
					}
				}
				
				repaint();
				
			}
			
		} );
		
	}
	
    @Override
    protected void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        
        Graphics g1 = (Graphics) g;
        Graphics g2 = (Graphics) g;
        
        g1.drawImage(player1, xpos, ypos, size1, size1, this);
        g2.drawImage(player2, xppos, yppos, size2, size2, this);
        
        if (xpos < 0) {
        	
        	xpos = 0;
        	repaint();
        	
        }
        
        if (xppos < 0) {
        	
        	xppos = 0;
        	repaint();
        	
        }
        
        if (xpos > 39 * 16) {
        	
        	xpos = 39 * 16;
        	repaint();
        	
        }
        
        if (xppos > 39 * 16) {
        	
        	xppos = 39 * 16;
        	repaint();
        	
        }
        
        if (ypos < 0) {
        	
        	ypos = 0;
        	repaint();
        	
        }
        
        if (yppos < 0) {
        	
        	yppos = 0;
        	repaint();
        	
        }
        
        if (ypos > 29 * 16) {
        	
        	ypos = 29 * 16;
        	repaint();
        	
        }
        
        if (yppos > 29 * 16) {
        	
        	yppos = 29 * 16;
        	repaint();
        	
        }
        
    }
	
}














