package gamemodel.tower;
/**
 * An enumerate  list tower id
 * 
 *@author yongpinggao 
 *@since  1/30/16
 *@version 1.0  
 */
public enum TowerId {
    TOWERNULL(""),

    TOWERA1("towerA_1"),
    TOWERA2("towerA_2"),
    TOWERA3("towerA_3"),
    TOWERAH("towerA_high"),

    TOWERB1("towerB_1"),
    TOWERB2("towerB_2"),
    TOWERB3("towerB_3"),
    TOWERBH("towerB_high"),

    TOWERC1("towerC_1"),
    TOWERC2("towerC_2"),
    TOWERC3("towerC_3"),
    TOWERCH("towerC_high");


    private String name;
    
    /**
     * A constructor assign name to towerName.
     * @param towerName tower name
     */
    TowerId(String towerName) {
        this.name = towerName;
    }
    
    /**
     * get tower name.
     * @return tower name 
     */
    public String getName() {
        return name;
    }
    
    /**
     * get tower id.
     * @param name tower name
     * @return tower id
     */
    public static TowerId getTowerIdFrom(String name) {
        TowerId id = null;

        for(TowerId tid: TowerId.values()) {
            if (tid.getName().equals(name)) {
                id = tid;
            }
        }
        return id;
    }
}
