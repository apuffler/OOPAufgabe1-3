public class Economy
{
	public float capital;
	public float losses;
	public float interest;

	/**
	 * Economy represents the current state of finances 
 	 * GOOD: Weak coupling
 	 * @param (capital): float capital must be >= 0
 	 * @param (losses):  float losses must be >= 0
 	 * @param (interest):  float interest must be >= 0
 	 */
	public Economy(float capital, float losses, float interest)
	{
		this.capital = capital;
		this.losses = losses;
		this.interest = interest;
	}

}