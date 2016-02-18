package gamemodel.gamemap;


/**
 * Enumerate define  all the possible cell state
 * 
 * @author Mansour
 * @version 1.0
 * since 26/1/2016
 */
public enum CellState {
    GRASS("grass"),
    PATH("path"),
    ENTRANCE("entrance"),
    EXIT("exit"),
    TOPLACETOWER("toplacetower"),
    TOWER("tower"),
    CHOSEN("chosen");


    private String cellStateName;
    /**
     * set the cell state name
     * @param name the cell state name
     */
    CellState(String name) {
        cellStateName = name;
    }
/**
 * get the cell state name 
 * @return the cell state name
 */
    public String getCellStateName() {
        return cellStateName;
    }
}