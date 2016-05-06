package JManGame;

import java.awt.Color;

public class Pillars extends Piece {

	/** Constructor: a new Pillar at position (x, y) on Map m
    with color red if c = 0, green if c = 1, and yellow if c = 2. */
	public Pillars(int x, int y, int c, Map m){
		super(Piece.PILLAR, m);
		super.setX( x );
		super.setY( y );
		if ( c == 0 ) {
			super.setColor( Color.RED );
		}
		else if ( c == 1 ) {
			super.setColor( Color.GREEN );
		}
		else if ( c == 2 ) {
			super.setColor( Color.YELLOW );
		}
	}

	/** Constructor: a new Pillar at position (x, y) on Map m
    with color c. Precondition: c is one of
    Color.RED, Color.GREEN, and Color.YELLOW.*/
	public Pillars(int x, int y, Color c, Map m){
		super(Piece.PILLAR, m);
		super.setX( x );
		super.setY( y );
		super.setColor( c );
	}

	/** change color continuously */
	public void act(){
		int rand = Piece.rand( 0, 3 );
		
		if ( rand == 3 ) {
			super.setColor( Piece.rand( 0, 2 ) ); 
		}
	}

	/** = representation of this piece */
	public String toString() {
		return getColorWord() + " Pillar at (" + getX() + ", " + getY() + ")";
	}
}
