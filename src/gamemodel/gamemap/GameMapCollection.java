package gamemodel.gamemap;
import java.util.ArrayList;


/**
 * This class  story all saved maps by the player .
 * 
 * when the player save a new game it is added to Arraylist Type GameMAp.
 * and when  player remove it removed from that Arraylist.
 *  
 * @author Mansour 
 * @since 1/26/16.
 *@version 1.0
 *@see {@link gamemodel.gamemap.GameMap GameMap}
 */
public class GameMapCollection {

    private ArrayList<GameMap> maps;

/**
 * Constructor fot game map collection.
 * 
 */
    public GameMapCollection(){
        this.maps = new ArrayList<>();
    }
/**
 * get the maps from the game map collection
 * @return the map collection storied by the player
 */
    public ArrayList<GameMap> getMaps() {
        return maps;
    }
/**
 * adding the map to game map collection 
 * @param map  the saved map by the player
 */
    public void addMap(GameMap map){
        this.maps.add(map);
    }
/**
 * delete the map from the game map collection
 * @param index   the map index in the Arraylist.
 */
    public void deleteMap(int index){                   
        this.maps.remove(index);
    }


}
