package model.imagecollection;

import model.critter.Critter;
import model.critter.CritterName;
import model.tower.TowerName;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * image collection for critters
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public class CritterImageCollection extends ImageCollection {

    public static HashMap<CritterName, Image> critterImages = new HashMap<>();

    static {
        critterImages.put(CritterName.CritterA, new ImageIcon(BASE_URL + CritterName.CritterA.getCritterName() + PNG).getImage());
        critterImages.put(CritterName.CritterB, new ImageIcon(BASE_URL + CritterName.CritterB.getCritterName()  + PNG).getImage());
        critterImages.put(CritterName.CritterC, new ImageIcon(BASE_URL + CritterName.CritterC.getCritterName()  + PNG).getImage());
        critterImages.put(CritterName.CritterD, new ImageIcon(BASE_URL + CritterName.CritterD.getCritterName()  + PNG).getImage());
    }

    /**
     * get bound of the critter
     * @param critterName
     * @return dimension of critter image
     */
    public static Dimension getCritterImageSizeOf(CritterName critterName){
        return new Dimension(new ImageIcon(BASE_URL + critterName + PNG).getIconWidth(), new ImageIcon(BASE_URL + critterName + PNG).getIconHeight());
    }

}
