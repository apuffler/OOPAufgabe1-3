import java.util.ArrayList;

//GOOD: Dynamic Binding used to inherit
public class EconomyModel extends Model<Economy>
{

	
	/**
	 * Method applyTo applies conditions to the given Economy 
 	 * GOOD: Weak coupling
 	 * @param (capital): float capital must be >= 0
 	 * @param (losses):  float losses must be >= 0
 	 * @param (interest):  float interest must be >= 0
 	 */
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

	/**
	 * EconomyModel represents the change of Economy over time 
 	 * @param (conditions): ArrayList<Economy> conditions must not be NULL and have at least one entry.
 	 * @param (cyclic)
 	 */
	public EconomyModel(ArrayList<Economy> conditions, boolean cyclic)
	{
		this.conditions = conditions;
		this.currentYear = 0;
		this.cyclic = cyclic;
	}


}