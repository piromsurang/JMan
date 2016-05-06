package JManGame;

import java.awt.Color;

public class Walkers extends Piece {
	/** Constructor: a new Walker at position (x, y) on Map m
    with color red if c = 0, green if c = 1, and yellow if c = 2. */
	public Walkers(int x, int y, int c, Map m){
		super(Piece.WALKER, m);
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

	/** Constructor: a new Walker at position (x, y) on Map m
    with color c. Precondition: c is one of
    Color.RED, Color.GREEN, and Color.YELLOW.*/
	public Walkers(int x, int y, Color c, Map m){
		super(Piece.WALKER, m);
		super.setX( x );
		super.setY( y );
		super.setColor( c );
	}

	/** change position randomly  */
	public void act(){
		int random = Piece.rand( 0, 2 );
		int rand = Piece.rand( 0, 4 );

		if ( random == 1 ) {
			if ( rand == 0 && this.getMap().isEmpty( this.getX() + 1, this.getY() ) && this.map.isInGrid( this.getX() + 1, this.getY() ) ) {
				this.map.move( this.getX(), this.getY(), this.getX() + 1, this.getY() );
			}
			else if ( rand == 1 && this.getMap().isEmpty( this.getX() - 1, this.getY() ) && this.map.isInGrid( this.getX() - 1, this.getY() ) ) {
				this.map.move( this.getX(), this.getY(), this.getX() - 1, this.getY() );
			}
			else if ( rand == 2 && this.getMap().isEmpty( this.getX(), this.getY() + 1 ) && this.map.isInGrid( this.getX(), this.getY() + 1 ) ) {
				this.map.move( this.getX(), this.getY(), this.getX(), this.getY() + 1 );
			}
			else if ( rand == 3 && this.getMap().isEmpty( this.getX(), this.getY() - 1 ) && this.map.isInGrid( this.getX(), this.getY() - 1 ) ) {
				this.map.move( this.getX(), this.getY(), this.getX(), this.getY() - 1 );
			}
		}
	}

	/** = representation of this piece */
	public String toString() {
		return getColorWord() + " Walker at (" + getX() + ", " + getY() + ")";
	}
}
