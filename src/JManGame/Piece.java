package JManGame;

import java.awt.*;

/** An instance is a piece for use in the J*Man!! assignment 2.*/
public abstract class Piece{
    /** Constants that identify the kind of a piece. */
    public static final int BLOCK= 0;  // piece is a block
    public static final int JMAN= 1;   // piece is the J*man
    public static final int WALKER= 2; // piece is a walker
    public static final int PILLAR= 3; // piece is a pillar
    
    
    public int type;
    public Map map;
    public Color color;
    public String colorInString;
    public int positionx;
    public int positiony;
    public boolean acted;
    /** Constructor: a Piece on Map m with type t.
        Precondition: type is one of the four constants of this class. */
    public Piece(int t, Map m){
    	this.type = t;
    	this.map = m;
    	color = null;
    	colorInString = null;
    	positionx = 0;
    	positiony = 0;
    	this.acted = false;
    }
    
    /** = this piece's type: (one of the four constants of this class. */
    public int getType(){
        return this.type;
    }
    
    /** = this piece's x location. */
    public int getX(){
        return this.positionx;
    }
    
    /** = this piece's y location. */
    public int getY(){
        return this.positiony;
    }
    
    /** = this piece's color. */
    public Color getColor(){
        return this.color;
    }
    
    /** = the color of this piece, as a capitalized word (e.g. "Red").
        = the empty string if it is not one of red, green, yellow, or white*/
    public String getColorWord() {
        if ( color == Color.RED ) {
        	this.colorInString = "Red";
        }
        else if ( color == Color.GREEN ) {
        	this.colorInString = "Green";
        }
        else if ( color == Color.YELLOW ) {
        	this.colorInString = "Yellow";
        }
        else if ( color == Color.WHITE ) {
        	this.colorInString = "White";
        }
        else {
        	this.colorInString = null;
        }
        return this.colorInString;
    }
    
    /** = "This piece has already acted this round". */
    public boolean hasActed(){
        return this.acted;
    }
    
    /** = the map this piece is on. */
    public Map getMap(){
        return this.map;
    }
    
    /** Set this piece's x location to x. */
    public void setX(int x){
        this.positionx = x;
    }
    
    /** Set this piece's y location to y. */
    public void setY(int y){
        this.positiony = y;
    }
    
    /** Set this piece's color to the c.
        Precondition: c is Color.WHITE and this is a block,OR
        c is Color.RED, Color.GREEN, or Color.YELLOW. */
    public void setColor(Color c){
        this.color = c;
    }
    
    /**
     * set this piece's color to the color base on number input
     * @param i input that will identify color
     */
    public void setColor( int i ) {
    	if ( i == 0 ) {
    		this.color = Color.RED;
    		this.colorInString = "Red";
    	}
    	else if ( i == 1 ) {
    		this.color = Color.GREEN;
    		this.colorInString = "Green";
    	}
    	else {
    		this.color = color.YELLOW;
    		this.colorInString = "Yellow";
    	}
    }
    
    /** Set the state of this piece to the value of acted.*/
    public void setActed(boolean acted){
        this.acted = acted;
    }
    
    /** Make this piece take one action. What a piece does on
        its action is defined in the assignment. */
    public abstract void act();
    
    /** = a random integer in the range lo..hi, with all integers in
          the range being equally likely. 
          Precondition lo < hi. */
    public static int rand(int lo, int hi){
        return (int)(Math.random()*(hi-lo+1))+lo;
    }
    
}