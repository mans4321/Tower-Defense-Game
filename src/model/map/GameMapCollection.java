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
     * g
     * @return
     */
    public ArrayList<GameMap> getMaps() {
        return maps;
    }

    public void addMap(GameMap map) {
        this.maps.add(map);
    }

    public void deleteMap(int index) {
        this.maps.remove(index);
    }

    public static boolean saveMapsToFile(GameMapCollection maps) {
        return FileProcessing.sharedInstance().writeToJsonFile(JSON_FILE, maps);
    }

    public static GameMapCollection loadMapsFromFile() {
        return FileProcessing.sharedInstance().readFromJsonFile(JSON_FILE, GameMapCollection.class);
    }



}
