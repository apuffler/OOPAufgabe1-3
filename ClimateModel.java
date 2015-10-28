import java.util.ArrayList;
import java.util.HashMap;
public class ClimateModel extends Model<Environment>
{

	//TODO: Still need to implement Special Cases

	//private HashMap<int, Forest> specialCases = null;


	public Environment applyTo(Environment e)
	{
		/*
		Forest special = 0; 
		if specialCases != null
		{
			special = specialCases.get(currentYear);
			if special != null
		}
		*/
		if(this.cyclic && conditions.size() > currentYear)
		{
				currentYear = 0;
		}
		if (! this.cyclic && conditions.size() > currentYear)
		{
			//Default factors
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

	

	/*
	public ClimateModel(ArrayList<Environment> conditions, boolean cyclic)
	{
		this.specialCases = specialCases;
		this.conditions = conditions;
		this.currentYear = 0;
		this.cyclic = cyclic;
	}
	*/


	public ClimateModel (ArrayList<Environment> conditions, boolean cyclic)
	{
		this.conditions = conditions;
		this.currentYear = 0;
		this.cyclic = cyclic;
	}

	
}