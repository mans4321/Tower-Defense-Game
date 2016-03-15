package unitTestpackage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddingDeletingMap.class, Bank.class, ConvertXYcoordinateConverter.class, CritterTest.class,
		EntranceExit.class, TestingEditAreaListener.class, TowerFactoryTest.class, TowerTest.class,
		updateInfoOfTower.class, Utilityclass.class, validatemap.class })
public class TestSuite {

}
