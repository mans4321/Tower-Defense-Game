import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by yongpinggao on 1/26/16.
 */
public class FileProcessing {

    public static String JSON_DIR = "saved/";
    public static String MAP_THUMBNAIL_DIR = "maparchive/";

    private static String JSON_FILE_NAME = JSON_DIR + "/maps.json";

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // Input: Map information: 1. map size(rows and cols the map has); 2. a list of map cell state
    // Output: Write the info to a file in JSON Format
    // Dependency: gson-2.5 library
    public static void addMapToJsonFile(GameMap map){
        try {
            GameMapCollection maps = readMapFromJsonFile();
            if(maps == null){
                try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
                maps = new GameMapCollection();
                System.out.println(JSON_FILE_NAME + " not exists, we create one for you.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            maps.addMap(map);
            BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
            writer.write(gson.toJson(maps));
            writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void deleteMapFromJsonFile(int index){

        try {
            GameMapCollection maps = readMapFromJsonFile();

            if(maps != null){
                maps.deleteMap(index);
                BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE_NAME));
                writer.write(gson.toJson(maps));
                writer.close();
            }

            if (maps.getMaps().size() == 0){
                // if json file is empty, then remove json file
                new File(JSON_FILE_NAME).delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameMapCollection readMapFromJsonFile() {


        File file = new File(JSON_FILE_NAME);

        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(JSON_FILE_NAME));

                GameMapCollection maps = gson.fromJson(br, GameMapCollection.class);
                return maps;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        } else return null;
    }

    public static ImageIcon readFromMapArchive(String mapName){
        if(new File(MAP_THUMBNAIL_DIR + mapName + ".png").exists()){
            return new ImageIcon(MAP_THUMBNAIL_DIR + mapName + ".png");
        } else return null;

    }

    public static void writeToMapArchive(String mapName, BufferedImage image){
        try {
            if(mapName != null){
                //save thumbnail to mapName.png
                ImageIO.write(image, "png", new File(MAP_THUMBNAIL_DIR + mapName + ".png"));
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static void sync(){

        if (new File(JSON_FILE_NAME).exists()) {
            ArrayList<GameMap> maps = readMapFromJsonFile().getMaps();

            for (int i = 0; i < maps.size(); i++) {
                // if json has this mapName, but map archive doesn't have this map
                // then delete this map in json file
                if (readFromMapArchive(maps.get(i).getImageName()) == null) {
                    deleteMapFromJsonFile(i);
                }
            }
        }


    }

}
