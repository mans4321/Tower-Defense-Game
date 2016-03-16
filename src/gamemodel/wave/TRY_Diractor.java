package gamemodel.wave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gamemodel.critter.CritterStore;

public class TRY_Diractor implements ActionListener {

	
    private Timer generateCritterTimer;
    private int index;
    private WaveStartListener listener;
    
	TRY_Builder builder ;
	
	public TRY_Diractor(TRY_Builder builder){
		
		this.builder = builder;
		
        generateCritterTimer = new Timer(1000, this);
        generateCritterTimer.start();
        index = 0;
	}


	public TRY_Wave getWave(){
		
		return this.builder.getWave();
	}

	public void buildWave(){
		
		this.builder.buildCritterA();
		this.builder.buildCritterB();
		this.builder.buildCritterC();
	}
	

    public void addWaveStartListener(WaveStartListener listener) {
        this.listener = listener;
    }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		  if (index <= CritterStore.critters.size()) {
	            listener.initCritterPos(CritterStore.critters.get(index));
	            index ++;
	            if (index >= CritterStore.critters.size()) generateCritterTimer.stop();
	        }
		
	}
}
