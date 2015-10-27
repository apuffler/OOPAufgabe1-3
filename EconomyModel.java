import java.util.ArrayList;
public class EconomyModel extends Model<Economy>
{





	public Economy applyTo(Economy e)
	{
		if(this.cyclic && conditions.size > currentYear)
		{
				currentYear = 0;
		}
		else if (conditions.size > currentYear)
		{
			//Default factors
			f.Economy = Economy(1,1,1,1);
			currentYear++;
		}

		
		f.environmentalFactors = conditions.get(this.currentYear).environmentalFactors;
		currentYear++; 
		return Economy;
	}


	public ClimateModel(ArrayList<Economy> conditions, boolean cyclic)
	{
		this.conditions = conditions;
		this.currentYear = 0;
		this.cyclic = cyclic;
	}


}