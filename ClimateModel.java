import java.util.ArrayList;
import java.util.HashMap;
/*
 *GOOD: Dynamic Binding used to inherit Model
 */
public class ClimateModel extends Model<Environment>
{

	
	/**
	 * Method applyTo applies conditions to the given Environment 
 	 * BAD: Strong(ish) coupling
 	 * @param (e): Environment e must not be NULL
 	 */
	public Environment applyTo(Environment e)
	{
		
		if(this.cyclic && conditions.size() > currentYear)
		{
				currentYear = 0;
		}
		if (! this.cyclic && conditions.size() > currentYear)
		{
			
			currentYear++;
			return e;
		}

		Environment condition  = conditions.get(this.currentYear);
		e.temperature = e.temperature * condition.temperature;
    	e.precipitation = e.temperature * condition.temperature;
    	e.humidity = e.humidity * condition.humidity;
    	e.sunshine = e.sunshine * condition.sunshine;

		currentYear++; 
		return e;
	}

	/**
	 * ClimateModel represents the change of Climate over time.
 	 * BAD: Strong(ish) coupling
 	 * @param (conditions):  ArrayList<Environment> conditions must not be NULL and have at least one entry
 	 * @param (cyclic): 
 	 */
	public ClimateModel (ArrayList<Environment> conditions, boolean cyclic)
	{
		this.conditions = conditions;
		this.currentYear = 0;
		this.cyclic = cyclic;
	}

	
}