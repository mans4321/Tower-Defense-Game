package gamemodel.gamemap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

/**
 * This class responsible for Reading from or Writing on a  file.
 * 
 * one of the main function of this class is interacting with Json File.
 * interacting means Read,write,or modify Jsonfile.
 * this class also read/write  the map image from/on archive.
 *        
 *@author yongpinggao 
 *@since 1/26/16.
 *@version 1.0
 *
 */
public class FileProcessing {

    public static String JSON_DIR = "saved/";
    public static String MAP_THUMBNAIL_DIR = "maparchive/";

    private static String JSON_FILE_NAME = JSON_DIR + "/maps.json";

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // Input: Map information: 1. map size(rows and cols the map has); 2. a list of map cell state
    // Output: Write the info to a file in JSON Format
    // Dependency: gson-2.5 library
   /**
    *  write the map  in Json format.
    * @param map the map created by the player 
    */
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
/**
 * deleting the map from Json file 
 * @param index the converted X&Y coordinated 
 */
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
/**
 *Read the maps from JsonFile and deserializes to GameMapCollection class   
 * @return the maps from Json file. or null in case if the Json file missing 
 * or catching error while reading from Json file .
 */
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
/**
 * Read the map image form the map archive.
 * 
 * @param mapName the name of the map image 
 * @return   the map image
 */
    public static ImageIcon readFromMapArchive(String mapName){
        if(new File(MAP_THUMBNAIL_DIR + mapName + ".png").exists()){
            return new ImageIcon(MAP_THUMBNAIL_DIR + mapName + ".png");
        } else return null;

    }
/**
 * This story the map image in the map archive
 * @param mapName
 * @param image
 */
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
/**
 * Sync the map archive with the Json file.
 * To illustlate, if a map does not exist in the archive, 
 * but it exist in the Json file. the map will be deleted from Json file.     
 */
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
