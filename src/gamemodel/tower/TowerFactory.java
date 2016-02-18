package gamemodel.tower;

/**
 * produce new tower instance base on TowerID.
 * 
 *This class apply singleton design.
 * @author yongpinggao 
 * @since 2/4/16.
 * @version 1.0
 */
public class TowerFactory {

    // singleton + Factory

    private static TowerFactory ourInstance = new TowerFactory();
    
    /**
     * Returns the tower factory.
     * @return
     */
    public static TowerFactory getInstance() {
        return ourInstance;
    }
    
    /**
     * Constructor make TowerFactory Private.  
     */
    private TowerFactory() {}
    
    /**
     * Getter that returns a new Tower of the the specified type.
     * @param id tower id 
     * @return
     */
    public Tower getTower(TowerId id) {
        switch (id) {
            case TOWERA1:
                return new TowerA(1);
            case TOWERA2:
                return new TowerA(2);
            case TOWERA3:
                return new TowerA(3);
            case TOWERB1:
                return new TowerB(1);
            case TOWERB2:
                return new TowerB(2);
            case TOWERB3:
                return new TowerB(3);
            case TOWERC1:
                return new TowerC(1);
            case TOWERC2:
                return new TowerC(2);
            case TOWERC3:
                return new TowerC(3);
            default:
                return null;
        }
    }
}
