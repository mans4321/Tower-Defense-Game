package unitTestpackage;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import View.EndPanel;
import View.TowerSpecificationPanel;
import gamemodel.tower.Tower;
import gamemodel.tower.TowerFactory;
import gamemodel.tower.TowerId;

public class updateInfoOfTower {

	Tower tower ;
	EndPanel endPanel;
	TowerId id;
	TowerSpecificationPanel towerSpecification;
	
	@Before
	public void setValue(){
		
		 tower = TowerFactory.getInstance().getTower(id.TOWERA1);
		 endPanel = new EndPanel();
		 towerSpecification = new TowerSpecificationPanel();
	}
	
	
	@Test
	public void setBuyPrice() {
		endPanel.getTowerSpecificationPanel().setBuyPrice(tower.getBuyPrice());
		double towerBuyPrice= tower.getBuyPrice();
		double buyPrice = endPanel.getTowerSpecificationPanel().getBuyPrice();
		assertTrue(towerBuyPrice == buyPrice);
	}
	
	@Test
	public void setSellPrice() {
	         endPanel.getTowerSpecificationPanel().setSellPrice(tower.getSellPrice());
	         
	        double towersellPrice= tower.getSellPrice();
			double sellPrice = endPanel.getTowerSpecificationPanel().getSellPrice();
			assertTrue(towersellPrice == sellPrice);
			
	}
	
	@Test
	public void setPower() {
		 endPanel.getTowerSpecificationPanel().setPower(tower.getPower());
		 
		    double towerpower= tower.getPower();
			double pwer = endPanel.getTowerSpecificationPanel().getPower();
			assertTrue(towerpower == pwer);
	}
	
	@Test
	public void setRange() {
		 endPanel.getTowerSpecificationPanel().setRange(tower.getRange());
		 
		 double towerrange= tower.getRange();
			double range = endPanel.getTowerSpecificationPanel().getRange();
			assertTrue(towerrange == range);
	}
	
	@Test
	public void setRateOfFire() {
		endPanel.getTowerSpecificationPanel().setRateOfFire(tower.getRateOfFire());

		    double towerRateOfFire= tower.getRateOfFire();
			double rateOfFire = endPanel.getTowerSpecificationPanel().getRateOfFire();
			assertTrue(towerRateOfFire == rateOfFire);
			
	}
	
	 

}
