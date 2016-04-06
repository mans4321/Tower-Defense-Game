package model.tower;

/**
 * produce new tower instance base on TowerName.
 * 
 * This class apply singleton design.
 * @author yongpinggao 
 * @since 3/16/16.
 * @version 2.0
 */
public class TowerFactory {

	// singleton + Factory
	
    private static TowerFactory instance = new TowerFactory();
    /**
     * Returns the tower factory.
     * @return 
     */
    public static TowerFactory sharedInstance() {
        return instance;
    }
    /**
     * Constructor make TowerFactory Private.  
     */
    private TowerFactory() {}
    /**
     * Getter that returns a new Tower of the the specified type.
     * @param name tower name 
     * @return
     */
    public Tower getTower(TowerName name) {
        switch (name) {
            case TowerA1:
                return new NormalTower(1);
            case TowerA2:
                return new NormalTower(2);
            case TowerA3:
                return new NormalTower(3);
            case TowerB1:
                return new IceTower(1);
            case TowerB2:
                return new IceTower(2);
            case TowerB3:
                return new IceTower(3);
            case TowerC1:
                return new PoisonTower(1);
            case TowerC2:
                return new PoisonTower(2);
            case TowerC3:
                return new PoisonTower(3);
            default:
                return null;
        }
    }
}