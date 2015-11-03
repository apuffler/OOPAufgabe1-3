import java.util.ArrayList;
public abstract class Model<T> {	

	/*
	NOTE:
	Standard Model is a empty conditions ArrayList, in which case the Forest update will work without influences.
	Parametrised Models are Models which have a filled ArrayList, in which case the Forest update will be influenced.
	Special Cases are not yet implemented.
	*/

	public ArrayList<T> conditions;
	public int currentYear;
	public boolean cyclic;

	//T must not be NULL!
	public abstract T applyTo(T t);


}