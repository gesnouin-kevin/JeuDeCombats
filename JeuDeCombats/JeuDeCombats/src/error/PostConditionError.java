package error;

public class PostConditionError extends Error{

	private static final long serialVersionUID = 1L;

	public PostConditionError(String message){
		super(message);
	}
}
