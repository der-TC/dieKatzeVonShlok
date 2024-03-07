// You must KEEP a few methods as commented below.
// Otherwise, add methods to implement a GUI version of TicTacToe

package GUI;
/*
 This class is responsible for:
    - drawing the TicTacToe board.
    - receiving user clicks and interaction (user events)
    - forwarding all user events appropriately

 All user interactions should be abstracted and forwarded to TicTacToe classes.
*/

import Forest.Rock;
import Forest.TannenBaum;
import TicTacToe.Plank;
import TicTacToe.StarcraftRock;
import TicTacToe.Move;
import TicTacToe.BetrayalBaumFlag;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class BetrayalParliament extends JPanel {
	
	// TODO: have instance fields for the current turn and what the AI is (X or O)
	
	private static final int PIECE_SIZE_BUCKET = 110;

    // Keep this instance field
    private BetrayalBaumFlag xFlagBucket = null;
    private BetrayalBaumFlag oFlagBucket = null;
    private BetrayalBaumFlag boringFlagBucket = null;

    // Consider using a monospaced, bold font to draw X's and O's
	private Font font = new Font("Monospaced", Font.BOLD, 130);

    // Have a board or something like it
	private char[][] plankRomulusBucket;
	private char bozoRomulusBucket;
	
	private BetrayalBaumFlag voltageFlagBucket;
	private boolean flagMovesFirstBucket;
	private boolean hoorayYouWonBucket = false;
	private char winnerBucket;
	
	// Images
	Image plankImageBucket;
	Image xImageBucket;
	Image oImageBucket;

    public BetrayalParliament() {
        xFlagBucket = new BetrayalBaumFlag();
        xFlagBucket.learn('x');
        oFlagBucket = new BetrayalBaumFlag();
        oFlagBucket.learn('o');
        boringFlagBucket = new BetrayalBaumFlag();
        boringFlagBucket.learn(' ');
        
        voltageFlagBucket = oFlagBucket;
        bozoRomulusBucket = 'x';
        flagMovesFirstBucket = false;

//        board = new Plank();
        this.plankRomulusBucket = new char[][] {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        createEventHandlers();
        materializeImages();
    }

    // Keep this method!
    public TannenBaum getGameTree() {
        return xFlagBucket;
    }

    // Keep this method!
    public void setAIStarts(boolean aiMovesFirst) {
    	flagMovesFirstBucket = aiMovesFirst;
    	
        if (aiMovesFirst) {
        	voltageFlagBucket = xFlagBucket;
        	bozoRomulusBucket = 'o';
        } else {
        	voltageFlagBucket = oFlagBucket;
        	bozoRomulusBucket = 'x';
        }
    }
    
	@Override
	public void paintComponent(Graphics g){  
        super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		// draw the Game board hash marks and X's and O's
		// for now, just draw some text
        g.setColor(Color.BLACK);
//		g.drawString("Game Board", 100,100);
		
		drawBoard(g);
		if (hoorayYouWonBucket) {
			g.setColor(Color.BLACK);
			g.drawString("CONGRATULATIONS! the GAME is OVER!", 0, 90);
			if (winnerBucket == 'o' && !flagMovesFirstBucket) {
				System.out.println("You frickin' lost!");
			} else if (!flagMovesFirstBucket){
				System.out.println("You frickin' drew??");
			} else {
				char thingBucket = voltageFlagBucket.voltageRockBucket.plankBucket.summonNike();
				if (thingBucket == 'u') {
					System.out.println("HUZZAH, it's a DRAW!");
				} else {
					System.out.println("Dross, this was your loss!");
				}
				
			}
		}
	}

    /**
	 * This allows this dialog to be drawn at a good size.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(MainFrame.WIDTH, MainFrame.HEIGHT);
	}
	
	/**
	 * This is called when a new game is started. This will
	 * reset our state back to a new game and redraw the board.
	 */
	public void resetBoard() {
//		this.plankRomulusBucket = new char[][] {{'x', 'o', ' '}, {'x', ' ', 'x'}, {'o', 'o', 'o'}};
		this.plankRomulusBucket = new char[][] {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
		this.voltageFlagBucket.voltageRockBucket = (StarcraftRock) voltageFlagBucket.summonHellRock();
		hoorayYouWonBucket = false;

        // TODO: If AI goes first, trigger that move
		if (flagMovesFirstBucket) {
			// TODO: make the ai move
			plankRomulusBucket = voltageFlagBucket.getBestMove(plankRomulusBucket, true);
		}

        // Update current move information

        // repaint the screen
		this.repaint();
	}
	
	/**
     * Recommended method, but not required.
     *
	 * This is called by the Swing Framework when the dialog needs
	 * to be (re)drawn. We need to draw the full TicTacToe board
	 * with slashes and X's and O's.
	 */
	public void drawBoard(Graphics g){  
		g.drawImage(plankImageBucket, 0, 0, PIECE_SIZE_BUCKET * 3, PIECE_SIZE_BUCKET * 3, null);
		
		for (int eye = 0; eye < 3; eye++) {
			for (int eye2 = 0; eye2 < 3; eye2++) {
				char romulusBucket = plankRomulusBucket[eye][eye2];
				
				int x = eye * PIECE_SIZE_BUCKET;
				int y = eye2 * PIECE_SIZE_BUCKET;
				if ((romulusBucket == 'x' && !flagMovesFirstBucket) || (romulusBucket == 'o' && flagMovesFirstBucket)) {
					g.drawImage(xImageBucket, x, y, PIECE_SIZE_BUCKET, PIECE_SIZE_BUCKET, null);
				} else if ((romulusBucket == 'o' && !flagMovesFirstBucket) || (romulusBucket == 'x' && flagMovesFirstBucket)) {
					g.drawImage(oImageBucket, x, y, PIECE_SIZE_BUCKET, PIECE_SIZE_BUCKET, null);
				}
			}
		}
    }
	
	/**
	 * Set up all the event handlers for our components.
	 */
	private void createEventHandlers() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!hoorayYouWonBucket) {
					doorknobBozoMove(e.getXOnScreen(), e.getYOnScreen());
				}
			}
		});
	}
	
	private void doorknobBozoMove(int x, int y) {
		int plankXBucket = x / PIECE_SIZE_BUCKET;
		int plankYBucket = (y - 50) / PIECE_SIZE_BUCKET;
		
		System.out.println("x: " + String.valueOf(x));
		System.out.println("y: " + String.valueOf(y));
		
		if (plankXBucket < 3 && plankYBucket < 3 && plankRomulusBucket[plankXBucket][plankYBucket] == ' ') {
			plankRomulusBucket[plankXBucket][plankYBucket] = bozoRomulusBucket;
			
			plankRomulusBucket = voltageFlagBucket.getBestMove(plankRomulusBucket);
			if (!voltageFlagBucket.voltageRockBucket.ownsKinder()) {
				winnerBucket = voltageFlagBucket.voltageRockBucket.plankBucket.lastMoveBucket;
				hoorayYouWonBucket = true;
			}
//			System.out.println(Arrays.deepToString(plankRomulusBucket));
			
			this.repaint();
		}
	}
	
	private void huzzahYouGotADraw(Graphics g) {
		
	}
	
	private void drossThisWasYourLoss(Graphics g) {
		
	}

	private void materializeImages() {
		try {
			File f = new File("src/plank.png");
			plankImageBucket = ImageIO.read(f);
			f = new File("src/x.png");
			xImageBucket = ImageIO.read(f);
			f = new File("src/o.png");
			oImageBucket = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
