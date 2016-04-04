//package testingUnit;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import model.tower.BurningTower;
//import org.junit.Before;
//import org.junit.Test;
//
//import model.critter.Critter;
//import model.tower.shootingstrategy.TargetBasedOnNearest;
//import model.tower.shootingstrategy.TargetBasedOnStrongest;
//import model.tower.shootingstrategy.TargetBasedOnWeakest;
//import view.critter.CritterType;
//import view.map.Position;
//
//
///**
// * test tower shooting strategies.
// *
// * @author m_lzahra
// * @version 1.0
// * @since 14/3/2016
// */
//public class TowerTest {
//
//    Critter crriter1;
//    Critter crriter2;
//    Set<Critter> crittersInRange;
//    BurningTower tower ;
//    private TargetBasedOnWeakest targetBasedOnWeakest;
//    private TargetBasedOnStrongest targetBasedOnStrongest;
//    private TargetBasedOnNearest targetBasedOnNearestest;
//
//
//    /**
//     * setting the critters to test tower strategies
//     */
//    @Before
//    public void setValues() {
//
//        crriter1 = new Critter(CritterType.CritterA);
//        crriter2 = new Critter(CritterType.CritterA);
//        crriter1.setCurrentHealth(100);
//        crriter2.setCurrentHealth(60);
//
//        crriter1.getMovingBehavior().setCurrentPosition(new Position(0, 0));
//        crriter2.getMovingBehavior().setCurrentPosition(new Position(0, 100));
//
//        crittersInRange = new HashSet<>();
//
//        crittersInRange.add(crriter1);
//        crittersInRange.add(crriter2);
//
//        tower = new BurningTower(1);
//    }
//
//    /**
//     * testing target based on weakest shooting strategy
//     */
//    @Test
//    public void testTargetBasedOnWeakest() {
//
//        targetBasedOnWeakest = new TargetBasedOnWeakest();
//
//
//        assertTrue(crriter2.equals(targetBasedOnWeakest.targetOnCritters(crittersInRange)) );
//    }
//
//    /**
//     *  testing target based on strongest shooting strategy
//     */
//    @Test
//    public void testTargetBasedOnStrongest() {
//
//        targetBasedOnStrongest = new TargetBasedOnStrongest();
//
//        assertTrue(crriter1.equals(targetBasedOnStrongest.targetOnCritters(crittersInRange)));
//    }
//
////    /**
////     * testing target Based on nearest  shooting strategy
////     */
////    @Test
////    public void testTargetBasedOnNearestest() {
////
//////        targetBasedOnNearestest = new TargetBasedOnNearest();
//////
//////
//////         assertTrue(crriter1.equals(targetBasedOnNearestest.targetOnCritters(crittersInRange)));
////}
//}