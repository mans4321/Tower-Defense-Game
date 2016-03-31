package view.tower;

import javafx.geometry.Pos;
import view.map.Position;
import view.map.Drawing;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by yongpinggao on 3/19/16.
 */
public class TowerShootingRangeView {

    private int range;
    private Position position;

    public TowerShootingRangeView(Position position, int range){
        this.range = range;
        this.position = position;
    }


    public Ellipse2D getTowerRangeCircle() {
        return new Ellipse2D.Float(position.getX() + Drawing.CELL_SIZE / 2 - range / 2, position.getY() + Drawing.CELL_SIZE  / 2 - range / 2, range, range);
    }

    public Rectangle getBounds(){
        return getTowerRangeCircle().getBounds();
    }

    public int getRange() {
        return range;
    }


}
