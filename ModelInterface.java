import java.util.ArrayList;
public interface ModelInterface {	
	//Conditions over years in form of (currently either a forest or an economy)
	//private ArrayList<T> conditions;
	//int is the year in which this specialCondition will be applied, Object T will encorporate this specialCondition.
	//For example: If there is a ForestFire, the number of trees will be reduced to 0.
	//private HashMap<int, SpecialCase> specialConditions;

	//0 <= currentYear < conditions.size
	//public int currentYear;

	//public boolean cyclic;

	//Applies the Model to (currently either a forest or an economy) for a number of years (mod length of conditions) if cyclic.
	//This method will overwrite certain parameters (taken from the current condition) and leave others (if they are marked with a negative value) alone.

	//public ArrayList<T> applyTo(T t, int years);
	//Applies the model for 1 year.
	//public Forest applyTo(Forest f);



	//public ModelInterface<T> (ArrayList<T> conditions,boolean cyclic);


}