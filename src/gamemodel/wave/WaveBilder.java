package gamemodel.wave;

public class WaveBilder implements TRY_Builder {

	
	private TRY_Wave wave;
	private static int numA= 5;
	private static int numB= 4;
	private static int numC= 3;
	
	public WaveBilder(){
		
		wave = new TRY_Wave();
	}
	
	@Override
	public void buildCritterA() {

		wave.setCritterA(numA);
		numA+=2;
	}

	@Override
	public void buildCritterB() {
		
		wave.setCritterB(numB);
		
		numB+=2;
	}

	@Override
	public void buildCritterC() {
		
		wave.setCritterC(numC);
		numC+=2;
	}

	@Override
	public TRY_Wave getWave() {
		
		return this.wave;
	}

	
}
