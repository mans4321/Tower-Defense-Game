package gamemodel.critter;
/**
 *  An interface class set the method that will handle the Critter death
 * 
 * 
 *  @author  yongpinggao
 *  @version 1.0
 *  @since 28/1/16
 *  
 */
public interface CritterGotKilledListener {
/**
 *a method to handle Critter got killed  
 * 
 * @param c  the critter type
 */
    void critterGotKilled(Critter c);

}
