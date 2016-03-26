package model.map;

import utility.FileProcessing;

import java.util.ArrayList;

/**
 * GameMapCollection class
 * store all game map that user created
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */
public class GameMapCollection {

	
    private static String JSON_FILE = "maps.json";

    private ArrayList<GameMap> maps;

    /**
     * constructor
     * create a new arraylist
     */
    public GameMapCollection(){
        this.maps = new ArrayList<>();
    }

    /**
     * getter for maps
     * @return maps
     */
    public ArrayList<GameMap> getMaps() {
        return maps;
    }

    /**
     * adding a game map 
     * @param map game map
     */
    public void addMap(GameMap map) {
        this.maps.add(map);
    }

    /**
     * deleting map
     * @param index map index
     */
    public void deleteMap(int index) {
        this.maps.remove(index);
    }

    /**
     * save maps to Json file 
     * @param maps saved maps collection
     * @return saving map status 
     */
    public static boolean saveMapsToFile(GameMapCollection maps) {
        return FileProcessing.sharedInstance().writeToJsonFile(JSON_FILE, maps);
    }

    /**
     * load  maps for Json file 
     * @return an instance of GameMapCollection class
     */
    public static GameMapCollection loadMapsFromFile() {
        return FileProcessing.sharedInstance().readFromJsonFile(JSON_FILE, GameMapCollection.class);
    }



}
