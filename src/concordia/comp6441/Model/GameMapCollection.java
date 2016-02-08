package concordia.comp6441.Model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    public void setMaps(ArrayList<GameMap> maps) {
        this.maps = maps;
    }

    public void addMap(GameMap map){
        this.maps.add(map);
    }


}
