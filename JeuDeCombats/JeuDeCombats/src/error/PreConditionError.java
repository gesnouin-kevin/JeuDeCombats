package error;

public class PreConditionError extends Error{

	private static final long serialVersionUID = 1L;

	public PreConditionError(String message){
		super(message);
	}
}
