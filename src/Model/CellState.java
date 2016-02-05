import java.util.ArrayList;

/**
 * Created by yongpinggao on 1/28/16.
 */
enum CellState {
    GRASS("grass"),
    PATH("path"),
    ENTRANCE("entrance"),
    EXIT("exit"),
    TOPLACETOWER("toplacetower"),
    TOWER("tower"),
    CHOSEN("chosen");


    private String cellStateName;
    CellState(String name) {
        cellStateName = name;
    }

    public String getCellStateName() {
        return cellStateName;
    }
}