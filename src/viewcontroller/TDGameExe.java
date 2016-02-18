package viewcontroller;

import javax.swing.*;

import gamemodel.gamemap.FileProcessing;

import java.io.File;

/**
 * Main game execution
 * @author yongpinggao
 * @since 1/24/16
 *
 */
public class TDGameExe {
    
    /**
     * main method starts game and make main menu visible
     * @param args
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                // create file directory for map archive
                File jsonDir = new File(FileProcessing.JSON_DIR);
                File mapThumbnailDir = new File(FileProcessing.MAP_THUMBNAIL_DIR);
                jsonDir.mkdir();
                mapThumbnailDir.mkdir();

                FileProcessing.sync();

                new MainMenuWindow().setVisible(true);

            }
        });
    }
}
