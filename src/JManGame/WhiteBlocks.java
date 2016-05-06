package JManGame;

import java.awt.Color;

public class WhiteBlocks extends Piece {
	
	/** Constructor: a new Block at position (x, y) on Map m
    with color red if c = 0, green if c = 1, and yellow if c = 2. */
	public WhiteBlocks(int x, int y, Map m){
		super(Piece.BLOCK, m);
		super.setX( x );
		super.setY( y );
		super.setColor( Color.WHITE );
	}

	/** no need to act */
	public void act(){
	}
	
    /** = representation of this piece */
    public String toString() {
        return getColorWord() + " WhiteBlock at (" + getX() + ", " + getY() + ")";
    }
}
