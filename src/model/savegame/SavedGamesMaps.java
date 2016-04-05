package model.savegame;

import java.util.ArrayList;

import model.map.GameMap;


import utility.FileProcessing;

public class SavedGamesMaps {		
	    private static  String JSON_FILE = "GamesMaps.json";

	    private ArrayList<GameMap> maps;

	    
	    /**
	     * constructor
	     * create a new arraylist
	     */
	    public SavedGamesMaps() {
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

	    public static boolean saveMapsToFile(SavedGamesMaps maps) {
	        return FileProcessing.sharedInstance().writeToJsonFile(JSON_FILE, maps);
	    }

	    public static SavedGamesMaps loadMapsFromFile() {
	        return FileProcessing.sharedInstance().readFromJsonFile(JSON_FILE, SavedGamesMaps.class);
	    }

}

