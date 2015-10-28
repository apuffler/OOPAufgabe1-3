import java.util.ArrayList;
public class EconomyModel extends Model<Economy>
{



	public Economy applyTo(Economy e)
	{



		if(this.cyclic && conditions.size() > currentYear)
		{
				currentYear = 0;
		}
		if (!this.cyclic && conditions.size() > currentYear)
		{
			//Default factors
			currentYear++;
			return e;
		}



		Economy condition = conditions.get(this.currentYear);
		e.capital = e.capital * condition.capital;
		e.losses = e.losses * condition.losses;
		e.interest = e.interest * condition.interest;
		//Interest
		e.losses = e.losses * e.interest;

		currentYear++; 
		return e;
	}


	public EconomyModel(ArrayList<Economy> conditions, boolean cyclic)
	{
		this.conditions = conditions;
		this.currentYear = 0;
		this.cyclic = cyclic;
	}


}