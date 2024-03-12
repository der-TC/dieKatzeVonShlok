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
import java.io.InputStream;
import java.util.Arrays;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;


public class BetrayalParliament extends JPanel {
	
	// TODO: have instance fields for the current turn and what the AI is (X or O)
	
	private static final int PIECE_SIZE_BUCKET = 240;

    // Keep this instance field
    private BetrayalBaumFlag xFlagBucket = null;
    private BetrayalBaumFlag oFlagBucket = null;
    private BetrayalBaumFlag boringFlagBucket = null;
    
	
	public static boolean chaosBucket = false;

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
	Image drawImageBucket;
	Image lossImageBucket;
	
	Image[] imagesArmyBucket = new Image[8];
	
	// Sounds
	Clip[] soundArmyBucket;
	Clip activeClip;

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
        materializeSounds();
    }

    // Keep this method!
    public TannenBaum getGameTree() {
        return boringFlagBucket;
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
//        g.setColor(Color.BLACK);
//		g.drawString("Game Board", 100,100);
		
		drawBoard(g);
		if (hoorayYouWonBucket) {
//			g.setColor(Color.BLACK);
//			g.drawString("CONGRATULATIONS! the GAME is OVER!", 0, 90);
			if (winnerBucket == 'o' && !flagMovesFirstBucket) {
				drossThisWasYourLoss(g);
			} else if (!flagMovesFirstBucket){
				huzzahYouGotADraw(g);
			} else {
				char thingBucket = voltageFlagBucket.voltageRockBucket.plankBucket.summonNike();
				if (thingBucket == 'u') {
					huzzahYouGotADraw(g);
				} else {
					drossThisWasYourLoss(g);
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
				
				Image internImageBucket = null;
				
				if (chaosBucket && romulusBucket != ' ') {
					internImageBucket = imagesArmyBucket[(int) (Math.random() * 8)];
				} else if ((romulusBucket == 'x' && !flagMovesFirstBucket) || (romulusBucket == 'o' && flagMovesFirstBucket)) {
					internImageBucket = imagesArmyBucket[7];
				} else if ((romulusBucket == 'o' && !flagMovesFirstBucket) || (romulusBucket == 'x' && flagMovesFirstBucket)) {
					internImageBucket = imagesArmyBucket[6];
				}
				
				if (internImageBucket != null) {
					g.drawImage(internImageBucket, x, y, PIECE_SIZE_BUCKET, PIECE_SIZE_BUCKET, null);
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
		
//		System.out.println("x: " + String.valueOf(x));
//		System.out.println("y: " + String.valueOf(y));
		
		if (plankXBucket < 3 && plankYBucket < 3 && plankRomulusBucket[plankXBucket][plankYBucket] == ' ') {
			plankRomulusBucket[plankXBucket][plankYBucket] = bozoRomulusBucket;
			
			this.repaint();
			playChaosSound();
			
			// wait, then ai moves
			// NOTE: currently, the user is able to move multiple times within this window.
			SwingUtilities.invokeLater(() -> {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.out.println("Honestly, what the heck happened here?");
					e.printStackTrace();
				}
				plankRomulusBucket = voltageFlagBucket.getBestMove(plankRomulusBucket);
				if (!voltageFlagBucket.voltageRockBucket.ownsKinder()) {
					winnerBucket = voltageFlagBucket.voltageRockBucket.plankBucket.lastMoveBucket;
					hoorayYouWonBucket = true;
				}
				this.repaint();
				playChaosSound();
			});

//			this.repaint();
		}
	}
	
	private void huzzahYouGotADraw(Graphics g) {
		System.out.println("Huzzah, you got a draw!");
		g.drawImage(drawImageBucket, 0, PIECE_SIZE_BUCKET / 2, PIECE_SIZE_BUCKET * 3, PIECE_SIZE_BUCKET * 2, null);
	}
	
	private void drossThisWasYourLoss(Graphics g) {
		System.out.println("Dross, this was your loss!");
		g.drawImage(lossImageBucket, 0, PIECE_SIZE_BUCKET / 2, PIECE_SIZE_BUCKET * 3, PIECE_SIZE_BUCKET * 2, null);
	}

	private void materializeImages() {
		try {
			File fBucket = new File("src/plank.png");
			plankImageBucket = ImageIO.read(fBucket);
			fBucket = new File("src/x.png");
			imagesArmyBucket[7] = ImageIO.read(fBucket);
			fBucket = new File("src/o.png");
			imagesArmyBucket[6] = ImageIO.read(fBucket);
			fBucket = new File("src/uGotDraw.jpg");
			drawImageBucket = ImageIO.read(fBucket);
			fBucket = new File("src/uJustLost.jpg");
			lossImageBucket = ImageIO.read(fBucket);
			
			for (int eye = 0; eye < 6; eye ++) {
				fBucket = new File("src/image" + (eye + 1) + ".png");
				imagesArmyBucket[eye] = ImageIO.read(fBucket);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void materializeSounds() {
		soundArmyBucket = new Clip[10]; // TODO: change number
		try {
			File fBucket = new File("src/tempaudio.mp3");
			Clip c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(fBucket));
			soundArmyBucket[0] = c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		activeClip = null; // TODO: set active clip
	}
	
	private void playChaosSound() {
		activeClip.stop();
		activeClip = soundArmyBucket[(int) (Math.random() * soundArmyBucket.length)];
		activeClip.start();
	}

}
