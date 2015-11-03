import java.util.ArrayList;
import java.util.HashMap;
public class ClimateModel extends Model<Environment>
{

	
	//Argument must not be NULL
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

		//this.currentYear must at least have 1 entry 
		Environment condition  = conditions.get(this.currentYear);
		e.temperature = e.temperature * condition.temperature;
    	e.precipitation = e.temperature * condition.temperature;
    	e.humidity = e.humidity * condition.humidity;
    	e.sunshine = e.sunshine * condition.sunshine;

		currentYear++; 
		return e;
	}


	//ArrayList<Environment> must not be NULL
	public ClimateModel (ArrayList<Environment> conditions, boolean cyclic)
	{
		this.conditions = conditions;
		this.currentYear = 0;
		this.cyclic = cyclic;
	}

	
}