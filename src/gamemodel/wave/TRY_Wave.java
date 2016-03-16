package gamemodel.wave;

import gamemodel.critter.CritterA;
import gamemodel.critter.CritterB;
import gamemodel.critter.CritterC;
import gamemodel.critter.CritterStore;

public class TRY_Wave implements TRY_SetWave {

	@Override
	public void setCritterA(int num) {
		
		  for (int i = 0; i < num; i++) {
              CritterA critterA = new CritterA();
              CritterStore.critters.add(critterA);
          }
	}

	@Override
	public void setCritterB(int num) {
		
		  for (int i = 0; i < num; i++) {
              CritterB critterB = new CritterB();
              CritterStore.critters.add(critterB);
          }
		
	}

	@Override
	public void setCritterC(int num) {
		
		  for (int i = 0; i < num; i++) {
              CritterC critterC = new CritterC();
              CritterStore.critters.add(critterC);
          }
	        
	}
	
	public TRY_Wave  getTRY_wave(){
		
		return this;
	}

}
