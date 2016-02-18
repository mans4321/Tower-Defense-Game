package mapvalidation;

/**
 * This is a interface named MapValidator, easy to be realized in different validators.  
 * 
 * @author LiChong
 * @version 1.1
 */
public interface  MapValidator {
/**
 * Validates the path  	
 * 
 * @return path validation result 
 */
	boolean validate(); 
}
