import java.util.ArrayList;
public abstract class Model<T> {	

	//Conditions over years in form of (currently either a forest or an economy)
	public ArrayList<T> conditions;
	//int is the year in which this specialCondition will be applied, Object T will encorporate this specialCondition.
	//For example: If there is a ForestFire, the number of trees will be reduced to 0.
	//private HashMap<int, SpecialCase> specialConditions;

	//0 <= currentYear < conditions.size
	public int currentYear;

	public boolean cyclic;

	//Applies the Model to (currently either a forest or an economy) for a number of years (mod length of conditions) if cyclic.
	//This method will overwrite certain parameters (taken from the current condition) and leave others (if they are marked with a negative value) alone.

	//Applies the model for 1 year.
	public abstract T applyTo(T t);


	/*
	public Model (ArrayList<T> conditions,boolean cyclic)
	{
		this.conditions = conditions;
		this.cyclic = cyclic;
	}
	*/

}