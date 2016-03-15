package mapvalidation;


import java.util.HashMap;


/**
 * This class is to validate whether the path in map is consecutive.
 * Having gap in path is illegal.
 * 
 * @author LiChong
 *
 */
public class ContinousPathValidator implements MapValidator {

    private HashMap<Integer,Integer> cMap;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate() {
        // TODO Auto-generated method stub

        for (int i : cMap.values()) {
            if (i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Setter to the validator property.
     * @param countMap HashMap validator
     */
    public ContinousPathValidator(HashMap<Integer,Integer> countMap) {
        this.cMap = countMap;
    }

}
