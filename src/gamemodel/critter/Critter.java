package gamemodel.critter;
import javax.swing.*;

import gamemodel.tower.Tower;
import viewcontroller.DrawMap;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class defining the  parameters all  Critters shares.
 *  
 * It is also responsible for defining the the Critter movement pattern    
 * in order to reached the exist.Additional Responsibility is to determine the impact on
 * the Critter when it is shot by different tower    
 * 
 * 
 * This class implements CritterBehavior. 
 *  
 *@author yongpinggao
 *@since  
 */
public class Critter implements CritterBehavior{

    protected int moveSpeed;
    protected String imgURL;

    // current position
    protected int posX;
    protected int posY;

    protected int nextPosX;
    protected int nextPosY;

    protected boolean isVisible;
    protected boolean isSuccess;
    protected boolean isKilled;

    protected int health;
    protected int initHealth;
    protected int healthBar;
    protected double worth;

    protected boolean aleadyDonated;
    private ArrayList<Integer> pathList;
/**
 * A constructor to initial all the boolean parameters to false   
 */
    public Critter(){
        aleadyDonated = false;
        isKilled = false;
        isSuccess = false;
        isVisible = false;
        pathList = new ArrayList<>();
    }

    // The path of every critter


    // x, y -> current position
    /**
     * move the Critter to right 
     */
    private void moveRight(){
        posX += moveSpeed;
    }
    /**
     * move the Critter to bottom 
     */
    private void moveDown(){
        posY += moveSpeed;
    }
    /**
     * move the Critter to left 
     */
    private void moverLeft(){
        posX -= moveSpeed;
    }
/**
 * move the Critter to up 
 */
    private void moveUp(){
        posY -= moveSpeed;
    }
/**
 * get the life state of a critter
 * @return  the life state of a critter 
 */
    public boolean isKilled() {
        return isKilled;
    }
/**
 * set the life state of a critter
 * @param killed the life state of a Critter, true means died.
 */
    public void setKilled(boolean killed) {
        isKilled = killed;
    }
    /**
     * get the x coordinate of a Critter
     * @return the current x coordinate of a Critter
     */
    public int getPosX() {
        return posX;
    }
    /**
     * get the y coordinate of a Critter
     * @return the current y coordinate of a Critter
     */
    public int getPosY() {
        return posY;
    }
    /**
     * get the next  x coordinate of a Critter
     * @return the next x coordinate of a Critter
     */
    public int getNextPosX() {
        return nextPosX;
    }
/**
 * set the next  x coordinate of a Critter
 * @param nextPosX   the next x coordinate the critter will be on 
 */
    public void setNextPosX(int nextPosX) {
        this.nextPosX = nextPosX;
    }
    /**
     * get the next  y coordinate of a Critter
     * @return the next x coordinate of a Critter
     */
    public int getNextPosY() {
        return nextPosY;
    }

    /**
     * set the next  y coordinate of a Critter
     * @param nextPosY the next x coordinate the critter will be on 
     */
    public void setNextPosY(int nextPosY) {
        this.nextPosY = nextPosY;
    }
   /**
    * set the x coordinate of a Critter
    * @param posX  x coordinate of a Critter
    */
    public void setPosX(int posX) {
        this.posX = posX;
    }
    /**
     * set the     y coordinate of a Critter
     *@param posY  y coordinate of a Critter
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }
    /**
     * get the critter icon
     * @return the image of a Critter 
     */
    public Image getImage(){
        return new ImageIcon(imgURL).getImage();
    }
   /**
    * get the visibility state of a Critter 
    * @return the visibility state of a Critter 
    */
    public boolean isVisible() {
        return isVisible;
    }
/**
 *  set the visibility state of a Critter
 * @param visible visibility state of a Critter,true means is visible.  
 */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }
/**
 * get  the Critter success states
 * @return boolean value that check if the Critter reached the exist point
 */
    public boolean isSuccess() {
        return isSuccess;
    }
/**
 * set the Critter success states  
 * @param success check if the Critter reached the exist point, true means it reached the exist point.
 */
    public void setSuccess(boolean success) {
        isSuccess = success;
    }
/** 
 * get the dimension of the Critter icon
 * @return the dimension of the Critter icon
 */
    private Dimension getSize(){
        return new Dimension(new ImageIcon(imgURL).getIconWidth(), new ImageIcon(imgURL).getIconHeight());
    }
/**
 * get the bounder of the Critter icon
 * @return the Critter icon bounder.
 */
    public Rectangle getBound(){
        return new Rectangle(posX,posY, getSize().width, getSize().height);
    }

/**
 * get the Critter health
 * @return the critter health
 */
    public int getHealth() {
        return health;
    }
/**
 *  set the critter health
 * @param health    
 */
    public void setHealth(int health) {
        this.health = health;
    }
/**
 * get the amount of money the player get when the kill the critter.
 * @return the amount money the player get by killing the Critter.
 */
    public double getWorth() {
        return worth;
    }
/**
 * set the amount of money the player get when the kill the critter.
 * @param worth the amount money the player get by killing the Critter.
 */
    public void setWorth(double worth) {
        this.worth = worth;
    }
/**
 * set the critter path toward the exist point 
 * @param pathList  the path toward the exist point
 */
    public void setPathList(ArrayList<Integer> pathList) {

        this.pathList = pathList;
    }
/**
 *                                                                //what 
 * @return
 */
    public boolean isAleadyDonated() {
        return aleadyDonated;
    }
/**
 *                                                               //what 
 * @param aleadyDonated
 */
    public void setAleadyDonated(boolean aleadyDonated) {
        this.aleadyDonated = aleadyDonated;
    }
/**
 * get the next x&y coordinate for the critter  
 * @param x      the x coordinate of the Critter
 * @param y      the x coordinate of the Critter 
 * @param cols   the column starting from which the critter on,count start at 0.  
 * @return       the x&y coordinate or null if the critter reached the exist point
 */
    private int[] getDestination(int x, int y, int cols) {

        int index = DrawMap.coordinateConverter(x, y, cols);

        int iLeft = index - 1;
        int iRight = index + 1;
        int iDown = index + cols;
        int iUp = index - cols;
        // TODO when critter gone, it should stop

        if (pathList.contains(iLeft)) {
            index = iLeft;
        } else if (pathList.contains(iRight)) {
            index = iRight;
        } else if (pathList.contains(iDown)) {
           index = iDown;
        } else if (pathList.contains(iUp)) {
            index = iUp;
        } else {
            return null;
        }
        pathList.remove(new Integer(index)); 
        return DrawMap.indexConverter(index, cols);
    }

/**
 * moving the critter toward the exist point 
 * @param x    the x coordinate of the exist point
 * @param y    the y coordinate of the exist point
 * @param cols the column of the exist point 
 */
      private void moveToPosition(int x, int y, int cols) {

        int[] temp;
        if(posY > y){
            moveUp();
        } else if (posY < y){
            moveDown();
        } else if (posX > x){
            moverLeft();
        } else if (posX < x){
            moveRight();
        } else if (posX == x && posY == y){
            temp = getDestination(posX, posY, cols);                // why
            if(temp != null){ // path has been walked through
                nextPosX = temp[0];
                nextPosY = temp[1];
                moveToPosition(nextPosX, nextPosY, cols);
            } else {
                setVisible(false);
                setSuccess(true);
            }
        }

    }

    @Override
/**
 *move the critter 
 * @param cols  the number of  column                        // what
 */
    public void move(int cols) {
        moveToPosition(nextPosX, nextPosY, cols);
    }

/**
 * get the type of tower that hit the Critter
 * @param tower the type of tower that hit the critter
 */
    public void getHitBy(Tower tower){
        this.health = this.health - tower.getPower();
        if(this.health < 0){
            this.setVisible(false);
            this.setKilled(true);
            this.setSuccess(false);
        }
    }
 /**
  *  get the health status
  * @return  the health status 
  */
    public float getHealthBar() {
        if(health > 0)  return (float)getHealth() / initHealth;
        else            return 0;
    }
/**
 * get the HealthBar of a Critter 
 * @param healthBar the health status represented by int range between 0to100
 */
    public void setHealthBar(int healthBar) {
        if(healthBar >= 0)
        this.healthBar = healthBar;
    }
}


