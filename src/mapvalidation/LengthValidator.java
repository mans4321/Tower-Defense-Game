package mapvalidation;

import java.util.ArrayList;

import gamemodel.CellState;

/**
 * This class is to validate whether the length of path in map is legal.
 * Too short path(the length of path less than 3) is illegal.
 * Too long path(the length of path more than half of the whole size of map) is illegal.
 * 
 * @author LiChong
 *
 */
public class LengthValidator implements MapValidator {
	//public static final String TOO_SHORT_ERROR = "Sorry,path is too short";//how to seperate these situation?
	//public static final String TOO_LONG_ERROR = "Sorry,path is too long";
	
	private ArrayList<CellState> cellList;//how to simplize it?
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		int numberOfPath = 0;
		for(int i = 0; i < cellList.size(); i++){
			if(cellList.get(i) == CellState.PATH ){ numberOfPath ++;}
		}
		
		if(numberOfPath < 3 || numberOfPath > (cellList.size())/2){
			return false;
		}else{
			return true;
		}
		
	}
	
	public LengthValidator(){
		
	}

}
