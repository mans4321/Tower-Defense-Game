package model.drawing;

/**
 * basic class of drawing
 * @author yongpinggao
 * @since 3/16/16.
 * @version 2.0 
 */

public class Drawing {
	
	/**
	 * convert position to index
	 * @param x coordinate x
	 * @param y coordinate y
	 * @param cols map cols
	 * @return index map index
	 */
    public static int coordinateToIndexConverter(int x, int y, int cols) {
        return x / CELL_SIZE + (y / CELL_SIZE) * cols;
    }

    /**
     * convert index to coordinate
     * @param index index of game map cells
     * @param cols map cols
     * @return coordinate
     */
    public static int[] indexToCoordinateConverter(int index, int cols) {
        int x = index % cols;
        int y = index / cols;
        return new int[]{x * CELL_SIZE, y * CELL_SIZE};
    }

    public final static int CELL_SIZE = 30;
}
