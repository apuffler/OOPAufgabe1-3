import java.util.ArrayList;
public class ClimateModel extends Model<Forest>
{

	//TODO: Still need to implement Special Cases

	public Forest applyTo(Forest f)
	{
		if(this.cyclic && conditions.size > currentYear)
		{
				currentYear = 0;
		}
		else if (conditions.size > currentYear)
		{
			//Default factors
			f.environmentalFactors = EnvironmentalFactors(1,1,1,1);
			currentYear++;
		}

		
		f.environmentalFactors = conditions.get(this.currentYear).environmentalFactors;
		currentYear++; 
		return null;
	}



	
	public Forest applyTo(Forest f)
	{
		if(this.cyclic && conditions.size > currentYear)
		{
				currentYear = 0;
		}
		else if (conditions.size > currentYear)
		{
			//Default factors
			f.environmentalFactors = EnvironmentalFactors(1,1,1,1);
			currentYear++;
		}

		
		f.environmentalFactors = conditions.get(this.currentYear).environmentalFactors;
		currentYear++; 
		return Forest;
	}


	public ClimateModel(ArrayList<Forest> conditions, boolean cyclic)
	{
		this.conditions = conditions;
		this.currentYear = 0;
		this.cyclic = cyclic;
	}

	
}