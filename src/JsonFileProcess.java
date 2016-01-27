import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 * Created by yongpinggao on 1/26/16.
 */
public class JsonFileProcess {

    private static String FILE_NAME = "saved/maps.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    // Input: Map information: 1. map size(rows and cols the map has); 2. a list of map cell state
    // Output: Write the info to a file in JSON Format
    // Dependency: gson-2.5 library
    public static void writeToJson(GameMap map){
        try {
            GameMapCollection maps = readFromJson();
            if(maps == null){
                try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
                maps = new GameMapCollection();
                System.out.println(FILE_NAME + " not exists, we create one for you.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            maps.addMap(map);
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(gson.toJson(maps));
            writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
    // System.out.println(maps.getMaps().get(1).getCells());
    public static GameMapCollection readFromJson(){

        File file = new File(FILE_NAME);
        if(file.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

                GameMapCollection maps = gson.fromJson(br, GameMapCollection.class);
                return maps;

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else return null;
    }
}
