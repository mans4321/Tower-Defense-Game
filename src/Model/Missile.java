import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yongpinggao on 2/2/16.
 */
public class Missile implements MissileBehavior{

    protected int speed;


    protected String imageURL;

    protected final int level = 3;

    protected int posX;
    protected int posY;




    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    private void getBound(){

    }

    public String getImageURL() {
        return imageURL;
    }

    public Image getImage(){
        return new ImageIcon(imageURL).getImage();
    }


    @Override
    public void move() {
        posX += speed;
        posY += speed;
    }


}
