package model.tower;
/**
 * An enumerate  list tower name
 * 
 *@author yongpinggao 
 *@since  3/16/16
 *@version 2.0  
 */
public enum TowerName {
    TowerNull(""),

    // Normal Tower
    TowerA1("towerA_1"),
    TowerA2("towerA_2"),
    TowerA3("towerA_3"),
    TowerAH("towerA_high"),

    // Ice Tower
    TowerB1("towerB_1"),
    TowerB2("towerB_2"),
    TowerB3("towerB_3"),
    TowerBH("towerB_high"),

    // Poison Tower
    TowerC1("towerC_1"),
    TowerC2("towerC_2"),
    TowerC3("towerC_3"),
    TowerCH("towerC_high");


    private String towerName;
    /**
     * A constructor assign name to towerName.
     * @param towerName tower name
     */
    TowerName(String towerName) {
        this.towerName = towerName;
    }
    /**
     * get tower name.
     * @return tower name 
     */
    public String getTowerName() {
        return towerName;
    }
}
