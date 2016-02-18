package gamemodel.tower;
/**
 * Createing  by yongpinggao on 2/4/16.
 */
public class TowerFactory {

    // singleton + Factory

    private static TowerFactory ourInstance = new TowerFactory();
/**
 * 
 * @return
 */
    public static TowerFactory getInstance() {
        return ourInstance;
    }

    private TowerFactory() {}
/**
 * 
 * @param id tower id 
 * @return
 */
    public Tower getTower(TowerID id){
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
