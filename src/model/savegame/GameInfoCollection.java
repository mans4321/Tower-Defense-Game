package model.savegame;

import com.google.gson.annotations.Expose;
import utility.FileProcessing;

import java.util.ArrayList;

/**
 * Created by yongpinggao on 3/29/16.
 */
public class GameInfoCollection {

    private static final String JSON_FILE = "games.json";

    @Expose
    private ArrayList<GameInfo> savedGames;

    /**
     * constructor
     * create a new arraylist
     */
    public GameInfoCollection(){
        this.savedGames = new ArrayList<>();
    }

    public ArrayList<GameInfo> getSavedGames() {
        return savedGames;
    }

    public void addGame(GameInfo game) {
        savedGames.add(game);
    }

    public static boolean saveGamesToFile(GameInfoCollection games) {
        return FileProcessing.sharedInstance().writeToJsonFile(JSON_FILE, games);
    }

    public static GameInfoCollection loadGamesFromFile() {
        return FileProcessing.sharedInstance().readFromJsonFile(JSON_FILE, GameInfoCollection.class);
    }

    public boolean isEmpty() {
        return savedGames.isEmpty();
    }
}
