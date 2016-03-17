package model.tower;

import java.awt.*;

/**
 * An enum that define shooting effect
 * @author yongpinggao 
 * @since 3/16/16.
 * @version 2.0  
 */
public enum ShootingEffect {

    IceEffect,
    PoisonEffect,
    NormalEffect;
	/**
	 * Get stock by different shooting effect
	 * @param e represents shooting effect
	 * @return stock
	 */
    public static BasicStroke getStoke(ShootingEffect e){
        switch (e){
            case IceEffect:
                return new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            case NormalEffect:
                return new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[]{10f, 10f}, 2f);
            case PoisonEffect:
                return new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[]{10.0f, 3.0f, 1.0f, 10.0f}, 2f);
            default:
                return null;
        }
    }




}
