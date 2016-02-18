package gamemodel.critter;
/**
 *  An interface class set the method that will handle the Critter death
 *  @author  yongpinggao
 */
public interface CritterGotKilledListener {
/**
 * 
 * @param c  the critter type
 */
    void critterGotKilled(Critter c);

}
