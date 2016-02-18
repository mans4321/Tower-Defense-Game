package gamemodel.critter;


/**
 * Interface  describing  Critters movement behavior.
 * 
 * @author yongpinggao 
 * @since 2/2/16.
 * 
 */
public interface CritterBehavior {
	/**
	 * Describe the critters moving behavior.
	 *  
	 * @param cols number of column. 
	 */
    void move(int cols);
}
