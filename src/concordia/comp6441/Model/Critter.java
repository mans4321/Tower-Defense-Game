package concordia.comp6441.Model;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by yongpinggao on 2/2/16.
 */
public class Critter implements CritterBehavior{

    protected int moveSpeed;
    protected String imgURL;

    // current position
    protected int posX;
    protected int posY;

    protected boolean isVisible;


    // input: destination coordinate(x, y)
    // output: if the critter arrived at the destination
    // return false means it is on its way to the destination
    @Override
    public boolean moveToPosition(int x, int y) {

        if(posY > y){
            moveUp();
            return false;
        } else if (posY < y){
            moveDown();
            return false;
        } else if (posX > x){
            moverLeft();
            return false;
        } else if (posX < x){
            moveRight();
            return false;
        } else if (x == posX && y == posY) {
            return true;
        } else return false;

    }

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


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
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
}
