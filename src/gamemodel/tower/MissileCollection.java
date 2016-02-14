package gamemodel.tower;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by yongpinggao on 2/7/16.
 */
public class MissileCollection {

    public static final HashMap<TowerID, BasicStroke> missiles = new HashMap<>();

    static {

        BasicStroke bs_a1 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        BasicStroke bs_a2 = new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        BasicStroke bs_a3 = new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        missiles.put(TowerID.TOWERA1, bs_a1);
        missiles.put(TowerID.TOWERA2, bs_a2);
        missiles.put(TowerID.TOWERA3, bs_a3);


        float[] dashTowerB = {10f, 10f};
        BasicStroke bs_b1 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, dashTowerB, 2f);
        BasicStroke bs_b2 = new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, dashTowerB, 2f);
        BasicStroke bs_b3 = new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, dashTowerB, 2f);
        missiles.put(TowerID.TOWERB1, bs_b1);
        missiles.put(TowerID.TOWERB2, bs_b2);
        missiles.put(TowerID.TOWERB3, bs_b3);

        float[] dashTowerC = {10.0f, 3.0f, 1.0f, 10.0f};
        BasicStroke bs_c1 = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, dashTowerC, 2f);
        BasicStroke bs_c2 = new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, dashTowerC, 2f);
        BasicStroke bs_c3 = new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, dashTowerC, 2f);
        missiles.put(TowerID.TOWERC1, bs_c1);
        missiles.put(TowerID.TOWERC2, bs_c2);
        missiles.put(TowerID.TOWERC3, bs_c3);


    }
}
