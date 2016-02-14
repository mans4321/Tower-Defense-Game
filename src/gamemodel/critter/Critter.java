package gamemodel.critter;
import javax.swing.*;

import gamemodel.tower.Tower;
import viewcontroller.DrawMap;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * This class is a model for the Critters.
 *  
 *  In this class we define the main charactistics that all the Critters shares.
 *  such as the current x&y coordinate of the Critter.
 *  Also, this class implements CritterBehavior. 
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

    public Critter(){
        aleadyDonated = false;
        isKilled = false;
        isSuccess = false;
        isVisible = false;
        pathList = new ArrayList<>();
    }

    // The path of every critter


    // x, y -> current position
    private void moveRight(){
        posX += moveSpeed;
    }

    private void moveDown(){
        posY += moveSpeed;
    }

    private void moverLeft(){
        posX -= moveSpeed;
    }

    private void moveUp(){
        posY -= moveSpeed;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getNextPosX() {
        return nextPosX;
    }

    public void setNextPosX(int nextPosX) {
        this.nextPosX = nextPosX;
    }

    public int getNextPosY() {
        return nextPosY;
    }

    public void setNextPosY(int nextPosY) {
        this.nextPosY = nextPosY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Image getImage(){
        return new ImageIcon(imgURL).getImage();
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    private Dimension getSize(){
        return new Dimension(new ImageIcon(imgURL).getIconWidth(), new ImageIcon(imgURL).getIconHeight());
    }

    public Rectangle getBound(){
        return new Rectangle(posX,posY, getSize().width, getSize().height);
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getWorth() {
        return worth;
    }

    public void setWorth(double worth) {
        this.worth = worth;
    }

    public void setPathList(ArrayList<Integer> pathList) {

        this.pathList = pathList;
    }

    public boolean isAleadyDonated() {
        return aleadyDonated;
    }

    public void setAleadyDonated(boolean aleadyDonated) {
        this.aleadyDonated = aleadyDonated;
    }

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


    // recursion!
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
            temp = getDestination(posX, posY, cols);
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
    public void move(int cols) {
        moveToPosition(nextPosX, nextPosY, cols);
    }


    public void getHitBy(Tower tower){
        this.health = this.health - tower.getPower();
        if(this.health < 0){
            this.setVisible(false);
            this.setKilled(true);
            this.setSuccess(false);
        }
    }

    public float getHealthBar() {
        if(health > 0)  return (float)getHealth() / initHealth;
        else            return 0;
    }

    public void setHealthBar(int healthBar) {
        if(healthBar >= 0)
        this.healthBar = healthBar;
    }
}


