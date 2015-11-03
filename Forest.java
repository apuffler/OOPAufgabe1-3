
/**
 * BAD: Forest gets an class variable of type Environment and Economy but never works with them, instead a new Environment is given with each call of update
 */

public abstract class Forest{
    protected int livingWoodAmount;
    protected int harvestedWoodAmount;
    protected float harvestedWoodUsagePerYear;
    protected int deadWoodAmount;
    protected int totallyUsedWood;
    protected int boundCO2;
    protected int relaxationValue;
    protected Environment env;
    protected Economy eco;

    /**
     * Default constructor for the forest class, initializes all values with lowest possible amount
     */
    public Forest(){
        this.livingWoodAmount = 0;
        this.harvestedWoodAmount = 0;
        this.harvestedWoodUsagePerYear = 0;
        this.deadWoodAmount = 0;
        this.totallyUsedWood = 0;
        this.env = new Environment(1,1,1,1);
        this.eco = new Economy(0,0,0);
    }

    public abstract Forest makeCopy();

    /**
     * Constructor of the forest class
     *
     * @param (livingWoodAmount) Variable of type int; Amount of living wood in the forest, has to be >= 0 or an exception is thrown
     * @param (harvestedWoodAmount) Variable of type int; Amount of harvested wood in the forest, has to be >= 0 or an exception is thrown
     * @param (harvestedWoodUsagePerYear) Variable of type float; Percent of harvested wood used each year, has to be >= 0 and <= 1 or an exception is thrown
     * @param (deadWoodAmount) Variable of type int; Amount of dead wood in the forest, hast to be >= 0 or an exception is thrown
     * @param (env) Variable of type Environment; Environment which gives us the sunshine, temperature, humidity and precipitation used in the grow calculations
     * @param (eco) Variable of type Economy; Economy of the forest
     */
    public Forest(int livingWoodAmount, int harvestedWoodAmount, float harvestedWoodUsagePerYear, int deadWoodAmount, Environment env, Economy eco){

        if(this.livingWoodAmount < 0)
            throw new IllegalArgumentException("LivingWood: Amount can't be below zero.");
        this.livingWoodAmount = livingWoodAmount;

        if(this.harvestedWoodAmount < 0)
            throw new IllegalArgumentException("HarvestedWood: Amount can't be below zero.");
        this.harvestedWoodAmount = harvestedWoodAmount;
        if(this.harvestedWoodUsagePerYear < 0.0 || this.harvestedWoodUsagePerYear > 1.0)
            throw new IllegalArgumentException("HarvestedWood: Usage per year can't be below zero or above one.");
        this.harvestedWoodUsagePerYear = harvestedWoodUsagePerYear;

        if(this.deadWoodAmount < 0)
            throw new IllegalArgumentException("DeadWood: Amount can't be below zero.");
        this.deadWoodAmount = deadWoodAmount;

        this.env = env;
        this.eco = eco;
    }

    /**
     * Sets the amount of living wood
     *
     * @param (amount) Variable of type int; amount of living wood the forest should have
     */
    public void setLivingWoodAmount(int amount){
        this.livingWoodAmount = amount;
    }

    /**
     * Returns the current amount of living wood in the forest
     *
     * @return integer value >= 0
     */
    public int getLivingWoodAmount(){
        return this.livingWoodAmount;
    }

    /**
     * Sets the amount of harvested wood
     *
     * @param (amount) Variable of type int; amount of harvested wood the forest should have
     */
    public void setHarvestedWoodAmount(int amount){
        this.harvestedWoodAmount = amount;
    }

    /**
     * Returns the current amount of harvested wood in the forest
     *
     * @return integer value >= 0
     */
    public int getHarvestedWoodAmount(){
        return this.harvestedWoodAmount;
    }

    /**
     * Sets the percentage of harvested wood usage per year
     *
     * @param (usage) Variable of type float; percent of harvested wood used each year
     */
    public void setHarvestedWoodUsagePerYear(float usage){
        this.harvestedWoodUsagePerYear = usage;
    }

    /**
     * Returns the current percent of harvested wood usage per year
     *
     * @return float value >= 0 and <= 1
     */
    public float getHarvestedWoodUsagePerYear(){
        return this.harvestedWoodUsagePerYear;
    }

    /**
     * Sets the amount of harvested wood
     *
     * @param (amount) Variable of type int; amount of dead wood the forest should have
     */
    public void setDeadWoodAmount(int amount){
        this.deadWoodAmount = amount;
    }

    /**
     * Returns the current amount of dead wood in the forest
     *
     * @return integer value >= 0
     */
    public int getDeadWoodAmount(){
        return this.deadWoodAmount;
    }

    /**
     * Sets the amount of used wood
     *
     * @param (amount) Variable of type int; amount of used wood the forest should have
     */
    public void setTotallyUsedWood(int amount){
        this.totallyUsedWood = amount;
    }

    /**
     * Returns the current amount of used wood in the forest
     *
     * @return integer value >= 0
     */
    public int getTotallyUsedWood(){
        return this.totallyUsedWood;
    }

    public abstract void updateForest(Environment e);
}
