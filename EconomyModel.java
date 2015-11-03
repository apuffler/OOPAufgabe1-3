import java.util.ArrayList;
public class EconomyModel extends Model<Economy>
{

	//Argument must not be NULL
	public Economy applyTo(Economy e)
	{

		if(this.cyclic && conditions.size() > currentYear)
		{
				currentYear = 0;
		}
		if (!this.cyclic && conditions.size() > currentYear)
		{
			currentYear++;
			return e;
		}
		//this.currentYear must have at least 1 entry
		Economy condition = conditions.get(this.currentYear);
		e.capital = e.capital * condition.capital;
		e.losses = e.losses * condition.losses;
		e.interest = e.interest * condition.interest;

		e.losses = e.losses * e.interest;

		currentYear++; 
		return e;
	}

	//ArrayList<Economy> conditions must not be NULL
	public EconomyModel(ArrayList<Economy> conditions, boolean cyclic)
	{
		this.conditions = conditions;
		this.currentYear = 0;
		this.cyclic = cyclic;
	}


}