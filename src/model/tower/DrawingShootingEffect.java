package model.tower;

import model.drawing.Drawing;

import java.awt.*;

/**
 * An interface that define to draw shooting effect
 * @author yongpinggao 
 * @since 3/16/16.
 * @version 2.0  
 */
public interface DrawingShootingEffect {
    int CELL_SIZE = Drawing.CELL_SIZE;
    void drawShootingEffect(Graphics g);
}
