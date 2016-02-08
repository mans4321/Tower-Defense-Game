package concordia.comp6441.Model;
/**
 * Created by yongpinggao on 1/30/16.
 */
public enum TowerID {
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
    TowerID(String towerName) {
        this.name = towerName;
    }

    public String getName() {
        return name;
    }

    public static TowerID getTowerIDFrom(String name){
        TowerID id = null;

        for(TowerID tid: TowerID.values()){
            if(tid.getName().equals(name)){
                id = tid;
            }
        }
        return id;
    }
}
