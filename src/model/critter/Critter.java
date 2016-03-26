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
public class Critter implements ActionListener {
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
     * @param gameMap  played game map
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
     * @return critter life state
     */
    public boolean isKilled() {
        return isKilled;
    }

    /**
     * check if critter is killed 
     * setter method
     * @param killed life status
     */
    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    /**
     * critter worth after it is killed
     * getter method 
     * @return critter worth
     */
    public double getWorth() {
        return worth;
    }

    /**
     * critter worth after it is killed
     * setter method 
     *@param worth amount of money earned for killing critter
     */
    public void setWorth(double worth) {
        this.worth = worth;
    }

    /**
     * a critter's path cell index
     * getter method
     * @return critter path
     */
    public ArrayList<Integer> getPathList() {
        return pathList;
    }

    /**
     * a critter's path cell index
     * setter method
     *@param pathList the path for critters 
     */
    public void setPathList(ArrayList<Integer> pathList) {
        this.pathList = pathList;
    }

    /**
     * check if critter has stole the coins successfully
     * getter method
     * @return whether critter reached the exsit point
     */
    public boolean isSucceed() {
        return isSucceed;
    }

    /**
     * check if critter has stole the coins successfully
     * setter method
     *@param succeed critter reaching the end status 
     */
    public void setSucceed(boolean succeed) {
        isSucceed = succeed;
    }
    
    /**
     * special effect timer for a critter
     * getter method
     * @return timer for moving critter
     */
    public Timer getMovingTimer() {
        return movingTimer;
    }

    /**
     * special effect: moving speed affected timer for a critter 
     * setter method
     *@param movingTimer timer for moving critter  
     */
    public void setMovingTimer(Timer movingTimer) {
        this.movingTimer = movingTimer;
    }

    /**
     * special effect: poison affected timer for a critter
     * getter method
     * @return critter inner timer
     */
    public Timer getInnerTimer() {
        return innerTimer;
    }

    /**
     * continues damage for a critter
     * getter method
     * 
     */
    public int getContinuesDamage() {
        return continuesDamage;
    }

    /**
     * continues damage for a critter
     * setter method
     * @return Continues Damage damage on critter over time
     */
    public void setContinuesDamage(int continuesDamage) {
        this.continuesDamage = continuesDamage;
    }

    /**
     * special effect: poison affected timer for a critter
     * setter method
     * @param innerTimer inner time for critter
     */
    public void setInnerTimer(Timer innerTimer) {
        this.innerTimer = innerTimer;
    }

    /**
     * initial move speed for a critter
     * getter method
     * @return initial critter moving speed
     */
    public int getInitialMoveSpeed() {
        return initialMoveSpeed;
    }

    /**
     * initial move speed for a critter
     * setter method
     * @param initialMoveSpeed the initial moving speed for critter
     */
    public void setInitialMoveSpeed(int initialMoveSpeed) {
        this.initialMoveSpeed = initialMoveSpeed;
    }

    /**
     * get bounds for the crriter for collision detection
     * getter method
     * @return critter rectangle 
     */
    public Rectangle getBound() {
        Dimension dimension = CritterImageCollection.getCritterImageSizeOf(critterName);
        return new Rectangle(currentPosX, currentPosY, dimension.width, dimension.height);
    }
    
    /**
     * get a hearth bar length for drawing health bar for critter
     * @return critter HealthBarLength
     */
    public float getHealthBarLength() {
        return (float)(currentHealth) / maxHealth;
    }

    /**
     * moving speed for a critter
     * getter method
     * @return critter current Moving  Speed
     */
    public int getCurrentMoveSpeed() {
        return currentMoveSpeed;
    }
    
    /**
     * moving speed for a critter
     * setter method
     *@param currentMoveSpeed critter current moving speed
     */
    public void setCurrentMoveSpeed(int currentMoveSpeed) {
        this.currentMoveSpeed = currentMoveSpeed;
    }

    /**
     * critter type
     * getter method
     * @return critter name 
     */
    public CritterName getCritterName() {
        return critterName;
    }

    /**
     * critter type
     * setter method
     * @param critterName critter name
     */
    public void setCritterName(CritterName critterName) {
        this.critterName = critterName;
    }

    /**
     * check if critter is visible for game drawing
     * getter method
     * @return critter visibility state
     */
    public boolean isVisible() {
        return isVisible;
    }
    
    /**
     * check if critter is visible for game drawing
     * setter method for critter visibility
     *@param visible critter visibility status 
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
     * @return critter current X Position 
     */
    public int getCurrentPosX() {
        return currentPosX;
    }

    /**
     * set critter: x  position  
     * setter method
     *@param currentPosX critter current position X 
     */
    public void setCurrentPosX(int currentPosX) {
        this.currentPosX = currentPosX;
    }

    /**
     * position of a critter: y
     * getter method
     * @return  critter current Y Position 
     */
    public int getCurrentPosY() {
        return currentPosY;
    }

    /**
     * position of a critter: y
     * setter method
     *@param currentPosY current Y Position
     */
    public void setCurrentPosY(int currentPosY) {
        this.currentPosY = currentPosY;
    }

    /**
     * current health of critter
     * getter method
     * @return critter current Health
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * current health of critter
     * setter method
     *@param currentHealth critter current health
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * max health of a critter
     * getter method
     * @return critter maxHealth
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * max health of a critter
     * setter method
     *@param maxHealth maximum health
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * get next index based on current position
     * @return critter next index or -1
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
     * @param index map index
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
            if (currentPosY - y >= currentMoveSpeed) {
                moveUp();
            }
            else if (y - currentPosY >= currentMoveSpeed) {
                moveDown();
            }
            else if (currentPosX - x >= currentMoveSpeed) {
                moverLeft();
            }
            else if (x - currentPosX >= currentMoveSpeed) {
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
        if (e.getActionCommand() != null){ // critter get poisoned
            if (e.getActionCommand().equals("POISON")) {
                currentHealth -= continuesDamage;
            }
        } else { // set back to initial speed of frozen state or low speed state
            if (innerTimer != null) {
                innerTimer.stop();
            }
            setCurrentMoveSpeed(initialMoveSpeed);
        }
    }
}
