package JManGame;

import java.awt.*;

/** An instance of this class is a J*Man.
 There should at most one J*Man in a game board at a time*/
public class JMan extends Piece {
    
    /** Constructor: a new J*Man at position (x, y) on Map m
     with color red if c = 0, green if c = 1, and yellow if c = 2. */
    public JMan(int x, int y, int c, Map m){
        super(Piece.JMAN, m);
        super.setX( x );
        super.setY( y );
        if ( c == 0 ) {
        	super.setColor( Color.RED );
        }
        else if ( c == 1 ) {
        	super.setColor( Color.GREEN );
        }
        else {
        	super.setColor( Color.YELLOW );
        }
    }
    
    /** Constructor: a new J*Man at position (x, y) on Map m
     with color c. Precondition: c is one of
     Color.RED, Color.GREEN, and Color.YELLOW.*/
    public JMan(int x, int y, Color c, Map m){
        super(Piece.JMAN, m);
        super.setX( x );
        super.setY( y );
        super.setColor( c );
    }
    
    /** J*Man should move based on what button is pushed.
     This method is not used. */
    public void act(){
        return;
    }
    
    /** Move J*Man one step based on the value of i:
        0 = up, 1 = down, 2 = left, 3 = right. */
    public void step(int i){
        setActed( true );
        
        if ( i == 0 && this.map.isInGrid( this.getX(), this.getY() - 1 ) && capture( this.map.pieceAt( this.getX(), this.getY() - 1 ) ) ) {
        	this.getMap().move( this.getX(), this.getY(), this.getX(), this.getY() - 1 );
        }
        else if ( i == 1 && this.map.isInGrid( this.getX(), this.getY() + 1 ) && capture( this.map.pieceAt( this.getX(), this.getY() + 1 ) ) ) {
        	this.getMap().move( this.getX(), this.getY(), this.getX(), this.getY() + 1 );
        }
        else if ( i == 2 && this.map.isInGrid( this.getX() - 1, this.getY() ) && capture( this.map.pieceAt( this.getX() + 1, this.getY() ) ) ) {
        	this.getMap().move( this.getX(), this.getY(), this.getX() - 1, this.getY() );
        }
        else if ( i == 3 && this.map.isInGrid( this.getX() + 1, this.getY() ) && capture( this.map.pieceAt( this.getX() - 1, this.getY() ) ) ) {
        	this.getMap().move( this.getX(), this.getY(), this.getX() + 1, this.getY() );
        }
    }
    
    /** = representation of this piece */
    public String toString() {
        String color= "";
        return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
    }
    
    public boolean capture( Piece piece ) {
    	boolean check = !( piece instanceof WhiteBlocks );
    	boolean checkMoveable = true;
    	if ( check && ( piece instanceof Walkers ) ) {
    		if ( piece.getColor() == Color.GREEN && this.getColor() == Color.YELLOW ) {
    			this.setColor( Color.GREEN );
    		}
    		else if ( piece.getColor() == Color.YELLOW && this.getColor() == Color.RED ) {
    			this.setColor( Color.YELLOW );
    		}
    		else if ( piece.getColor() == Color.RED && this.getColor() == Color.GREEN ) {
    			this.setColor( Color.RED );
    		}
    		else {
    			checkMoveable = false;
    		}
    	}
    	else if ( check && piece instanceof Pillars ) {
    		if ( piece.getColor() == Color.GREEN ) {
    			this.setColor( Color.GREEN );
    		}
    		else if ( piece.getColor() == Color.YELLOW ) {
    			this.setColor( Color.YELLOW );
    		}
    		else if ( piece.getColor() == Color.RED ) {
    			this.setColor( Color.RED );
    		}
    	}
    	
    	return check && checkMoveable;
    }
}