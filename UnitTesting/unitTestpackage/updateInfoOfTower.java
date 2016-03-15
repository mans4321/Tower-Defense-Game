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

/**
 * test update Tower information
 * 
 * @author m_lzahra
 *@version 1.0
 *@since 14/2/2016
 */
public class updateInfoOfTower {

	Tower tower ;
	EndPanel endPanel;
	TowerId id;
	TowerSpecificationPanel towerSpecification;
	/**
	 * setting the values for the test;
	 */
	@Before
	public void setValue(){
		
		 tower = TowerFactory.getInstance().getTower(id.TOWERA1);
		 endPanel = new EndPanel();
		 towerSpecification = new TowerSpecificationPanel();
	}
	
	/**
	 * test set tower buy price
	 */
	@Test
	public void setBuyPrice() {
		endPanel.getTowerSpecificationPanel().setBuyPrice(tower.getBuyPrice());
		double towerBuyPrice= tower.getBuyPrice();
		double buyPrice = endPanel.getTowerSpecificationPanel().getBuyPrice();
		assertTrue(towerBuyPrice == buyPrice);
	}
	/**
	 * test set tower SellPrice
	 */
	@Test
	public void setSellPrice() {
	         endPanel.getTowerSpecificationPanel().setSellPrice(tower.getSellPrice());
	         
	        double towersellPrice= tower.getSellPrice();
			double sellPrice = endPanel.getTowerSpecificationPanel().getSellPrice();
			assertTrue(towersellPrice == sellPrice);
			
	}
	
	/**
	 * test set tower Power
	 */
	@Test
	public void setPower() {
		 endPanel.getTowerSpecificationPanel().setPower(tower.getPower());
		 
		    double towerpower= tower.getPower();
			double pwer = endPanel.getTowerSpecificationPanel().getPower();
			assertTrue(towerpower == pwer);
	}
	
	/**
	 * test set tower Range
	 */
	@Test
	public void setRange() {
		 endPanel.getTowerSpecificationPanel().setRange(tower.getRange());
		 
		 double towerrange= tower.getRange();
			double range = endPanel.getTowerSpecificationPanel().getRange();
			assertTrue(towerrange == range);
	}
	
	/**
	 * test set  tower rate of fire 
	 */
	@Test
	public void setRateOfFire() {
		endPanel.getTowerSpecificationPanel().setRateOfFire(tower.getRateOfFire());

		    double towerRateOfFire= tower.getRateOfFire();
			double rateOfFire = endPanel.getTowerSpecificationPanel().getRateOfFire();
			assertTrue(towerRateOfFire == rateOfFire);
			
	}
	
	 

}
