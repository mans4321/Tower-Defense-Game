import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class GameMapCollection {

    private ArrayList<GameMap> maps;

    public GameMapCollection(){
        this.maps = new ArrayList<GameMap>();
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
