package mapValidation;

public abstract class MapValidator {

	abstract boolean validate();
	String errorMessage;
	
	public String getErrorMessage(){
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
	
}
