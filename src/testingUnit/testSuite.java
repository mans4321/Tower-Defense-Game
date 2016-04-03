package testingUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    Bank.class, 
    ConvertXYcoordinateConverter.class, 
    CritterTest.class, 
    EntranceExit.class, 
    TestingMap.class,
    TowerFactoryTest.class, 
//    TowerTest.class,
    Utilityclass.class, 
    ValidateMap.class 
})
public class testSuite {

}
