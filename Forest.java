
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

    public Forest(int livingWoodAmount, int harvestedWoodAmount, float harvestedWoodUsagePerYear, int deadWoodAmount, Environment env, Economy eco){

        // LivingWood
        if(this.livingWoodAmount < 0)
            throw new IllegalArgumentException("LivingWood: Amount can't be below zero.");
        this.livingWoodAmount = livingWoodAmount;

        // HarvestedWood
        if(this.harvestedWoodAmount < 0)
            throw new IllegalArgumentException("HarvestedWood: Amount can't be below zero.");
        this.harvestedWoodAmount = harvestedWoodAmount;
        if(this.harvestedWoodUsagePerYear < 0.0 || this.harvestedWoodUsagePerYear > 1.0)
            throw new IllegalArgumentException("HarvestedWood: Usage per year can't be below zero or above one.");
        this.harvestedWoodUsagePerYear = harvestedWoodUsagePerYear;

        // DeadWood
        if(this.deadWoodAmount < 0)
            throw new IllegalArgumentException("DeadWood: Amount can't be below zero.");
        this.deadWoodAmount = deadWoodAmount;

        this.env = env;
        this.eco = eco;
    }

    public void setLivingWoodAmount(int amount){
        this.livingWoodAmount = amount;
    }

    public int getLivingWoodAmount(){
        return this.livingWoodAmount;
    }

    public void setHarvestedWoodAmount(int amount){
        this.harvestedWoodAmount = amount;
    }

    public int getHarvestedWoodAmount(){
        return this.harvestedWoodAmount;
    }

    public void setHarvestedWoodUsagePerYear(float usage){
        this.harvestedWoodUsagePerYear = usage;
    }

    public float getHarvestedWoodUsagePerYear(){
        return this.harvestedWoodUsagePerYear;
    }

    public void setDeadWoodAmount(int amount){
        this.deadWoodAmount = amount;
    }

    public int getDeadWoodAmount(){
        return this.deadWoodAmount;
    }

    public void setTotallyUsedWood(int amount){
        this.totallyUsedWood = amount;
    }

    public int getTotallyUsedWood(){
        return this.totallyUsedWood;
    }

    public abstract void updateForest(Environment e);
}
