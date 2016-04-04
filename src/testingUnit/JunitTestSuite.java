package testingUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	Bank.class, 
	BurningTowerShootingBehaviorTest.class,
	IceTowerShootingBehaviorTest.class, 
	SplashTowerShootingBehaviorTest.class,
	TargetBasedOnWeakestTest.class,
	
	CoordinateConverter.class, 
	CritterTest.class,
	EntranceExitPoint.class,  
	TestingMap.class, 
	TowerFactoryTest.class, 
	Utilityclass.class,
	ValidateMap.class })
public class JunitTestSuite {

}
