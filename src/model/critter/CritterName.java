package model.critter;

/**
 * CritterName Enumeration
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public enum CritterName {

    CritterA("critterA"),
    CritterB("critterB"),
    CritterC("critterC"),
    CritterD("critterD");

    private String critterName;

    CritterName(String critterName) {
        this.critterName = critterName;
    }

    /**
     * critter name
     * getter method
     * @return
     */
    public String getCritterName() {
        return critterName;
    }
}