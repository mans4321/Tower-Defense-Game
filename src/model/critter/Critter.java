package model.critter;

import model.imagecollection.CritterImageCollection;
import model.map.GameMap;
import model.drawing.GameMapDrawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Critter Base class
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public class Critter implements ActionListener{
    protected CritterName critterName;
    protected int currentHealth;
    protected int maxHealth;
    protected double worth;
    protected int currentMoveSpeed;
    protected int initialMoveSpeed;
    protected boolean isVisible;
    protected boolean isKilled;
    protected boolean isSucceed;

    protected Timer movingTimer;
    protected Timer innerTimer;
    protected int continuesDamage;

    // current position
    protected int currentPosX;
    protected int currentPosY;

    private int nextIndex;
    private int cols;
    private ArrayList<Integer> pathList;
    private int entranceIndex;
    private int exitIndex;

    /**
     * set the gamemap for a critter
     * @param gameMap
     */
    public void setGameMap(GameMap gameMap) {
        pathList = gameMap.findPathList();
        cols = gameMap.getmCols();
        entranceIndex = gameMap.findEntranceIndex();
        exitIndex = gameMap.findExitIndex();
        int[] currentPosition = GameMapDrawing.indexToCoordinateConverter(entranceIndex, cols);
        currentPosX = currentPosition[0];
        currentPosY = currentPosition[1];
        nextIndex = entranceIndex;
    }

    /**
     * check if critter is killed 
     * getter method
     * @return
     */
    public boolean isKilled() {
        return isKilled;
    }

    /**
     * check if critter is killed 
     * setter method
     * @param killed
     */
    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    /**
     * critter worth after it is killed
     * getter method 
     * @return
     */
    public double getWorth() {
        return worth;
    }

    /**
     * critter worth after it is killed
     * setter method 
     * @return
     */
    public void setWorth(double worth) {
        this.worth = worth;
    }

    /**
     * a critter's path cell index
     * getter method
     * @return
     */
    public ArrayList<Integer> getPathList() {
        return pathList;
    }

    /**
     * a critter's path cell index
     * setter method
     * @return
     */
    public void setPathList(ArrayList<Integer> pathList) {
        this.pathList = pathList;
    }

    /**
     * check if critter has stole the coins successfully
     * getter method
     * @return
     */
    public boolean isSucceed() {
        return isSucceed;
    }

    /**
     * check if critter has stole the coins successfully
     * setter method
     * @return
     */
    public void setSucceed(boolean succeed) {
        isSucceed = succeed;
    }
    
    /**
     * special effect timer for a critter
     * getter method
     * @return
     */
    public Timer getMovingTimer() {
        return movingTimer;
    }

    /**
     * special effect: moving speed affected timer for a critter 
     * setter method
     * @return
     */
    public void setMovingTimer(Timer movingTimer) {
        this.movingTimer = movingTimer;
    }

    /**
     * special effect: poison affected timer for a critter
     * getter method
     * @return
     */
    public Timer getInnerTimer() {
        return innerTimer;
    }

    /**
     * continues damage for a critter
     * getter method
     * @return
     */
    public int getContinuesDamage() {
        return continuesDamage;
    }

    /**
     * continues damage for a critter
     * setter method
     * @return
     */
    public void setContinuesDamage(int continuesDamage) {
        this.continuesDamage = continuesDamage;
    }

    /**
     * special effect: poison affected timer for a critter
     * setter method
     * @return
     */
    public void setInnerTimer(Timer innerTimer) {
        this.innerTimer = innerTimer;
    }

    /**
     * initial move speed for a critter
     * getter method
     * @return
     */
    public int getInitialMoveSpeed() {
        return initialMoveSpeed;
    }

    /**
     * initial move speed for a critter
     * setter method
     * @return
     */
    public void setInitialMoveSpeed(int initialMoveSpeed) {
        this.initialMoveSpeed = initialMoveSpeed;
    }

    /**
     * get bounds for the crriter for collision detection
     * getter method
     * @return
     */
    public Rectangle getBound(){
        Dimension dimension = CritterImageCollection.getCritterImageSizeOf(critterName);
        return new Rectangle(currentPosX, currentPosY, dimension.width, dimension.height);
    }
    
    /**
     * get a hearth bar length for drawing health bar for critter
     * @return
     */
    public float getHealthBarLength() {
        return (float)(currentHealth) / maxHealth;
    }

    /**
     * moving speed for a critter
     * getter method
     * @return
     */
    public int getCurrentMoveSpeed() {
        return currentMoveSpeed;
    }
    
    /**
     * moving speed for a critter
     * setter method
     * @return
     */
    public void setCurrentMoveSpeed(int currentMoveSpeed) {
        this.currentMoveSpeed = currentMoveSpeed;
    }

    /**
     * critter type
     * getter method
     * @return
     */
    public CritterName getCritterName() {
        return critterName;
    }

    /**
     * critter type
     * setter method
     * @return
     */
    public void setCritterName(CritterName critterName) {
        this.critterName = critterName;
    }

    /**
     * check if critter is visible for game drawing
     * getter method
     * @return
     */
    public boolean isVisible() {
        return isVisible;
    }
    
    /**
     * check if critter is visible for game drawing
     * setter method
     * @return
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    /**
     * move method for critters
     * move right
     */
    private void moveRight() {
        currentPosX += currentMoveSpeed;
    }

    /**
     * move method for critters
     * move down
     */
    private void moveDown() {
        currentPosY += currentMoveSpeed;
    }

    /**
     * move method for critters
     * move left
     */
    private void moverLeft() {
        currentPosX -= currentMoveSpeed;
    }

    /**
     * move method for critters
     * move up
     */
    private void moveUp() {
        currentPosY -= currentMoveSpeed;
    }

    /**
     * position of a critter: x 
     * getter method
     * @return
     */
    public int getCurrentPosX() {
        return currentPosX;
    }

    /**
     * position of a critter: x 
     * setter method
     * @return
     */
    public void setCurrentPosX(int currentPosX) {
        this.currentPosX = currentPosX;
    }

    /**
     * position of a critter: y
     * getter method
     * @return
     */
    public int getCurrentPosY() {
        return currentPosY;
    }

    /**
     * position of a critter: y
     * setter method
     * @return
     */
    public void setCurrentPosY(int currentPosY) {
        this.currentPosY = currentPosY;
    }

    /**
     * current health of critter
     * getter method
     * @return
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * current health of critter
     * setter method
     * @return
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * max health of a critter
     * getter method
     * @return
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * max health of a critter
     * setter method
     * @return
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * get next index based on current position
     */
    private int getDestination(int index) {

        int iLeft = index - 1;
        int iRight = index + 1;
        int iDown = index + cols;
        int iUp = index - cols;
        // TODO when critter gone, it should stop
        int nextIndex;
        if (pathList.contains(iLeft)) {
            nextIndex = iLeft;
        } else if (pathList.contains(iRight)) {
            nextIndex = iRight;
        } else if (pathList.contains(iDown)) {
            nextIndex = iDown;
        } else if (pathList.contains(iUp)) {
            nextIndex = iUp;
        } else {
            return -1;
        }
        pathList.remove(new Integer(index));
        return nextIndex;
    }

    /**
     * critter moving method, move to specific index
     * @param index
     */
    private void moveToIndex(int index) {
        int[] nextPosition = GameMapDrawing.indexToCoordinateConverter(index, cols);
        int x = nextPosition[0];
        int y = nextPosition[1];

        if (currentPosX == x && currentPosY == y){
            nextIndex = getDestination(GameMapDrawing.coordinateToIndexConverter(x, y ,cols));
            if(nextIndex != -1) {
                moveToIndex(nextIndex);
            } else {
                isVisible = false;
                isSucceed = true;
            }
        } else {
            if(currentPosY - y >= currentMoveSpeed){
                moveUp();
            }
            else if (y - currentPosY >= currentMoveSpeed){
                moveDown();
            }
            else if (currentPosX - x >= currentMoveSpeed){
                moverLeft();
            }
            else if (x - currentPosX >= currentMoveSpeed){
                moveRight();
            } else {
                currentPosX = x;
                currentPosY = y;
            }
        }
    }

    /**
     * wrapper method for critter
     */
    public void moveThroughPathInMap() {
        if(isVisible) moveToIndex(nextIndex);
    }

    /**
     * listener: observing critter timers
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() != null){ // critter get poisoned
            if(e.getActionCommand().equals("POISON")){
                currentHealth -= continuesDamage;
            }
        } else { // set back to initial speed of frozen state or low speed state
            if(innerTimer != null) innerTimer.stop();
            setCurrentMoveSpeed(initialMoveSpeed);
        }
    }
}
