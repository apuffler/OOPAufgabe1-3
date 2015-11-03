import java.util.ArrayList;

//GOOD: Using abstract classes to simplify.
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

	/**
	 * Method applyTo applies a given Object to another and returns such. 
 	 * GOOD: Using abstract methods to simplify.
 	 * @param (t): T t must not be NULL
 	 */
	public abstract T applyTo(T t);


}