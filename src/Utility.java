

import java.util.ArrayList;


public class Utility {

    public static int getMaxValueFrom(String[] strArr) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (String s : strArr){
            arr.add(Integer.parseInt(s));
        }
        int max = arr.get(0);
        for(int i = 1; i < arr.size(); i++){
            if (arr.get(i) > max)
                max = arr.get(i);
        }

        return max;
    }

    static ArrayList<CellState> changeCellState(CellState oldState, CellState newState, ArrayList<CellState> cells){
        for(int i = 0; i < cells.size(); i++){
            if(cells.get(i) == oldState){
                cells.set(i, newState);
            }
        }
        return cells;
    }

    static ArrayList<TowerID> changeTowerState(TowerID oldState, TowerID newState, ArrayList<TowerID> towerIDArrayList){
        for(int i = 0; i < towerIDArrayList.size(); i++){
            if(towerIDArrayList.get(i) == oldState){
                towerIDArrayList.set(i, newState);
            }
        }
        return towerIDArrayList;
    }






}
