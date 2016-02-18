package gamemodel.gamemap;
import java.util.ArrayList;


/**
 * Created by yongpinggao on 1/26/16.
 */
public class GameMapCollection {

    private ArrayList<GameMap> maps;


    public GameMapCollection(){
        this.maps = new ArrayList<>();
    }

    public ArrayList<GameMap> getMaps() {
        return maps;
    }

    public void addMap(GameMap map){
        this.maps.add(map);
    }

    public void deleteMap(int index){
        this.maps.remove(index);
    }


}
